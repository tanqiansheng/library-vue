<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="流水号" prop="borrowrecorduuid">
        <el-input
          v-model="queryParams.borrowrecorduuid"
          placeholder="请输入借阅流水号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="借阅日期" prop="borrowtime">
        <el-date-picker clearable
                        v-model="queryParams.borrowtime"
                        type="date"
                        value-format="yyyy-MM-dd HH:mm:ss"
                        placeholder="请选择借阅日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="归还日期" prop="returndtime">
        <el-date-picker clearable
                        v-model="queryParams.returndtime"
                        type="date"
                        value-format="yyyy-MM-dd HH:mm:ss"
                        placeholder="请选择归还日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['admin:borrowrecord:add']"
        >借书
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['admin:borrowrecord:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['admin:borrowrecord:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-s-platform"
          size="mini"
          :disabled="multiple"
          @click="handleReturnBook"
        >归还图书
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:borrowrecord:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="borrowrecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column v-if="false" label="借阅id" align="center" prop="borrowrecordId"/>
      <el-table-column label="借阅流水号" align="center" prop="borrowrecorduuid"/>
      <el-table-column label="图书" align="center" prop="bookuuid"/>
      <el-table-column label="读者" align="center" prop="userid"/>
      <el-table-column label="借阅日期" align="center" prop="borrowtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.borrowtime) }}</span>
          <!--<span>{{ parseTime(scope.row.borrowtime, '{y}-{m}-{d}') }}</span>-->
        </template>
      </el-table-column>
      <el-table-column label="归还日期" align="center" prop="returndtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.returndtime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark"/>
      <el-table-column label="还书" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-s-platform"
            @click="handleReturnBook(scope.row)"
          >还书
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['admin:borrowrecord:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:borrowrecord:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改借书记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="借阅流水id" prop="borrowrecorduuid">
           <el-input v-model="form.borrowrecorduuid" placeholder="请输入借阅流水id"/>
         </el-form-item>-->
        <el-form-item label="种类" prop="categoryuuid">
          <el-select @change="selectBooksByCategoryuuidChange($event)" v-model="categoryuuid" placeholder="请选择种类"
                     clearable
                     :style="{width: '100%'}">
            <el-option v-for="(item, index) in catalogueData" :key="index" :label="item.cataloguename"
                       :value="item.catalogueuuid" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="图书" prop="bookuuid">
          <el-select @change="selectBookChange($event)" v-model="form.bookuuid" placeholder="请选择图书" clearable
                     :style="{width: '100%'}">
            <el-option v-for="(item, index) in books" :key="index" :label="item.bookname"
                       :value="item.bookuuid" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>

        <!--  <el-form-item label="图书" prop="bookuuid">
            <el-input v-model="form.bookuuid" placeholder="请输入图书流水号"/>
          </el-form-item>-->
        <el-form-item label="读者" prop="userid">
          <el-select v-model="form.userid" placeholder="请选择读者" clearable
                     :style="{width: '100%'}">
            <el-option v-for="(item, index) in userData" :key="index" :label="item.nickName"
                       :value="item.usernumber" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
         <el-form-item label="学号" prop="userid">
           <el-input v-model="form.userid" placeholder="请输入学号"/>
         </el-form-item>
        <el-form-item label="借阅时间" prop="borrowtime">
          <el-date-picker clearable
                          v-model="form.borrowtime"
                          type="datetime"
                          value-format="yyyy-MM-dd HH:mm:ss"
                          placeholder="请选择借阅时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="归还时间" prop="returndtime">
          <el-date-picker clearable disabled
                          v-model="form.returndtime"
                          type="datetime"
                          value-format="yyyy-MM-dd HH:mm:ss"
                          placeholder="请选择归还日期">
          </el-date-picker>
        </el-form-item>
        <!--   <el-form-item label="删除标志" prop="delFlag">
             <el-input v-model="form.delFlag" placeholder="请输入删除标志"/>
           </el-form-item>-->
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listBorrowrecord,
    getBorrowrecord,
    delBorrowrecord,
    addBorrowrecord,
    updateBorrowrecord,
    handleReturnBook
  } from "@/api/admin/borrowrecord";
  import {listCatalogueAll} from "@/api/admin/catalogue";
  import {selectBooksByCategoryuuid} from "@/api/admin/book";
  import {getAllUser} from "@/api/system/user";

  export default {
    name: "Borrowrecord",
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 借书记录表格数据
        borrowrecordList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          borrowrecorduuid: null,
          bookuuid: null,
          userid: null,
          borrowtime: null,
          returndtime: null,
        },
        // 表单参数
        form: {},
        categoryuuid: "",
        // 表单校验
        rules: {
          borrowrecorduuid: [
            {required: true, message: "借阅流水id不能为空", trigger: "blur"}
          ],
          borrowtime: [
            {required: true, message: "借阅时间不能为空", trigger: "blur"}
          ],
          bookuuid: [
            {required: true, message: "借阅图书不能为空", trigger: "blur"}
          ],
          userid: [
            {required: true, message: "读者不能为空", trigger: "blur"}
          ],
        },
        catalogueData: [],
        books: [],
        bookuuid: "",
        userData: [],
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询借书记录列表 */
      getList() {
        this.loading = true;
        listBorrowrecord(this.queryParams).then(response => {
          this.borrowrecordList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          borrowrecordId: null,
          borrowrecorduuid: null,
          bookuuid: null,
          userid: null,
          borrowtime: null,
          returndtime: null,
          delFlag: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
          remark: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.borrowrecordId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.getUser();
        this.getCategory();
        this.selectBooksByCategoryuuidChange();
        this.reset();
        this.open = true;
        this.title = "添加借书记录";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.getCategory();
        this.selectBooksByCategoryuuidChange();
        this.getUser();
        this.reset();
        const borrowrecordId = row.borrowrecordId || this.ids
        getBorrowrecord(borrowrecordId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改借书记录";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.borrowrecordId != null) {
              updateBorrowrecord(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addBorrowrecord(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const borrowrecordIds = row.borrowrecordId || this.ids;
        this.$modal.confirm('是否确认删除借书记录编号为"' + borrowrecordIds + '"的数据项？').then(function () {
          return delBorrowrecord(borrowrecordIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {
        });
      },
      /** 还书按钮操作 */
      handleReturnBook(row) {
        const borrowrecordIds = row.borrowrecordId || this.ids;
        var msg = "";
        if (row.borrowrecordId != null && row.borrowrecordId != "") {
          console.log(row)
          msg = "归还" + row.userid + "借阅的" + row.bookuuid
          if (this.divTime(row.borrowtime) > 10) {
            msg += "，"+row.bookuuid+"借书时间为" + this.divTime(row.borrowtime) + "天，超过10天，" + row.userid + "应该被罚款！"
          }
        } else {
          const map = new Map();
          this.borrowrecordList.forEach(item => {
            map.set(item.borrowrecordId, item)
          })
          msg = "归还" + this.ids.length + "本书，"
          for (let i = 0; i < this.ids.length; i++) {
            let row = map.get(this.ids[i])
            if (this.divTime(row.borrowtime) > 10) {
              msg +="，"+row.bookuuid+ "借书时间为" + this.divTime(row.borrowtime) + "天，超过10天，" + row.userid + "应该被罚款！"
            }
          }

        }
        this.$modal.confirm(msg).then(function () {
          return handleReturnBook(borrowrecordIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("还书成功");
        }).catch(() => {
        });
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('admin/borrowrecord/export', {
          ...this.queryParams
        }, `borrowrecord_${new Date().getTime()}.xlsx`)
      },
      getCategory() {
        listCatalogueAll().then(response => {
          this.catalogueData = response.data;
        });
      },
      getUser() {
        getAllUser().then(response => {
          console.log(response)
          this.userData = response.data;
        });
      },
      selectBooksByCategoryuuidChange(val) {

        selectBooksByCategoryuuid(val).then(response => {
          this.books = response.data;
        });

      },
      selectBookChange(val) {
        if (val != null && val != '' && val != undefined) {
          this.form.bookuuid = val;
        }
      },


      divTime(targetDate) {
        /*time1 = Date.parse(new Date(time1));
        time2 = Date.parse(new Date(time2));
        return Math.abs(parseInt((time2 - time1) / 1000 / 3600));*/
        let date1 = new Date(targetDate);
        let date2 = new Date();
        date1 = new Date(date1.getFullYear(), date1.getMonth(), date1.getDate());
        date2 = new Date(date2.getFullYear(), date2.getMonth(), date2.getDate());
        const diff = date2.getTime() - date1.getTime();
        const diffDate = diff / (24 * 60 * 60 * 1000);
        return diffDate;

      }


    }
  };
</script>

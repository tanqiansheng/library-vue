<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="流水号" prop="bookuuid">
        <el-input
          v-model="queryParams.bookuuid"
          placeholder="请输入图书流水号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="书名" prop="bookname">
        <el-input
          v-model="queryParams.bookname"
          placeholder="请输入书名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input
          v-model="queryParams.author"
          placeholder="请输入作者"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="购买日期" prop="buydate">
        <el-date-picker clearable
                        v-model="queryParams.buydate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择购买日期">
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
          v-hasPermi="['admin:book:add']"
        >新增
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
          v-hasPermi="['admin:book:edit']"
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
          v-hasPermi="['admin:book:remove']"
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
          @click="handleBrrowBook"
        >借书
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:book:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="bookList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column v-if="false" label="种类id" align="center" prop="bookId"/>
      <el-table-column label="图书流水号" align="center" prop="bookuuid"/>
      <el-table-column label="种类" align="center" prop="categoryuuid"/>
      <el-table-column label="书名" align="center" prop="bookname"/>
      <el-table-column label="作者" align="center" prop="author"/>
      <el-table-column label="价格" align="center" prop="price"/>
      <el-table-column label="购买日期" align="center" prop="buydate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.buydate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="图片" align="center" prop="img" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.img" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark"/>
      <el-table-column label="借书" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-s-platform"
            @click="handleBrrowBook(scope.row)"
          >借书
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
            v-hasPermi="['admin:book:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:book:remove']"
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

    <!-- 添加或修改新书购入对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!--   <el-form-item label="图书流水id" prop="bookuuid">
             <el-input v-model="form.bookuuid" placeholder="请输入图书流水id" />
           </el-form-item>-->
        <!--  <el-form-item label="种类" prop="categoryuuid">
            <el-input v-model="form.categoryuuid" type="textarea" placeholder="请输入内容" />
          </el-form-item>-->
        <el-form-item label="种类" prop="categoryuuid">
          <el-select v-model="form.categoryuuid" placeholder="请选择种类" clearable :style="{width: '100%'}">
            <el-option v-for="(item, index) in catalogueData" :key="index" :label="item.cataloguename"
                       :value="item.catalogueuuid" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="书名" prop="bookname">
          <el-input v-model="form.bookname" placeholder="请输入书名"/>
        </el-form-item>
        <el-form-item label="作者" prop="author">
          <el-input v-model="form.author" placeholder="请输入作者"/>
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格"/>
        </el-form-item>
        <el-form-item label="购买日期" prop="buydate">
          <el-date-picker clearable
                          v-model="form.buydate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择购买日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="图片">
          <image-upload v-model="form.img"/>
        </el-form-item>
        <!--<el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
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
  import {listBook, getBook, delBook, addBook, updateBook} from "@/api/admin/book";
  import {listCatalogueAll} from "@/api/admin/catalogue";
  import {handleBrrowBook } from "@/api/admin/borrowrecord";
  export default {
    name: "Book",
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
        // 新书购入表格数据
        bookList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          bookuuid: null,
          categoryuuid: null,
          bookname: null,
          author: null,
          price: null,
          buydate: null,
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          bookuuid: [
            {required: true, message: "图书流水id不能为空", trigger: "blur"}
          ],
          categoryuuid: [{
            required: true,
            message: '请选择图书种类',
            trigger: 'change'
          }],
        },
        catalogueData: [],

      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询新书购入列表 */
      getList() {
        this.loading = true;
        listBook(this.queryParams).then(response => {
          this.bookList = response.rows;
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
          bookId: null,
          bookuuid: null,
          categoryuuid: null,
          bookname: null,
          author: null,
          price: null,
          buydate: null,
          img: null,
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
        this.queryParams.pageNum =
          this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.bookId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.getCategory();
        this.reset();
        this.open = true;
        this.title = "添加新书购入";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        this.getCategory();
        const bookId = row.bookId || this.ids
        getBook(bookId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改新书购入";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.bookId != null) {
              updateBook(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addBook(this.form).then(response => {
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
        const bookIds = row.bookId || this.ids;
        this.$modal.confirm('是否确认删除新书购入编号为"' + bookIds + '"的数据项？').then(function () {
          return delBook(bookIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {
        });
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('admin/book/export', {
          ...this.queryParams
        }, `book_${new Date().getTime()}.xlsx`)
      },
      getCategory() {
        listCatalogueAll().then(response => {
          this.catalogueData = response.data;
        });
      },
      /** 借书按钮操作 */
      handleBrrowBook(row) {
        const bookIds = row.bookId || this.ids;
        var msg = "";
        if (row.bookId != null && row.bookId != "") {
          msg = "借阅" + row.bookname
        } else {
          const map = new Map();
          this.bookList.forEach(item => {
            map.set(item.bookId, item)
          })
          msg = "借阅" + this.ids.length + "本书，"
          for (let i = 0; i < this.ids.length; i++) {
            let row = map.get(this.ids[i])
            msg+=row.bookname+" "
          }
        }
        this.$modal.confirm(msg).then(function () {
          return handleBrrowBook(bookIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("借书成功");
        }).catch(() => {
        });
      },
    }
  };
</script>

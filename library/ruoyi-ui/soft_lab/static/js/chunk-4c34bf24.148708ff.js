(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4c34bf24"],{"4ec9":function(e,t,r){"use strict";var o=r("6d61"),n=r("6566");o("Map",(function(e){return function(){return e(this,arguments.length?arguments[0]:void 0)}}),n)},"50c7":function(e,t,r){"use strict";r.d(t,"e",(function(){return n})),r.d(t,"c",(function(){return a})),r.d(t,"a",(function(){return i})),r.d(t,"g",(function(){return u})),r.d(t,"b",(function(){return l})),r.d(t,"f",(function(){return s})),r.d(t,"d",(function(){return c}));var o=r("b775");function n(e){return Object(o["a"])({url:"/admin/book/list",method:"get",params:e})}function a(e){return Object(o["a"])({url:"/admin/book/"+e,method:"get"})}function i(e){return Object(o["a"])({url:"/admin/book",method:"post",data:e})}function u(e){return Object(o["a"])({url:"/admin/book",method:"put",data:e})}function l(e){return Object(o["a"])({url:"/admin/book/"+e,method:"delete"})}function s(e){return Object(o["a"])({url:"/admin/book/selectBooksByCategoryuuid",method:"post",data:{categoryuuid:e}})}function c(e){return Object(o["a"])({url:"/admin/book/getPanelGroupData"})}},"5a0d":function(e,t,r){"use strict";r.d(t,"j",(function(){return n})),r.d(t,"g",(function(){return a})),r.d(t,"a",(function(){return i})),r.d(t,"k",(function(){return u})),r.d(t,"f",(function(){return l})),r.d(t,"i",(function(){return s})),r.d(t,"e",(function(){return c})),r.d(t,"c",(function(){return d})),r.d(t,"b",(function(){return m})),r.d(t,"d",(function(){return b})),r.d(t,"h",(function(){return f}));var o=r("b775");function n(e){return Object(o["a"])({url:"/admin/borrowrecord/list",method:"get",params:e})}function a(e){return Object(o["a"])({url:"/admin/borrowrecord/"+e,method:"get"})}function i(e){return Object(o["a"])({url:"/admin/borrowrecord",method:"post",data:e})}function u(e){return Object(o["a"])({url:"/admin/borrowrecord",method:"put",data:e})}function l(e){return Object(o["a"])({url:"/admin/borrowrecord/"+e,method:"delete"})}function s(e){return Object(o["a"])({url:"/admin/borrowrecord/handleReturnBook/"+e})}function c(){return Object(o["a"])({url:"/admin/borrowrecord/borrowrecordOf30Day"})}function d(){return Object(o["a"])({url:"/admin/borrowrecord/borrowrecordBycataloguePercentage"})}function m(){return Object(o["a"])({url:"/admin/borrowrecord/borrowrecordByDeptPercentage"})}function b(){return Object(o["a"])({url:"/admin/borrowrecord/borrowrecordBycatalogueRaddar"})}function f(e){return Object(o["a"])({url:"/admin/borrowrecord/handleBrrowBook/"+e})}},9539:function(e,t,r){"use strict";r.d(t,"d",(function(){return n})),r.d(t,"c",(function(){return a})),r.d(t,"a",(function(){return i})),r.d(t,"f",(function(){return u})),r.d(t,"b",(function(){return l})),r.d(t,"e",(function(){return s}));var o=r("b775");function n(e){return Object(o["a"])({url:"/admin/catalogue/list",method:"get",params:e})}function a(e){return Object(o["a"])({url:"/admin/catalogue/"+e,method:"get"})}function i(e){return Object(o["a"])({url:"/admin/catalogue",method:"post",data:e})}function u(e){return Object(o["a"])({url:"/admin/catalogue",method:"put",data:e})}function l(e){return Object(o["a"])({url:"/admin/catalogue/"+e,method:"delete"})}function s(){return Object(o["a"])({url:"/admin/catalogue/listCatalogueAll",method:"get"})}},c0c7:function(e,t,r){"use strict";r.d(t,"h",(function(){return a})),r.d(t,"f",(function(){return i})),r.d(t,"a",(function(){return u})),r.d(t,"k",(function(){return l})),r.d(t,"c",(function(){return s})),r.d(t,"i",(function(){return c})),r.d(t,"b",(function(){return d})),r.d(t,"g",(function(){return m})),r.d(t,"l",(function(){return b})),r.d(t,"m",(function(){return f})),r.d(t,"n",(function(){return h})),r.d(t,"e",(function(){return p})),r.d(t,"j",(function(){return g})),r.d(t,"d",(function(){return w}));var o=r("b775"),n=r("c38a");function a(e){return Object(o["a"])({url:"/system/user/list",method:"get",params:e})}function i(e){return Object(o["a"])({url:"/system/user/"+Object(n["e"])(e),method:"get"})}function u(e){return Object(o["a"])({url:"/system/user",method:"post",data:e})}function l(e){return Object(o["a"])({url:"/system/user",method:"put",data:e})}function s(e){return Object(o["a"])({url:"/system/user/"+e,method:"delete"})}function c(e,t){var r={userId:e,password:t};return Object(o["a"])({url:"/system/user/resetPwd",method:"put",data:r})}function d(e,t){var r={userId:e,status:t};return Object(o["a"])({url:"/system/user/changeStatus",method:"put",data:r})}function m(){return Object(o["a"])({url:"/system/user/profile",method:"get"})}function b(e){return Object(o["a"])({url:"/system/user/profile",method:"put",data:e})}function f(e,t){var r={oldPassword:e,newPassword:t};return Object(o["a"])({url:"/system/user/profile/updatePwd",method:"put",params:r})}function h(e){return Object(o["a"])({url:"/system/user/profile/avatar",method:"post",data:e})}function p(e){return Object(o["a"])({url:"/system/user/authRole/"+e,method:"get"})}function g(e){return Object(o["a"])({url:"/system/user/authRole",method:"put",params:e})}function w(){return Object(o["a"])({url:"/system/user/getAllUser",method:"get"})}},d5cd:function(e,t,r){"use strict";r.r(t);var o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"app-container"},[r("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[r("el-form-item",{attrs:{label:"流水号",prop:"borrowrecorduuid"}},[r("el-input",{attrs:{placeholder:"请输入借阅流水号",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.borrowrecorduuid,callback:function(t){e.$set(e.queryParams,"borrowrecorduuid",t)},expression:"queryParams.borrowrecorduuid"}})],1),r("el-form-item",{attrs:{label:"借阅日期",prop:"borrowtime"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择借阅日期"},model:{value:e.queryParams.borrowtime,callback:function(t){e.$set(e.queryParams,"borrowtime",t)},expression:"queryParams.borrowtime"}})],1),r("el-form-item",{attrs:{label:"归还日期",prop:"returndtime"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择归还日期"},model:{value:e.queryParams.returndtime,callback:function(t){e.$set(e.queryParams,"returndtime",t)},expression:"queryParams.returndtime"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),r("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),r("el-row",{staticClass:"mb8",attrs:{gutter:10}},[r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:borrowrecord:add"],expression:"['admin:borrowrecord:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("借书 ")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:borrowrecord:edit"],expression:"['admin:borrowrecord:edit']"}],attrs:{type:"success",plain:"",icon:"el-icon-edit",size:"mini",disabled:e.single},on:{click:e.handleUpdate}},[e._v("修改 ")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:borrowrecord:remove"],expression:"['admin:borrowrecord:remove']"}],attrs:{type:"danger",plain:"",icon:"el-icon-delete",size:"mini",disabled:e.multiple},on:{click:e.handleDelete}},[e._v("删除 ")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{attrs:{type:"primary",plain:"",icon:"el-icon-s-platform",size:"mini",disabled:e.multiple},on:{click:e.handleReturnBook}},[e._v("归还图书 ")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:borrowrecord:export"],expression:"['admin:borrowrecord:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出 ")])],1),r("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.borrowrecordList},on:{"selection-change":e.handleSelectionChange}},[r("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),e._e(),r("el-table-column",{attrs:{label:"借阅流水号",align:"center",prop:"borrowrecorduuid"}}),r("el-table-column",{attrs:{label:"图书",align:"center",prop:"bookuuid"}}),r("el-table-column",{attrs:{label:"读者",align:"center",prop:"userid"}}),r("el-table-column",{attrs:{label:"借阅日期",align:"center",prop:"borrowtime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("span",[e._v(e._s(e.parseTime(t.row.borrowtime)))])]}}])}),r("el-table-column",{attrs:{label:"归还日期",align:"center",prop:"returndtime",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("span",[e._v(e._s(e.parseTime(t.row.returndtime)))])]}}])}),r("el-table-column",{attrs:{label:"备注",align:"center",prop:"remark"}}),r("el-table-column",{attrs:{label:"还书",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{attrs:{size:"mini",type:"text",icon:"el-icon-s-platform"},on:{click:function(r){return e.handleReturnBook(t.row)}}},[e._v("还书 ")])]}}])}),r("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:borrowrecord:edit"],expression:"['admin:borrowrecord:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(r){return e.handleUpdate(t.row)}}},[e._v("修改 ")]),r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:borrowrecord:remove"],expression:"['admin:borrowrecord:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(r){return e.handleDelete(t.row)}}},[e._v("删除 ")])]}}])})],1),r("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),r("el-dialog",{attrs:{title:e.title,visible:e.open,width:"500px","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[r("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[r("el-form-item",{attrs:{label:"种类",prop:"categoryuuid"}},[r("el-select",{style:{width:"100%"},attrs:{placeholder:"请选择种类",clearable:""},on:{change:function(t){return e.selectBooksByCategoryuuidChange(t)}},model:{value:e.categoryuuid,callback:function(t){e.categoryuuid=t},expression:"categoryuuid"}},e._l(e.catalogueData,(function(e,t){return r("el-option",{key:t,attrs:{label:e.cataloguename,value:e.catalogueuuid,disabled:e.disabled}})})),1)],1),r("el-form-item",{attrs:{label:"图书",prop:"bookuuid"}},[r("el-select",{style:{width:"100%"},attrs:{placeholder:"请选择图书",clearable:""},on:{change:function(t){return e.selectBookChange(t)}},model:{value:e.form.bookuuid,callback:function(t){e.$set(e.form,"bookuuid",t)},expression:"form.bookuuid"}},e._l(e.books,(function(e,t){return r("el-option",{key:t,attrs:{label:e.bookname,value:e.bookuuid,disabled:e.disabled}})})),1)],1),r("el-form-item",{attrs:{label:"读者",prop:"userid"}},[r("el-select",{style:{width:"100%"},attrs:{placeholder:"请选择读者",clearable:""},model:{value:e.form.userid,callback:function(t){e.$set(e.form,"userid",t)},expression:"form.userid"}},e._l(e.userData,(function(e,t){return r("el-option",{key:t,attrs:{label:e.nickName,value:e.usernumber,disabled:e.disabled}})})),1)],1),r("el-form-item",{attrs:{label:"学号",prop:"userid"}},[r("el-input",{attrs:{placeholder:"请输入学号"},model:{value:e.form.userid,callback:function(t){e.$set(e.form,"userid",t)},expression:"form.userid"}})],1),r("el-form-item",{attrs:{label:"借阅时间",prop:"borrowtime"}},[r("el-date-picker",{attrs:{clearable:"",type:"datetime","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择借阅时间"},model:{value:e.form.borrowtime,callback:function(t){e.$set(e.form,"borrowtime",t)},expression:"form.borrowtime"}})],1),r("el-form-item",{attrs:{label:"归还时间",prop:"returndtime"}},[r("el-date-picker",{attrs:{clearable:"",disabled:"",type:"datetime","value-format":"yyyy-MM-dd HH:mm:ss",placeholder:"请选择归还日期"},model:{value:e.form.returndtime,callback:function(t){e.$set(e.form,"returndtime",t)},expression:"form.returndtime"}})],1),r("el-form-item",{attrs:{label:"备注",prop:"remark"}},[r("el-input",{attrs:{placeholder:"请输入备注"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),r("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},n=[],a=r("5530"),i=(r("d81d"),r("4ec9"),r("d3b7"),r("3ca3"),r("ddb0"),r("159b"),r("5a0d")),u=r("9539"),l=r("50c7"),s=r("c0c7"),c={name:"Borrowrecord",data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,borrowrecordList:[],title:"",open:!1,queryParams:{pageNum:1,pageSize:10,borrowrecorduuid:null,bookuuid:null,userid:null,borrowtime:null,returndtime:null},form:{},categoryuuid:"",rules:{borrowrecorduuid:[{required:!0,message:"借阅流水id不能为空",trigger:"blur"}],borrowtime:[{required:!0,message:"借阅时间不能为空",trigger:"blur"}],bookuuid:[{required:!0,message:"借阅图书不能为空",trigger:"blur"}],userid:[{required:!0,message:"读者不能为空",trigger:"blur"}]},catalogueData:[],books:[],bookuuid:"",userData:[]}},created:function(){this.getList()},methods:{getList:function(){var e=this;this.loading=!0,Object(i["j"])(this.queryParams).then((function(t){e.borrowrecordList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={borrowrecordId:null,borrowrecorduuid:null,bookuuid:null,userid:null,borrowtime:null,returndtime:null,delFlag:null,createBy:null,createTime:null,updateBy:null,updateTime:null,remark:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.borrowrecordId})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.getUser(),this.getCategory(),this.selectBooksByCategoryuuidChange(),this.reset(),this.open=!0,this.title="添加借书记录"},handleUpdate:function(e){var t=this;this.getCategory(),this.selectBooksByCategoryuuidChange(),this.getUser(),this.reset();var r=e.borrowrecordId||this.ids;Object(i["g"])(r).then((function(e){t.form=e.data,t.open=!0,t.title="修改借书记录"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.borrowrecordId?Object(i["k"])(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):Object(i["a"])(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,r=e.borrowrecordId||this.ids;this.$modal.confirm('是否确认删除借书记录编号为"'+r+'"的数据项？').then((function(){return Object(i["f"])(r)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleReturnBook:function(e){var t=this,r=e.borrowrecordId||this.ids,o="";if(null!=e.borrowrecordId&&""!=e.borrowrecordId)console.log(e),o="归还"+e.userid+"借阅的"+e.bookuuid,this.divTime(e.borrowtime)>10&&(o+="，"+e.bookuuid+"借书时间为"+this.divTime(e.borrowtime)+"天，超过10天，"+e.userid+"应该被罚款！");else{var n=new Map;this.borrowrecordList.forEach((function(e){n.set(e.borrowrecordId,e)})),o="归还"+this.ids.length+"本书，";for(var a=0;a<this.ids.length;a++){var u=n.get(this.ids[a]);this.divTime(u.borrowtime)>10&&(o+="，"+u.bookuuid+"借书时间为"+this.divTime(u.borrowtime)+"天，超过10天，"+u.userid+"应该被罚款！")}}this.$modal.confirm(o).then((function(){return Object(i["i"])(r)})).then((function(){t.getList(),t.$modal.msgSuccess("还书成功")})).catch((function(){}))},handleExport:function(){this.download("admin/borrowrecord/export",Object(a["a"])({},this.queryParams),"borrowrecord_".concat((new Date).getTime(),".xlsx"))},getCategory:function(){var e=this;Object(u["e"])().then((function(t){e.catalogueData=t.data}))},getUser:function(){var e=this;Object(s["d"])().then((function(t){console.log(t),e.userData=t.data}))},selectBooksByCategoryuuidChange:function(e){var t=this;Object(l["f"])(e).then((function(e){t.books=e.data}))},selectBookChange:function(e){null!=e&&""!=e&&void 0!=e&&(this.form.bookuuid=e)},divTime:function(e){var t=new Date(e),r=new Date;t=new Date(t.getFullYear(),t.getMonth(),t.getDate()),r=new Date(r.getFullYear(),r.getMonth(),r.getDate());var o=r.getTime()-t.getTime(),n=o/864e5;return n}}},d=c,m=r("2877"),b=Object(m["a"])(d,o,n,!1,null,null,null);t["default"]=b.exports}}]);
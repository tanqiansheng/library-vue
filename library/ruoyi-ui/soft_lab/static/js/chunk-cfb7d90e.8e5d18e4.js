(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-cfb7d90e"],{"4ec9":function(e,t,r){"use strict";var a=r("6d61"),o=r("6566");a("Map",(function(e){return function(){return e(this,arguments.length?arguments[0]:void 0)}}),o)},"50c7":function(e,t,r){"use strict";r.d(t,"e",(function(){return o})),r.d(t,"c",(function(){return n})),r.d(t,"a",(function(){return i})),r.d(t,"g",(function(){return l})),r.d(t,"b",(function(){return u})),r.d(t,"f",(function(){return c})),r.d(t,"d",(function(){return s}));var a=r("b775");function o(e){return Object(a["a"])({url:"/admin/book/list",method:"get",params:e})}function n(e){return Object(a["a"])({url:"/admin/book/"+e,method:"get"})}function i(e){return Object(a["a"])({url:"/admin/book",method:"post",data:e})}function l(e){return Object(a["a"])({url:"/admin/book",method:"put",data:e})}function u(e){return Object(a["a"])({url:"/admin/book/"+e,method:"delete"})}function c(e){return Object(a["a"])({url:"/admin/book/selectBooksByCategoryuuid",method:"post",data:{categoryuuid:e}})}function s(e){return Object(a["a"])({url:"/admin/book/getPanelGroupData"})}},"5a0d":function(e,t,r){"use strict";r.d(t,"j",(function(){return o})),r.d(t,"g",(function(){return n})),r.d(t,"a",(function(){return i})),r.d(t,"k",(function(){return l})),r.d(t,"f",(function(){return u})),r.d(t,"i",(function(){return c})),r.d(t,"e",(function(){return s})),r.d(t,"c",(function(){return d})),r.d(t,"b",(function(){return m})),r.d(t,"d",(function(){return b})),r.d(t,"h",(function(){return p}));var a=r("b775");function o(e){return Object(a["a"])({url:"/admin/borrowrecord/list",method:"get",params:e})}function n(e){return Object(a["a"])({url:"/admin/borrowrecord/"+e,method:"get"})}function i(e){return Object(a["a"])({url:"/admin/borrowrecord",method:"post",data:e})}function l(e){return Object(a["a"])({url:"/admin/borrowrecord",method:"put",data:e})}function u(e){return Object(a["a"])({url:"/admin/borrowrecord/"+e,method:"delete"})}function c(e){return Object(a["a"])({url:"/admin/borrowrecord/handleReturnBook/"+e})}function s(){return Object(a["a"])({url:"/admin/borrowrecord/borrowrecordOf30Day"})}function d(){return Object(a["a"])({url:"/admin/borrowrecord/borrowrecordBycataloguePercentage"})}function m(){return Object(a["a"])({url:"/admin/borrowrecord/borrowrecordByDeptPercentage"})}function b(){return Object(a["a"])({url:"/admin/borrowrecord/borrowrecordBycatalogueRaddar"})}function p(e){return Object(a["a"])({url:"/admin/borrowrecord/handleBrrowBook/"+e})}},"64f5":function(e,t,r){"use strict";r.r(t);var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"app-container"},[r("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[r("el-form-item",{attrs:{label:"流水号",prop:"bookuuid"}},[r("el-input",{attrs:{placeholder:"请输入图书流水号",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.bookuuid,callback:function(t){e.$set(e.queryParams,"bookuuid",t)},expression:"queryParams.bookuuid"}})],1),r("el-form-item",{attrs:{label:"书名",prop:"bookname"}},[r("el-input",{attrs:{placeholder:"请输入书名",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.bookname,callback:function(t){e.$set(e.queryParams,"bookname",t)},expression:"queryParams.bookname"}})],1),r("el-form-item",{attrs:{label:"作者",prop:"author"}},[r("el-input",{attrs:{placeholder:"请输入作者",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.author,callback:function(t){e.$set(e.queryParams,"author",t)},expression:"queryParams.author"}})],1),r("el-form-item",{attrs:{label:"购买日期",prop:"buydate"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择购买日期"},model:{value:e.queryParams.buydate,callback:function(t){e.$set(e.queryParams,"buydate",t)},expression:"queryParams.buydate"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),r("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),r("el-row",{staticClass:"mb8",attrs:{gutter:10}},[r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:book:add"],expression:"['admin:book:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("新增 ")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:book:edit"],expression:"['admin:book:edit']"}],attrs:{type:"success",plain:"",icon:"el-icon-edit",size:"mini",disabled:e.single},on:{click:e.handleUpdate}},[e._v("修改 ")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:book:remove"],expression:"['admin:book:remove']"}],attrs:{type:"danger",plain:"",icon:"el-icon-delete",size:"mini",disabled:e.multiple},on:{click:e.handleDelete}},[e._v("删除 ")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{attrs:{type:"primary",plain:"",icon:"el-icon-s-platform",size:"mini",disabled:e.multiple},on:{click:e.handleBrrowBook}},[e._v("借书 ")])],1),r("el-col",{attrs:{span:1.5}},[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:book:export"],expression:"['admin:book:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出 ")])],1),r("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.bookList},on:{"selection-change":e.handleSelectionChange}},[r("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),e._e(),r("el-table-column",{attrs:{label:"图书流水号",align:"center",prop:"bookuuid"}}),r("el-table-column",{attrs:{label:"种类",align:"center",prop:"categoryuuid"}}),r("el-table-column",{attrs:{label:"书名",align:"center",prop:"bookname"}}),r("el-table-column",{attrs:{label:"作者",align:"center",prop:"author"}}),r("el-table-column",{attrs:{label:"价格",align:"center",prop:"price"}}),r("el-table-column",{attrs:{label:"购买日期",align:"center",prop:"buydate",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("span",[e._v(e._s(e.parseTime(t.row.buydate,"{y}-{m}-{d}")))])]}}])}),r("el-table-column",{attrs:{label:"图片",align:"center",prop:"img",width:"100"},scopedSlots:e._u([{key:"default",fn:function(e){return[r("image-preview",{attrs:{src:e.row.img,width:50,height:50}})]}}])}),r("el-table-column",{attrs:{label:"备注",align:"center",prop:"remark"}}),r("el-table-column",{attrs:{label:"借书",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{attrs:{size:"mini",type:"text",icon:"el-icon-s-platform"},on:{click:function(r){return e.handleBrrowBook(t.row)}}},[e._v("借书 ")])]}}])}),r("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:book:edit"],expression:"['admin:book:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(r){return e.handleUpdate(t.row)}}},[e._v("修改 ")]),r("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["admin:book:remove"],expression:"['admin:book:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(r){return e.handleDelete(t.row)}}},[e._v("删除 ")])]}}])})],1),r("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),r("el-dialog",{attrs:{title:e.title,visible:e.open,width:"500px","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[r("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[r("el-form-item",{attrs:{label:"种类",prop:"categoryuuid"}},[r("el-select",{style:{width:"100%"},attrs:{placeholder:"请选择种类",clearable:""},model:{value:e.form.categoryuuid,callback:function(t){e.$set(e.form,"categoryuuid",t)},expression:"form.categoryuuid"}},e._l(e.catalogueData,(function(e,t){return r("el-option",{key:t,attrs:{label:e.cataloguename,value:e.catalogueuuid,disabled:e.disabled}})})),1)],1),r("el-form-item",{attrs:{label:"书名",prop:"bookname"}},[r("el-input",{attrs:{placeholder:"请输入书名"},model:{value:e.form.bookname,callback:function(t){e.$set(e.form,"bookname",t)},expression:"form.bookname"}})],1),r("el-form-item",{attrs:{label:"作者",prop:"author"}},[r("el-input",{attrs:{placeholder:"请输入作者"},model:{value:e.form.author,callback:function(t){e.$set(e.form,"author",t)},expression:"form.author"}})],1),r("el-form-item",{attrs:{label:"价格",prop:"price"}},[r("el-input",{attrs:{placeholder:"请输入价格"},model:{value:e.form.price,callback:function(t){e.$set(e.form,"price",t)},expression:"form.price"}})],1),r("el-form-item",{attrs:{label:"购买日期",prop:"buydate"}},[r("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择购买日期"},model:{value:e.form.buydate,callback:function(t){e.$set(e.form,"buydate",t)},expression:"form.buydate"}})],1),r("el-form-item",{attrs:{label:"图片"}},[r("image-upload",{model:{value:e.form.img,callback:function(t){e.$set(e.form,"img",t)},expression:"form.img"}})],1),r("el-form-item",{attrs:{label:"备注",prop:"remark"}},[r("el-input",{attrs:{placeholder:"请输入备注"},model:{value:e.form.remark,callback:function(t){e.$set(e.form,"remark",t)},expression:"form.remark"}})],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),r("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},o=[],n=r("5530"),i=(r("d81d"),r("4ec9"),r("d3b7"),r("3ca3"),r("ddb0"),r("159b"),r("50c7")),l=r("9539"),u=r("5a0d"),c={name:"Book",data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,bookList:[],title:"",open:!1,queryParams:{pageNum:1,pageSize:10,bookuuid:null,categoryuuid:null,bookname:null,author:null,price:null,buydate:null},form:{},rules:{bookuuid:[{required:!0,message:"图书流水id不能为空",trigger:"blur"}],categoryuuid:[{required:!0,message:"请选择图书种类",trigger:"change"}]},catalogueData:[]}},created:function(){this.getList()},methods:{getList:function(){var e=this;this.loading=!0,Object(i["e"])(this.queryParams).then((function(t){e.bookList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={bookId:null,bookuuid:null,categoryuuid:null,bookname:null,author:null,price:null,buydate:null,img:null,delFlag:null,createBy:null,createTime:null,updateBy:null,updateTime:null,remark:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=this.getList()},resetQuery:function(){this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.bookId})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.getCategory(),this.reset(),this.open=!0,this.title="添加新书购入"},handleUpdate:function(e){var t=this;this.reset(),this.getCategory();var r=e.bookId||this.ids;Object(i["c"])(r).then((function(e){t.form=e.data,t.open=!0,t.title="修改新书购入"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.bookId?Object(i["g"])(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):Object(i["a"])(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,r=e.bookId||this.ids;this.$modal.confirm('是否确认删除新书购入编号为"'+r+'"的数据项？').then((function(){return Object(i["b"])(r)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("admin/book/export",Object(n["a"])({},this.queryParams),"book_".concat((new Date).getTime(),".xlsx"))},getCategory:function(){var e=this;Object(l["e"])().then((function(t){e.catalogueData=t.data}))},handleBrrowBook:function(e){var t=this,r=e.bookId||this.ids,a="";if(null!=e.bookId&&""!=e.bookId)a="借阅"+e.bookname;else{var o=new Map;this.bookList.forEach((function(e){o.set(e.bookId,e)})),a="借阅"+this.ids.length+"本书，";for(var n=0;n<this.ids.length;n++){var i=o.get(this.ids[n]);a+=i.bookname+" "}}this.$modal.confirm(a).then((function(){return Object(u["h"])(r)})).then((function(){t.getList(),t.$modal.msgSuccess("借书成功")})).catch((function(){}))}}},s=c,d=r("2877"),m=Object(d["a"])(s,a,o,!1,null,null,null);t["default"]=m.exports},9539:function(e,t,r){"use strict";r.d(t,"d",(function(){return o})),r.d(t,"c",(function(){return n})),r.d(t,"a",(function(){return i})),r.d(t,"f",(function(){return l})),r.d(t,"b",(function(){return u})),r.d(t,"e",(function(){return c}));var a=r("b775");function o(e){return Object(a["a"])({url:"/admin/catalogue/list",method:"get",params:e})}function n(e){return Object(a["a"])({url:"/admin/catalogue/"+e,method:"get"})}function i(e){return Object(a["a"])({url:"/admin/catalogue",method:"post",data:e})}function l(e){return Object(a["a"])({url:"/admin/catalogue",method:"put",data:e})}function u(e){return Object(a["a"])({url:"/admin/catalogue/"+e,method:"delete"})}function c(){return Object(a["a"])({url:"/admin/catalogue/listCatalogueAll",method:"get"})}}}]);
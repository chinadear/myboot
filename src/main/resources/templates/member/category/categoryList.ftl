<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="addCate()">增加分类</button>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12" id="catetable">
			<#include "categoryTable.ftl">
		</div>
	</div>
	<div class="row ">
		<div class="paging-component"></div>
	</div>
</div>
<!--增加角色页面-->
<div class="modal fade in" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">新增分类</h4>  
	        </div>  
			<div class="modal-body">  
		    	<#include "addCategory.ftl">
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="add_submit()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->  
<!--修改角色页面-->
<div class="modal fade in" id="editModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">编辑分类</h4>  
	        </div>  
			<div class="modal-body">  
		    	<p id="edittemp"></p>
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="edit_submit()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->
 <script type="text/javascript">
	function cateTable(currPage) {
		$("#catetable").load("${rc.contextPath}/category/noSitemesh/loadcatetable",{pageNo:currPage},function(){});
	}
	//翻页组件初始化，翻页组件暂时职能采用table的load来刷新翻页的列表
	function callBackPagination() {
	    $('.paging-component').extendPagination({
	        totalCount:${cateList.totalCount},//总记录数
	        showPage:5,//分页栏显示页数，其他页数...代替
	        limit:10,//每页显示记录数
	        callback: function (curr, limit, totalCount) {//curr当前页数
	            cateTable(curr);
	        }
	    });
	}
 	window.onload = function(){
 		callBackPagination();
 		//编辑
 		comp.validate.addRemote("cateNameIsExsit","${rc.contextPath}/category/isExsit/name",{name:function(){return $("#name").val();},id:function(){return $("#id").val();}},"分类名称有重复");
		//新增
		comp.validate.addRemote("cateNameIsExsit_","${rc.contextPath}/category/isExsit/name",{name:function(){return $("#name_").val();}},"分类名称有重复");
		initAddValidate();
 	}
 	function editCate(id){
	 	$("#edittemp").load("${rc.contextPath}/category/noSitemesh/editCate",{"id":id},function(){
			initEditValidate();
	 	});
		comp.showModal('editModal');
	 }
 	function addCate(){
		$(".addCategoryForm").compReset();
		comp.showModal('addModal');
	}
 	function deleteCate(id,name){
 		var r=confirm("确定要删除“"+name+"”分类？");
 		if(r){
 			window.location.href="${rc.contextPath}/category/delete/"+id;
 		}
 	}
 	function add_submit(){
 		$(".addCategoryForm").submit();
 	}
 	function edit_submit(){
 		$(".editCategoryForm").submit();
 	}
 	function initAddValidate(){
		$(".addCategoryForm").compValidate({
			rules:{
				name_:{required: true,maxlength: 50,cateNameIsExsit_:true},
				comments_: {maxlength: 150}
					},
			messages:{
				name_:{required:"请填写一个分类名称"}
				}
		});
	}
 	function initEditValidate(){
		$(".editCategoryForm").compValidate({
			rules:{
				name:{required: true,maxlength: 50,cateNameIsExsit:true},
				comments: {maxlength: 150}
					},
			messages:{
				name:{required:"请填写一个分类名称"}
				}
		});
	}
</script>
</body>
</html>
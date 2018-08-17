<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="addRole()">增加角色</button>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12 roletable-balabala">
			<#include "roleTable.ftl">
		</div>
	</div>
	<div class="row ">
		<div id="callBackPager" style="position:fixed;bottom:25px;right:15px;/*float:right; margin-right:15px;margin-top:-35px; */"></div>
	</div>
</div>
<!--增加角色页面-->
<div class="modal fade in" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">新增角色</h4>  
	        </div>  
			<div class="modal-body">  
		    	<#include "addRole.ftl">
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
		        <h4 class="modal-title">编辑角色</h4>  
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
	function roleTable(currPage, limit, total) {
		$(".roletable-balabala").load("${rc.contextPath}/noSitemesh/role/loadroletable",{pageNo:currPage},function(){});
	}
	function callBackPagination() {
	    $('#callBackPager').extendPagination({
	        totalCount:${roleList.totalCount},//总记录数
	        showPage:5,//分页栏显示页数，其他页数...代替
	        limit:10,//每页显示记录数
	        callback: function (curr, limit, totalCount) {//curr当前页数
	            roleTable(curr, limit, totalCount);
	        }
	    });
	}
 	window.onload = function(){
 		callBackPagination();
 		//编辑
 		comp.validate.addRemote("roleNameIsExsit","${rc.contextPath}/role/isExsit/name",{name:function(){return $("#name").val();},id:function(){return $("#id").val();}},"角色名称有重复");
		comp.validate.addRemote("roleCodeIsExsit","${rc.contextPath}/role/isExsit/code",{code:function(){return $("#code").val();},id:function(){return $("#id").val();}},"角色编码有重复");
		//新增
		comp.validate.addRemote("roleNameIsExsit_","${rc.contextPath}/role/isExsit/name",{name:function(){return $("#name_").val();}},"角色名称有重复");
		comp.validate.addRemote("roleCodeIsExsit_","${rc.contextPath}/role/isExsit/code",{code:function(){return $("#code_").val();}},"角色编码有重复");
		initAddValidate();
 	}
 	function editRole(id){
	 	$("#edittemp").load("${rc.contextPath}/noSitemesh/role/editRole",{"id":id},function(){
			initEditValidate();
	 	});
		comp.showModal('editModal');
	 }
 	function addRole(){
		$(".addRoleForm").compReset();
		comp.showModal('addModal');
	}
 	function deleteRole(id,name){
 		var r=confirm("确定要删除“"+name+"”角色？");
 		if(r){
 			window.location.href="${rc.contextPath}/role/delete/"+id;
 		}
 	}
 	function add_submit(){
 		$(".addRoleForm").submit();
 	}
 	function edit_submit(){
 		$(".editRoleForm").submit();
 	}
 	function initAddValidate(){
		$(".addRoleForm").compValidate({
			rules:{
				name_:{required: true,maxlength: 150,roleNameIsExsit_:true},
				code_:{required: true,maxlength: 150,roleCodeIsExsit_:true},
				comments_: {maxlength: 150}
					},
			messages:{
				name_:{required:"请填写一个角色名称"},
				code_:{required:"请填写角色编码"}
				}
		});
	}
 	function initEditValidate(){
		$(".editRoleForm").compValidate({
			rules:{
				name:{required: true,maxlength: 150,roleNameIsExsit:true},
				code:{required: true,maxlength: 150,roleCodeIsExsit:true},
				comments: {maxlength: 150}
					},
			messages:{
				name:{required:"请填写一个角色名称"},
				code:{required:"请填写角色编码"}
				}
		});
	}
</script>
</body>
</html>
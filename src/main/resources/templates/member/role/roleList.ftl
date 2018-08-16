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
		<div class="col-md-12">
			<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
				<thead>
					<tr>
						<th width="5%">编号</th>
						<th>角色名称</th>
						<th>角色编码</th>
    					<th>角色类型</th>
    					<th>备注</th>
    					<th width="8%">操作</th>
					</tr>
				</thead>
				<tbody>
					<#if roleList??>
						<#list roleList as r>
							<tr>   
				                <td>${r_index+1}</td>
				                <td class="autocut">${(r.name!)?html}</td>
				                <td class="autocut">${(r.code!)?html}</td>
				                <td class="autocut"><#if r.type??><#if r.type=='1'>系统角色<#else>成员角色</#if></#if></td>
				                <td class="autocut">${(r.comments!)?html}</td>
				                <td>
									<a href="#" onclick="editRole('${r.id!}')" title="修改角色"><i class="glyphicon glyphicon-edit"></i></a>
									<a href="#" onclick="deleteRole('${r.id!}','${r.name}')" title="删除角色"><i class="glyphicon glyphicon-trash"></i></a>
				                </td>  
		               		</tr>  
						</#list>
					</#if>
				</tbody>
			</table>
		</div>
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
 	window.onload = function(){
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
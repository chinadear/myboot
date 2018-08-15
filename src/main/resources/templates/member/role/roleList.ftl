<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="">控制</button>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12">
			<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
				<thead>
					<tr>
						<th width="5%">编号</th>
						<th>昵称</th>
						<th>姓名</th>
    					<th>手机号</th>
    					<th>QQ号</th>
    					<th>Email</th>
    					<th>openId</th>
    					<th>出生日期</th>
    					<th>通讯地址</th>
    					<th>上次登录</th>
    					<th>创建日期</th>
    					<th width="8%">操作</th>
					</tr>
				</thead>
				<tbody>
					<#if userList??>
						<#list userList as u>
							<tr>   
				                <td>${u_index+1}</td>
				                <td class="autocut">${(u.name!)?html}</td>
				                <td class="autocut">${(u.realName!)?html}</td>
				                <td class="autocut">${(u.phone!)?html}</td>
				                <td class="autocut">${(u.qq!)?html}</td>
				                <td class="autocut">${(u.email!)?html}</td>
				                <td class="autocut">${(u.openid!)?html}</td>
				                <td class="autocut"><#if u.birthday??>${u.birthday?date('yyyy-MM-dd')}</#if></td>
				                <td class="autocut">${(u.address!)?html}</td>
				                <td class="autocut">${u.lastLoginTime!}</td>
				                <td class="autocut">${u.createTime!}</td>
				                <td>
									<a href="#" onclick="" title="修改"><i class="fa fa-edit"></i></a>
									<a href="#" onclick="" title="重置密码"><i class="fa fa-lock"></i></a>
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
				<button type="button" class="btn btn-primary" id="sure" onclick="addRole()">确认</button>  
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
				<button type="button" class="btn btn-primary" id="sure" onclick="editRole()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->
 <script type="text/javascript">
 	window.onload = function(){
 		//编辑
 		comp.validate.addRemote("roleNameIsExsit_","${rc.contextPath}/role/isExsit/name",{name:function(){return $("#name_").val();},id:function(){return $("#id").val();}},"角色名称有重复");
		comp.validate.addRemote("roleCodeIsExsit_","${rc.contextPath}/role/isExsit/code",{name:function(){return $("#code_").val();},id:function(){return $("#id").val();}},"角色编码有重复");
		//新增
		comp.validate.addRemote("roleNameIsExsit","${rc.contextPath}/role/isExsit/name",{name:function(){return $("#name").val();}},"角色名称有重复");
		comp.validate.addRemote("roleCodeIsExsit","${rc.contextPath}/role/isExsit/code",{name:function(){return $("#code").val();}},"角色编码有重复");
		initAddValidate();
 	}
 	function popEditWin(id){
	 	$("#edittemp").load("${rc.contextPath}/noSitemesh/role/editRole",{"id":id},function(){
			initEditValidate();
	 	});
		comp.showModal('editModal');
	 }
 	function popAddWin(){
		$(".addRoleForm").compReset();
		comp.showModal('addModal');
	}
 	function initAddValidate(){
		$(".addRoleForm").compValidate({
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
 	function initEditValidate(){
		$(".editRoleForm").compValidate({
			rules:{
				name_:{required: true,maxlength: 150,roleNameIsExsit_:true},
				code_:{required: true,maxlength: 150,roleCodeIsExsit_:true},
				comments_: {maxlength: 150}
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
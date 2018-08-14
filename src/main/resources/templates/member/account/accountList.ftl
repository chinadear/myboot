<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	  	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="showAddConfDialog();">创建账户</button>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12">
			<h3 class="heading">账户列表</h3>
			<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
				<thead>
					<tr>
						<th width="10%">编号</th>
						<th>用户名</th>
    					<th>账户</th>
    					<th>手机号</th>
    					<th>上次登录日期</th>
    					<th>创建日期</th>
    					<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
					<#if accountList??>
						<#list accountList as al>
							<tr>   
				                <td>${al_index+1}</td>
				                <td class="autocut">${(al.userId.name!)?html}</td>
				                <td class="autocut">${(al.username!)?html}</td>
				                <td class="autocut">${(al.userId.phone!)?html}</td>
				                <td class="autocut">${al.userId.lastLoginTime!}</td>
				                <td class="autocut">${al.createTime!}</td>
				                <td>
				                	<#if al.userId.userType!='0'>
				                		<a href="#" onclick="delSysConfig('${al.id}')" title="删除"><i class="fa fa-trash-o"></i></a>
									</#if>
									<a href="#" onclick="editsysconfig('${al.id}')" title="修改"><i class="fa fa-edit"></i></a>
									<a href="#" onclick="editsysconfig('${al.id}')" title="重置密码"><i class="fa fa-lock"></i></a>
				                </td>  
		               		</tr>  
						</#list>
					</#if>
				</tbody>
			</table>
		</div>
	</div>
</div>
 <script type="text/javascript">
 	window.onload = function(){
 		comp.validate.addRemote("keyIsExsit","${rc.contextPath}/system/config/judgyKey",{key:function(){return $('#config_key').val()}},"key值已存在，请使用其他key值");
 	}
 	function showAddConfDialog(){
 		initAddValidate();
 		$(".addSysConfigForm").compReset();
 		comp.showModal('addModal');
 	}
 	function editsysconfig(id){
 		$("#edittemp").load("${rc.contextPath}/noSitemesh/system/config/initEdit",{"id":id},function(){
			initEditValidate();
	 	});
 		comp.showModal('editModal');
 	}
 	function add_submit(){
 		$(".addSysConfigForm").submit();
 	}
 	function edit_submit(){
 		$(".editSysConfigForm").submit();
 	}
	function delSysConfig(id){
		comp.confirm("确定要删除该配置？",function(r){
			if(r){
				window.location.href="${rc.contextPath}/system/config/delete/"+id;
			}
		});
	}
	function initAddValidate(){
		$(".addSysConfigForm").compValidate({
			rules:{
				config_key: { required: true, 
							  maxlength: 20,
							  keyIsExsit:true,
							  uwsnumchar:true
							},
				config_value: {maxlength: 150},
				config_comment: {maxlength: 100
							},
					},
			messages:{
				config_key:{required:"key不能为空"}
				}
		});
	}
	function initEditValidate(){
		$(".editSysConfigForm").compValidate({
			rules:{
				config_value_: {maxlength: 150},
				config_comment_: {maxlength: 100
							},
					}
		});
	}
</script>
</body>
</html>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="modifypersional();">修改个人信息</button>
</div>
<div class="container-fluid innerScroll">
	<div class="row">
 		<div class="col-md-3" style="border-right:1px solid #e6e1e1;margin-top:10px;">
			<div class="form-group">
				<div style="text-align:center;">
				<img src="${rc.contextPath}/account/headerimg/${sessionUser.userId}" class="img-circle" style="width:190px;height:190px;" alt="User Image">
			   	</div>
			   	<div id="modifyheader" style="text-align:center;">
			   		<a href="##" onclick="modifyheader()">[更换头像]</a>
				</div>
				<div id="uploadarea" style="display:none;text-align:center;">
				    <div class="col-sm-12" style="text-align:center;">
				    <form enctype="multipart/form-data" id="uploadform" method="post" action="${rc.contextPath}/account/persional/headerimg/modify">
					    <input type="file" id="file" name="file">
					    <p class="help-block">请上传jpg、png图片文件</p>
				    	<p><a href="##" onclick="submit_img()" class="btn btn-primary btn-sm" title="确认"><i class="glyphicon glyphicon-ok"></i></a><a href="##" onclick="cancle()" class="btn btn-primary btn-sm" style="margin-left:3px;" title="取消"><i class="glyphicon glyphicon-remove"></i></a></p>
				    </form>
				    </div>
			    </div>
			</div>
		</div>
 		<div class="col-md-9">
 			<div class="row" id="viewpersional" style="margin-top:10px;">
 				<div class="col-md-12">
 					<form class="form-horizontal">
						<div class="form-group">
						    <label for="config_key" class="col-sm-2 control-label">昵称：</label>
					   		<div class="col-sm-9">
								<p class="col-sm-4 form-control-static">${(userLogin.userId.name!)?html}</p>
							</div>
						</div>
						<div class="hr-bottom"></div>
						<div class="form-group">
						    <label for="config_key" class="col-sm-2 control-label">实名：</label>
					   		<div class="col-sm-9">
								<p class="col-sm-4 form-control-static">${(userLogin.userId.realName!)?html}</p>
							</div>
						</div>
						<div class="hr-bottom"></div>
						<div class="form-group">
							<label for="config_value" class="col-sm-2 control-label">账号：</label>
							<div class="col-sm-9">
					   			<p class="col-sm-4 form-control-static">${(userLogin.username!)?html}</p>
							</div>
						</div>
						<div class="hr-bottom"></div>
						<div class="form-group">
							<label for="config_comment" class="col-sm-2 control-label">手机号：</label>
							<div class="col-sm-9">
								<p class="col-sm-4 form-control-static">${(userLogin.userId.phone!)?html}</p>
							</div>
						</div>
						<div class="hr-bottom"></div>
						<div class="form-group">
							<label for="config_comment" class="col-sm-2 control-label">QQ号：</label>
							<div class="col-sm-9">
								<p class="col-sm-4 form-control-static">${(userLogin.userId.qq!)?html}</p>
							</div>
						</div>
						<div class="hr-bottom"></div>
						<div class="form-group">
							<label for="config_comment" class="col-sm-2 control-label">Email：</label>
							<div class="col-sm-9">
								<p class="col-sm-4 form-control-static">${(userLogin.userId.email!)?html}</p>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row" style="display:none;margin-top:10px;" id="editpersional">
 				<div class="col-md-12">
 					<#include "accountEdit.ftl">
 					<div style="text-align:center;">
 					<button type="button" class="btn btn-primary btn-sm" onclick="edit_submit();">确认</button>
 					<button type="button" class="btn btn-sm" onclick="canclem();">取消</button>
 					</div>
 				</div>
			</div>
 		</div>
 	</div>
</div>
<script type="text/javascript">
window.onload = function(){
	comp.validate.addRemote("nameIsExsit","${rc.contextPath}/account/isExsit/name",{name:function(){return $('#name').val();},id:function(){return $("#id").val();}},"此昵称已存在");
	initEditValidate();
}
function modifyheader(){
	$("#modifyheader").hide();
	$("#uploadarea").show();
	$("#file").val("");
}
function cancle(){
	$("#modifyheader").show();
	$("#uploadarea").hide();
}
function canclem(){
	$("#viewpersional").show();
	$("#editpersional").hide();
}
function submit_img(){
	$("#uploadform").submit();
}
function modifypersional(){
	$("#viewpersional").hide();
	$("#editpersional").show();
}
//提交编辑内容
function edit_submit(){
	$("#flag").val("1");
	$(".editAccountForm").submit();
}
function initEditValidate(){
	$(".editAccountForm").compValidate({
		rules:{
			name:{required: true,maxlength: 150,nameIsExsit:true},
			realName:{required: true,maxlength: 150},
			phone: {number:true,maxlength: 20},
			qq: {number:true,maxlength: 15},
			email: {email:true,maxlength: 150}
				},
		messages:{
			name:{required:"请为您自己起个昵称"},
			realName:{required:"请填写您的姓名"},
			phone:{number:"请输入正确格式的手机号"},
			qq: {number:"请输入正确格式的QQ号码"}
			}
	});
}
</script>
</body>
</html>
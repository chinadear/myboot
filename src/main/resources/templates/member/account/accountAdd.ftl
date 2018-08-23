<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
		<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="goback();">返回</button>
	  	<!-- <a type="button" class="optionbtn-left" href="##" onclick="goback()"><i class="glyphicon glyphicon-menu-left">返回</i></a> -->
</div>
<div class="container-fluid innerScroll">
	<ul class="nav nav-tabs mytab" role="tablist">
		<li role="presentation" class="active"><a href="#first" aria-controls="first" role="tab" data-toggle="tab">1.创建账号</a></li>
		<li role="presentation" ><a href="#second" class="nouse" aria-controls="second" role="tab" data-toggle="tab">2.填写用户信息</a></li>
	</ul>
  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="first">
		<form class="form-horizontal addAccountForm1" style="margin-top:10px;">
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label"><font color="red">*</font>账号：</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="username_" name="username_" maxlength="50" value="" placeholder="账号">
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label"><font color="red">*</font>密码：</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" id="password_" name="password_" value="" placeholder="密码">
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label"><font color="red">*</font>确认密码：</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" id="repassword" name="repassword" value="" placeholder="确认密码">
				</div>
			</div>
		</form>
	</div>
    <div role="tabpanel" class="tab-pane " id="second">
		<form class="form-horizontal addAccountForm" action="${rc.contextPath}/account/add" style="margin-top:10px;">
			<div class="form-group">
			    <label for="config_key" class="col-sm-2 control-label"><font color="red">*</font>昵称：</label>
		   		<div class="col-sm-9">
					<input type="text" class="form-control" id="name" name="name" maxlength="20" value="" placeholder="昵称">
				</div>
			</div>
			<div class="form-group">
			    <label for="config_key" class="col-sm-2 control-label"><font color="red">*</font>实名：</label>
		   		<div class="col-sm-9">
					<input type="text" class="form-control" id="realName" name="realName" maxlength="20" value="" placeholder="真实姓名">
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">角色：</label>
				<div class="col-sm-9">
					<select name="roleId" id="roleId" class="form-control">
						<option value="0">请选择...</option>
						<#if roles?? && roles?size gt 0>
							<#list roles as r> 
								<option value="${r.id}">${r.name}</option>
							</#list>
						</#if>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">手机号：</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="phone" name="phone" maxlength="20" value="" placeholder="手机号">
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">QQ号：</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="qq" name="qq" maxlength="15" value="" placeholder="QQ号码">
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">Email：</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="email" name="email" value="" placeholder="Email">
				</div>
			</div>
			<input type="hidden" id="username" name="username" value="">
			<input type="hidden" id="password" name="password" value="">
		</form>
	</div>
  </div>
  <div class="row" style="text-align:center;">
  	<button type="button" class="btn btn-primary btn-sm optionbtn" id="pre" style="display:none;" onclick="pre();">上一步</button>
	<button type="button" class="btn btn-primary btn-sm optionbtn" id="next" onclick="next();">下一步</button>
 	<button type="button" class="btn btn-primary btn-sm optionbtn" id="submit" style="display:none;" onclick="submit();">提交</button>
  </div>
</div>
<input type="hidden" value="0" id="index">
<script type="text/javascript">
	window.onload = function(){
		comp.validate.addRemote("accountIsExsit","${rc.contextPath}/account/isExsit/account",{username:function(){return $('#username_').val();}},"此账号已存在");
		comp.validate.addRemote("nameIsExsit","${rc.contextPath}/security/account/isExsit/name",{name:function(){return $('#name').val();}},"此昵称已存在");
		comp.validate.addRule("repasswordIsEQ",function(value,element){
			var result="t";
			var pwd=$("#password_").val()
			if(value!=pwd){
				result="f";					
			}
			return this.optional(element) || (result=='t');
		},"两次输入的密码不一致");
		initAddAccountValidate();
		initAddUserinfoValidate();
	}
	function goback(){
		window.location.href="${rc.contextPath}/account/list";
	}
	function submit(){
		$(".addAccountForm").submit();
	}
	//下一步，只需要设置（页签数量-2）的定额限制
	function next(){
		if($(".addAccountForm1").compValidator().form()){
			var index=parseInt($("#index").val());
			if(index>0){//页签数-2
				return;
			}
			$('.mytab li:eq('+index+') a').addClass("nouse");
			$('.mytab li:eq('+(index+1)+') a').tab('show').removeClass("nouse");
			$("#index").val(index+1);
			//以上是通用的，下面是控制按钮显示的
			$("#pre").show();
			$("#next").hide();
			$("#submit").show();
			$("#username").val($("#username_").val());
			$("#password").val($("#password_").val());
		}
	}
	//上一步
	function pre(){
		var index=parseInt($("#index").val());
		if(index<=0){
			return;
		}
		$('.mytab li:eq('+(index-1)+') a').tab('show').removeClass("nouse");
		$('.mytab li:eq('+(index)+') a').addClass("nouse");
		$("#index").val(index-1);
		//以上是通用的，下面是控制按钮显示的
		$("#pre").hide();
		$("#next").show();
		$("#submit").hide();
	}
	function initAddAccountValidate(){
		$(".addAccountForm1").compValidate({
			rules:{
				username_:{required: true,maxlength: 50,uwsnumcharcn:true,accountIsExsit:true},
				password_:{required: true,maxlength: 50},
				repassword: {required:true,maxlength: 50,repasswordIsEQ:true},
					},
			messages:{
				username_:{required:"请填写账号"},
				password_:{required:"请设置密码"},
				repassword:{required:"请确认密码"}
				}
		});
	}
	function initAddUserinfoValidate(){
		$(".addAccountForm").compValidate({
			rules:{
				name:{required: true,maxlength: 50,nameIsExsit:true},
				realName:{required: true,maxlength: 50},
				phone: {number:true,maxlength: 20},
				qq: {number:true,maxlength: 15},
				email: {email:true,maxlength: 150}
					},
			messages:{
				name:{required:"请填写昵称"},
				realName:{required:"请填写真实姓名"},
				phone:{number:"请输入正确格式的手机号"},
				qq: {number:"请输入正确格式的QQ号码"}
				}
		});
	}

</script>
</body>
</html>
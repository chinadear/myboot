<form class="form-horizontal editAccountForm" action="${rc.contextPath}/account/edit">
	<div class="form-group">
	    <label for="config_key" class="col-sm-2 control-label"><font color="red">*</font>用户名：</label>
   		<div class="col-sm-9">
			<input type="text" class="form-control" id="name" name="name" value="${(userLogin.userId.name!)?html}" placeholder="用户名">
		</div>
	</div>
	<div class="form-group">
	    <label for="config_key" class="col-sm-2 control-label"><font color="red">*</font>姓名：</label>
   		<div class="col-sm-9">
			<input type="text" class="form-control" id="realName" name="realName" value="${(userLogin.userId.realName!)?html}" placeholder="姓名">
		</div>
	</div>
	<div class="form-group">
		<label for="config_value" class="col-sm-2 control-label">账户：</label>
		<div class="col-sm-9">
   			<label class="col-sm-4 control-label">${(userLogin.username!)?html}</label>
		</div>
	</div>
	<div class="form-group">
		<label for="config_comment" class="col-sm-2 control-label">手机号：</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="phone" name="phone" value="${(userLogin.userId.phone!)?html}" placeholder="手机号">
		</div>
	</div>
	<div class="form-group">
		<label for="config_comment" class="col-sm-2 control-label">QQ号：</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="qq" name="qq" value="${(userLogin.userId.qq!)?html}" placeholder="QQ号码">
		</div>
	</div>
	<div class="form-group">
		<label for="config_comment" class="col-sm-2 control-label">Email：</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="email" name="email" value="${(userLogin.userId.email!)?html}" placeholder="Email">
		</div>
	</div>
	<input type="hidden" id="id" name="id" value="${userLogin.userId.id}">
</form>
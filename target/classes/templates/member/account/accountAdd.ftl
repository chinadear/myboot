<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	  	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="next();">下一步</button>
	  	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="pre();">上一步</button>
	  	<a type="button" class="optionbtn-left" href="javascript:history.go(-1);"><i class="fa fa-chevron-left">&nbsp;返回</i></a>
</div>
<div class="container-fluid innerScroll">
	<ul class="nav nav-tabs mytab" role="tablist">
		<li role="presentation" class="active"><a href="#first" aria-controls="first" role="tab" data-toggle="tab">第一步</a></li>
		<li role="presentation" ><a href="#second" class="nouse" aria-controls="second" role="tab" data-toggle="tab">第二步</a></li>
	</ul>
  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane fade in active" id="first">
		<form class="form-horizontal editAccountForm" action="${rc.contextPath}/account/edit" style="margin-top:10px;">
			<div class="form-group">
			    <label for="config_key" class="col-sm-2 control-label"><font color="red">*</font>用户名：</label>
		   		<div class="col-sm-9">
					<input type="text" class="form-control" id="name" name="name" value="" placeholder="用户名">
				</div>
			</div>
			<div class="form-group">
			    <label for="config_key" class="col-sm-2 control-label"><font color="red">*</font>姓名：</label>
		   		<div class="col-sm-9">
					<input type="text" class="form-control" id="realName" name="realName" value="" placeholder="用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="config_value" class="col-sm-2 control-label">账户：</label>
				<div class="col-sm-9">
		   			<label class="col-sm-4 control-label"></label>
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">手机号：</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="phone" name="phone" value="" placeholder="手机号">
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">QQ号：</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="qq" name="qq" value="" placeholder="QQ号码">
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">Email：</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="email" name="email" value="" placeholder="Email">
				</div>
			</div>
		</form>
	</div>
    <div role="tabpanel" class="tab-pane fade " id="second">
	    <form class="form-horizontal editAccountForm" action="${rc.contextPath}/account/edit" style="margin-top:10px;">
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">手机号：</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="phone" name="phone" value="" placeholder="手机号">
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">手机号：</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" id="password" name="password" value="" placeholder="手机号">
				</div>
			</div>
			<div class="form-group">
				<label for="config_comment" class="col-sm-2 control-label">再次：</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" id="repassword" name="repassword" value="" placeholder="手机号">
				</div>
			</div>
		</form>
	</div>
  </div>
</div>
<input type="hidden" value="0" id="index">
<script type="text/javascript">
	window.onload = function(){
		
	}
	//通用下一步，只需要设置（页签数量-2）的定额限制
	function next(){
		var index=parseInt($("#index").val());
		if(index>0){//页签数-2
			return;
		}
		$('.mytab li:eq('+index+') a').addClass("nouse");
		$('.mytab li:eq('+(index+1)+') a').tab('show').removeClass("nouse");
		$("#index").val(index+1);
	}
	//通用上一步
	function pre(){
		var index=parseInt($("#index").val());
		if(index<=0){
			return;
		}
		$('.mytab li:eq('+(index-1)+') a').tab('show').removeClass("nouse");
		$('.mytab li:eq('+(index)+') a').addClass("nouse");
		$("#index").val(index-1);
	}


</script>
</body>
</html>
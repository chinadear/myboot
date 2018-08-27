<!DOCTYPE HTML>
<html>
<head>
<title>BootPlus</title>
<meta name="keywords" content="bootplus,开发平台,链接一切">
<meta name="description" content="bootplus开发平台学习">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="${rc.contextPath}/css/login/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${rc.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
</head>
<body>
<!-- contact-form -->	
<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>登陆Bootplus</h1>
	</div>
	<form class="form-horizontal" form action="${rc.contextPath}/login" method="post">
		<div style="text-align: center;"><font color="red" id="tipfont">${meg!}</font></div>
		<div class="form-group">
			<div class="input-group">
				<div class="input-group-addon "><li class="glyphicon glyphicon-user"></li></div>
				<input type="text" class="form-control" name="username" id="username" placeholder="账号">
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<div class="input-group-addon "><li class="glyphicon glyphicon-lock"></li></div>
				<input type="password" class="form-control" name="password" id="password"  placeholder="密码">
			</div>
		</div>
		<div class="form-group" style="text-align:right;">
			<div class="input-group" >
				<input type="text" class="form-control" name="kaptcha" placeholder="验证码"  maxlength="4" style="width:100px;height:50px;">
				<img src="${rc.contextPath}/auth/noSecurity/getKaptchaImage" style="height:50px;" onclick="this.src='${rc.contextPath}/auth/noSecurity/getKaptchaImage?abc='+Math.random()" class="captcha changeCaptcha pull-left margin-r-5" title="看不清楚？点一下"/>
				<a href="javascript:changekaptcha();">换一张</a>
			</div>
		</div>
		<div class="form-group" >
			<a href="${rc.contextPath}/registerAdmin" >注册账号</a>
			<button type="submit" class="button" id="submit" >登录</button>
		</div>
	</form>
	</div>					
</div>
<div class="footer">
	<p>Copyright &copy; 2014.</p>
</div>
<script src="${rc.contextPath}/webjars/jquery/3.1.1/jquery.min.js"></script> 
<script src="${rc.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
<script type="text/javascript">
function changekaptcha(){
	$(".captcha").attr("src","${rc.contextPath}/auth/noSecurity/getKaptchaImage?abc='+Math.random()");
}
</script>
</body>
</html>
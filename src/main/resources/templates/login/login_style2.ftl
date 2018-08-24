<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>myboot 后台管理系统登陆</title>
<meta name="keywords" content="后台登陆页面模板,后台登录界面html,后台登录模板,后台登录页面html,后台管理系统后台登录模板">
<meta name="description" content="cssmoban提供后台管理系统登录界面html模板学习和下载">
<meta name="viewport" content="width=device-width">
<link href="${rc.contextPath}/css/login/base.css" rel="stylesheet" type="text/css">
<link href="${rc.contextPath}/css/login/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 
【说明】
2018-08-24
此页面暂时不用
作为备用登录页面，暂时不用 
-->
<div class="login">
<form action="${rc.contextPath}/login" method="post" name="f">
	<div class="logo">
		
    </div>
    <div class="login_form">
    	<div class="user">
        	<input class="text_value" value="" name="username" placeholder="请输入账号..." type="text" id="username">
            <input class="text_value" value="" name="password" placeholder="请输入密码..." type="password" id="password">
        </div>
        <div class="input-group" style="width: 259px;float: right;position: relative;">
	    	<input type="text" name="kaptcha" style="text-align:center;height:56.5px;width:80px;position: relative;bottom: 32px;border:10px solid #e3e7ea;background-color: #f5f6f7;border-top-left-radius: 5px;border-bottom-left-radius: 5px;" placeholder="验证码">
			<img src="${rc.contextPath}/auth/noSecurity/getKaptchaImage" onclick="this.src='${rc.contextPath}/auth/noSecurity/getKaptchaImage?abc='+Math.random()" style="position: relative;width:80px;height:75.5px;left: -2.5px;border-bottom-right-radius: 5px;top: 1.7px;" class="captcha changeCaptcha pull-left margin-r-5" title="看不清楚？点一下"/>
	    	<button class="button" id="submit" type="submit" style="position: relative;left: -27px;top: -8.2px;">登录</button>
        </div>
    </div>
    
</form>
    <div id="tip"><font color="red" id="tipfont">${meg!}</font></div>
    <div class="foot">
    Copyright © 2011-2015  All Rights Reserved. More Templates <a href="${rc.contextPath}/registerAdmin" title="点击增加管理员账号">点击增加管理员账号</a> - Collect from <a href="http://www.baidu.com/" title="百度" target="_blank">百度</a>
    </div>
</div>
</body>
</html>

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12">
			<h1>欢迎来到后台管理系统</h1>
			<h3><#if sessionUser??>${sessionUser.name!} </#if>,您的到来使本系统蓬荜生辉！</h3>
		</div>
	</div>
</div>
</body>
</html>
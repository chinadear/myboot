<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
 <script type="text/javascript">
	function ppp(){
		window.location.href="${rc.contextPath}/list?id="+$("#index").val();
	}
	function qqq(){
		window.location.href="${rc.contextPath}/addUser?pwd="+$("#password").val();
	}
</script>
<div  class="inner-header">
	<input type="text" id="index" value="" /> 
	密码:<input type="text" id="password" value="" />
  <a href="##" class="btn btn-primary btn-sm optionbtn" onclick="qqq();">创建用户</a>
  <a href="##" class="btn btn-primary btn-sm optionbtn" onclick="ppp();">刷新</a>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12">
			<h3 class="heading">列表信息</h3>
			<table class="table table-bordered table-striped  table-hover" id="smpl_tbl">
				<thead>
					<tr>
						<th>ID</th>
						<th>用户</th>
    					<th>姓名</th>
    					<th>电话</th>
    					<th>邮箱</th>
    					<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<#list hb0101s as hb0101>   
   						<tr>   
			                <td>${hb0101.id!}</td>
			                <td>${hb0101.hb0101001!}</td>
			                <td>${hb0101.hb0101002!}</td>
			                <td>${hb0101.hb0101003!}</td>
			                <td>${hb0101.hb0101004!}</td>
			                <td><a href="${rc.contextPath}/delete?id=${hb0101.id!}" >删除</a></td>  
		               </tr>  
		            </#list>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>
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
									<!-- <a href="#" onclick="" title="修改"><i class="fa fa-edit"></i></a>
									<a href="#" onclick="" title="重置密码"><i class="fa fa-lock"></i></a> -->
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
 	}
</script>
</body>
</html>
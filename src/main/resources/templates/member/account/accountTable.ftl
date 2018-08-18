<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
	<thead>
		<tr>
			<th width="5%">编号</th>
			<th>昵称</th>
			<th>账号</th>
			<th>实名</th>
			<th>手机号</th>
			<th>QQ号</th>
			<th>Email</th>
			<th>上次登录日期</th>
			<th>创建日期</th>
			<th width="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		<#if page??>
			<#list page.result as al>
				<tr>   
	                <td>${al_index+1}</td>
	                <td class="autocut">${(al.userId.name!)?html}</td>
	                <td class="autocut">${(al.username!)?html}</td>
	                <td class="autocut">${(al.userId.realName!)?html}</td>
	                <td class="autocut">${(al.userId.phone!)?html}</td>
	                <td class="autocut">${(al.userId.qq!)?html}</td>
	                <td class="autocut">${(al.userId.email!)?html}</td>
	                <td class="autocut">${al.userId.lastLoginTime!}</td>
	                <td class="autocut">${al.createTime!}</td>
	                <td>
						<a href="#" onclick="editAccount('${al.id}')" title="修改"><i class="glyphicon glyphicon-edit"></i></a>
						<a href="#" onclick="resetPassword('${al.id}','${al.username!}')" title="重置密码"><i class="glyphicon glyphicon-lock"></i></a>
	                	<#if al.userId.userType!='0'>
	                		<a href="#" onclick="delAccount('${al.id}','${al.username!}')" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
						</#if>
	                </td>  
           		</tr>  
			</#list>
		</#if>
	</tbody>
</table>
<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
	<thead>
		<tr>
			<th width="5%">编号</th>
			<th width="10%">IP</th>
			<th>留言</th>
			<th width="13%">创建日期</th>
			<th width="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		<#if page??>
			<#list page.result as u>
				<tr>   
	                <td>${u_index+1}</td>
	                <td class="autocut">${(u.ip!)?html}</td>
	                <td class="autocut">${(u.message!)?html}</td>
	                <td class="autocut">${u.createTime!}</td>
	                <td>
						<a href="##" onclick="deleteMsg('${u.id!}')" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
	                </td>  
           		</tr>  
			</#list>
		</#if>
	</tbody>
</table>
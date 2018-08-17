<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
	<thead>
		<tr>
			<th width="5%">编号</th>
			<th>角色名称</th>
			<th>角色编码</th>
			<th>角色类型</th>
			<th>备注</th>
			<th width="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		<#if roleList??>
			<#list roleList.result as r>
				<tr>   
	                <td>${r_index+1}</td>
	                <td class="autocut">${(r.name!)?html}</td>
	                <td class="autocut">${(r.code!)?html}</td>
	                <td class="autocut"><#if r.type??><#if r.type=='1'>系统角色<#else>成员角色</#if></#if></td>
	                <td class="autocut">${(r.comments!)?html}</td>
	                <td>
						<a href="#" onclick="editRole('${r.id!}')" title="修改角色"><i class="glyphicon glyphicon-edit"></i></a>
						<a href="#" onclick="deleteRole('${r.id!}','${r.name}')" title="删除角色"><i class="glyphicon glyphicon-trash"></i></a>
	                </td>  
              		</tr>  
			</#list>
		</#if>
	</tbody>
</table>
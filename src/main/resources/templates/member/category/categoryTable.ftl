<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
	<thead>
		<tr>
			<th width="5%">编号</th>
			<th>分类名称</th>
			<th>备注</th>
			<th width="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		<#if cateList??>
			<#list cateList.result as c>
				<tr>   
	                <td>${c_index+1}</td>
	                <td class="autocut">${(c.name!)?html}</td>
	                <td class="autocut">${(c.comments!)?html}</td>
	                <td>
						<a href="#" onclick="editCate('${c.id!}')" title="修改分类"><i class="glyphicon glyphicon-edit"></i></a>
						<a href="#" onclick="deleteCate('${c.id!}','${c.name!}')" title="删除分类"><i class="glyphicon glyphicon-trash"></i></a>
	                </td>  
              		</tr>  
			</#list>
		</#if>
	</tbody>
</table>
<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
	<thead>
		<tr>
			<th width="5%">编号</th>
			<th width="15%">分类名称</th>
			<th width="15%">所属板块</th>
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
	                <td class="autocut">
						<!-- <#switch c.type> 
							<#case '0'>
								博客
							<#break> 
							<#case '1'>
								从0-1
							<#break> 
							<#case '2'>
								行业资讯
							<#break> 
							<#case '3'>
								首页
							<#break> 
							<#default>博客
						</#switch> -->
						<#if list??>
							<#list list as l>
								<#if l.code==c.type>
									${l.name!}
									<#break>
								</#if>
							</#list>
						</#if>
					</td>
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
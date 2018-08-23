<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
	<thead>
		<tr>
			<th width="5%">编号</th>
			<th>标题</th>
			<th>摘要</th>
			<th>状态</th>
			<th>创建日期</th>
			<th width="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		<#if page??>
			<#list page.result as u>
				<tr>   
	                <td>${u_index+1}</td>
	                <td class="autocut">${(u.title!)?html}</td>
	                <td class="autocut">${(u.summary!)?html}</td>
	                <td class="autocut"><#if u.status??><#if u.status=='0'>草稿<#elseif u.status=='1'>发布<#else>禁用</#if></#if></td>
	                <td class="autocut">${u.createTime!}</td>
	                <td>
						<a href="#" onclick="editblog('${u.id}')" title="修改"><i class="glyphicon glyphicon-edit"></i></a>
						<a href="#" onclick="delblog('${u.id}')" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
						<#if u.status=='0'>
	                		<a href="#" onclick="publish('${u.id}')" title="发布"><i class="glyphicon glyphicon-ok-circle"></i></a>
	                	<#else>
	                		<a href="#" onclick="unpublish('${u.id}')" title="取消发布"><i class="glyphicon glyphicon-minus-sign"></i></a>
	                	</#if>
	                </td>  
           		</tr>  
			</#list>
		</#if>
	</tbody>
</table>
<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
	<thead>
		<tr>
			<th width="5%">编号</th>
			<th>标题</th>
			<th>摘要</th>
			<th width="6%">板块</th>
			<th width="6%">评论</th>
			<th width="6%">状态</th>
			<th width="15%">创建日期</th>
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
	                <#switch u.plate> 
						<#case '1'><td class="autocut">从0-1</td><#break> 
						<#case '2'><td class="autocut">行业资讯</td><#break> 
						<#case '3'><td class="autocut">首页</td><#break> 
						<#default><td class="autocut">博客</td>
					</#switch>
	                <td class="autocut"><#if u.discuss?? && u.discuss=='0'>关闭<#else>开启</#if></td>
	                <td class="autocut"><#if u.status??><#if u.status=='0'>草稿<#elseif u.status=='1'>发布<#elseif u.status='2'>未发布<#else>禁用</#if></#if></td>
	                <td class="autocut">${u.createTime!}</td>
	                <td>
						<#if u.status=='2'>
							<a href="#" onclick="editblog('${u.id}')" title="修改"><i class="glyphicon glyphicon-edit"></i></a>
	                		<a href="#" onclick="publish('${u.id}')" title="发布"><i class="glyphicon glyphicon-ok-circle"></i></a>
							<a href="#" onclick="delblog('${u.id}')" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
	                	<#elseif u.status=='1'>
	                		<a href="#" onclick="unpublish('${u.id}')" title="取消发布"><i class="glyphicon glyphicon-minus-sign"></i></a>
	                	<#else>
	                		<a href="#" onclick="editblog('${u.id}')" title="修改"><i class="glyphicon glyphicon-edit"></i></a>
							<a href="#" onclick="delblog('${u.id}')" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
	                	</#if>
	                </td>  
           		</tr>  
			</#list>
		</#if>
	</tbody>
</table>
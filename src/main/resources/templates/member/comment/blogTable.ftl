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
	                <td class="autocut"><#if u.status??><#if u.status=='0'>草稿<#elseif u.status=='1'>发布<#elseif u.status='2'>未发布<#else>禁用</#if></#if></td>
	                <td class="autocut">${u.createTime!}</td>
	                <td>
	                	<#if u.isNnPub=='1'>
	                		<button class="btn btn-danger btn-xs" style="margin-top:-5px;margin-bottom:-5px;" type="button" title="查看评论" onclick="viewcomment('${u.id}')">
								<i class="glyphicon glyphicon-comment"></i> <span class="badge">${u.commentNum!'0'}</span>
							</button>
	                	<#else>
		                	<button class="btn btn-primary btn-xs" style="margin-top:-5px;margin-bottom:-5px;" type="button" title="查看评论" onclick="viewcomment('${u.id}')">
								<i class="glyphicon glyphicon-comment"></i> <span class="badge">${u.commentNum!'0'}</span>
							</button>
	                	</#if>
	                </td>  
           		</tr>  
			</#list>
		</#if>
	</tbody>
</table>
<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
	<thead>
		<tr>
			<th width="5%">编号</th>
			<th>标题</th>
			<th>摘要</th>
			<th>链接</th>
			<th>板块</th>
			<th>状态</th>
			<th>创建日期</th>
			<th>下架日期</th>
			<th width="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		<#if page??>
			<#list page.result as r>
				<tr>   
	                <td>${r_index+1}</td>
	                <td class="autocut">${(r.title!)?html}</td>
	                <td class="autocut">${(r.summary!)?html}</td>
	                <td class="autocut">${(r.url!)?html}</td>
	                <td class="autocut">
	                <#if list??&&r.plate??>
							<#list list as l>
								<#if l.code==r.plate>
									${l.name!}
									<#break>
								</#if>
							</#list>
						</#if>
					</td>
	                <td class="autocut"><#if r.status?? && r.status=="1">发布<#else>未发布</#if></td>
	                <td class="autocut">${r.createTime!}</td>
	                <td class="autocut">${r.closingDate!}</td>
	                <td>
	                	<#if r.status=='0'>
							<a href="#" onclick="editDrum('${r.id}')" title="修改"><i class="glyphicon glyphicon-edit"></i></a>
	                		<a href="#" onclick="updateStatus('${r.id}','1')" title="发布"><i class="glyphicon glyphicon-ok-circle"></i></a>
							<a href="#" onclick="delDrum('${r.id}','${(r.title!)?html}')" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
	                	<#else>
	                		<a href="#" onclick="updateStatus('${r.id}','0')" title="取消发布"><i class="glyphicon glyphicon-minus-sign"></i></a>
	                	</#if>
	                </td>  
              		</tr>  
			</#list>
		</#if>
	</tbody>
</table>
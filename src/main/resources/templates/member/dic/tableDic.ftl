<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
	<thead>
		<tr>
			<th width="5%">编号</th>
			<th>名称</th>
			<th>编码</th>
			<th>备注</th>
			<th>状态</th>
			<th width="8%">操作</th>
		</tr>
	</thead>
	<tbody>
		<#if page??>
			<#list page.result as r>
				<tr>   
	                <td>${r_index+1}</td>
	                <td class="autocut">${(r.name!)?html}</td>
	                <td class="autocut">${(r.code!)?html}</td>
	                <td class="autocut">${(r.comments!)?html}</td>
	                <td class="autocut"><#if r.status?? && r.status=="1">锁定<#else>未锁定</#if></td>
	                <td>
	                	<#if r.status=='0'>
							<a href="#" onclick="editDic('${r.id}')" title="修改"><i class="glyphicon glyphicon-edit"></i></a>
	                		<a href="#" onclick="updateStatus('${r.id}','1')" title="锁定"><i class="glyphicon glyphicon-ok-circle"></i></a>
	                		<a href="#" onclick="addDicItem('${r.id}')" title="添加项"><i class="glyphicon glyphicon-th-large"></i></a>
							<a href="#" onclick="delDic('${r.id}','${(r.name!)?html}')" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
	                	<#else>
	                		<a href="#" onclick="updateStatus('${r.id}','0')" title="取消锁定"><i class="glyphicon glyphicon-minus-sign"></i></a>
	                	</#if>
	                </td>  
              		</tr>  
			</#list>
		</#if>
	</tbody>
</table>
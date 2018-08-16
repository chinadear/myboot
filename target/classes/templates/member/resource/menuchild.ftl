<div class="row" id="smpl_tbl">
	<div class="col-md-12">
		<table class="table table-bordered table-striped  table-hover tablecut">
			<thead>
				<tr>
					<th width="10%">序号</th>
					<th>菜单名称</th>
					<th>菜单编码</th>
					<th>菜单链接</th>
					<th>图标样式</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<#if menuList??>
				<#list menuList as m>
				<tr>
					<td>${m_index+1}</td>
					<td class="autocut">${m.name?html}</td>
					<td class="autocut">${(m.code!)?html}</td>
					<td class="autocut">${m.link?html}</td>
					<td class="autocut">${m.classCode?html}</td>
					<td>
						<a href="#" onclick="delTreeNode('${m.id}')" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
						<a href="#" onclick="popEditWin('${m.id}')" title="修改"><i class="glyphicon glyphicon-edit"></i></a>
						<a href="#" onclick="upTreeNode('${m.id}')" title="上移"><i class="glyphicon glyphicon-circle-arrow-up"></i></a>
						<a href="#" onclick="downTreeNode('${m.id}')" title="下移"><i class="glyphicon glyphicon-circle-arrow-down"></i></a>
					</td>
				</tr>
				</#list> 
			</#if>
			</tbody>
		</table>
	</div>
</div>
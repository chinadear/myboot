<form class="editDrumForm form-horizontal" enctype="multipart/form-data" method="post" action="${rc.contextPath}/drumbeating/edit">
	<div class="form-group">
	    <label class="col-sm-2 control-label">标题：</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="title" name="title" value="${(drum.title!)?html}" placeholder="标题">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">摘要：</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="summary" name="summary" cols="20" rows="3" placeholder="摘要">${(drum.summary!)?html}</textarea>
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">链接：</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="url" name="url" value="${drum.url!}" placeholder="链接">
	    </div>
 	</div>
 	<div class="form-group">
		<label class="col-sm-2 control-label">所属板块：</label>
		<div class="col-sm-9">
			<select name="plate" id="plate" class="form-control" style="width: 200px;">
				<#if list??>
					<#list list as r>
						<#if drum.plate?? && drum.plate==r.code>
							<option value="${r.code!}" selected>${(r.name!)?html}</option>
						<#else>
							<option value="${r.code!}">${(r.name!)?html}</option>
						</#if>
					</#list>
				</#if>
			</select>
		</div>
	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">区域：</label>
	    <div class="col-sm-9">
		    <select name="type" id="type" class="form-control" style="width: 200px;">
				<#if dlist?? && dlist?size gt 0>
					<#list dlist as r>
						<#if drum.type==r.code>
							<option value="${r.code!}" selected>${(r.name!)?html}</option>
						<#else>
							<option value="${r.code!}">${(r.name!)?html}</option>
						</#if>
					</#list>
				</#if>
			</select>
	    </div>
 	</div>
 	<div class="form-group">
		<label class="col-sm-2 control-label">上传图片：</label>
		<div class="col-sm-9">
		    <input type="file" id="ufile" name="ufile" class="upfile">
		    <div class="alert alert-info" role="alert">请上传jpg、png图片文件</div>
		</div>
	</div>
 	<div class="form-group">
 		<label class="col-sm-2 control-label">是否发布：</label>
 		<div class="col-sm-9">
 			<#if drum.status=="1">
		    	<input class="myswitch switch-anim switch-anim-edit" type="checkbox" checked onchange="editt()">
	    	<#else>
	    		<input class="myswitch switch-anim switch-anim-edit" type="checkbox" onchange="editt()">
	    	</#if>
	    </div>
	</div>
	<input type="hidden" id="editstatus" name="status" value="${drum.status!}">
 	<input type="hidden" value="${drum.id!}" id="id" name="id">
</form> 	
 	
	

<form class="addDrumForm form-horizontal" enctype="multipart/form-data" method="post" action="${rc.contextPath}/drumbeating/add">
 	<div class="form-group">
	    <label class="col-sm-2 control-label">标题：</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="title" name="title" placeholder="标题">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">摘要：</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="summary" name="summary" cols="20" rows="3" placeholder="摘要"></textarea>
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">链接：</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="url" name="url" placeholder="链接">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">版块类型：</label>
	    <div class="col-sm-9">
	    <select name="type" id="type" class="form-control" style="width: 200px;">
			<#if dlist?? && dlist?size gt 0>
				<#list dlist as r>
					<option value="${r.code!}">${(r.name!)?html}</option>
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
		    <input class="myswitch switch-anim" type="checkbox" onchange="addt()">
	    </div>
	</div>
	<input type="hidden" id="status" name="status" value="0">
</form>

<form class="addCategoryForm form-horizontal" enctype="multipart/form-data" method="post" action="${rc.contextPath}/category/add">
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>分类名称</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="name_" name="name_" placeholder="分类名称">
	    </div>
 	</div>
 	<div class="form-group">
		<label class="col-sm-2 control-label">所属板块：</label>
		<div class="col-sm-9">
			<select name="type_" id="type_" class="form-control" style="width: 200px;">
					<#if list??>
						<#list list as r>
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
 	<div class="form-group" id="menuIconDiv">
	    <label class="col-sm-2 control-label">备注信息</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="comments_" name="comments_" cols="20" rows="3" placeholder="备注信息"></textarea>
	    </div>
 	</div>
</form>

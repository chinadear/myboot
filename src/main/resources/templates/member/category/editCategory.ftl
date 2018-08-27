<form class="editCategoryForm form-horizontal" action="${rc.contextPath}/category/edit">
	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>分类名称</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" value="${(category.name!)?html}" id="name" name="name" placeholder="分类名称">
	    </div>
 	</div>
 	<div class="form-group" id="menuIconDiv">
	    <label class="col-sm-2 control-label">备注信息</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="comments" name="comments" cols="20" rows="3" placeholder="备注信息">${(category.comments!)?html}</textarea>
	    </div>
 	</div>
 	<input type="hidden" value="${category.id!}" id="id" name="id">
</form> 	
 	
	

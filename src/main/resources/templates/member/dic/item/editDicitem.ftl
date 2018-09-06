<form class="editDicForm form-horizontal" action="${rc.contextPath}/dicitem/edit">
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>名称</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="name_" name="name_" maxlength="50" placeholder="字典项名称" value="${(di.name!)?html}">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>编码</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="code_" name="code_" maxlength="50" placeholder="字典项编码" value="${(di.code!)?html}">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">是否发布</label>
 		<div class="col-sm-9">
 		<#if di.status?? && di.status=='1'>
		    <input class="myswitch switch-anim-edit" type="checkbox" id="p_" name="p_" onchange="editt()" checked>
 		<#else>
		    <input class="myswitch switch-anim-edit" type="checkbox" id="p_" name="p_" onchange="editt()">
 		</#if>
	    <input type="hidden" name="status_" id="status_" value="${(di.status!)?html}">
	    </div>
 	</div>
 	<div class="form-group" id="menuIconDiv">
	    <label class="col-sm-2 control-label">备注信息</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="comments_" name="comments_" cols="20" rows="3" maxlength="150" placeholder="备注信息" >${(di.comments!)?html}</textarea>
	    </div>
 	</div>
 	<input type="hidden" id="id" name="id" value="${di.id!}">
</form>

<form class="editDicForm form-horizontal" action="${rc.contextPath}/dic/edit">
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>名称</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="name_" name="name_" maxlength="50" placeholder="字典名称" value="${(dic.name!)?html}">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>编码</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="code_" name="code_" maxlength="50" placeholder="字典编码" value="${(dic.code!)?html}">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">是否锁定</label>
 		<div class="col-sm-9">
 		<#if dic.status?? && dic.status=='1'>
		    <input class="myswitch switch-anim-edit" type="checkbox" id="p_" name="p_" onchange="editt()" checked>
 		<#else>
		    <input class="myswitch switch-anim-edit" type="checkbox" id="p_" name="p_" onchange="editt()">
 		</#if>
	    <input type="hidden" name="status_" id="status_" value="${(dic.status!)?html}">
	    </div>
 	</div>
 	<div class="form-group" id="menuIconDiv">
	    <label class="col-sm-2 control-label">备注信息</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="comments_" name="comments_" cols="20" rows="3" maxlength="150" placeholder="备注信息" >${(dic.comments!)?html}</textarea>
	    </div>
 	</div>
 	<input type="hidden" id="id" name="id" value="${dic.id!}">
</form>

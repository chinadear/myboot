<form class="editRoleForm form-horizontal">
	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>角色名称</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" value="${(role.name!)?html}" id="name_" name="name_" placeholder="角色名称">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>角色编码</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" value="${(role.code!)?html}" id="code_" name="code_" placeholder="角色编码">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">角色类型</label>
	    <div class="col-sm-9">
	    <select name="type_" id="type_">
    		<#if role.type?? && role.type=='1'>
		    	<option value="1" selected>系统角色</option>
    		<#else>
    			<option value="1">系统角色</option>
    		</#if>
    		<#if role.type?? && role.type=='2'>
		    	<option value="2" selected>成员角色</option>
    		<#else>
    			<option value="2">成员角色</option>
    		</#if>
	    </select>
	    </div>
 	</div>
 	<div class="form-group" id="menuIconDiv">
	    <label class="col-sm-2 control-label">备注信息</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="comments_" name="comments_" cols="20" rows="3" placeholder="备注信息">value="${(role.comments!)?html}"</textarea>
	    </div>
 	</div>
 	<input type="hidden" value="${role.id!}" id="id" name="id">
</form> 	
 	
	

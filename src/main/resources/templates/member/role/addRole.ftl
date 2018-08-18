<form class="addRoleForm form-horizontal" action="${rc.contextPath}/role/add">
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>角色名称</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="name_" name="name_" placeholder="角色名称">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>角色编码</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="code_" name="code_" placeholder="角色编码">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">角色类型</label>
	    <div class="col-sm-9">
	    <select name="type_" id="type_" class="form-control">
	    	<option value="1">系统角色</option>
	    	<option value="2">成员角色</option>
	    </select>
	    </div>
 	</div>
 	<div class="form-group" id="menuIconDiv">
	    <label class="col-sm-2 control-label">备注信息</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="comments_" name="comments_" cols="20" rows="3" placeholder="备注信息"></textarea>
	    </div>
 	</div>
</form>

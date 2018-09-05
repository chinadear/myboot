<form class="addDicForm form-horizontal" action="${rc.contextPath}/dic/add">
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>名称</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="name" name="name" maxlength="50" placeholder="字典名称">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>编码</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="code" name="code" maxlength="50" placeholder="字典编码">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">是否发布</label>
 		<div class="col-sm-9">
		    <input class="myswitch switch-anim" type="checkbox" maxlength="150" onchange="addt()" value="0">
	    </div>
 	</div>
 	<div class="form-group" id="menuIconDiv">
	    <label class="col-sm-2 control-label">备注信息</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="comments" name="comments" cols="20" rows="3" placeholder="备注信息"></textarea>
	    </div>
 	</div>
</form>

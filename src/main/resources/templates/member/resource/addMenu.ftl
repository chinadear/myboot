<form class="addMenuForm form-horizontal">
	<div class="form-group">
	    <label class="col-sm-2 control-label">上级菜单</label>
	    <div class="col-sm-9">
	    	<label class="col-sm-4 control-label" id="fathermenu">上级菜单</label>
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>菜单名称</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="menuname" name="menuname" placeholder="菜单名称">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label"><font color="red"> *</font>菜单编码</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="menucode" name="menucode" placeholder="菜单编码">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">菜单链接</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="menulink" name="menulink" placeholder="菜单链接">
	    </div>
 	</div>
 	<div class="form-group" id="menuIconDiv">
	    <label class="col-sm-2 control-label">图标样式</label>
	    <div class="col-sm-5">
	      <input type="text" class="form-control" id="classCode" name="classCode" placeholder="样式代码">
	    </div>
	    <div class="col-md-1"><div style="background:#1786b3;width:25px;height:25px;text-align:center;vertical-align:middle;line-height:25px;"><i id="iconShow"></i></div></div>
		<div class="col-md-3"><font size="1">图标预览区域</font></div>
 	</div>
 	<div class="form-group" id="menuIconDiv">
	    <label class="col-sm-2 control-label">备注信息</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="comments" name="comments" cols="20" rows="3"></textarea>
	    </div>
 	</div>
</form>

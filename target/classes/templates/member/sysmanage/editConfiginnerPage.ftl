<form class="form-horizontal editSysConfigForm" action="${rc.contextPath}/system/config/edit">
	<div class="form-group">
	    <label for="config_key" class="col-sm-2 control-label">Key：</label>
   		<div class="col-sm-9">
   			<label class="col-sm-4 control-label" id="fathermenu">${(sysconfig.key!)?html}</label>
		</div>
	</div>
	<div class="form-group">
		<label for="config_value" class="col-sm-2 control-label">Value：</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="config_value_" name="config_value_" value="${(sysconfig.value!)?html}" placeholder="value">
		</div>
	</div>
	<div class="form-group">
		<label for="config_comment" class="col-sm-2 control-label">备注：</label>
		<div class="col-sm-9">
			 <textarea class="form-control" id="config_comment_" name="config_comment_" cols="20" rows="3" placeholder="备注">${(sysconfig.comments!)?html}</textarea>
		</div>
	</div>
	<input type="hidden" name="sysconfig_id" value="${sysconfig.id!}" />
</form>
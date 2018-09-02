<form class="editDrumForm form-horizontal" enctype="multipart/form-data" method="post" action="${rc.contextPath}/drumbeating/edit">
	<div class="form-group">
	    <label class="col-sm-2 control-label">标题：</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="title" name="title" value="${(drum.title!)?html}" placeholder="标题">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">摘要：</label>
	    <div class="col-sm-9">
	      <textarea class="form-control" id="summary" name="summary" cols="20" rows="3" placeholder="摘要">${(drum.summary!)?html}</textarea>
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">链接：</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="url" name="url" value="${drum.url!}" placeholder="链接">
	    </div>
 	</div>
 	<div class="form-group">
	    <label class="col-sm-2 control-label">版块类型：</label>
	    <div class="col-sm-9">
	    <select name="type" id="type" class="form-control" >
			<#list [["0","头部banner"],["1","右侧轮播"]] as r>
				<#if drum.type==r[0]>
					<option value="${r[0]}" selected>${r[1]}</option>
				<#else>
					<option value="${r[0]}">${r[1]}</option>
				</#if>
			</#list>
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
 			<#if drum.status=="1">
		    	<input class="myswitch switch-anim switch-anim-edit" type="checkbox" checked onchange="editt()">
	    	<#else>
	    		<input class="myswitch switch-anim switch-anim-edit" type="checkbox" onchange="editt()">
	    	</#if>
	    </div>
	</div>
	<input type="hidden" id="editstatus" name="status" value="${drum.status!}">
 	<input type="hidden" value="${drum.id!}" id="id" name="id">
</form> 	
 	
	

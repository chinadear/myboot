<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	
	  	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="showAddConfDialog();">增加配置</button>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12">
			<!-- <h3 class="heading">列表信息</h3> -->
			<table class="table table-bordered table-striped  table-hover tablecut" id="smpl_tbl">
				<thead>
					<tr>
						<th width="10%">编号</th>
						<th>Key</th>
    					<th>Value</th>
    					<th>备注</th>
    					<th width="10%">操作</th>
					</tr>
				</thead>
				<tbody>
					<#if configList??>
						<#list configList as cl>
							<tr>   
				                <td>${cl_index+1}</td>
				                <td class="autocut">${(cl.key!)?html}</td>
				                <td class="autocut">${(cl.value!)?html}</td>
				                <td class="autocut">${(cl.comments!)?html}</td>
				                <td>
				                	<a href="#" onclick="delSysConfig('${cl.id}','${cl.key}')" title="删除"><i class="glyphicon glyphicon-trash"></i></a>
									<a href="#" onclick="editsysconfig('${cl.id}')" title="修改"><i class="glyphicon glyphicon-edit"></i></a>
				                </td>  
		               		</tr>  
						</#list>
					</#if>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- 增加配置 -->
<div class="modal fade in" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">增加配置</h4>  
	        </div>  
			<div class="modal-body">  
		    	<form class="form-horizontal addSysConfigForm" action="${rc.contextPath}/system/config/add">
					<div class="form-group">
					    <label for="config_key" class="col-sm-2 control-label"><font color="red">*</font>Key：</label>
				   		<div class="col-sm-9">
				   			<input type="text" class="form-control" id="config_key" name="config_key" placeholder="key">
						</div>
					</div>
					<div class="form-group">
						<label for="config_value" class="col-sm-2 control-label">Value：</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="config_value" name="config_value" placeholder="value">
						</div>
					</div>
					<div class="form-group">
						<label for="config_comment" class="col-sm-2 control-label">备注：</label>
						<div class="col-sm-9">
							 <textarea class="form-control" id="config_comment" name="config_comment" cols="20" rows="3" placeholder="备注"></textarea>
						</div>
					</div>
				</form>
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" onclick="add_submit()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->  
<!-- 编辑配置 -->
<div class="modal fade in" id="editModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">修改配置</h4>  
	        </div>  
			<div class="modal-body">  
		    	<p id="edittemp"></p>
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" onclick="edit_submit()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->
<input type="hidden" id="flag" value="1" />
 <script type="text/javascript">
 	window.onload = function(){
 		comp.validate.addRemote("keyIsExsit","${rc.contextPath}/system/config/judgyKey",{key:function(){return $('#config_key').val()}},"key值已存在，请使用其他key值");
 	}
 	function showAddConfDialog(){
 		initAddValidate();
 		$(".addSysConfigForm").compReset();
 		comp.showModal('addModal');
 	}
 	function editsysconfig(id){
 		$("#edittemp").load("${rc.contextPath}/noSitemesh/system/config/initEdit",{"id":id},function(){
			initEditValidate();
	 	});
 		comp.showModal('editModal');
 	}
 	function add_submit(){
 		$(".addSysConfigForm").submit();
 	}
 	function edit_submit(){
 		$(".editSysConfigForm").submit();
 	}
	function delSysConfig(id,key){
		var r=confirm("确定要删除key值为“"+key+"”的配置项吗？");
		if(r){
			window.location.href="${rc.contextPath}/system/config/delete/"+id;
		}
	}
	function initAddValidate(){
		$(".addSysConfigForm").compValidate({
			rules:{
				config_key: { required: true, 
							  maxlength: 20,
							  keyIsExsit:true,
							  uwsnumchar:true
							},
				config_value: {maxlength: 150},
				config_comment: {maxlength: 100
							},
					},
			messages:{
				config_key:{required:"key不能为空"}
				}
		});
	}
	function initEditValidate(){
		$(".editSysConfigForm").compValidate({
			rules:{
				config_value_: {maxlength: 150},
				config_comment_: {maxlength: 100
							},
					}
		});
	}
</script>
</body>
</html>
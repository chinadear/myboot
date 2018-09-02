<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
<form class="form-inline">
		<div class="form-group" style="margin-top: 5px;margin-left:5px;">
    		<label for="roleId">版块：</label>
			<select name="queryType" id="queryType" class="form-control" onchange="flushList(this)" style="width: 200px;">
					<#list [["0","头部banner"],["1","右侧轮播"]] as r>
						<#if type==r[0]>
							<option value="${r[0]}" selected>${r[1]}</option>
						<#else>
							<option value="${r[0]}">${r[1]}</option>
						</#if>
					</#list>
			</select>
		</div>
		<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="addDrum()">增加推广</button>
	</form>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12" id="flushtable">
			<#include "tableDrumbeating.ftl">
		</div>
	</div>
	<div class="row ">
		<div class="paging-component"></div>
	</div>
</div>
<!--增加推广页面-->
<div class="modal fade in" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">新增推广条目</h4>  
	        </div>  
			<div class="modal-body">
				<#include "addDrumbeating.ftl">
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="add_submit()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->  
<!--修改推广页面-->
<div class="modal fade in" id="editModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">编辑推广条目</h4>  
	        </div>  
			<div class="modal-body">  
		    	<p id="edittemp"></p>
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="edit_submit()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->
 <script type="text/javascript">
 	window.onload = function(){
 	}
 	function editDrum(id){
	 	$("#edittemp").load("${rc.contextPath}/drumbeating/noSitemesh/editDrum",{"id":id},function(){
			comp.showModal('editModal');
	 	});
	 }
 	function addDrum(){
		$(".addDrumForm").compReset();
		comp.showModal('addModal');
	}
 	function delDrum(id,name){
 		var type=$("#queryType").val();
 		var r=confirm("确定要删除“"+name+"”这条推广信息吗？");
 		if(r){
 			$.ajax({
				async :false,
				cache :false,
				dataType :"text",
				type:"POST",
				timeout: 100000,
				url: "${rc.contextPath}/drumbeating/delete/?id="+id,
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					$("#flushtable").load("${rc.contextPath}/drumbeating/noSitemesh/loadDurmbeatingtable",{type:type},function(){
						comp.message("删除成功！");
					});
				}
			});
 		}
 	}
 	function add_submit(){
 		$(".addDrumForm").submit();
 	}
 	function edit_submit(){
 		$(".editDrumForm").submit();
 	}
 	function updateStatus(id,status){
 		var type=$("#queryType").val();
 		$.ajax({
			async :false,
			cache :false,
			timeout: 100000,
			type:"POST",
			url: "${rc.contextPath}/drumbeating/updateStatus",
			data:{id:id,status:status},
			error: function () {//请求失败处理函数
				comp.message("请求失败，请稍后再试","error");
				return;
			},
			success:function(data){ //请求成功后处理函数。  
				$("#flushtable").load("${rc.contextPath}/drumbeating/noSitemesh/loadDurmbeatingtable",{type:type},function(){
					if(status=="1"){
						comp.message("已成功发布！");
					}else{
						comp.message("已取消发布！");
					}
				});
			}
		});
 	}
 	//检索版块
 	function flushList(obj){
 		$("#flushtable").load("${rc.contextPath}/drumbeating/noSitemesh/loadDurmbeatingtable",{"type":obj.value},function(){});
 	}
 	function addt(){
        if($(".switch-anim").prop("checked")){
            $("#status").val("1");
        }else{
        	$("#status").val("0");
        }
	}
 	function editt(){
        if($(".switch-anim-edit").prop("checked")){
            $("#editstatus").val("1");
        }else{
        	$("#editstatus").val("0");
        }
	}
 	
</script>
</body>
</html>
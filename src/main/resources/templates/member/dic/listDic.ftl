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
    		<label for="roleId">字典：</label>
    		<select class="selectpicker" data-style="btn-default" id="qname" data-live-search="true" onchange="flushList(this);">
    			<option value="">请选择...</option>
    			<#if list??&&list?size gt 0>
	    			<#list list as l>
						<option value="${l.name!}">${l.name}</option>
					</#list>
				</#if>
			</select>
		</div>
		<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="addDic()">增加字典</button>
	</form>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12" id="flushtable">
			<#include "tableDic.ftl">
		</div>
	</div>
	<div class="row ">
		<div class="paging-component"></div>
	</div>
</div>
<!--增加字典页面-->
<div class="modal fade in" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">新增字典</h4>  
	        </div>  
			<div class="modal-body">
				<#include "addDic.ftl">
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="add_submit()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->  
<!--修改字典页面-->
<div class="modal fade in" id="editModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">编辑字典</h4>  
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
 		comp.validate.addRemote("dicNameIsExsit","${rc.contextPath}/dic/isExsit/name",{name:function(){return $("#name").val();}},"字典名称有重复");
		comp.validate.addRemote("dicCodeIsExsit","${rc.contextPath}/dic/isExsit/code",{code:function(){return $("#code").val();}},"字典编码有重复");
		comp.validate.addRemote("dicNameIsExsit_","${rc.contextPath}/dic/isExsit/name",{name:function(){return $("#name_").val();},id:function(){return $("#id").val()}},"字典名称有重复");
		comp.validate.addRemote("dicCodeIsExsit_","${rc.contextPath}/dic/isExsit/code",{code:function(){return $("#code_").val();},id:function(){return $("#id").val()}},"字典编码有重复");
 		callBackPagination();
 		initAddValidate();
 	}
 	function dicTable(currPage) {
		$("#flushtable").load("${rc.contextPath}/dic/noSitemesh/loadDictable",{pageNo:currPage},function(){});
	}
	//翻页组件初始化，翻页组件暂时职能采用table的load来刷新翻页的列表
	function callBackPagination() {
	    $('.paging-component').extendPagination({
	        totalCount:${page.totalCount},//总记录数
	        showPage:5,//分页栏显示页数，其他页数...代替
	        limit:10,//每页显示记录数
	        callback: function (curr, limit, totalCount) {//curr当前页数
	        	dicTable(curr);
	        }
	    });
	}
	//进入编辑
 	function editDic(id){
	 	$("#edittemp").load("${rc.contextPath}/dic/noSitemesh/editDic",{"id":id},function(){
	 		initeditValidate();
			comp.showModal('editModal');
	 	});
	 }
	//进入新增
 	function addDic(){
		$(".addDicForm").compReset();
		comp.showModal('addModal'); 
	}
 	//删除
 	function delDic(id,name){
 		var qname=$("#qname").val();
 		var r=confirm("确定要删除“"+name+"”这条字典信息吗？");
 		if(r){
 			$.ajax({
				async :false,
				cache :false,
				dataType :"text",
				type:"POST",
				timeout: 100000,
				url: "${rc.contextPath}/dic/delete?id="+id,
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					var page=Number($('.paging-component').find('li[class="active"]').find('a').html());
					$("#flushtable").load("${rc.contextPath}/dic/noSitemesh/loadDictable",{pageNo:page,name:qname},function(){
						comp.message("删除成功！");
					});
				}
			});
 		}
 	}
 	//提交新增
 	function add_submit(){
 		$(".addDicForm").submit();
 	}
 	//提交修改
 	function edit_submit(){
 		var id=$("#id").val();
 		var name=$("#name_").val();
 		var code=$("#code_").val();
 		var status=$("#status_").val();
 		var comments=$("#comments_").val();
 		var qname=$("#qname").val();
 		if($(".editDicForm").compValidator().form()){
 			$.ajax({
 				async :false,
 				cache :false,
 				timeout: 100000,
 				type:"POST",
 				url: "${rc.contextPath}/dic/edit",
 				data:{id:id,status:status,name:name,code:code,comments:comments},
 				error: function () {//请求失败处理函数
 					comp.message("请求失败，请稍后再试","error");
 					return;
 				},
 				success:function(data){ //请求成功后处理函数。  
 					var page=Number($('.paging-component').find('li[class="active"]').find('a').html());
					$("#flushtable").load("${rc.contextPath}/dic/noSitemesh/loadDictable",{pageNo:page,name:qname},function(){
						comp.message("修改成功！");
						comp.hideModal('editModal');
					});
 				}
 			});
 		}
 	}
 	//更改锁定状态，由于字典比较重要防止误操作，增加锁定功能
 	function updateStatus(id,status){
 		var qname=$("#qname").val();
 		$.ajax({
			async :false,
			cache :false,
			timeout: 100000,
			type:"POST",
			url: "${rc.contextPath}/dic/updateStatus",
			data:{id:id,status:status},
			error: function () {//请求失败处理函数
				comp.message("请求失败，请稍后再试","error");
				return;
			},
			success:function(data){ //请求成功后处理函数。  
				var page=Number($('.paging-component').find('li[class="active"]').find('a').html());
				$("#flushtable").load("${rc.contextPath}/dic/noSitemesh/loadDictable",{pageNo:page,name:qname},function(){
					if(data=="1"){
						comp.message("锁定成功！");
					}else{
						comp.message("为防止误操作请及时锁定！");
					}
				});
			}
		});
 	}
 	//select框检索字典
 	function flushList(obj){
 		$("#flushtable").load("${rc.contextPath}/dic/noSitemesh/loadDictable",{name:obj.value},function(){});
 	}
 	//新增-发布开关切换
 	function addt(){
        if($(".switch-anim").prop("checked")){
            $("#status").val("1");
        }else{
        	$("#status").val("0");
        }
	}
 	//修改-发布开关切换
 	function editt(){
        if($(".switch-anim-edit").prop("checked")){
            $("#status_").val("1");
        }else{
        	$("#status_").val("0");
        }
	}
 	//新增校验
 	function initAddValidate(){
		$(".addDicForm").compValidate({
			rules:{
				name:{required: true,dicNameIsExsit:true},
				code:{required: true,dicCodeIsExsit:true}
					},
			messages:{
				name:{required:"请填写字典名称"},
				code:{required:"请填写字典编码"}
				}
		});
	}
 	//修改校验
 	function initeditValidate(){
		$(".editDicForm").compValidate({
			rules:{
				name_:{required: true,dicNameIsExsit_:true},
				code_:{required: true,dicCodeIsExsit_:true}
					},
			messages:{
				name_:{required:"请填写字典名称"},
				code_:{required:"请填写字典编码"}
				}
		});
	}
 	//添加项
 	function addDicItem(id){
 			window.location.href="${rc.contextPath}/dicitem/list?id="+id;
 	}
</script>
</body>
</html>
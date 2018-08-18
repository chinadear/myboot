<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12" id="roletable">
			<#include "roleTable.ftl">
		</div>
	</div>
	<div class="row ">
		<div class="paging-component"></div>
	</div>
</div>
<!--角色授权页面-->
<div class="modal fade in" id="treeModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">授权</h4>  
	        </div>  
			<div class="modal-body">  
				<ul id="roleMenuTree" class="ztree"></ul>
				<input type="hidden" id="roleId">
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="menuFormSubmit()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->  
<!--成员设置-->
<div class="modal fade in" id="memberModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">成员设置</h4>  
	        </div>  
			<div class="modal-body">  
		    	正在建设中...
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->
 <script type="text/javascript">
 	window.onload = function(){
 		callBackPagination();
 	}
	function roleTable(currPage) {
		$("#roletable").load("${rc.contextPath}/authorization/noSitemesh/loadroletable",{pageNo:currPage},function(){});
	}
	//翻页组件初始化，翻页组件暂时职能采用table的load来刷新翻页的列表
	function callBackPagination() {
	    $('.paging-component').extendPagination({
	        totalCount:${roleList.totalCount},//总记录数
	        showPage:5,//分页栏显示页数，其他页数...代替
	        limit:10,//每页显示记录数
	        callback: function (curr, limit, totalCount) {//curr当前页数
	            roleTable(curr);
	        }
	    });
	}
 	function setUserRole(id){
	 	/* $("#edittemp").load("${rc.contextPath}/role/noSitemesh/editRole",{"id":id},function(){
			initEditValidate();
	 	}); */
	 	comp.message("建设中，敬待佳音");
		comp.showModal('memberModal');
	 }
 	//树基本属性配置
	var setting = {
		view: {
			selectedMulti: true,
			dblClickExpand: false,
			showLine: false,
			showIcon:true
		},
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
				}
			},
		callback: {
		}
	};
	//初始化树
	function popRoleMenuTree(id){
		comp.initTree("roleMenuTree","${rc.contextPath}/authorization/resource/initRoleMenuTreeAjax",{roleId:id},null,null,setting); 
		$("#roleId").val(id);
		comp.showModal("treeModal");
	}
	//提交设置菜单权限结果
	function menuFormSubmit(){
		var nodes = comp.returnTreeValue("roleMenuTree");
		var length = nodes.length;
		var ids="";
		var roleId=$("#roleId").val();
		if (length>0) {
			for (i = 0; i < length; i++) {
				ids += nodes[i].id + ",";
			}
		}
		$.ajax({
			async :false,
			cache :false,
			type:"POST",
			dataType :"text",
			timeout: 100000,
			url: "${rc.contextPath}/authorization/resource/setResAuth",
			data:{ids:ids,roleId:roleId},
			error: function () {//请求失败处理函数
				comp.message("请求失败，请稍后再试","error");
				return;
			},
			success:function(data){ //请求成功后处理函数。  
				comp.message("权限设置成功！");
				comp.hideModal("treeModal");
			}
		});
	}
</script>
</body>
</html>
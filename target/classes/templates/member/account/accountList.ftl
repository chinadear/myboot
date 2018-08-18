<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="addAccount();">创建账号</button>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12" id="accounttable">
			<#include "accountTable.ftl">
		</div>
	</div>
	<div class="row ">
		<div class="paging-component"></div>
	</div>
</div>
<!--修改账户页面-->
<div class="modal fade in" id="editModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">修改账户信息</h4>  
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
 <script type="text/javascript">
 	window.onload = function(){
 		comp.validate.addRemote("nameIsExsit","${rc.contextPath}/account/isExsit/name",{name:function(){return $('#name').val();},id:function(){return $("#id").val();}},"此昵称已存在");
 		callBackPagination();
 	}
 	function accountTable(currPage) {
		$("#accounttable").load("${rc.contextPath}/account/noSitemesh/loadaccounttable",{pageNo:currPage},function(){});
	}
	//翻页组件初始化，翻页组件暂时职能采用table的load来刷新翻页的列表
	function callBackPagination() {
	    $('.paging-component').extendPagination({
	        totalCount:${page.totalCount},//总记录数
	        showPage:5,//分页栏显示页数，其他页数...代替
	        limit:10,//每页显示记录数
	        callback: function (curr, limit, totalCount) {//curr当前页数
	            accountTable(curr);
	        }
	    });
	}
 	//弹出编辑窗口
 	function editAccount(id){
 		$("#edittemp").load("${rc.contextPath}/account/noSitemesh/editAccount",{"id":id},function(){
			initEditValidate();
	 	});
 		comp.showModal('editModal');
 	}
 	//提交编辑内容
 	function edit_submit(){
 		$(".editAccountForm").submit();
 	}
 	function addAccount(){
 		window.location.href="${rc.contextPath}/account/addAccount";
 	}
	function delAccount(id,name){
		var r=confirm("确定要删除“"+name+"”账号？");
		if(r){
			window.location.href="${rc.contextPath}/account/delete/"+id;
		}
	}
	function resetPassword(id,name){
		var r=confirm("确定要重置“"+name+"”的密码吗？");
		if(r){
			$.ajax({
				async :false,
				cache :false,
				timeout: 100000,
				type:"POST",
				url: "${rc.contextPath}/account/resetPassword",
				data:{id:id},
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					comp.message("密码重置成功！");
				}
			});
		}
	}
	function initEditValidate(){
		$(".editAccountForm").compValidate({
			rules:{
				name:{required: true,maxlength: 150,nameIsExsit:true},
				realName:{required: true,maxlength: 150},
				phone: {number:true,maxlength: 20},
				qq: {number:true,maxlength: 15},
				email: {email:true,maxlength: 150}
					},
			messages:{
				name:{required:"请为您自己起个昵称"},
				realName:{required:"请填写您的姓名"},
				phone:{number:"请输入正确格式的手机号"},
				qq: {number:"请输入正确格式的QQ号码"}
				}
		});
	}
</script>
</body>
</html>
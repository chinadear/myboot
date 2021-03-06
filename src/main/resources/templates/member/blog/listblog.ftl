<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="togglediscuss('0')">关闭全部评论</button>
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="togglediscuss('1')">开启全部评论</button>
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="writeblog()">写博客</button>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12" id="blogtable">
			<#include "blogTable.ftl">
		</div>
	</div>
	<div class="row ">
		<div class="paging-component"></div>
	</div>
</div>
 <script type="text/javascript">
 	window.onload = function(){
 		callBackPagination();
 	}
 	function blogtable(currPage) {
		$("#blogtable").load("${rc.contextPath}/blog/noSitemesh/loadblogstable",{pageNo:currPage},function(){});
	}
	//翻页组件初始化，翻页组件暂时职能采用table的load来刷新翻页的列表
	function callBackPagination() {
	    $('.paging-component').extendPagination({
	        totalCount:${page.totalCount},//总记录数
	        showPage:5,//分页栏显示页数，其他页数...代替
	        limit:10,//每页显示记录数
	        callback: function (curr, limit, totalCount) {//curr当前页数
	        	blogtable(curr);
	        }
	    });
	}
	function writeblog(){
		window.location.href="${rc.contextPath}/blog/write";
	}
	function editblog(id){
		window.location.href="${rc.contextPath}/blog/editblog/"+id;
	}
	function delblog(id){
		var page=Number($('.paging-component').find('li[class="active"]').find('a').html());
		var r=confirm("确定要删除该文章吗？");
		if(r){
			$.ajax({
				async :false,
				cache :false,
				timeout: 100000,
				type:"POST",
				url: "${rc.contextPath}/blog/delete",
				data:{id:id},
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					$("#blogtable").load("${rc.contextPath}/blog/noSitemesh/loadblogstable",{pageNo:page},function(){
						comp.message("删除成功！");
					});
				}
			});
		}
	}
	function publish(id){
		var page=Number($('.paging-component').find('li[class="active"]').find('a').html());
		$.ajax({
			async :false,
			cache :false,
			timeout: 100000,
			type:"POST",
			url: "${rc.contextPath}/blog/updateStatus",
			data:{id:id,status:'1'},
			error: function () {//请求失败处理函数
				comp.message("请求失败，请稍后再试","error");
				return;
			},
			success:function(data){ //请求成功后处理函数。  
				$("#blogtable").load("${rc.contextPath}/blog/noSitemesh/loadblogstable",{pageNo:page},function(){
					comp.message("发布成功！");
				});
			}
		});
	}
	function unpublish(id){
		var page=Number($('.paging-component').find('li[class="active"]').find('a').html());
		$.ajax({
			async :false,
			cache :false,
			timeout: 100000,
			type:"POST",
			url: "${rc.contextPath}/blog/updateStatus",
			data:{id:id,status:'2'},
			error: function () {//请求失败处理函数
				comp.message("请求失败，请稍后再试","error");
				return;
			},
			success:function(data){ //请求成功后处理函数。  
				$("#blogtable").load("${rc.contextPath}/blog/noSitemesh/loadblogstable",{pageNo:page},function(){
					comp.message("已取消发布！");
				});
			}
		});
	}
	function togglediscuss(status){
		var r=confirm(status=='1'?"确定要启用全部评论吗？":"确定要禁止全部评论吗？");
		if(r){
			$.ajax({
				async :false,
				cache :false,
				timeout: 100000,
				type:"POST",
				url: "${rc.contextPath}/blog/togglediscuss",
				data:{status:status},
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					$("#blogtable").load("${rc.contextPath}/blog/noSitemesh/loadblogstable",{},function(){
						comp.message(status=='1'?"成功启用全部文章的评论":"成功禁止全部文章的评论");
					});
				}
			});
		}
	}
</script>
</body>
</html>
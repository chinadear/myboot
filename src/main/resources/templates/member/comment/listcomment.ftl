<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="goback()">返回</button>
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="oneKeyPublishAll()">一键发布</button>
</div>
<div class="container-fluid innerScroll">
	<div class="row ">
		<div class="col-md-12" id="blogtable">
			<#include "commentTable.ftl">
		</div>
	</div>
	<input type="hidden" id="blogid" value="${blogid!}">
	<div class="row ">
		<div class="paging-component"></div>
	</div>
</div>
 <script type="text/javascript">
 	window.onload = function(){
 		callBackPagination();
 	}
 	function blogtable(currPage) {
 		var blogid=$("#blogid").val();
		$("#blogtable").load("${rc.contextPath}/comment/noSitemesh/loadcommenttable",{pageNo:currPage,id:blogid},function(){});
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
	function delcomment(id){
		var blogid=$("#blogid").val();
		var page=Number($('.paging-component').find('li[class="active"]').find('a').html());
		var r=confirm("确定要删除该评论吗？");
		if(r){
			$.ajax({
				async :false,
				cache :false,
				timeout: 100000,
				type:"POST",
				url: "${rc.contextPath}/comment/delete",
				data:{id:id},
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					$("#blogtable").load("${rc.contextPath}/comment/noSitemesh/loadcommenttable",{pageNo:page,id:blogid},function(){
						comp.message("删除成功！");
					});
				}
			});
		}
	}
	//一键发布
	function oneKeyPublishAll(){
		var blogid=$("#blogid").val();
		var r=confirm("确定要发布此文章的全部评论吗？");
		if(r){
			$.ajax({
				async :false,
				cache :false,
				timeout: 100000,
				type:"POST",
				url: "${rc.contextPath}/comment/publishAll",
				data:{id:blogid},
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					$("#blogtable").load("${rc.contextPath}/comment/noSitemesh/loadcommenttable",{pageNo:'1',id:blogid},function(){
						comp.message("发布成功！");
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
			url: "${rc.contextPath}/comment/updateStatus",
			data:{id:id,status:'1'},
			error: function () {//请求失败处理函数
				comp.message("请求失败，请稍后再试","error");
				return;
			},
			success:function(data){ //请求成功后处理函数。  
				var blogid=$("#blogid").val();
				$("#blogtable").load("${rc.contextPath}/comment/noSitemesh/loadcommenttable",{pageNo:page,id:blogid},function(){
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
			url: "${rc.contextPath}/comment/updateStatus",
			data:{id:id,status:'0'},
			error: function () {//请求失败处理函数
				comp.message("请求失败，请稍后再试","error");
				return;
			},
			success:function(data){ //请求成功后处理函数。
				var blogid=$("#blogid").val();
				$("#blogtable").load("${rc.contextPath}/comment/noSitemesh/loadcommenttable",{pageNo:page,id:blogid},function(){
					comp.message("已取消发布！");
				});
			}
		});
	}
	function goback(){
		window.location.href="${rc.contextPath}/comment/blogs";
	}
</script>
</body>
</html>
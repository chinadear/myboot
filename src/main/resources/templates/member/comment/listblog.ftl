<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div  class="inner-header">
	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="">查看待审核评论</button>
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
		$("#blogtable").load("${rc.contextPath}/comment/noSitemesh/loadblogstable",{pageNo:currPage},function(){});
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
	function viewcomment(id){
		window.location.href="${rc.contextPath}/comment/comments/"+id;
	}
</script>
</body>
</html>
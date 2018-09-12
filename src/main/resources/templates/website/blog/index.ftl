<!DOCTYPE html>
<html>
	<head>
	    <!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Author Meta -->
		<meta name="author" content="colorlib">
		<!-- Meta Description -->
		<meta name="description" content="">
		<!-- Meta Keyword -->
		<meta name="keywords" content="">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>boot+</title>
		<#include "../pubarea/styles.ftl">
	</head>
<body>
<#include "../pubarea/header.ftl">
<#include "../pubarea/banner.ftl">
	<section class="category-area section-gap" id="news">
		<div class="container">
			<div class="row d-flex justify-content-center">
				<div class="menu-content pb-70 col-lg-8">
					<div class="title text-center">
						<h1 class="mb-10">Latest News from all categories</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore  et dolore magna aliqua.</p>
					</div>
				</div>
			</div>						
			<div class="active-cat-carusel">
				<div class="item single-cat">
					<img src="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3486262091,1760605442&fm=173&app=25&f=JPEG?w=218&h=146&s=1D2FC71482A8410F1C7A35D80300C0BE" alt="">
					<p class="date">10 Jan 2018</p>
					<h4><a href="#">It S Hurricane Season Visiting Hilton</a></h4>
				</div>
				<div class="item single-cat">
					<img src="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2646551676,729013745&fm=173&app=25&f=JPEG?w=218&h=146&s=55B58F740041734D021795C70300E0B9" alt="">
					<p class="date">10 Jan 2018</p>
					<h4><a href="#">What Makes A Hotel Boutique</a></h4>
				</div>
				<div class="item single-cat">
					<img src="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3904588938,2179784957&fm=173&app=25&f=JPEG?w=218&h=146&s=569403650159D467568BA9D30300C0BB" alt="">
					<p class="date">10 Jan 2018</p>
					<h4><a href="#">Les Houches The Hidden Gem Valley</a></h4>
				</div>							
			</div>												
		</div>	
	</section>    
	<#include "../pubarea/footer.ftl">      
	<#include "../pubarea/scripts.ftl">
	<script src="${rc.contextPath}/js/myblog.js"></script>  
       <script type="text/javascript">
      		var pageNum=2;//翻页默认下一页页号，初始第一页,进入后默认第一页，因此翻页目标是到第二页
      		var pageSize=10;//每页文章数量
       	function loadmore(){
       		var appendstr="";
       		$.ajax({
				async :false,
				cache :false,
				dataType :"json",
				type:"POST",
				timeout: 100000,
				url: "${rc.contextPath}/articals/news/more",
				data:{pageNum:pageNum,pageSize:pageSize},
				error: function () {//请求失败处理函数
					alert("请求失败！");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					if(data==""){
						$("#loadmore").html("没有更多文章喽~").attr("disabled", "true");
						return;
					}
					for(var i=0;i<data.length;i++){
						appendstr+= articalTemplet(data[i]);
					}
					$(".search-list").append(appendstr);
					pageNum++;
					if(data.length<2){
						$("#loadmore").html("没有更多文章喽~").attr("disabled", "true");
					}
				}
			});
       	}
       </script>
    </body>
</html>
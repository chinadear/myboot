<!DOCTYPE html>
<html>
	<head>
	    <!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Author Meta -->
		<meta name="author" content="colorlib">
		<!-- Meta Description -->
		<meta name="description" content="我的足迹,bootplus,基于springboot搭建的学习网站">
		<!-- Meta Keyword -->
		<meta name="keywords" content="我的足迹,bootplus,经管学习,IT项目,产品经理,金融贸易">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>我的足迹</title>
		<#include "../pubarea/styles.ftl">
	</head>
<body>
<#include "../pubarea/header.ftl">
	<!-- banner area start -->
	<#if structModel??&&structModel.banner??>
	<!-- <a href="${structModel.banner.url!'##'}" target="_blank"> -->
		<#if structModel.banner.file??>
			<section class="banner-area relative" style="padding:150px 0;" id="home" data-parallax="scroll" data-image-src="${rc.contextPath}/blog/noSecurity/img/${structModel.banner.file.id!}">
		<#else>
			<section class="banner-area relative section-gap" id="home" data-parallax="scroll" data-image-src="${rc.contextPath}/lib/blog/img/defult_banner.jpg">
		</#if>
	    <div class="container">
	        <div class="row justify-content-start align-items-center d-flex">
	            <div class="col-lg-8 top-left" style="min-height:120px">
	                <h1 class="text-white mb-20">${(structModel.banner.title!)?html}</h1>
	                <p class="text-white">${(structModel.banner.summary!)?html}</p>
	            </div>
	        </div>
	    </div>  
	</section>
<!-- 	</a> -->
	</#if>
	<!-- banner area end -->
	<section class="category-area section-gap" id="news">
		<div class="container">
			<div class="row d-flex justify-content-center">
				<div class="menu-content col-lg-8">
					<div class="title text-center">
						<h1 class="mb-10">主题</h1>
						<p>不积跬步无以至千里，不积小流无以成江海。学习就要循序渐进，不断积累坚持不懈，快看看今天学点啥！</p>
					</div>
				</div>
			</div>						
			<div class="active-cat-carusel">
			<#if clist??>
				<#list clist as c>
					<div class="item single-cat">
					<a href="${rc.contextPath}/articals/cate/${c.id!}" target="_blank"><!-- 340*250 -->
						<#if c.file??>
							<img src="${rc.contextPath}/blog/noSecurity/img/${c.file.id!}" style="width:100%;height:250px;" class="img-responsive center-block" alt="">
			        	<#else>
		        			<img src="${rc.contextPath}/lib/blog/img/defult_mini.png" style="width:100%;height:250px;" class="img-responsive center-block" alt="">
			        	</#if>
						<p class="date" style="width: 100%;"><h3>${(c.name!)?html}</h3></p>
						${(c.comments!)?html}</a>
					</div>
				</#list>
			</#if>
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
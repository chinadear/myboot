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
		<meta name="keywords" content="一起学习吧,云服务器搭建,springboot产品开发,从0到1学习,项目管理,产品经理,个人实践经验填坑">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>boot+</title>
		<#include "../pubarea/styles.ftl">
	</head>
<body>
<#include "../pubarea/header.ftl">
<#include "../pubarea/banner.ftl">
    <!-- Start post Area -->
    <div class="post-wrapper pt-20">
        <!-- Start post Area -->
        <section class="post-area">
            <div class="container">
                <div class="row justify-content-center d-flex">
                	<!-- 左侧 -->
                    <div class="col-lg-8">
                    <#if clist??>
                    	<#list clist as c>
	                    	<a href="${rc.contextPath}/articals/cate/${c.id!}"><div class="single_widget tag_widget">
						        <div class="row">
						        	<div class="col-sm-4">
						        		<#if c.file??>
						        			<img src="${rc.contextPath}/blog/noSecurity/img/${c.file.id!}" style="width:100%;height:100%;" class="img-responsive center-block" alt="">
						        		<#else>
							        		<img src="${rc.contextPath}/lib/blog/img/header-bg.jpg" style="width:100%;height:100%;" class="img-responsive center-block" alt="">
						        		</#if>
						        	</div>
						        	<div class="col-sm-8">
							        	<h1 class="text-black mb-20">${(c.name!)?html}</h1>
		                				<p class="text-black">${(c.comments!)?html}</p>
						        	</div>
						        </div>
						    </div></a>
						</#list>
					</#if>
					</div>
<#include "../pubarea/right.ftl">
                </div>
            </div>    
        </section>
        <!-- End post Area -->  
    </div>
    <!-- End post Area -->
    
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
					url: "${rc.contextPath}/articals/more",
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
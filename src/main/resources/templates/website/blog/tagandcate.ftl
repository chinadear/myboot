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
<#include "../pubarea/banner.ftl">
    <!-- Start post Area -->
    <div class="post-wrapper pt-20">
        <!-- Start post Area -->
        <section class="post-area">
            <div class="container">
                <div class="row justify-content-center d-flex">
                	<!-- 左侧 -->
                    <div class="col-lg-8">
                    <!-- 分类 -->
                    	<div class="single_widget tag_widget">
					        <h4 class="text-uppercase pb-20">分类</h4>
					        <ul>
					        <#if clist??>
					            <#list clist as c>
						            <li>
						                <a href="${rc.contextPath}/articals/cate/${c.id!}"  target="_blank">
						                	${(c.name!)?html}  
						    			</a>
						            </li>
					            </#list>
					        </#if>
					        </ul>
					    </div>
					    <!-- 标签 -->
					    <div class="single_widget tag_widget">
					        <h4 class="text-uppercase pb-20">标签</h4>
					        <ul>
					        <#if tlist??>
					            <#list tlist as t>
						            <li>
						                <a href="${rc.contextPath}/articals/tags/${t.id!}"  target="_blank">
						                	${(t.name!)?html}  
						    			</a>
						            </li>
					            </#list>
					        </#if>
					        </ul>
					    </div>     
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
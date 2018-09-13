<!DOCTYPE html>
<html>
	<head>
	    <!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Author Meta -->
		<meta name="author" content="colorlib">
		<!-- Meta Description -->
		<meta name="description" content="一起学习吧,bootplus,个人搭建的学习网站">
		<!-- Meta Keyword -->
		<meta name="keywords" content="一起学习吧,云服务器搭建,springboot产品开发,从0到1学习,项目管理,产品经理">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>一起学习吧</title>
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
                        <div class="post-lists search-list">
                        <#if page??>
							<#list page.result as r>
	                            <div class="single-list flex-row d-flex">
	                                <div class="detail">
	                                    <a href="${rc.contextPath}/articals/${r.id!}"  target="_blank"><h4 class="pb-10">${(r.title!)?html}</h4></a>
	                                    <p>${(r.summary!)?html}</p>
	                                    <p class="footer">
	                                    	<i class="vd-right"> 发布时间：${r.createTime!}</i>
		                                    <i>阅读量：${r.viewNum!'0'}<i class="fa fa-eye" title="阅读量"></i></i>
	                                    </p>
	                                </div>
	                            </div>
                           	</#list>
                        </#if>
                        </div>                          
                        <div class="justify-content-center d-flex">
                        <#if page??&&page.result?size gt 0>                       
                            <button class="text-uppercase primary-btn loadmore-btn mt-40 mb-60" id="loadmore" onclick="loadmore()" >加载更多...</button>
                        <#else>
                        	当前无相关文章~
                        </#if>                                                                     
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
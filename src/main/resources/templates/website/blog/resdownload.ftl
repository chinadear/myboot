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
	    <link rel="stylesheet" href="${rc.contextPath}/lib/bootstrap-select/css/bootstrap-select.min.css"/>
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
                    	<div class="single_widget tag_widget innertoolsbox">
					        <#include "innerpage/innerresdownload.ftl">
					    </div>
                    </div>
					<!-- 右侧 start -->
					<div class="col-lg-4 sidebar-area">
					<!-- 搜索 -->
					    <div class="single_widget tag_widget">
		                    <select class="selectpicker form-control form-angle input-sm breadth-form col-sm-12" title="点击搜索工具"  data-live-search="true" onchange="flashToolsBox(this)">
				    			<option value="">全部</option>
				    			<#if downloads??&&downloads?size gt 0>
					    			<#list downloads as l>
										<option value="${l.title!}">${l.title}</option>
									</#list>
								</#if>
							</select>
						</div>
					    <!-- 广告 -->
					    <div class="single_widget recent_widget">
					        <div class="active-recent-carusel">
					        <#if structModel?? &&structModel.rightdrum?? && structModel.rightdrum?size gt 0>
					        	<#list structModel.rightdrum as d>
					        		<div class="item">
						                <a href="${(d.url!)?html}" target="_blank"><#if d.file??><img src="${rc.contextPath}/blog/noSecurity/img/${d.file.id!}" class="img-responsive" alt=""><#else><img src="${rc.contextPath}/lib/blog/img/asset/slider.jpg" alt=""></#if></a>
						                <p class="mt-20 title text-uppercase">${(d.title!)?html} </p>
						                <p>${(d.summary!)?html}</p>    
						            </div> 
					        	</#list>
					        <#else>
					            <div class="item">
					                <a href="##"><img src="${rc.contextPath}/lib/blog/img/asset/slider.jpg" alt=""></a>
					                <p class="mt-20 title text-uppercase">阿里云 </p>
					                <p>云服务器（Elastic Compute Service，简称 ECS）是一种简单高效、处理能力可弹性伸缩的计算服务，帮助您快速构建更稳定、安全的应用，提升运维效率，降低 IT 成本，使您更专注于核心业务创新。</p>    
					            </div>  
					            <div class="item">
					                <a href="##"><img src="${rc.contextPath}/lib/blog/img/asset/slider.jpg" alt=""></a>
					                <p class="mt-20 title text-uppercase">腾讯云 </p>
					                <p>  从这一个介绍里面知道，redis比memcache作为缓存数据库强大的地方，一个是支持的数据类型比较多，另一个就是redis持久化功能。</p>    
					            </div>  
					            <div class="item">
					                <a href="##"><img src="${rc.contextPath}/lib/blog/img/asset/slider.jpg" alt=""></a>
					                <p class="mt-20 title text-uppercase">百度云 </p>
					                <p>baidu</p>
					            </div>                                                                                            
					        </#if>
					        </div>
					    </div> 
					<!-- 热门 -->
					    <div class="single_widget cat_widget">
					        <h4 class="text-uppercase">热门文章</h4>
					        <ul>
					        <#if structModel??&&structModel.hot??&&structModel.hot?size gt 0>
					            <#list structModel.hot as h>
						            <li>
						                <a href="${rc.contextPath}/articals/${h.id!}"  target="_blank" title="${(h.title!)?html}">    
						                <#if h.title?length gt 15>
									    	${h.title?substring(0,15)}...
									    <#else>
									    	${(h.title!)?html}
									    </#if>
									    <span>${h.viewNum!'0'}<i class="fa fa-eye" style="margin-left:5px;color: #a4a4a6;" title="阅读量"></i></span>
						    			</a>
						            </li>
					            </#list>
					        </#if>
					        </ul>
					    </div>  
					<!-- 分类 -->
					    <div class="single_widget cat_widget">
					        <h4 class="text-uppercase">分类</h4>
					        <ul>
					       	<#if structModel??&&structModel.cate??&&structModel.cate?size gt 0>
					            <#list structModel.cate as h>
						            <li>
						                <a href="${rc.contextPath}/articals/cate/${h.id!}"  target="_blank" title="${(h.name!)?html}">    
						                <#if h.name?length gt 15>
									    	${h.name?substring(0,15)}...
									    <#else>
									    	${(h.name!)?html}
									    </#if>
						    			</a>
						            </li>
					            </#list>
					        </#if>
					        </ul>
					        <a href="${rc.contextPath}/articals/tagAndcate/more" class="genric-btn link circle" style="text-decoration:none;" target="_blank">更多...</a>
					    </div>
					 	
					    <!-- tag -->
					    <div class="single_widget tag_widget">
					        <h4 class="text-uppercase pb-20">标签</h4>
					        <ul>
					        <#if structModel??&&structModel.tag??&&structModel.tag?size gt 0>
					            <#list structModel.tag as h>
						            <li>
						                <a href="${rc.contextPath}/articals/tags/${h.id!}"  target="_blank">
						                	${(h.name!)?html}  
						    			</a>
						            </li>
					            </#list>
					        </#if>
					        </ul>
					        <a href="${rc.contextPath}/articals/tagAndcate/more" class="genric-btn link circle" style="text-decoration:none;" target="_blank">更多...</a>
					    </div>                                                 
					
					</div>
					<script type="text/javascript">
					function search(){
						window.open("${rc.contextPath}/articals/search?words="+$("#words").val());
					}
					</script>
					<!-- 右侧end -->

                </div>
            </div>    
        </section>
        <!-- End post Area -->  
    </div>
    <!-- End post Area -->
    
		<#include "../pubarea/footer.ftl">      
		<#include "../pubarea/scripts.ftl">
		<script src="${rc.contextPath}/js/myblog.js"></script> 
		<script type="text/javascript" src="${rc.contextPath}/lib/bootstrap-select/js/bootstrap-select.min.js"></script> 
        <script type="text/javascript">
	        $(function () {
	    		$('[data-toggle="tooltip"]').tooltip();
	    	})
	      	function flashToolsBox(o){
	        	$(".innertoolsbox").load("${rc.contextPath}/articals/flashResDownload",{"title":o.value},function(){
	        		$('[data-toggle="tooltip"]').tooltip();
	        	});
	        }
        </script>
    </body>
</html>
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
     
            <!-- Start top-section Area -->
            <section class="top-section-area section-gap">
                <div class="container">
                    <div class="row justify-content-center align-items-center d-flex">
                        <div class="col-lg-8">
                            <div id="imaginary_container"> 
                            <form action="/articals/search">
                                <div class="input-group stylish-input-group">
                                    <input type="text" name="words" id="words" class="form-control" maxlength="50" placeholder="站内文章搜索" onfocus="this.placeholder = ''" onblur="this.placeholder = '站内文章搜索'" required="" value="${(words!)?html}">
                                    <span class="input-group-addon">
                                        <button type="submit">
                                            <span class="lnr lnr-magnifier"></span>
                                        </button>  
                                    </span>
                                </div>
                            </form>
                            </div> 
                            <p class="mt-20 text-center text-white">共搜索出 ${count!'0'} 篇相关文章</p>
                        </div>
                    </div>
                </div>  
            </section>
            <!-- End top-section Area -->
    
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
								<#if r.poster??>
									<div class="single_widget tag_widget single-list" style="padding: 10px;">
								        <div class="row">
								        	<div class="col-sm-4">
							        			<img src="${rc.contextPath}/blog/noSecurity/img/${r.poster.id!}" style="width:100%;height:100%;" class="img-responsive center-block" alt="">
								        	</div>
								        	<div class="col-sm-8 detail">
									        	<a href="${rc.contextPath}/articals/${r.id!}" target="_blank"><h4 class="pb-10">${(r.title!)?html}</h4></a>
			                                    <p>${(r.summary!)?html}</p>
			                                    <p class="footer">
			                                    	<i class="vd-right"> 发布时间：${r.createTime!}</i>
		                                    		<i>阅读量：${r.viewNum!'0'}<i class="fa fa-eye" title="阅读量"></i></i>
			                                    </p>
								        	</div>
								        </div>
								    </div>
	                            <#else>
		                           <div class="single_widget tag_widget single-list" style="padding: 10px;">
								        <div class="row">
								        	<div class="col-sm-12 detail">
									        	<a href="${rc.contextPath}/articals/${r.id!}" target="_blank"><h4 class="pb-10">${(r.title!)?html}</h4></a>
			                                    <p>${(r.summary!)?html}</p>
			                                    <p class="footer">
			                                    	<i class="vd-right"> 发布时间：${r.createTime!}</i>
		                                    		<i>阅读量：${r.viewNum!'0'}<i class="fa fa-eye" title="阅读量"></i></i>
			                                    </p>
								        	</div>
								        </div>
							        </div>
                            	</#if>
                           	</#list>
                        </#if>
                        </div>
                         <div class="justify-content-center d-flex">
                        <#if page??&&page.result?size gt 0>                          
                            <button class="text-uppercase primary-btn loadmore-btn mt-40 mb-60" id="loadmore" onclick="loadmore()" >加载更多...</button>
                        <#else>
                        	未搜索到相关文章~
                        </#if>                                                                      
                        </div>                                                                 
                    </div>
	<!-- 右侧 start -->
					<div class="col-lg-4 sidebar-area">
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
				url: "${rc.contextPath}/articals/search/more",
				data:{pageNum:pageNum,pageSize:pageSize,words:$("#words").val()},
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
					pageNum++;//页数加一
					if(data.length<2){
						$("#loadmore").html("没有更多文章喽~").attr("disabled", "true");
					}
				}
			});
    	}
    </script>
   </body>
</html>
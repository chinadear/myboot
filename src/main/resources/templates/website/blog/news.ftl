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
								<#if false><!-- 图文结合的列表还没有调好，暂时不支持 -->
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
	                            <#else>
	                            <div class="single_widget tag_widget single-list" style="padding: 10px;">
							        <div class="row">
							        	<div class="col-sm-4"> 
							        		<#switch r_index%3> 
												<#case 0>
								        			<img src="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2532104642,3296323948&fm=173&app=25&f=JPEG?w=218&h=146&s=49B022D1D764070D940DD40D0300E0D1" style="width:100%;height:100%;" class="img-responsive center-block" alt="">
												<#break> 
												<#case 1>
													<img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1333422679,1744962616&fm=173&app=25&f=JPEG?w=218&h=146&s=1221716C845A95D413F7E59A0300409F" class="img-responsive center-block" alt="">
												<#break> 
												<#case 2>
													<img src="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=950379029,1521686261&fm=173&app=25&f=JPEG?w=218&h=146&s=EA2DA044FA31EBCE2C373D81030080A8" class="img-responsive center-block" alt="">
												<#break> 
												<#default><img src="${rc.contextPath}/lib/blog/img/header-bg.jpg" class="img-responsive center-block" alt="">
																										
											</#switch>
							        	</div>
							        	<div class="col-sm-8 detail">
								        	<a href="#"><h4 class="pb-10">${(r.title!)?html}</h4></a>
		                                    <p>${(r.summary!)?html}</p>
		                                    <p class="footer">
		                                    	<i class="vd-right"> 发布时间：${r.createTime!}</i>
	                                    		<i>阅读量：${r.viewNum!'0'}<i class="fa fa-eye" title="阅读量"></i></i>
		                                    </p>
							        	</div>
							        </div>
							    </div>
		                            <!-- <div class="single-list flex-row d-flex">
		                                <div class="detail">
			                                <div class="row">
				                                <div class="thumb col-sm-4 thumbnail">
				                                    <img src="${rc.contextPath}/lib/blog/img/header-bg.jpg" class="img-responsive center-block" alt="">
				                                </div>
				                                <div class="col-sm-8">
				                                    <a href="#"><h4 class="pb-10">${(r.title!)?html}</h4></a>
				                                    <p>${(r.summary!)?html}</p>
				                                    <p class="footer">
				                                    	<i class="vd-right"> 发布时间：${r.createTime!}</i>
			                                    		<i>阅读量：${r.viewNum!'0'}<i class="fa fa-eye" title="阅读量"></i></i>
				                                    </p>
			                                    </div>
			                                </div>
		                                </div>
	                            	</div> -->
                            	</#if>
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
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
     
            <!-- Start top-section Area -->
            <section class="top-section-area section-gap">
                <div class="container">
                    <div class="row justify-content-center align-items-center d-flex">
                        <div class="col-lg-8">
                            <div id="imaginary_container"> 
                                <div class="input-group stylish-input-group">
                                    <input type="text" class="form-control"  placeholder="站内搜索" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Addictionwhen gambling '" required="">
                                    <span class="input-group-addon">
                                        <button type="submit">
                                            <span class="lnr lnr-magnifier"></span>
                                        </button>  
                                    </span>
                                </div>
                            </div> 
                            <p class="mt-20 text-center text-white">169 results found for “Addictionwhen gambling”</p>
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
								<#if true><!-- 图文结合的列表还没有调好，暂时不支持 -->
		                            <div class="single-list flex-row d-flex">
		                                <div class="detail">
		                                    <a href="${rc.contextPath}/articals/${r.id!}"  target="_blank"><h4 class="pb-10">${(r.title!)?html}</h4></a>
		                                    <p>${(r.summary!)?html}</p>
		                                    <p class="footer">
			                                    <i>${r.createTime?date} 发布</i>
			                                    <i class="fa fa-eye" aria-hidden="true" title="阅读量"></i><a href="#">06</a>     
			                                    <i class="ml-10 fa fa-comment-o" aria-hidden="true" title="评论"></i><a href="#">02</a>
		                                    </p>
		                                </div>
		                            </div>
	                            <#else>
		                            <div class="single-list flex-row d-flex">
		                                <div class="detail">
			                                <div class="row">
				                                <div class="thumb col-sm-4">
				                                    <img src="${rc.contextPath}/lib/blog/img/header-bg.jpg" class="img-responsive" style="width:170px;height:160px;" alt="">
				                                </div>
				                                <div class="col-sm-8">
				                                    <a href="#"><h4 class="pb-10">${(r.title!)?html}</h4></a>
				                                    <p>${(r.summary!)?html}</p>
				                                    <p class="footer">
					                                    <i>${r.createTime?date} 发布</i>
					                                    <i class="fa fa-eye" aria-hidden="true" title="阅读量"></i><a href="#">06</a>     
					                                    <i class="ml-10 fa fa-comment-o" aria-hidden="true" title="评论"></i><a href="#">02</a>
				                                    </p>
			                                    </div>
			                                </div>
		                                </div>
	                            	</div>
                            	</#if>
                           	</#list>
                        </#if>
                            <div class="justify-content-center d-flex">
                                <a class="text-uppercase primary-btn loadmore-btn mt-40 mb-60" href="#"> Load More Post</a>
                            </div>                                                                     
                        </div>                          
                    </div>
<!-- 右侧 start -->
                    <div class="col-lg-4 sidebar-area pt-20">
                        <!-- 广告 -->
                        <div class="single_widget recent_widget">
                            <h4 class="text-uppercase pb-20">广告</h4>
                            <div class="active-recent-carusel">
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
                            </div>
                        </div> 
						<!-- 分类 -->
                        <div class="single_widget cat_widget">
                            <h4 class="text-uppercase pb-20">类别</h4>
                            <ul>
                                <li>
                                    <a href="#">Technology <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Lifestyle <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Fashion <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Art <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Food <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Architecture <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Adventure <span>37</span></a>
                                </li>                                
                            </ul>
                        </div>
                     	<!-- 今日推荐 -->
                        <div class="single_widget cat_widget">
                            <h4 class="text-uppercase pb-20">今日推荐</h4>
                            <ul>
                                <li>
                                    <a href="#">Dec'17 <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Nov'17 <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Oct'17 <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Sept'17 <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Aug'17 <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Jul'17 <span>37</span></a>
                                </li>
                                <li>
                                    <a href="#">Jun'17 <span>37</span></a>
                                </li>                                
                            </ul>
                        </div> 
                        <!-- tag -->
                        <div class="single_widget tag_widget">
                            <h4 class="text-uppercase pb-20">标签</h4>
                            <ul>
                                <li><a href="#">Lifestyle</a></li>
                                <li><a href="#">Art</a></li>
                                <li><a href="#">Adventure</a></li>
                                <li><a href="#">Food</a></li>
                                <li><a href="#">Technology</a></li>
                                <li><a href="#">Fashion</a></li>
                                <li><a href="#">Adventure</a></li>
                                <li><a href="#">Food</a></li>
                                <li><a href="#">Technology</a></li>
                            </ul>
                        </div>                                                 
                  		
                    </div>
<!-- 右侧end -->
                </div>
            </div>    
        </section>
        <!-- End post Area -->  
    </div>
    <!-- End post Area -->
    
<!-- start footer Area -->      
        <footer class="footer-area section-gap">
            <div class="container">
                <div class="row">
                </div>

                <div class="row footer-bottom d-flex justify-content-between">

                    
                    <p class="col-lg-8 col-sm-12 footer-text">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | made with Colorlib -  More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
                    

                    <div class="col-lg-4 col-sm-12 footer-social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-dribbble"></i></a>
                        <a href="#"><i class="fa fa-behance"></i></a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- End footer Area -->        

        <script src="${rc.contextPath}/lib/blog/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="${rc.contextPath}/lib/blog/js/vendor/bootstrap.min.js"></script>
        <script src="${rc.contextPath}/lib/blog/js/jquery.ajaxchimp.min.js"></script>
        <script src="${rc.contextPath}/lib/blog/js/parallax.min.js"></script>          
        <script src="${rc.contextPath}/lib/blog/js/owl.carousel.min.js"></script>      
        <script src="${rc.contextPath}/lib/blog/js/jquery.magnific-popup.min.js"></script>             
        <script src="${rc.contextPath}/lib/blog/js/jquery.sticky.js"></script>
        <script src="${rc.contextPath}/lib/blog/js/main.js"></script>  
    </body>
</html>
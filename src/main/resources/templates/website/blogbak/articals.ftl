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
		<!-- Favicon-->
		<link rel="shortcut icon" href="${rc.contextPath}/lib/blog/img/fav.png">
		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
		<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/linearicons.css">
		<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/font-awesome.min.css">
		<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/bootstrap.css">
		<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/owl.carousel.css">
		<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/main.css">
	</head>
<body>
     <!-- Start Header Area -->
	<header class="default-header">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<a class="navbar-brand" href="##">
					<img src="${rc.contextPath}/lib/blog/img/logo.png" alt="bootplus">
				</a>
		        <!-- 响应式菜单样式start -->
		        <!-- 移动端菜单控制按钮，只有移动端浏览才会出现 -->
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-end align-items-center" id="navbarSupportedContent">
					<ul class="navbar-nav scrollable-menu">
						<li><a href="#home">首页</a></li>
						<li><a href="#news">新闻</a></li>
						<li><a href="#travel">springboot</a></li>
						<li><a href="#fashion">java工具类</a></li>
						<li><a href="${rc.contextPath}/articals">博客</a></li>
						<!-- Dropdown -->
					    <li class="dropdown">
							<a class="dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
							  阿里云
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="single.html">Single</a>
								<a class="dropdown-item" href="category.html">Category</a>
								<a class="dropdown-item" href="search.html">Search</a>
								<a class="dropdown-item" href="archive.html">Archive</a>
								<a class="dropdown-item" href="generic.html">Generic</a>
								<a class="dropdown-item" href="elements.html">Elements</a>
							</div>
					    </li>                               
					</ul>
				</div><!-- 响应式钮菜单end -->                     
		    </div>
		</nav>
	</header>
     <!-- End Header Area -->
     
     <!-- Start top-section Area -->
     <section class="banner-area relative section-gap" id="home" data-parallax="scroll" data-image-src="${rc.contextPath}/lib/blog/img/header-bg.jpg">
         <div class="container">
             <div class="row justify-content-start align-items-center d-flex">
                 <div class="col-lg-8 top-left">
                     <h1 class="text-white mb-20">阿里雲</h1>
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
			                                    <i>${r.createTime!} 发布</i>
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
                        </div>                          
                        <div class="justify-content-center d-flex">
                            <button class="text-uppercase primary-btn loadmore-btn mt-40 mb-60" id="loadmore" onclick="loadmore()" >加载更多...</button>
                        </div>                                                                     
                    </div>
<!-- 右侧 start -->
                    <div class="col-lg-4 sidebar-area pt-20">
						<!-- 搜索 -->
                        <div class="single_widget search_widget">
                            <div id="imaginary_container"> 
                                <div class="input-group stylish-input-group">
                                    <input type="text" class="form-control"  placeholder="站内搜索" >
                                    <span class="input-group-addon">
                                        <button type="button" onclick="search()">
                                            <span class="lnr lnr-magnifier"></span>
                                        </button>  
                                    </span>
                                </div>
                            </div> 
                        </div>
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
        	function search(){
        		window.open("${rc.contextPath}/articals/search");
    	    }
        </script>
    </body>
</html>
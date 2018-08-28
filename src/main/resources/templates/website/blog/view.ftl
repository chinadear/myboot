 <!DOCTYPE html>
 <html>
 <head>
     <!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Author Meta -->
	<meta name="author" content="colorlib">
	<!-- Meta Description -->
	<meta name="description" content="${(artical.summary!)?html}">
	<!-- Meta Keyword -->
	<meta name="keywords" content="${(artical.tags!)?html}">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>${(artical.title!)?html}</title>
	<!-- Favicon-->
	<link rel="shortcut icon" href="${rc.contextPath}/lib/blog/img/fav.png">
	<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
	<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/linearicons.css">
	<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/font-awesome.min.css">
	<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/bootstrap.css">
	<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/owl.carousel.css">
	<link rel="stylesheet" href="${rc.contextPath}/lib/blog/css/main.css">
	<link rel="stylesheet" href="${rc.contextPath}/lib/editormd/css/editormd.css"/>
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
						<li><a href="##">java工具类</a></li>
						<li><a href="${rc.contextPath}/liulu/blog">博客</a></li>
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
    <!--  <section class="banner-area relative section-gap" id="home" data-parallax="scroll" data-image-src="${rc.contextPath}/lib/blog/img/header-bg.jpg">
         <div class="container">
             <div class="row justify-content-start align-items-center d-flex">
                 <div class="col-lg-8 top-left">
                     <h1 class="text-white mb-20">阿里雲</h1>
                 </div>
             </div>
         </div>  
     </section> -->
     <!-- End top-section Area -->
    <!-- Start post Area -->
    <div class="post-wrapper pt-20">
        <!-- Start post Area -->
        <section class="post-area">
            <div class="container">
                <div class="row justify-content-center">
<!-- 左侧内容区 -->
                    <div class="col-lg-8">
                        <div class="single-page-post">
                            <div class="top-wrapper ">
                                <div class="row d-flex justify-content-between">
	                                    <h2 class="col-lg-12 col-md-12 text-uppercase">
	                                        ${(artical.title!)?html}
	                                    </h2>
                                </div>
                            </div>
                            <div class="row artical-meta" >
                                  <i style="margin-top:1px;">发布时间：${artical.createTime?datetime}</i>
                                  <i style="margin-top:1px;">分类：${artical.category.name}</i>
                                  <i class="fa fa-eye" aria-hidden="true" title="阅读量">&nbsp;1322</i>    
                                  <i class="ml-10 fa fa-comment-o" aria-hidden="true" title="评论">&nbsp;29</i>
                            </div>
                            <div class="tags">
                                <ul>
                                	<#if tags??>
                                		<#list tags as t>
                                    		<li><a href="#">${(t.tag.name!)?html}</a></li>
                                    	</#list>
                                    </#if>
                                </ul>
                            </div>
<!-- 博文显示区start -->
                            <div class="single-post-content">
                            	<div id="com"><textarea style="display: none;">${artical.htmlContent!}</textarea></div>
                            </div>
<!-- 博文显示区end -->							
                            <div class="bottom-wrapper">
                                <div class="row">
                                    <div class="col-lg-8 single-b-wrap col-md-12">
                                    </div>
                                    <div class="col-lg-4 single-b-wrap col-md-12">
                                        <ul class="social-icons">
                                            <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
                                            <li><a href="#"><i class="fa fa-behance" aria-hidden="true"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                            <!-- Start 留言 Area -->
                            <section class="nav-area pb-15">
                                <div class="container">
                                    <div class="row justify-content-between">
                                        <div class="col-sm-12 nav-left justify-content-start d-flex">
                                             <textarea class="form-control" rows="1" placeholder="说点什么吧"></textarea>            
	                                        <button type="button" class="btn btn-primary btn-sm optionbtn">发表评论</button>
                                        </div>
                                    </div>
                                  <!--   <div class="row justify-content-between">
                                    	<div class="col-sm-12" style="text-align: right;">
                                    	<button type="button" class="btn btn-primary btn-sm optionbtn">发表评论</button>
                                   		</div>
                                    </div> -->
                                </div>    
                            </section>
                            <!-- End 留言 Area -->
                            
                            <!-- Start 评论 Area -->
                            <section class="comment-sec-area pt-20 pb-20">
                                <div class="container">
                                    <div class="row flex-column">
                                        <div class="comment-list">
                                            <div class="single-comment justify-content-between d-flex">
                                                <div class="user justify-content-between d-flex">
                                                    <div class="thumb">
                                                        <img src="" alt="">
                                                    </div>
                                                    <div class="desc">
                                                        <h5><a href="#">Emilly Blunt</a></h5>
                                                        <p class="date">December 4, 2017 at 3:12 pm </p>
                                                        <p class="comment">
                                                            Never say goodbye till the end comes!
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="reply-btn">
                                                       <a href="" class="btn-reply text-uppercase">回复</a> 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="comment-list left-padding">
                                            <div class="single-comment justify-content-between d-flex">
                                                <div class="user justify-content-between d-flex">
                                                    <div class="thumb">
                                                        <img src="" alt="">
                                                    </div>
                                                    <div class="desc">
                                                        <h5><a href="#">Emilly Blunt</a></h5>
                                                        <p class="date">December 4, 2017 at 3:12 pm </p>
                                                        <p class="comment">
                                                            Never say goodbye till the end comes!
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="reply-btn">
                                                       <a href="" class="btn-reply text-uppercase">回复</a> 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="comment-list left-padding">
                                            <div class="single-comment justify-content-between d-flex">
                                                <div class="user justify-content-between d-flex">
                                                    <div class="thumb">
                                                        <img src="" alt="">
                                                    </div>
                                                    <div class="desc">
                                                        <h5><a href="#">Emilly Blunt</a></h5>
                                                        <p class="date">December 4, 2017 at 3:12 pm </p>
                                                        <p class="comment">
                                                            Never say goodbye till the end comes!
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="reply-btn">
                                                       <a href="" class="btn-reply text-uppercase">回复</a> 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="comment-list">
                                            <div class="single-comment justify-content-between d-flex">
                                                <div class="user justify-content-between d-flex">
                                                    <div class="thumb">
                                                        <img src="" alt="">
                                                    </div>
                                                    <div class="desc">
                                                        <h5><a href="#">Emilly Blunt</a></h5>
                                                        <p class="date">December 4, 2017 at 3:12 pm </p>
                                                        <p class="comment">
                                                            Never say goodbye till the end comes!
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="reply-btn">
                                                       <a href="" class="btn-reply text-uppercase">回复</a> 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="comment-list">
                                            <div class="single-comment justify-content-between d-flex">
                                                <div class="user justify-content-between d-flex">
                                                    <div class="thumb">
                                                        <img src="" alt="">
                                                    </div>
                                                    <div class="desc">
                                                        <h5><a href="#">Emilly Blunt</a></h5>
                                                        <p class="date">December 4, 2017 at 3:12 pm </p>
                                                        <p class="comment">
                                                            Never say goodbye till the end comes!
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="reply-btn">
                                                       <a href="" class="btn-reply text-uppercase">回复</a> 
                                                </div>
                                            </div>
                                        </div>                                                                                                                                                                
                                    </div>
                                </div>    
                            </section>
                            <!-- End 评论 Area -->
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
                                        <button type="submit">
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
	    <script src="${rc.contextPath}/lib/editormd/lib/marked.min.js"></script>
	    <script src="${rc.contextPath}/lib/editormd/lib/prettify.min.js"></script>
		<script src="${rc.contextPath}/lib/editormd/lib/raphael.min.js"></script>
		<script src="${rc.contextPath}/lib/editormd/lib/underscore.min.js"></script>
		<script src="${rc.contextPath}/lib/editormd/lib/sequence-diagram.min.js"></script>
		<script src="${rc.contextPath}/lib/editormd/lib/flowchart.min.js"></script>
		<script src="${rc.contextPath}/lib/editormd/lib/jquery.flowchart.min.js"></script>
	    <script src="${rc.contextPath}/lib/editormd/js/editormd.js"></script>
	    <script type="text/javascript">
	    $(function(){
		    	editormd.markdownToHTML("com", {//注意：这里是上面DIV的id
			        htmlDecode : "style,script,iframe",
			        emoji : true,
			        taskList : true,
			        tex : true, // 默认不解析
			        flowChart : true, // 默认不解析
			        sequenceDiagram : false, // 默认不解析
			        codeFold : true
			    }); 
	    	})
	    </script>
    </body>
</html>
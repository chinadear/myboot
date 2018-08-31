<!-- 右侧 start -->
<div class="col-lg-4 sidebar-area">
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
<script type="text/javascript">
function search(){
	window.open("${rc.contextPath}/articals/search");
}
</script>
<!-- 右侧end -->

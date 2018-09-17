<!-- 右侧 start -->
<div class="col-lg-4 sidebar-area">
<!-- 搜索 -->
    <div class="single_widget search_widget">
        <div id="imaginary_container"> 
            <form action="${rc.contextPath}/articals/search">
            <div class="input-group stylish-input-group">
                <input type="text" id="words" name="words" maxlength="50" class="form-control"  placeholder="站内文章搜索" >
                <span class="input-group-addon">
                    <button type="submit">
                        <span class="lnr lnr-magnifier"></span>
                    </button>  
                </span>
            </div>
            </form>
        </div> 
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
                <p class="mt-20 title text-uppercase">一起学习吧</p>
                <p>记录自己学习过程中的点点滴滴，学习就要循序渐进，不断积累。</p>    
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

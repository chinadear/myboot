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
	<#include "../pubarea/styles.ftl">
	<link rel="stylesheet" href="${rc.contextPath}/lib/editormd/css/editormd.css"/>
</head>
<body>
<#include "../pubarea/header.ftl">
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
                                  <i style="margin-top:1px;" class="vd-right">发布时间：${artical.createTime?datetime}</i>
                                  <i style="margin-top:1px;" class="vd-right">分类：<#if artical.category??>${artical.category.name}<#else>其他</#if></i>
                                  <i style="margin-top:1px;">阅读量：${artical.viewNum!'0'}<i class="fa fa-eye" title="阅读量"></i></i>   
                            </div>
                            <div class="tags">
                                <ul>
                                	<#if tags??>
                                		<#list tags as t>
                                    		<li><a href="${rc.contextPath}/articals/tags/${t.tag.id!}">${(t.tag.name!)?html}</a></li>
                                    	</#list>
                                    </#if>
                                </ul>
                            </div>
<!-- 博文显示区start -->
                            <div class="single-post-content">
                            	<div id="com" style="font-size:18px;"><textarea style="display: none;">${(artical.htmlContent!)?html}</textarea></div>
                            </div>
<!-- 博文显示区end -->		
							<!-- 分享 -->				
                            <div class="bottom-wrapper">
                                <div class="row">
                                    <div class="col-lg-8 single-b-wrap col-md-12">
                                    </div>
                                    <div class="col-lg-4 single-b-wrap col-md-12">
                                        <ul class="social-icons">
                                            <li style="margin-right: 0;">
		                        				<a href="##" onclick="toSinawebo('${(artical.title!)?html}','${rc.contextPath}/articals/${artical.id}','')" title="分享到新浪微博"><img src="${rc.contextPath}/lib/blog/img/wb.png" style="width:30px;height:30px;float:right;margin-left:10px;background-color:#fff""></a>
		                        			</li>
		                        			<li>
			                        			<a href="##" onclick="toQQSpace('${(artical.title!)?html}','${rc.contextPath}/articals/${artical.id}','')" title="分享到QQ空间"><img src="${rc.contextPath}/lib/blog/img/qq.png" style="width:30px;height:30px;float:right;margin-left:10px;background-color:#fff;margin-top: 2px;"></a>
		                        			</li>
		                        			<li style="margin-left: -18px;">
			                        			<a href="##" onclick="toQQ('${(artical.title!)?html}','${rc.contextPath}/articals/${artical.id}','','${(artical.summary!)?html}')" title="分享到QQ"><img src="${rc.contextPath}/lib/blog/img/qqlogo.png" style="width:30px;height:30px;float:right;margin-left:10px;background-color:#fff;margin-top: 2px;"></a>
		                        			</li>
		                        			<li style="margin-left: -18px;">
			                        			<a href="##" onclick="toWX('${artical.id!}')" title="分享到微信"><img src="${rc.contextPath}/lib/blog/img/wx.png" style="width:30px;height:30px;float:right;margin-left:10px;background-color:#fff;margin-top: 2px;"></a>
		                        			</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
							<input type="hidden" id="articalId" value="${artical.id!}">
                            <#if comment_switch=='1'>
	                            <!-- Start 留言 Area -->
	                            <section class="nav-area pb-15">
	                                <div class="container">
	                                    <div class="row justify-content-between">
	                                        <div class="col-sm-12 nav-left justify-content-start d-flex">
	                                        	<#if artical.discuss=='0'>
	                                        		<textarea class="form-control" rows="1" disabled="disabled"  placeholder="评论已关闭"></textarea>            
		                                        	<button type="button" class="btn btn-primary btn-sm optionbtn" disabled="disabled">发表评论</button>
	                                        	<#else>
		                                            <textarea class="form-control" rows="1" id="comment" placeholder="说点什么吧"></textarea>            
		                                        	<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="addComment()">发表评论</button>
	                                        	</#if>
	                                        </div>
	                                    </div>
	                                </div>    
	                            </section>
	                            <!-- End 留言 Area -->
                            
	                            <!-- Start 评论 Area -->
	                            <section class="comment-sec-area pt-20 pb-20">
	                                <div class="container">
	                                    <div class="row flex-column">
	                                    <#if page??>
											<#list page.result as r>
		                                        <div class="comment-list">
		                                            <div class="single-comment justify-content-between d-flex">
		                                                <div class="user justify-content-between d-flex">
		                                                   <!--  头像，暂时不要
		                                                   <div class="thumb">
		                                                        <img src="" alt="">
		                                                    </div> -->
		                                                    <div class="desc">
		                                                        <h5><a href="#">匿名用户${(r.screenname!)?html}</a></h5>
		                                                        <p class="date">留言时间：${r.createTime!}</p>
		                                                        <p class="comment">
		                                                            ${(r.comment!)?html}
		                                                        </p>
		                                                    </div>
		                                                </div>
		                                                <!-- 回复按钮暂时不要
		                                                <div class="reply-btn">
		                                                       <a href="" class="btn-reply text-uppercase">回复</a> 
		                                                </div> -->
		                                          	</div>
		                                        </div>
	                                       	</#list>
	                                   </#if>
	                                        <!-- 回复区域暂时不要
	                                        <div class="comment-list left-padding">
	                                            <div class="single-comment justify-content-between d-flex">
	                                                <div class="user justify-content-between d-flex">
	                                                    <div class="thumb">
	                                                        <img src="" alt="">
	                                                    </div>
	                                                    <div class="desc">
	                                                        <h5><a href="#">2Emilly Blunt</a></h5>
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
	                                        </div> -->
	                                        
	                                    </div>
	                                </div>    
	                            </section>
                           </#if>
                            <!-- End 评论 Area -->
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
			        sequenceDiagram : true, // 默认不解析
			        codeFold : true
			    }); 
	    	})
    	function addComment(){
	    	var articalId=$("#articalId").val();
	    	var comment=$("#comment").val();
	    	if(comment==null || comment==""){
	    		alert("请填写评论内容");
	    		return;
	    	}
	    	$.ajax({
				async :false,
				cache :false,
				dataType :"text",
				type:"POST",
				timeout: 100000,
				url: "${rc.contextPath}/articals/comment/add",
				data:{articalId:articalId,comment:comment},
				error: function () {//请求失败处理函数
					alert("请求失败！");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					$("#comment").val("");
					alert("评论成功！");
				}
			});
	    }
	    //分享到新浪微博  
	    function toSinawebo(title,url,picurl){
	    	var domain = window.location.host;
	    	url="http://"+domain+url;
		    var sharesinastring='http://v.t.sina.com.cn/share/share.php?title='+title+'&url='+url+'&content=utf-8&sourceUrl='+url+'&pic='+picurl;  
		    window.open(sharesinastring,'newwindow','height=400,width=400,top=100,left=100');  
	    }  
	    //分享到QQ空间  
	    function toQQSpace(title,url,picurl){
	    	var domain = window.location.host;
	    	url="http://"+domain+url;
		    var shareqqzonestring='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?summary='+title+'&url='+url+'&pics='+picurl;  
		    window.open(shareqqzonestring,'newwindow','height=400,width=400,top=100,left=100');  
	    } 
	    function toQQ(title,url,picurl,summary){
	    	var domain = window.location.host;
	    	url="http://"+domain+url;
	    	var shareqqstring = "http://connect.qq.com/widget/shareqq/index.html?url="+url+"&title="+title+"&source=&desc=&pics=&summary="+summary;
	    	window.open(shareqqstring,'newwindow','height=600,width=800,top=50,left=250'); 
	    }
	    function toWX(id){
	    	window.open("${rc.contextPath}/articals/share2wx/"+id,'newwindow','height=330,width=330,top=150,left=450'); 
	    }
	    </script>
    </body>
</html>
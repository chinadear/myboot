<!-- start footer Area -->      
<footer class="footer-area section-gap">
	<div class="container">
		<div class="row">
			<div class="col-lg-4  col-md-12">
				<div class="single-footer-widget">
					<h6>留言吧</h6>
					<p>有什么问题请给我留言.</p>
					<div class="input-group">
					    <input type="text" class="form-control" id="message" style="height:100%;" maxlength="150" placeholder="150个字以内" onfocus="this.placeholder = ''" onblur="this.placeholder = '150个字以内'">
					    <span class="input-group-btn">
					   		<button class="btn btn-success" style="height:100%" type="button" onclick="sendMsg()">Go!</button>
					    </span>
				    </div><!-- /input-group -->
				</div>
			</div>
			<div class="col-lg-5  col-md-12">
				<div class="single-footer-widget newsletter">
					<h6>一起学习吧</h6>
					<ul class="unordered-list">
						<li>学习就要循序渐进，坚持到底，才有收获。</li>
						<li>记录学习过程中的点点滴滴，不断积累，厚积薄发。</li>
						<li>什么是bootplus?名字听起来是不是很高端？其实就是因为这个网站是基于springboot+各种插件构建的，因此叫bootplus哈哈。</li>
					</ul>
				</div>
			</div>
			<div class="col-lg-3  col-md-12">
				<div class="single-footer-widget mail-chimp" style="margin-top: 50px;margin-left: 70px;">
					<img src="${rc.contextPath}/lib/blog/img/footerlogo.png" alt="bootplus">
				</div>
			</div>						
		</div>

		<div class="row footer-bottom d-flex justify-content-between">
	 		<p class="col-lg-8 col-sm-12 footer-text" style="margin-top: 20px;">Copyright &copy;<script>document.write(new Date().getFullYear());</script> <a href="http://www.bootplus.com.cn/" target="_blank" title="boot+一切">Bootplus</a>.&nbsp;All Rights Reserved.&nbsp;|&nbsp;备案号:京ICP备18046806号 </p>		
			<div class="col-lg-4 col-sm-12">
				<a href="##" onclick="tofSinawebo()" title="分享到微博"><img src="${rc.contextPath}/lib/blog/img/wb.png" class="rounded img-thumbnail" style="width:40px;height:40px;float:right;margin-left:10px;background-color:#fff"></a>
				<a href="##" onclick="tofQQSpace()" title="分享到QQ空间"><img src="${rc.contextPath}/lib/blog/img/qq.png" class="rounded img-thumbnail" style="width:40px;height:40px;float:right;margin-left:10px;background-color:#fff;"></a>
				<a href="##" onclick="tofQQ()" title="分享到QQ"><img src="${rc.contextPath}/lib/blog/img/qqlogo.png" class="rounded img-thumbnail" style="width:40px;height:40px;float:right;margin-left:10px;background-color:#fff;"></a>
				<a href="##" onclick="tofWX()" title="分享到微信"><img src="${rc.contextPath}/lib/blog/img/wx.png" class="rounded img-thumbnail" style="width:40px;height:40px;float:right;margin-left:10px;background-color:#fff;"></a>
			</div>
		</div>
	</div>
</footer>
<script type="text/javascript">
	//分享到新浪微博  
	function tofSinawebo(){
		var url="https://www.bootplus.com.cn";
	    var sharesinastring='http://v.t.sina.com.cn/share/share.php?title=和我一起学习吧&url='+url+'&content=utf-8&sourceUrl='+url+'&pic=';  
	    window.open(sharesinastring,'newwindow','height=400,width=400,top=100,left=100');  
	}  
	//分享到QQ空间  
	function tofQQSpace(){
		var url="https://www.bootplus.com.cn";
	    var shareqqzonestring='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?summary=和我一起学习吧&url='+url+'&pics=';  
	    window.open(shareqqzonestring,'newwindow','height=400,width=400,top=100,left=100');  
	} 
	function tofQQ(){
		var url="https://www.bootplus.com.cn";
		var shareqqstring = "http://connect.qq.com/widget/shareqq/index.html?url="+url+"&title=和我一起学习吧&source=&desc=&pics=&summary=自己从开发到发布，从单机到云端，从0到1开发属于自己的产品";
		window.open(shareqqstring,'newwindow','height=600,width=800,top=50,left=250'); 
	}
	function tofWX(){
		window.open("${rc.contextPath}/articals/share2wx/''",'newwindow','height=330,width=330,top=150,left=450'); 
	}
	function sendMsg(){
		var msg=$("#message").val();
		if(msg=="" || msg==null){
			alert("说点什么吧！");
		}else{
			 $.ajax({
				async :false,
				cache :false,
				type:"POST",
				dataType :"text",
				timeout: 100000,
				url: "${rc.contextPath}/articals/sendMsg",
				data:{msg:msg},
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					return;
				},
				success:function(data){ //请求成功后处理函数。 
					if(data=="T"){
						alert("您想说的话已经发给站长了！");
						$("#message").val('');
					}else{
						alert("您已经留过言了，请过一会再来吧！");
						$("#message").val('');
					}
				}
			});
		}
	}
</script>
<!-- End footer Area -->        

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>写博客</title>
</head>
<body>
	<div  class="inner-header">
		<form class="form-inline">
	    	<div class="col-sm-10" style="margin-left: -4px;">
				<input type="text" class="form-control optionbtn-left" value="${(blog.title!)?html}" style="width:100%;" maxlength="50" name="title_" id="title_" placeholder="输入文章标题"/>
	    	</div>
	    	<div class="col-sm-2">
	    		<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="goback();">返回</button>
				<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="articalMetaSet();">发布</button>
	    		<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="saveblog();">保存</button>
			</div>
		</form>
	</div>
	<div class="container-fluid innerScroll">
		<form id="blogform" action="${rc.contextPath}/blog/modify" method="post" >
			<input type="hidden" name="title" id="title" value=""/>
			<input type="hidden" name="prestatus" id="prestatus" value="${blog.status!}"/><!-- 进到编辑页面的状态只可能是0草稿,2未发布,此状态为记录编辑前的状态用于分辨是否草稿状态 -->
			<input type="hidden" name="id" id="id" value="${blog.id!}"/>
			<input type="hidden" name="cateId" id="categoryid" value=""/>
			<input type="hidden" name="tags" id="tags" value=""/>
			<input type="hidden" name="status" id="status" value=""/>
			<div class="editormd" id="test-editormd"><!-- test-editormd-markdown-doc -->
			    <textarea class="editormd-markdown-textarea" name="content" id="content">${blog.content!}</textarea>
			    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
			    <textarea class="editormd-html-textarea" name="htmlContent" id="htmlContent">${blog.htmlContent}</textarea>
			</div>
			<div class="modal fade in" id="editModal" tabindex="-1" role="dialog" aria-hidden="true">  
				<div class="modal-dialog">  
					<div class="modal-content">  
						<div class="modal-header">  
					        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
					        <h4 class="modal-title">摘要</h4>  
				        </div>  
						<div class="modal-body">  
					    	<textarea class="form-control" rows="3" id="summary" name="summary" maxlength="150" placeholder="请填写150字以内的文章摘要">${(blog.summary!)?html}</textarea>
					    </div>  
						<div class="modal-footer">  
							<button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>  
						</div>  
					</div><!-- /.modal-content -->  
				</div><!-- /.modal-dialog -->  
			</div><!-- /.modal -->
		</form>
	</div>
<!-- 发布设置文章属性-->
<div class="modal fade in" id="publishModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">文章设置</h4>  
	        </div>  
			<div class="modal-body"> 
				<form class="form-horizontal">
				 	<div class="form-group">
					    <label class="col-sm-2 control-label">分类</label>
					    <div class="col-sm-9">
					    <select name="cate" id="cate" class="form-control">
					    	<option value="">其他分类</option>
					    	<#if clist??>
					    		<#list clist as cl>
					    			<#if blog??&&blog.category??>
					    				<#if blog.category.id==cl.id>
					    					<option value="${cl.id}" selected>${(cl.name!)?html}</option>
					    				<#else>
					    					<option value="${cl.id}">${(cl.name!)?html}</option>
					    				</#if>
					    			<#else>
					    				<option value="${cl.id}">${(cl.name!)?html}</option>
					    			</#if>
					    		</#list>
					    	</#if>
					    </select>
					    </div>
				 	</div>
					 <div class="form-group">
					    <label class="col-sm-2 control-label">标签</label>
					    <div class="col-sm-9">
					      <input type="text" class="form-control" maxlength="50" id="tagstr" name="tagstr" value="${(blog.tags!)?html}" placeholder="各个标签通过逗号分隔">
					    </div>
				 	</div>
				 </form>
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="sure()">确定</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->
<script type="text/javascript">
window.onload = function(){
       editormd("test-editormd", {
           width   : "100%",
           height  : 450,
           syncScrolling : "single",
          // emoji : true,
           //你的lib目录的路径，我这边用JSP做测试的
           tocm : true, // Using [TOCM]
           tex : true, // 开启科学公式TeX语言支持，默认关闭
           flowChart : true, // 开启流程图支持，默认关闭
           placeholder:"开始你的博文吧...",
           path    : "${rc.contextPath}/lib/editormd/lib/",
           //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
           saveHTMLToTextarea : true,
           imageUpload : true,
           imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
           imageUploadURL : "/blog/uploadimg",
           onsummary:function(){comp.showModal('editModal');},
           onload: function () {
               //console.log('onload', this);
               //this.fullscreen();
               //this.unwatch();
               //this.watch().fullscreen();
               this.width("100%");
               this.height(pingHeight-173);//480
               //this.resize("100%", 640);
           }
       });
   }
   //发布处理，只有从草稿状态发布时需要设置分类与标签
	function articalMetaSet(){
		var status=$("#prestatus").val();
		if(status=='0'){
			comp.showModal("publishModal");//分类标签设置窗口
		}else{
			$("#tagstr").attr("disabled","disabled");
			comp.showModal("publishModal");//分类标签设置窗口
		}
	}
	function sure(){
		var status=$("#prestatus").val();
		$("#categoryid").val($("#cate").val());
		if(status=='0'){
			var str=$("#tagstr").val();
			str=str.replace(/，/g,",").replace(/\s/g,'');
			$("#tags").val(str);
		}
		publishblog();
	}
	//发布博客，状态变为1
    function publishblog() {
      	$("#title").val($("#title_").val());
      	$("#status").val("1");
      	$("#blogform").submit();
    }
    //保存博客状态不变，保存分两种状态草稿保存还为草稿状态，未发布状态保存还为未发布状态
    function saveblog() {
    	var status=$("#prestatus").val();//获取原始状态
      	$("#title").val($("#title_").val());
      	$("#status").val(status);//
      	$("#blogform").submit();
    }
    function goback(){
		window.location.href="${rc.contextPath}/blog/myblogs";
	}

</script>

</body>
</html>
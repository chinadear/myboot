<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>Edit</title>
</head>
<body>
	<div  class="inner-header">
		<form class="form-inline">
	    	<div class="col-sm-11" style="margin-left: -4px;">
				<input type="text" class="form-control optionbtn-left" style="width:100%;" maxlength="50" name="title_" id="title_" placeholder="输入文章标题"/>
	    	</div>
	    	<div class="col-sm-1">
				<button type="button" class="btn btn-primary btn-sm optionbtn" onclick="submitblog();">发布</button>
			</div>
	</div>
	<div class="container-fluid innerScroll">
		<form id="editddddddd" action="${rc.contextPath}/blog/save" method="post" >
			<input type="hidden" name="title" id="title" value=""/>
		</form>
			<div class="editormd" id="test-editormd"><!-- test-editormd-markdown-doc -->
			    <textarea class="editormd-markdown-textarea" name="content" id="content"></textarea>
			    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
			    <textarea class="editormd-html-textarea" name="htmlContent" id="htmlContent"></textarea>
			</div>
			<div class="modal fade in" id="editModal" tabindex="-1" role="dialog" aria-hidden="true">  
				<div class="modal-dialog">  
					<div class="modal-content">  
						<div class="modal-header">  
					        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
					        <h4 class="modal-title">摘要</h4>  
				        </div>  
						<div class="modal-body">  
					    	<textarea class="form-control" rows="3" id="summary" name="summary" maxlength="150" placeholder="请填写150字以内的文章摘要"></textarea>
					    </div>  
						<div class="modal-footer">  
							<button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>  
						</div>  
					</div><!-- /.modal-content -->  
				</div><!-- /.modal-dialog -->  
			</div><!-- /.modal -->
	</div>
<!-- 测试如何显示博客内容 ：需要初始化的js，绑定id=com-->
<!-- <div id="com"><textarea style="display: none;" id="ccc"></textarea></div> -->
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
                this.height(450);//480
                //this.resize("100%", 640);
            }
        });
    }
		function submit() {
			var htmlContent = $("#htmlContent").val();
			var content = $("#htmlContent").val();
		    $("#com").html(htmlContent);
		   /*  editormd.markdownToHTML("com", {//注意：这里是上面DIV的id
		        htmlDecode : "style,script,iframe",
		        emoji : true,
		        taskList : true,
		        tex : true, // 默认不解析
		        flowChart : true, // 默认不解析
		        sequenceDiagram : false, // 默认不解析
		        codeFold : true
		    }); */
		    
		    comp.showModal('editModal');
		}
        function submitblog() {
        	$("#title").val($("#title_").val());
        	var action=$("#editddddddd").html();
        	alert(action);
        	//$("#blogform").submit();
           /*  var  title = $("#title").val();
            var content = $("#content").val();
            var htmlContent = $("#htmlContent").val();
            $.ajax({
                url: "submit",
                data: {title: title, content:content,htmlContent:htmlContent},
                success:function () {
                    alert("发布成功");
                },
                error:function () {
                    alert("发布失败");
                }
            }) */
        }

</script>

</body>
</html>
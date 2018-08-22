<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Edit</title>
    <link rel="stylesheet" href="${rc.contextPath}/lib/editormd/css/style.css"/>
   <!--  <link rel="shortcut icon" href="" type="image/x-icon"/> -->
</head>
<body>
	<div>
		<input type="text" name="title" style="width: 500px" id="title"/>
		<input type="submit" title="发布" id="submitBtn" />
	</div>
	<div class="editormd" id="test-editormd">
	    <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc" id="content"></textarea>
	    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
	    <textarea class="editormd-html-textarea" name="text" id="htmlContent"></textarea>
	</div>
	<!--修改角色页面-->
<div class="modal fade in" id="editModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">编辑角色</h4>  
	        </div>  
			<div class="modal-body">  
		    	<div id="com"><textarea style="display: none;" id="ccc"></textarea></div>
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="edit_submit()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->
<script type="text/javascript">
window.onload = function(){
        editormd("test-editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            //你的lib目录的路径，我这边用JSP做测试的
            tocm : true, // Using [TOCM]
            tex : true, // 开启科学公式TeX语言支持，默认关闭
            flowChart : true, // 开启流程图支持，默认关闭
            path    : "${rc.contextPath}/lib/editormd/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea : true,
            imageUpload : true,
            imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
            imageUploadURL : "/blog/uploadimg",
            onload: function () {
                //console.log('onload', this);
                //this.fullscreen();
                //this.unwatch();
                //this.watch().fullscreen();
                this.width("100%");
                this.height(480);
                //this.resize("100%", 640);
            }


        });
        $("#submitBtn").click(
            function () {
            	var htmlContent = $("#htmlContent").val();
                $("#ccc").html(htmlContent);
                editormd.markdownToHTML("com", {//注意：这里是上面DIV的id
                    htmlDecode : "style,script,iframe",
                    emoji : true,
                    taskList : true,
                    tex : true, // 默认不解析
                    flowChart : true, // 默认不解析
                    sequenceDiagram : false, // 默认不解析
                    codeFold : true
                });
                
                comp.showModal('editModal');
                //submitblog();
            }
        )
    }
        function submitblog() {
            var  title = $("#title").val();
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
            })
        }

</script>

</body>
</html>
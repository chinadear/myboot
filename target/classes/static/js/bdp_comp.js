/**
 * @author ll
 * @date 2013-8-31
 * @description component
 */
var compVar;
$(function() {
	$("input:text").blur(function() {
		/*if(this.value.indexOf("\"")>-1||this.value.indexOf("'")>-1||this.value.indexOf("<")>-1||this.value.indexOf(">")>-1){
			comp.message("\u7CFB\u7EDF\u5DF2\u7ECF\u81EA\u52A8\u5E2E\u60A8\u53BB\u9664\u975E\u6CD5\u5B57\u7B26('<>',\u524D\u540E\u7A7A\u683C,\u5355\u53CC\u5F15\u53F7)","info");
			this.value=this.value.replace(/\"/g,"").replace(/'/g,"");
			this.value=this.value.replace(/</g,"").replace(/>/g,"");
		}*/
		this.value=$.trim(this.value);
	});
	comp.validate.regRxp("uwsnumchar","^[0-9a-zA-Z_]*$", "\u53EA\u80FD\u5305\u62EC\u82F1\u6587\u5B57\u6BCD\u3001\u6570\u5B57\u548C\u4E0B\u5212\u7EBF");
	comp.validate.regRxp("uwsnumcharcn","^[\u0391-\uFFE50-9a-zA-Z_]*$", "\u53EA\u80FD\u5305\u62EC\u4E2D\u6587\u5B57\u3001\u82F1\u6587\u5B57\u6BCD\u3001\u6570\u5B57\u548C\u4E0B\u5212\u7EBF");
	
	$("form input").keypress(function(e){  
        if(e.keyCode == 13) {
            e.preventDefault();  
        }  
    });
});

comp = {
		orgSingleSelect: function(treeId) {//treeId前端放置树的控件的id
			var url=this.contextPath()+"/user/comp/getOrgTree.do";
			var singleOrgNodes;
			var singleOrgSet = {
					data: {
						simpleData: {enable: true}
							},
					view: {
						dblClickExpand: true,
						selectedMulti: false
							}
				};
			$.ajax({
				async : false,
				cache:false,
				type: 'POST',
				dataType : "json",
				url: url,
				error: function () {
					/*扩展错误提示 */
					comp.message("\u8BF7\u6C42\u5931\u8D25\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5!","error");
				},
				success:function(data){ 
					singleOrgNodes = data; 
				}
			});
			$.fn.zTree.init($("#"+treeId), singleOrgSet, singleOrgNodes);
		},
		orgMultiSelect: function(treeId) {
			var url=this.contextPath()+"/user/comp/getOrgTree.do";
			var MultiOrgNodes;
			var MultiOrgSet = {
					check: {
							enable: true,
							chkStyle : "checkbox",
							chkboxType: { "Y": "", "N": "" }
						},
					data: {
							simpleData: {enable: true}
						},
					view: {
							dblClickExpand: true,
							selectedMulti: false
						}
				};
				$.ajax({
					async : false,
					cache:false,
					type: 'POST',
					dataType : "json",
					url: url,
					error: function () {
						/*扩展错误提示 */
						comp.message("\u8BF7\u6C42\u5931\u8D25\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5!","error");
					},
					success:function(data){
						MultiOrgNodes = data; 
					}
				});
				$.fn.zTree.init($("#"+treeId), MultiOrgSet, MultiOrgNodes);
		},
		//initTree参数说明：treeId:树组件id；url：获取树数据的后台连接；data：url带的参数；type：树的类型；onclick：节点单击事件；setting：自定义setting
		initTree:function(treeId,url,data,type,onclick,setting){
			var check = "";
			if(type=="radio"){
				check={chkStyle : "radio",radioType: "all",enable: true};
			}else if(type=="checkbox"){
				check={chkStyle : "checkbox",chkboxType: { "Y":"", "N": "" },enable: true};
			}else{
				check={enable: false};
			}
			if(setting==null||setting==""){
				var treeSet = {
					check:check,
					data: {simpleData: {enable: true},key:{title: "title"}},
					view: {dblClickExpand: true,selectedMulti: false},
					callback:{onClick:onclick}
					};
			}else{
				setings={data: {
					key: {
						title: "title"
					}				
				}};
				var treeSet = $.extend( true, {},setings,setting );
			}
			var treeNodes;
			$(function(){
				$.ajax({
					async : false,
					cache:false,
					type: 'POST',
					dataType : "json",
					url: url,
					data:data,
					error: function () {
						/*扩展错误提示 */
						comp.message("\u8BF7\u6C42\u5931\u8D25\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5!","error");
					},
					success:function(data){
						treeNodes = data; 
					}
				});
				$.fn.zTree.init($("#"+treeId), treeSet, treeNodes);
			});
		},
		//returnTreeValue参数说明：type：输的类型无选择框和右选择框（选择框包括checkbox,radio）
		returnTreeValue:function(treeId,type){
			var treeObj = $.fn.zTree.getZTreeObj(treeId);
			var nodes=null;
			if(treeObj!=null){
				if(type==""||type==null){
					nodes = treeObj.getCheckedNodes(true);
				}else{
					nodes = treeObj.getSelectedNodes();
				}
			}
			return nodes;
		},
		getTreeObj:function(treeId){
			return $.fn.zTree.getZTreeObj(treeId);
		},
		//showModal参数说明divId：div的id;width：modal的宽度;position：modal的位置（上 右 下 左）
		showModal:function(divId,width,position){
			if(!width){
			}else{
				$('#'+divId).css("width",width);
			}
			if(!position){
			}else{
				$('#'+divId).css("margin",position);
			}
			$('#'+divId).modal({
				backdrop: "static",
				show:true
			});
		},
		hideModal:function(divId){
			$('#'+divId).modal('hide');
		},
		confirm:function(msg,function_){
			bootbox.setDefaults({locale: "zh_CN"}); 
			bootbox.confirm(msg,function_); 
		},
		message:function(msg,type,autoclose,position,height){//msg消息，type显示类型error警告,info信息
			type=type==null||type==""?"st-info":"st-"+type;
			autoclose=autoclose==null||autoclose==""?5000:autoclose;
			position=position==null||position==""?"top-right":position;
			height=height==null||position==""?"40px":height;
			$.sticky(msg, {autoclose : autoclose, position:position, type: type,height:height});
		},
		contextPath:function(){
			var curPath=window.document.location.href;//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
			var pathName=window.document.location.pathname;
			var pos=curPath.indexOf(pathName); //获取主机地址，如： http://localhost:8083
			var localhostPaht=curPath.substring(0,pos); //获取带"/"的项目名，如：/uimcardprj
			var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
			var rootPath = localhostPaht+projectName;
			return rootPath;
		},
		getTimestamp:function(){
			return new Date().getTime();
		},
		validate:validate={
			regRxp:function(name,rule,message){//自定义正则校验
				jQuery.validator.addMethod(name, function(value, element) {
					value=$.trim(value);
					var charRe=new RegExp(rule);
					return this.optional(element) || (charRe.test(value));
					}, message);  
			},
			addRemote:function(name,url,data,message){//增加remote规则,后台ajax返回值为“true”通过，”false“不通过
				jQuery.validator.addMethod(name, function(value, element) {
					var optionalval = this.optional(element);
					var returnval;
					$.ajax({
							async : false,
							cache:false,
						    type: "post",               
						    dataType: "json",          
							url: url,
						    data:data,
						    success: function(msg){
						    	returnval = optionalval || (msg==true);
					   		}            
						});
						return returnval;
				}, message);  
			},
			addRule:function(name,func,message){//增加规则
				jQuery.validator.addMethod(name, func, message);  
			}
		},
		getBrowserSupport:function(){
			var msieVer =     [9,10];
			var fireVer =     [24,39];
			var chromeVer =   [22,32];
			var operaVer =    [1,5];
			var netscapeVer = [1,5];
			var safariVer =   [1,7];

			
			var browser = {appname: 'unknown', version: 0},
	        userAgent = window.navigator.userAgent.toLowerCase();
			//alert(userAgent);//浏览器内核信息
			
		    if ( /(msie|firefox|opera|chrome|netscape)\D+(\d[\d.]*)/.test( userAgent ) ){
		        browser.appname = RegExp.$1;
		        browser.version = RegExp.$2;
		    } else if ( /version\D+(\d[\d.]*).*safari/.test( userAgent ) ){ // safari
		        browser.appname = 'safari';
		        browser.version = RegExp.$2;
		    }
		   
		    var appName = browser.appname;
		    var appVersion = browser.version;
		    //alert(appVersion);
		    var sVersion = appVersion.toString();
		    sVersion = sVersion.substring(0,sVersion.indexOf("."));
		    
		   
		    
		    //由于IE11内核信息与其他IE不同，所以需特别处理
		    //20151015目前IE浏览器的内核信息中只有IE11中有trident和rv信息，即条件成立时则为IE11浏览器
		    if(userAgent.indexOf("trident")>-1 && userAgent.indexOf("rv")>-1){
		    	appName = 'msie';
		    	//获取版本号
		    	sVersion = userAgent.substring(userAgent.indexOf("rv:"),userAgent.lastIndexOf(")"));
		    	sVersion = sVersion.substring(sVersion.indexOf(":")+1,sVersion.length);

		    }
		    
			if(appName=="msie"){
				if(sVersion >= msieVer[0] && sVersion <= msieVer[1]){
					return true;
				}else{
					return false;
				}
			}else  if(appName=="firefox"){
				if(sVersion >= fireVer[0] && sVersion <= fireVer[1]){
					return true;
				}else{
					return false;
				}
			}else  if(appName=="chrome"){
				if(sVersion >= chromeVer[0] && sVersion <= chromeVer[1]){
					return true;
				}else{
					return false;
				}
			}else  if(appName=="opera"){
				if(sVersion >= operaVer[0] && sVersion <= operaVer[1]){
					return true;
				}else{
					return false;
				}
			}else if(appName=="netscape"){
				if(sVersion >= netscapeVer[0] && sVersion <= netscapeVer[1]){
					return true;
				}else{
					return false;
				}
			}else  if(appName=="safari"){
				//safari5使用browser.version获取不到版本号，所以从内核信息中直接获取版本号
				if(sVersion == null || sVersion == ''){
					sVersion = userAgent.match(/version\/([\d.]+)/)[1];
					sVersion = sVersion.substring(0,sVersion.indexOf("."));
				}
				if(sVersion >= safariVer[0] && sVersion <= safariVer[1]){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		},
		getBrowserInfo:function(){
			var browser = {appname: 'unknown', version: 0},
	        userAgent = window.navigator.userAgent.toLowerCase();
		    if ( /(msie|firefox|opera|chrome|netscape)\D+(\d[\d.]*)/.test( userAgent ) ){
		        browser.appname = RegExp.$1;
		        browser.version = RegExp.$2;
		    } else if ( /version\D+(\d[\d.]*).*safari/.test( userAgent ) ){ // safari
		        browser.appname = 'safari';
		        browser.version = RegExp.$2;
		    }
		    
		    var appName = browser.appname;
		    var appVersion = browser.version;
		    
		    var sVersion = appVersion.toString();
		    //sVersion = sVersion.substring(0,sVersion.indexOf("."));
		    //由于IE11内核信息与其他IE不同，所以需特别处理
		    //20151015目前IE浏览器的内核信息中只有IE11中有trident和rv信息
		    if(userAgent.indexOf("trident")>-1 && userAgent.indexOf("rv")>-1){
		    	appName = 'msie';
		    	sVersion = userAgent.substring(userAgent.indexOf("rv:"),userAgent.lastIndexOf(")"));
		    	sVersion = sVersion.substring(sVersion.indexOf(":")+1,sVersion.length);
		    }
		    if(appName=="safari"){
				//safari5使用browser.version获取不到版本号，所以从内核信息中直接获取版本号
				if(sVersion == null || sVersion == ''){
					sVersion = userAgent.match(/version\/([\d.]+)/)[1];
					//sVersion = sVersion.substring(0,sVersion.indexOf("."));
				}
		    }
		    return appName+": "+sVersion;
		}
	};
(function($) {
	
	compDefault={//默认配置
			onkeyup: false,
			errorClass: 'error',
			validClass: 'valid',
			focusCleanup:true,
			focusInvalid:false,
			onfocusout:function(element, event){
				$("input:text").blur(function() {
					/*if(this.value.indexOf("\"")>-1||this.value.indexOf("'")>-1||this.value.indexOf("<")>-1||this.value.indexOf(">")>-1){
						comp.message("\u7CFB\u7EDF\u5DF2\u7ECF\u81EA\u52A8\u5E2E\u60A8\u53BB\u9664\u975E\u6CD5\u5B57\u7B26('<>',\u524D\u540E\u7A7A\u683C,\u5355\u53CC\u5F15\u53F7)","info");
						this.value=this.value.replace(/\"/g,"").replace(/'/g,"");
						this.value=this.value.replace(/</g,"").replace(/>/g,"");
					}*/
					this.value=$.trim(this.value);
				});
				if ( !this.checkable(element) && (element.name in this.submitted || !this.optional(element)) ) {
					this.element(element);
				}
			},
			highlight: function(element) {
				$(element).closest('div').addClass("f_error");
			},
			unhighlight: function(element) {
				$(element).closest('div').removeClass("f_error");
			},
		    errorPlacement: function(error, element) {
		        $(element).closest('div').append(error);
		    },
		    messages: {}
		};
	$.extend($.fn, {
		compValidate:function(options){//校验方法
			if ( $(this[0]).is('form')) {
					var settings = $.extend( true, {},compDefault, options );
					var validator=this.validate(settings);
					$.data(this[0],"compvalidator",validator);
					return validator;
				}else{
					
				}
		},
		compValidator:function(){//获取校验器
			if ( $(this[0]).is('form')) {
				return $.data(this[0],"compvalidator");
			}else{
				
			}
		},
		compReset:function(){//重置表单
			!this.compValidator()?"":this.compValidator().resetForm();
			$(this[0]).find("div").removeClass("f_error");
			this[0].reset();
			
		},
		compValid:function(){//直接验证表单
			return this.valid();
		}
	});
}(jQuery));

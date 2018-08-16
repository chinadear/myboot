<body>
	<div  class="inner-header">
		<button type="button" class="btn btn-primary btn-sm optionbtn" id="addChildbtn" onclick="popAddWin_()">增加下级</button>
    </div>
	<div class="container-fluid innerScroll">
  		<div class="row">
   			<div class="col-md-3">
				<ul id="tree" class="ztree myztree"></ul>
  			</div>
  			<div class="col-md-9">
				<#include "menuchild.ftl">
  			</div>
  		</div>
   </div>
<!--增加菜单页面-->
<div class="modal fade in" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">新增菜单</h4>  
	        </div>  
			<div class="modal-body">  
		    	<#include "addMenu.ftl">
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="addTreeNode_()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->  
<!--修改菜单页面-->
<div class="modal fade in" id="editModal" tabindex="-1" role="dialog" aria-hidden="true">  
	<div class="modal-dialog">  
		<div class="modal-content">  
			<div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>  
		        <h4 class="modal-title">编辑菜单</h4>  
	        </div>  
			<div class="modal-body">  
		    	<p id="edittemp"></p>
		    </div>  
			<div class="modal-footer">  
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
				<button type="button" class="btn btn-primary" id="sure" onclick="editTreeNode()">确认</button>  
			</div>  
		</div><!-- /.modal-content -->  
	</div><!-- /.modal-dialog -->  
</div><!-- /.modal -->  
<!--menuId 用于存放维护菜单操作时选择的菜单Id-->
<input type="hidden" id="menuId">
<!--menuTreeId选择的树对应的菜单ID-->
<input type="hidden" id="menuTreeId">
<!--选择的菜单ID-->
<input type="hidden" id="hpid" value="">
<script type="text/javascript">
	//菜单级别设置
	var varMenuLevel=2;
	window.onload = function(){
	    initTree();//初始化树
	    $("#classCode").blur(function(){//图标预览
			$("#iconShow").removeClass();
			$("#iconShow").addClass($("#classCode").val());
		});
	    //新增校验规则
		var nurl="${rc.contextPath}/resource/judgyName";
		var curl="${rc.contextPath}/resource/judgyCode";
		var andata={name:function(){return $("#menuname").val();},parent:function(){return $("#menuTreeId").val();},id:null};
		var acdata={code:function(){return $("#menucode").val();},parent:function(){return $("#menuTreeId").val();},id:null};
		comp.validate.addRemote("menuNameIsExsit",nurl,andata,"同级菜单名称有重复");
		comp.validate.addRemote("menuCodeIsExsit",curl,acdata,"菜单编码有重复");
		comp.validate.addRule("illegalCode",function(value,element){//菜单连接是否包含非法字符
			var result="t";
			if(value.indexOf('//')>-1||value.indexOf('\\')>-1){
				result="f";					
			}
			return this.optional(element) || (result=='t');
		},"菜单链接包含非法字符('//'或'\\')");
		initAddValidate();//执行构建新增校验规则
		//edit校验规则	
		var endata={name:function(){return $("#menuname_").val();},parent:function(){return $("#menuTreeId").val();},id:function(){return $("#hpid").val();}};	
		var ecdata={code:function(){return $("#menucode_").val();},parent:function(){return $("#menuTreeId").val();},id:function(){return $("#hpid").val();}};	
		comp.validate.addRemote("menuNameIsExsit_",nurl,endata,"同级菜单名称有重复");
		comp.validate.addRemote("menuCodeIsExsit_",curl,ecdata,"菜单编码有重复");
		initEditValidate()//执行构建编辑校验规则
    }
    function initTree(){
  	  comp.initTree("tree","${rc.contextPath}/resource/initMenuTree",null,null,null,setting);
    }
    var setting = {
				view: {
					selectedMulti: false,
					dblClickExpand: true,
					showLine: true
				},
				data: {
					simpleData: {
						enable: true
						}
					},
				callback: {
					onClick: getChildMenuList
				}
			};
	//获取子菜单列表
	function getChildMenuList(e,treeId, Nodes){
		var treeObj = comp.getTreeObj("tree");
		var nodes = treeObj.getSelectedNodes();//选择的节点对象
		$("#menuTreeId").val(nodes[0].id);
		if(nodes[0].level!=2){
			$("#smpl_tbl").show();
			$("#addChildbtn").show();			
			$("#smpl_tbl").load("${rc.contextPath}/noSitemesh/resource/childlist",{"pId":nodes[0].id,"level":nodes[0].level},function(){});
		}else{
			$("#smpl_tbl").hide();
			$("#addChildbtn").hide();
		}
	}
	//初始化新增页面
	function popAddWin_(){
		$(".addMenuForm").compReset();
		var treeObj = comp.getTreeObj("tree");
		var nodes = treeObj.getSelectedNodes();
		if (nodes.length == 0) {
			comp.message("请选择一个节点进行操作","error");
			return;
		}
		if(nodes[0].level>=varMenuLevel){
			comp.message("该菜单已经是末级菜单，不能再增加下级！","error");
			return;
		}
		$("#fathermenu").html(nodes[0].name);
		$("#iconShow").removeClass();
		comp.showModal('addModal');
	}
	//初始化编辑页面
	 function popEditWin(id){
		var treeObj = comp.getTreeObj("tree");
		var node = treeObj.getNodeByParam("id", id, null);
		var pnode=node.getParentNode();
	 	$("#hpid").val(id);
	 	$("#edittemp").load("${rc.contextPath}/noSitemesh/resource/initEditMenu",{"id":id,"fatherMenu":pnode.name},function(){
			initEditValidate();
			//$(".addMenuForm").compReset();
			ob();//触发图标预览
	 	});
		comp.showModal('editModal');
	 }
//=============================操作
	//增加节点
	function addTreeNode_(){
		var treeObj = comp.getTreeObj("tree");
		var nodes = treeObj.getSelectedNodes();
		var pnode = nodes[0];
		var treeNode;
		var menuname=$("#menuname").val();
		var menucode=$("#menucode").val();
		var menulink=$("#menulink").val();
		var comments=$("#comments").val();
		var menuname=$("#menuname").val();
		var classCode=$("#classCode").val();
		var fileId=$("#fileId").val();
		if($(".addMenuForm").compValidator().form()){
			var url="${rc.contextPath}/resource/addMenu";
			var data;
			if (pnode) { 
				data={menuname:menuname,menucode:menucode,menulink:menulink,comments:comments,pId:pnode.id,classCode:classCode,fileId:fileId};
			} else {//创建第一个根节点
				data={menuname:menuname,menucode:menucode,menulink:menulink,comments:comments,pId:null,classCode:classCode,fileId:fileId};
			}
			$.ajax({
				async :false,
				cache :false,
				timeout: 100000,
				type:"POST",
				url: url,
				data:data,
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					comp.hideModal('addModal');
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					if (pnode) {
						treeNode = treeObj.addNodes(pnode, {id:(data), pId:pnode.id,name:(menuname)});
					} else {
						treeNode = treeObj.addNodes(null, {id:(data), pId:null,name:(menuname)});
					}
					treeObj.refresh();
					treeObj.selectNode(pnode);
					comp.hideModal('addModal');
					comp.message("菜单添加成功！");
					$("#smpl_tbl").load("${rc.contextPath}/noSitemesh/resource/childlist",{"pId":nodes[0].id,"level":nodes[0].level},function(){});
				}
			});
		}
	}
	//删除菜单
	function delTreeNode(id){
			var treeObj = comp.getTreeObj("tree");
			var node = treeObj.getNodeByParam("id", id, null);
			var pnode=node.getParentNode();
			var r=confirm("确定要删除“"+node.name+"”菜单吗？");
			if(r){
				$.ajax({
					async :false,
					cache :false,
					dataType :"text",
					type:"POST",
					timeout: 100000,
					url: "${rc.contextPath}/resource/deleteMenu?id="+node.id,
					error: function () {//请求失败处理函数
						comp.message("请求失败，请稍后再试","error");
						return;
					},
					success:function(data){ //请求成功后处理函数。  
						treeObj.removeNode(node);
						comp.message("菜单删除成功！");
						$("#smpl_tbl").load("${rc.contextPath}/noSitemesh/resource/childlist",{"pId":pnode.id,"level":pnode.level},function(){});
					}
				});
			}
		}
	//编辑菜单
	function editTreeNode(){
		var pId=$("#hpid").val();
		var treeObj = comp.getTreeObj("tree");
		var node = treeObj.getNodeByParam("id", pId, null);
		var pnode=node.getParentNode();
		var menuname=$("#menuname_").val();
		var menucode=$("#menucode_").val();
		var menulink=$("#menulink_").val();
		var comments=$("#comments_").val();
		var classCode=$("#classCode_").val();
		if($(".editMenuForm").compValidator().form()){
			$.ajax({
				async :false,
				cache :false,
				timeout: 100000,
				type:"POST",
				url: "${rc.contextPath}/resource/editMenu",
				data:{menuname:menuname,menucode:menucode,menulink:menulink,comments:comments,id:node.id,classCode:classCode},
				error: function () {//请求失败处理函数
					comp.message("请求失败，请稍后再试","error");
					return;
				},
				success:function(data){ //请求成功后处理函数。  
					node.name=$("#menuname_").val();
					treeObj.updateNode(node);	
					comp.hideModal('editModal');
					comp.message("菜单信息修改成功！");
					$("#smpl_tbl").load("${rc.contextPath}/noSitemesh/resource/childlist",{"pId":pnode.id,"level":pnode.level},function(){});
				}
			});
		}
	}
	//编辑状态，直接显示菜单图标
	function ob(){
		$("#iconShow_").removeClass();
		$("#iconShow_").addClass($("#classCode_").val());
	}
	//上移
	function upTreeNode(id){
		var treeObj = comp.getTreeObj("tree");
		var node = treeObj.getNodeByParam("id", id, null);
		var pnode=node.getParentNode();
        if(node.isFirstNode){
       	 	comp.message("到顶了，无法在上移了","error");
            return;
        }
        var preNode = node.getPreNode();
         $.ajax({
			async :false,
			cache :false,
			type:"POST",
			dataType :"text",
			timeout: 100000,
			url: "${rc.contextPath}/resource/upDownMenu",
			data:{sourceId:node.id,targetId:preNode.id},
			error: function () {//请求失败处理函数
				comp.message("请求失败，请稍后再试","error");
				return;
			},
			success:function(data){ //请求成功后处理函数。  
				treeObj.moveNode(preNode,node,"prev");
				$("#smpl_tbl").load("${rc.contextPath}/noSitemesh/resource/childlist",{"pId":pnode.id,"level":pnode.level},function(){});
			}
		});
        
	}
//下移
	function downTreeNode(id){
	 	var treeObj = comp.getTreeObj("tree");
		var node = treeObj.getNodeByParam("id", id, null);
		var pnode=node.getParentNode();
        if(node.isLastNode){
        	comp.message("到底了，无法再下移了","error");
            return;
        }
        var preNode = node.getNextNode();
         $.ajax({
			async :false,
			cache :false,
			type:"POST",
			dataType :"text",
			timeout: 100000,
			url: "${rc.contextPath}/resource/upDownMenu",
			data:{sourceId:node.id,targetId:preNode.id},
			error: function () {//请求失败处理函数
				comp.message("请求失败，请稍后再试","error");
				return;
			},
			success:function(data){ //请求成功后处理函数。  
				treeObj.moveNode(preNode,node,"next");
				$("#smpl_tbl").load("${rc.contextPath}/noSitemesh/resource/childlist",{"pId":pnode.id,"level":pnode.level},function(){});
			}
		});
    }
//===================校验
	function initAddValidate(){
		$(".addMenuForm").compValidate({
			rules:{
				menuname: { required: true, 
							maxlength: 10,
							menuNameIsExsit:true,
							uwsnumcharcn:true
							},
				menulink: {
						   illegalCode:true,
						   maxlength: 100
							},
				menucode: { required: true, 
							maxlength: 30,
							menuCodeIsExsit:true,
							uwsnumchar:true
							},
				classCode: {maxlength: 100},
				comments: {maxlength: 150}
					},
			messages:{
				menuname:{required:"菜单名称不能为空"},
				menucode:{required:"菜单编码不能为空"}
				}
		});
	}
	function initEditValidate(){
		$(".editMenuForm").compValidate({
			rules:{
					menuname_: { required: true, 
								maxlength: 10,
								menuNameIsExsit_:true,
								uwsnumcharcn:true
							},
					menucode_: { required: true, 
								maxlength: 30,
								uwsnumchar:true,
								menuCodeIsExsit_:true
							},
					menulink_: {
						   		illegalCode:true,
						   		maxlength: 100
							},
					classCode_: {
							maxlength: 100
						},
					comments_: {maxlength: 150}
				},
		messages:{
			menuname_:{required:"菜单名称不能为空"},
			menucode_:{required:"菜单编码不能为空"}
			}
		});
	}
</script>
</body>
</html>
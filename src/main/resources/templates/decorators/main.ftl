<!DOCTYPE html>
<html style="overflow:hidden;">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=10">
  <title>BOOTPLUS</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="${rc.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
  <link rel="stylesheet" href="${rc.contextPath}/lib/dist/css/ionicons.min.css"/>
  <link rel="stylesheet" href="${rc.contextPath}/lib/dist/css/AdminLTE.css"/>
  <link rel="stylesheet" href="${rc.contextPath}/lib/dist/css/skins/_all-skins.css"/>
  <link rel="stylesheet" href="${rc.contextPath}/lib/vince/biao/css/font-awesome.min.css"/> 
  <link rel="stylesheet" href="${rc.contextPath}/css/main.css"/>
  <link rel="stylesheet" href="${rc.contextPath}/lib/ztree/css/bootstrapStyle/bootstrapStyle.css"/>
  <link rel="stylesheet" href="${rc.contextPath}/lib/sticky/sticky.css" />
  <link rel="stylesheet" href="${rc.contextPath}/lib/editormd/css/editormd.css"/>
  <!--[if lt IE 9]>
  <script src="${rc.contextPath}/lib/dist/js/html5shiv.min.js"></script>
  <script src="${rc.contextPath}/lib/dist/js/respond.min.js"></script>
  <![endif]-->
  <sitemesh:write property="head"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  <!-- header -->
  <#include "header.ftl">
  <!-- sidebar -->
  <#include "sidebar.ftl">
  <!-- main content -->
  <div class="content-wrapper">
  	<#include "navbar.ftl">
  	<sitemesh:write property="body"/>
  </div>
  <#include "footer.ftl">
  <div class="control-sidebar-bg"></div>
</div>
<script src="${rc.contextPath}/webjars/jquery/3.1.1/jquery.min.js"></script> 
<script src="${rc.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
<script src="${rc.contextPath}/lib/dist/js/app.min.js"></script>
<script src="${rc.contextPath}/lib/dist/js/demo.js"></script>
<script src="${rc.contextPath}/lib/vince/js/nicescroll.js"></script>
<script src="${rc.contextPath}/js/main.js"></script>
<script type="text/javascript" src="${rc.contextPath}/lib/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${rc.contextPath}/lib/ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="${rc.contextPath}/lib/ztree/js/jquery.ztree.exedit.js"></script>
<script src="${rc.contextPath}/lib/bootbox4/bootbox_custom.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/bdp_comp.js"></script>
<script src="${rc.contextPath}/lib/validation/jquery.validate.min.js"></script>
<script src="${rc.contextPath}/lib/sticky/sticky.js"></script>
<script src="${rc.contextPath}/js/myjs_message_cn.js"></script>
<script src="${rc.contextPath}/lib/turnPage/extendPagination.js"></script>
<script type="text/javascript" src="${rc.contextPath}/lib/editormd/js/editormd.js"></script>
</body>
</html>
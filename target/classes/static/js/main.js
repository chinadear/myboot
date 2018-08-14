$(function(){
	$(".sidebar-menu").niceScroll({
		touchbehavior:false,
		cursorcolor:"#000",  //内侧滚动条的颜色
		cursoropacitymax:0.7,   //滚动条的透明度
		cursorwidth:5,   //滚动条的宽度
		horizrailenabled:false,
		cursorborderradius:1,    //滚动轴的圆角
		autohidemode:true,    //自动隐藏滚动条
		background:'#333',  //滚动条的背景色
		cursorborder:'solid 1px #fff'   //滚动条的边框样式
	});
	$(".innerScroll").niceScroll({
        touchbehavior:false,
        cursorcolor:"#000",  //内侧滚动条的颜色
        cursoropacitymax:0.7,   //滚动条的透明度
        cursorwidth:5,   //滚动条的宽度
        horizrailenabled:false,
        cursorborderradius:1,    //滚动轴的圆角
        autohidemode:true,    //自动隐藏滚动条
        background:'#333',  //滚动条的背景色
        cursorborder:'solid 1px #fff'   //滚动条的边框样式
    });
	$(".sidebar-toggle").click(function(){
		if($("body").hasClass("sidebar-collapse")){
			$(".sidebar-menu").css({"overflow":'hidden',"width":230})
			$(".sidebar-menu").find(".active").removeClass("nei_active");
		}else{
			$(".sidebar-menu").css({"overflow":'visible'})
			$(".sidebar-menu").find(".active").addClass("nei_active")
		}});
});
//根据浏览器的大小设置页面适应尺寸
resizefun();
function resizefun(){
	pingHeight=document.documentElement.clientHeight;
	pingWidth=document.documentElement.clientWidth;
	$(".innerScroll").css({"height":pingHeight-191})//191=banner50+inner-header45+footer40+navbar56
	$(".content-wrapper").css({"height":pingHeight-90})//body(业务页面)区域，包括inner-header所以只减90=banner+footer
	$(".content-wrapper").css({"padding-top":50})//body区域下移50防止banner遮挡
	$(".sidebar-menu").css({"height":pingHeight-50})//左侧菜单下移防止banner遮挡
	$(".sidebar-menu").css({"overflow":'hidden'})
}

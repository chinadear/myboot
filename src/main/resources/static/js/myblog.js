/**
 * 
 */
function articalTemplet(data){
	var artical;
	/*var artical="<div class='single-list flex-row d-flex'>"+
	    "<div class='detail'>"+
	       "<a href='/articals/"+data.id+"'  target='_blank'><h4 class='pb-10'>"+data.title+"</h4></a>"+
	        "<p>"+data.summary+"</p>"+
	        "<p class='footer'>"+
	            "<i class='vd-right'>发布时间："+data.createTime+" </i>"+
	            "<i>阅读数："+data.viewNum+"<i class='fa fa-eye' title='阅读数'></i>"+data.poster+"</i>"+
	        "</p></div></div>";*/
	if(data.poster!=undefined){
		artical="<div class='single_widget tag_widget single-list' style='padding: 10px;'>"+
		"<div class='row'>"+
		"<div class='col-sm-4'>"+
		"<img src='/blog/noSecurity/img/"+data.poster.id+"' style='width:100%;height:100%;' class='img-responsive center-block' alt=''>"+
		"</div>"+
		"<div class='col-sm-8 detail'>"+
		"<a href='/articals/"+data.id+"' target='_blank'><h4 class='pb-10'>"+data.title+"</h4></a>"+
		"<p>"+data.summary+"</p>"+
		"<p class='footer'>"+
		"<i class=''vd-right'> 发布时间："+data.createTime+"</i>"+
		"<i>阅读量："+data.viewNum+"<i class='fa fa-eye' title='阅读量'></i></i>"+
		"</p>"+
		"</div>"+
		"</div>"+
		"</div>";
	}else{
		artical="<div class='single_widget tag_widget single-list' style='padding: 10px;'>"+
		"<div class='row'>"+
		"<div class='col-sm-12 detail'>"+
		"<a href='/articals/"+data.id+"' target='_blank'><h4 class='pb-10'>"+data.title+"</h4></a>"+
		"<p>"+data.summary+"</p>"+
		"<p class='footer'>"+
		"<i class='vd-right'> 发布时间："+data.createTime+"</i>"+
		"<i>阅读量："+data.viewNum+"<i class='fa fa-eye' title='阅读量'></i></i>"+
		"</p>"+
		"</div>"+
		"</div>"+
		"</div>";
	}
	return artical;
}




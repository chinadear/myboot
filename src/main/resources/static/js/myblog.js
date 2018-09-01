/**
 * 
 */
function articalTemplet(data){
	var artical="<div class='single-list flex-row d-flex'>"+
	    "<div class='detail'>"+
	       "<a href='/articals/"+data.id+"'  target='_blank'><h4 class='pb-10'>"+data.title+"</h4></a>"+
	        "<p>"+data.summary+"</p>"+
	        "<p class='footer'>"+
	            "<i class='vd-right'>发布时间："+data.createTime+" </i>"+
	            "<i>阅读数：32<i class='fa fa-eye' title='阅读数'></i></i>"+
	        "</p></div></div>";
	return artical;
}
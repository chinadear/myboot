/**
 * 
 */
function articalTemplet(data){
	var artical="<div class='single-list flex-row d-flex'>"+
	    "<div class='detail'>"+
	       "<a href='${rc.contextPath}/articals/"+data.id+"  target='_blank'><h4 class='pb-10'>"+data.title+"</h4></a>"+
	        "<p>"+data.summary+"</p>"+
	        "<p class='footer'>"+
	            "<i>"+data.createTime+" 发布</i>"+
	            "<i class='fa fa-eye' aria-hidden='true' title='阅读量'></i><a href='#'>06</a>"+   
	            "<i class='ml-10 fa fa-comment-o' aria-hidden='true' title='评论'></i><a href='#'>02</a>"+
	        "</p></div></div>";
	return artical;
}
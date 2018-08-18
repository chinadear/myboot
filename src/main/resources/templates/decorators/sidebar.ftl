<aside class="main-sidebar" style="position:fixed;">
	<section class="sidebar">
		<ul class="sidebar-menu">
		<#if sessionUser??>
			<#if (!sessionUser.curMenuId??)||sessionUser.curMenuId=='0'>
				<li class="active">
			<#else>
				<li>
			</#if>
					<!-- <a href="${rc.contextPath}/security/dispatcher/0"> -->
					<a href="##" onclick="dispatcher('0');">
						<i class="fa fa-home" style="font-size: 22px"></i> 
						<span>首页</span>
					</a>
				</li>
			<#if sessionUser.resource??>
				<#if sessionUser.resource.childList??>
					<#list sessionUser.resource.childList as m>
						<#if m.childList?size gt 0><!-- 存在子菜单 -->
							<#if sessionUser.curParentMenuId?? && sessionUser.curParentMenuId==m.id>
								<li class="treeview active">
							<#else>
								<li class="treeview">
							</#if>
								<a href="#"> 
									<i class="${m.classCode!}"></i>
									<span>
										<#if m.name?length gt 10>
											${m.name?substring(0,10)}...
										<#else>
											${m.name!}
										</#if>
									</span> 
									<span class="pull-right-container"> 
										<i class="fa fa-angle-left pull-right"></i>
									</span>
								</a>	
								<ul class="treeview-menu">
									<#list  m.childList as mc>
										<#if sessionUser.curMenuId??&&sessionUser.curMenuId==mc.id>
											<li class="active">
										<#else>
											<li>
										</#if>
											<a href="##" onclick="dispatcher('${mc.id}');"><i class="${mc.classCode!}"></i>${mc.name!}</a>
										</li>
									</#list>
								</ul>
							</li>
						<#else><!-- 不存在子菜单 -->
							<#if sessionUser.curMenuId??&&sessionUser.curMenuId==m.id>
								<li class="active">
							<#else>
								<li>
							</#if><!-- ${rc.contextPath}/security/dispatcher/${m.id} -->
							<a href="##" onclick="dispatcher('${m.id}')"> <i class="${m.classCode!}"></i> <span>${m.name!}</span></a></li>
						</#if>
					</#list>
				</#if>
			</#if>
		</#if>
		</ul>	
	</section>
</aside>
<script type="text/javascript">
function dispatcher(id){
	if($("body").hasClass("sidebar-collapse")){
		window.location.href="${rc.contextPath}/security/dispatcher/"+id+"/0";
	}else{
		window.location.href="${rc.contextPath}/security/dispatcher/"+id+"/1";
	}
}
</script>
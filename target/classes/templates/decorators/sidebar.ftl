<aside class="main-sidebar" style="position:fixed;">
	<section class="sidebar">
		<ul class="sidebar-menu">
		<!--li class="active"-->
		<#if sessionUser??>
			<#if (!sessionUser.curMenuId??)||sessionUser.curMenuId=='0'>
				<li class="active">
			<#else>
				<li >
			</#if>
					<a href="${rc.contextPath}/security/dispatcher/0">
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
									<i class="fa fa-sliders"></i>
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
										<a href="${rc.contextPath}/security/dispatcher/${mc.id}"><i class="fa fa-bookmark"></i>${mc.name!}</a>
									</li>
									</#list>
								</ul>
							</li>
						<#else><!-- 不存在子菜单 -->
							<#if sessionUser.curMenuId??&&sessionUser.curMenuId==m.id>
								<li class="active">
							<#else>
								<li>
							</#if>
							<a href="${rc.contextPath}/security/dispatcher/${m.id}"> <i class="fa fa-eye"></i> <span>${m.name!}</span></a></li>
						</#if>
					</#list>
				</#if>
			</#if>
		</#if>
<!-- 		
			<li >
				<a href="${rc.contextPath}/">
					<i class="fa fa-home" style="font-size: 22px"></i> 
					<span>首页</span>
				</a>
			</li>
			<li><a href="${rc.contextPath}/resource/list"> <i class="fa fa-eye"></i> <span>菜单管理</span></a></li>
			<li><a href="##"> <i class="fa fa-print"></i> <span>运行监测</span></a></li>
			<li class="treeview">
				<a href="#"> 
					<i class="fa fa-sliders"></i>
					<span>负荷响应</span> 
					<span class="pull-right-container"> 
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li><a href="xyxgpj.html"><i class="fa fa-bookmark"></i>响应效果评价</a></li>
					<li><a href="fhxyfx.html"><i class="fa fa-bookmark"></i>负荷响应分析</a></li>
					<li><a href="xyfagl.html"><i class="fa fa-bookmark"></i>响应方案管理</a></li>
				</ul>
			</li>
			<li><a href="yjgl.html"> <i class="fa fa-bell"></i> <span>预警管理</span></a></li>
			<li class="treeview">
				<a href="#"> 
					<i class="fa fa-gears"></i>
					<span>设备管理</span> 
					<span class="pull-right-container"> 
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li><a href="sbrk.html"><i class="fa fa-bookmark"></i>
							设备入库</a></li>
					<li><a href="sbaz.html"><i class="fa fa-bookmark"></i>
							设备安装</a></li>
					<li><a href="sbjx.html"><i class="fa fa-bookmark"></i>
							设备检修</a></li>
					<li><a href="sbbf.html"><i class="fa fa-bookmark"></i>
							设备报废</a></li>
					<li><a href="sbcx.html"><i class="fa fa-bookmark"></i>
							设备查询</a></li>
				</ul>
			</li> -->
		</ul>	
	</section>
</aside>
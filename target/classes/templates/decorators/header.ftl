<header class="main-header">
	<a href="#" class="logo" style="position:fixed;"> 
		<span class="logo-mini"> 
			<img src="${rc.contextPath}/lib/vince/images/v01.png">
		</span> 
		<span class="logo-lg"> 
			<img src="${rc.contextPath}/lib/vince/images/v01.png">项目
		</span>
	</a>
	<nav class="navbar navbar-fixed-top">
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"></a> <span class="all_title"></span>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <img
						src="${rc.contextPath}/lib/dist/img/user2-160x160.jpg"
						class="user-image" alt="User Image"> <span class="hidden-xs"><#if sessionUser??>${sessionUser.name!}</#if></span>
				</a>
					<ul class="dropdown-menu">
						<li class="user-header"><img
							src="${rc.contextPath}/lib/dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image">
							<p>
								姓名：<#if sessionUser??>${sessionUser.name!} </#if><small>部门：信息部</small>
							</p></li>
						<li class="user-footer">
							<div class="pull-right">
								<a href="${rc.contextPath}/logout" class="btn btn-default btn-flat">退出系统</a>
							</div>
						</li>
					</ul></li>

			</ul>
		</div>
	</nav>
</header>
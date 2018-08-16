<header class="main-header">
	<a href="#" class="logo" style="position:fixed;"> 
		<span class="logo-mini"> 
			<img src="${rc.contextPath}/lib/vince/images/angelheart.png" class="logo-img" >
		</span> 
		<span class="logo-lg"> 
			<img src="${rc.contextPath}/lib/vince/images/angelheart.png" class="logo-img" alt="Responsive image">ANQI
		</span>
	</a>
	<nav class="navbar navbar-fixed-top">
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"></a> <span class="all_title"></span>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <img
						src="${rc.contextPath}/account/headerimg/${sessionUser.userId}"
						class="user-image" alt="User Image"> <span class="hidden-xs"><#if sessionUser??>${sessionUser.name!}</#if></span>
				</a>
					<ul class="dropdown-menu">
						<li class="user-header"><img
							src="${rc.contextPath}/account/headerimg/${sessionUser.userId}"
							class="img-circle" alt="User Image">
							<p>
								<#if sessionUser??>${sessionUser.name!} </#if><small>上次登录时间：<#if sessionUser??>${sessionUser.lastLoginDate!} </#if></small>
								<small><a href="${rc.contextPath}/account/persional/center" style="color:#000;">[个人中心]</a></small>
							</p>
						</li>
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
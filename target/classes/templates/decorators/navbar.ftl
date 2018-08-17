<ol class="breadcrumb" style="margin-bottom:0;border-bottom: 1px solid #e6e1e1;"><!-- nav 的高度减少20px,因为breadcrumb中的margin-bottom的20px去掉了 -->
<#if sessionUser?? && sessionUser.navList?? && sessionUser.navList?size gt 0>
	<#list sessionUser.navList as nav>
		<#if nav_index!=0>
    	<li><font color="#72afd2">${nav!}</a></font></li>
    	</#if>
    </#list>
<#else>
	<li><font color="#72afd2">首页</a></font></li>
</#if>
	
</ol>
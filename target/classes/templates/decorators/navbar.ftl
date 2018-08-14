<ol class="breadcrumb">
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
<h4 class="text-uppercase pb-20">资源下载</h4>
<ul>
<#if downloads??>
    <#list downloads as c>
     <li data-toggle="tooltip" data-placement="top" title="${(c.summary!)?html}">
         <a href="${c.url!'##'}"  target="_blank">
         	${(c.title!)?html}  
</a>
     </li>
    </#list>
</#if>
</ul>

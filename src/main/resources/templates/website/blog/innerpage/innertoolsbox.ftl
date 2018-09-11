<h4 class="text-uppercase pb-20">工具箱</h4>
<ul>
<#if tools??>
    <#list tools as c>
     <li data-toggle="tooltip" data-placement="top" title="${(c.summary!)?html}">
         <a href="${c.url!'##'}"  target="_blank">
         	${(c.title!)?html}  
</a>
     </li>
    </#list>
</#if>
</ul>

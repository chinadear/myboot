<!-- banner area start -->
<#if structModel??&&structModel.banner??>
<!-- <#if structModel.banner.url??>
	<a href="${structModel.banner.url!}" target="_blank" id="abq">
<#else>
	<a href="##">
</#if> -->
	<#if structModel.banner.file??>
		<section class="banner-area relative section-gap" id="home" data-parallax="scroll" data-image-src="${rc.contextPath}/blog/noSecurity/img/${structModel.banner.file.id!}">
	<#else>
		<section class="banner-area relative section-gap" id="home" data-parallax="scroll" data-image-src="${rc.contextPath}/lib/blog/img/defult_banner.jpg">
	</#if>
    <div class="container">
        <div class="row justify-content-start align-items-center d-flex">
            <div class="col-lg-8 top-left" style="min-height:120px">
                <h1 class="text-white mb-20" style="text-shadow:5px 2px 6px #000;">${(structModel.banner.title!)?html}</h1>
                <h4 class="text-white" style="text-shadow:5px 2px 6px #000;">${(structModel.banner.summary!)?html}</h4>
            </div>
        </div>
    </div>  
</section>
<!-- </a> -->
</#if>
<!-- banner area end -->

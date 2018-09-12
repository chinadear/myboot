<!-- banner area start -->
<#if structModel??&&structModel.banner??>
<a href="${structModel.banner.url!'##'}" target="_blank">
	<#if structModel.banner.file??>
		<section class="banner-area relative section-gap" id="home" data-parallax="scroll" data-image-src="${rc.contextPath}/blog/noSecurity/img/${structModel.banner.file.id!}">
	<#else>
		<section class="banner-area relative section-gap" id="home" data-parallax="scroll" data-image-src="${rc.contextPath}/lib/blog/img/header-bg.jpg">
	</#if>
    <div class="container">
        <div class="row justify-content-start align-items-center d-flex">
            <div class="col-lg-8 top-left">
                <h1 class="text-white mb-20">${(structModel.banner.title!)?html}</h1>
                <p class="text-white">${(structModel.banner.summary!)?html}</p>
            </div>
        </div>
    </div>  
</section>
</a>
</#if>
<!-- banner area end -->

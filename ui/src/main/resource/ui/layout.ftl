<#macro layout breadcrumbs path>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title><#list breadcrumbs as crumb>${crumb}<#sep> -> </#list></title>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<ul class="navbar-nav">
		        <#list menuNodes as node>
		        	<@menuNode node '/ui' breadcrumbs />
		        </#list>
			</ul>
		</div>
	</nav>
    <div class="container">
		<breadcrumbs params="crumbs: [<#list breadcrumbs as crumb>'${crumb}'<#sep>, </#list>]"></breadcrumbs>
		<#assign l=breadcrumbs?size />
		<h1>${breadcrumbs[l - 1]}</h1>
	    <#nested/>
    </div>
    <footer class="container text-center">
    	<p>&copy; 2017</p>
	</footer>
    <script src="/js/require.js" data-main="/js${path}/main"></script>
</body>
</html>
</#macro>
<#macro menuNode node parentPath breadcrumbs>
	<#local url=parentPath + '/' + node.name />
	<#local active=('/'+templatePath)?index_of(url) &gt; -1 />
	<#list node.nodes>
		<#if active>
		<li class="nav-item active">
		<#else>
		<li class="nav-item">
		</#if>
			<a class="nav-link dropdown-toggle" href="${url}" data-toggle="dropdown">${node.name?capitalize}</a>
			<ul class="dropdown-menu">
				<#items as node>
					<@menuNode node url breadcrumbs />
				</#items>
			</ul>
		</li>
	<#else>
		<#if active>
		<li class="nav-item active">
		<#else>
		<li class="nav-item">
		</#if>
		<a class="nav-link" href="${url}">${node.name?capitalize}</a></li>
	</#list>
</#macro>
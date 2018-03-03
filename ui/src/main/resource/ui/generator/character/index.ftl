<#-- @ftlvariable name="" type="nz.co.fitnet.ui.resource.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
	<div class="row">
		<div class="col-sm-6">
			<wizard params="model: model"></wizard>
		</div>
	</div>
</@layout.layout>
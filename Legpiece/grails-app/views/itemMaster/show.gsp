
<%@ page import="legpiece.ItemMaster" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemMaster.label', default: 'ItemMaster')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-itemMaster" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-itemMaster" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list itemMaster">
			
				<g:if test="${itemMasterInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="itemMaster.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${itemMasterInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemMasterInstance?.unitOfMeasure}">
				<li class="fieldcontain">
					<span id="unitOfMeasure-label" class="property-label"><g:message code="itemMaster.unitOfMeasure.label" default="Unit Of Measure" /></span>
					
						<span class="property-value" aria-labelledby="unitOfMeasure-label"><g:fieldValue bean="${itemMasterInstance}" field="unitOfMeasure"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemMasterInstance?.vendor}">
				<li class="fieldcontain">
					<span id="vendor-label" class="property-label"><g:message code="itemMaster.vendor.label" default="Vendor" /></span>
					
						<span class="property-value" aria-labelledby="vendor-label"><g:link controller="vendor" action="show" id="${itemMasterInstance?.vendor?.id}">${itemMasterInstance?.vendor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${itemMasterInstance?.id}" />
					<g:link class="edit" action="edit" id="${itemMasterInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

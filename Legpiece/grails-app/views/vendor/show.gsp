
<%@ page import="legpiece.Vendor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vendor.label', default: 'Vendor')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-vendor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-vendor" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list vendor">
			
				<g:if test="${vendorInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="vendor.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${vendorInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vendorInstance?.contactNumber}">
				<li class="fieldcontain">
					<span id="contactNumber-label" class="property-label"><g:message code="vendor.contactNumber.label" default="Contact Number" /></span>
					
						<span class="property-value" aria-labelledby="contactNumber-label"><g:fieldValue bean="${vendorInstance}" field="contactNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vendorInstance?.comments}">
				<li class="fieldcontain">
					<span id="comments-label" class="property-label"><g:message code="vendor.comments.label" default="Comments" /></span>
					
						<span class="property-value" aria-labelledby="comments-label"><g:fieldValue bean="${vendorInstance}" field="comments"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${vendorInstance?.id}" />
					<g:link class="edit" action="edit" id="${vendorInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
		<g:link controller="auth" action="logout" class="icon icon_cross">Sign Out</g:link>
	</body>
</html>

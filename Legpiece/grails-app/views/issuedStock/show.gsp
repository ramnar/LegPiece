
<%@ page import="legpiece.IssuedStock" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'issuedStock.label', default: 'IssuedStock')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-issuedStock" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-issuedStock" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list issuedStock">
			
				<g:if test="${issuedStockInstance?.receivedTime}">
				<li class="fieldcontain">
					<span id="receivedTime-label" class="property-label"><g:message code="issuedStock.receivedTime.label" default="Received Time" /></span>
					
						<span class="property-value" aria-labelledby="receivedTime-label"><g:formatDate date="${issuedStockInstance?.receivedTime}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${issuedStockInstance?.quantity}">
				<li class="fieldcontain">
					<span id="quantity-label" class="property-label"><g:message code="issuedStock.quantity.label" default="Quantity" /></span>
					
						<span class="property-value" aria-labelledby="quantity-label"><g:fieldValue bean="${issuedStockInstance}" field="quantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${issuedStockInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="issuedStock.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${issuedStockInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${issuedStockInstance?.item}">
				<li class="fieldcontain">
					<span id="item-label" class="property-label"><g:message code="issuedStock.item.label" default="Item" /></span>
					
						<span class="property-value" aria-labelledby="item-label"><g:link controller="itemMaster" action="show" id="${issuedStockInstance?.item?.id}">${issuedStockInstance?.item?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${issuedStockInstance?.kitchen}">
				<li class="fieldcontain">
					<span id="kitchen-label" class="property-label"><g:message code="issuedStock.kitchen.label" default="Kitchen" /></span>
					
						<span class="property-value" aria-labelledby="kitchen-label"><g:link controller="kitchen" action="show" id="${issuedStockInstance?.kitchen?.id}">${issuedStockInstance?.kitchen?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${issuedStockInstance?.id}" />
					<g:link class="edit" action="edit" id="${issuedStockInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

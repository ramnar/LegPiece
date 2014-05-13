
<%@ page import="legpiece.AvailableStock" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'availableStock.label', default: 'AvailableStock')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-availableStock" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-availableStock" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list availableStock">
			
				<g:if test="${availableStockInstance?.purchasedTime}">
				<li class="fieldcontain">
					<span id="purchasedTime-label" class="property-label"><g:message code="availableStock.purchasedTime.label" default="Purchased Time" /></span>
					
						<span class="property-value" aria-labelledby="purchasedTime-label"><g:formatDate date="${availableStockInstance?.purchasedTime}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${availableStockInstance?.item}">
				<li class="fieldcontain">
					<span id="item-label" class="property-label"><g:message code="availableStock.item.label" default="Item" /></span>
					
						<span class="property-value" aria-labelledby="item-label"><g:link controller="itemMaster" action="show" id="${availableStockInstance?.item?.id}">${availableStockInstance?.item?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${availableStockInstance?.quantity}">
				<li class="fieldcontain">
					<span id="quantity-label" class="property-label"><g:message code="availableStock.quantity.label" default="Quantity" /></span>
					
						<span class="property-value" aria-labelledby="quantity-label"><g:fieldValue bean="${availableStockInstance}" field="quantity"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${availableStockInstance?.id}" />
					<g:link class="edit" action="edit" id="${availableStockInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
		<g:link controller="auth" action="logout" class="icon icon_cross">Sign Out</g:link>
	</body>
</html>

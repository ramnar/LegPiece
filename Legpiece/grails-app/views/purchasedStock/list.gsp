
<%@ page import="legpiece.PurchasedStock" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'purchasedStock.label', default: 'PurchasedStock')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-purchasedStock" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-purchasedStock" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'purchasedStock.dateCreated.label', default: 'Date Created')}" />
					
						<th><g:message code="purchasedStock.item.label" default="Item" /></th>
					
						<g:sortableColumn property="quantity" title="${message(code: 'purchasedStock.quantity.label', default: 'Quantity')}" />
					
						<g:sortableColumn property="totalPrice" title="${message(code: 'purchasedStock.totalPrice.label', default: 'Total Price')}" />
					
						<th><g:message code="purchasedStock.vendor.label" default="Vendor" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${purchasedStockInstanceList}" status="i" var="purchasedStockInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${purchasedStockInstance.id}">${fieldValue(bean: purchasedStockInstance, field: "dateCreated")}</g:link></td>
					
						<td>${fieldValue(bean: purchasedStockInstance, field: "item")}</td>
					
						<td>${fieldValue(bean: purchasedStockInstance, field: "quantity")}</td>
					
						<td>${fieldValue(bean: purchasedStockInstance, field: "totalPrice")}</td>
					
						<td>${fieldValue(bean: purchasedStockInstance, field: "vendor")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${purchasedStockInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

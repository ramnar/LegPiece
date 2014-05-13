
<%@ page import="legpiece.IssuedStock" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'issuedStock.label', default: 'IssuedStock')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-issuedStock" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-issuedStock" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="purchasedTime" title="${message(code: 'issuedStock.purchasedTime.label', default: 'Purchased Time')}" />
					
						<th><g:message code="issuedStock.item.label" default="Item" /></th>
					
						<g:sortableColumn property="quantity" title="${message(code: 'issuedStock.quantity.label', default: 'Quantity')}" />
					
						<th><g:message code="issuedStock.kitchen.label" default="Kitchen" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'issuedStock.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${issuedStockInstanceList}" status="i" var="issuedStockInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${issuedStockInstance.id}">${fieldValue(bean: issuedStockInstance, field: "purchasedTime")}</g:link></td>
					
						<td>${fieldValue(bean: issuedStockInstance, field: "item")}</td>
					
						<td>${fieldValue(bean: issuedStockInstance, field: "quantity")}</td>
					
						<td>${fieldValue(bean: issuedStockInstance, field: "kitchen")}</td>
					
						<td><g:formatDate date="${issuedStockInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${issuedStockInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

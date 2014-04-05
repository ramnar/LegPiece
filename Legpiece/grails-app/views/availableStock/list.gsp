
<%@ page import="legpiece.AvailableStock" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'availableStock.label', default: 'AvailableStock')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-availableStock" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-availableStock" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="receivedTime" title="${message(code: 'availableStock.receivedTime.label', default: 'Received Time')}" />
					
						<th><g:message code="availableStock.item.label" default="Item" /></th>
					
						<g:sortableColumn property="quantity" title="${message(code: 'availableStock.quantity.label', default: 'Quantity')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${availableStockInstanceList}" status="i" var="availableStockInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${availableStockInstance.id}">${fieldValue(bean: availableStockInstance, field: "receivedTime")}</g:link></td>
					
						<td>${fieldValue(bean: availableStockInstance, field: "item")}</td>
					
						<td>${fieldValue(bean: availableStockInstance, field: "quantity")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${availableStockInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

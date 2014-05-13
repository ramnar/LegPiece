
<%@ page import="legpiece.ItemMaster" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemMaster.label', default: 'ItemMaster')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-itemMaster" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-itemMaster" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'itemMaster.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="unitOfMeasure" title="${message(code: 'itemMaster.unitOfMeasure.label', default: 'Unit Of Measure')}" />
					
						<th><g:message code="itemMaster.vendor.label" default="Vendor" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${itemMasterInstanceList}" status="i" var="itemMasterInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${itemMasterInstance.id}">${fieldValue(bean: itemMasterInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: itemMasterInstance, field: "unitOfMeasure")}</td>
					
						<td>${fieldValue(bean: itemMasterInstance, field: "vendor")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${itemMasterInstanceTotal}" />
			</div>
		</div>
		<g:link controller="auth" action="logout" class="icon icon_cross">Sign Out</g:link>
	</body>
</html>

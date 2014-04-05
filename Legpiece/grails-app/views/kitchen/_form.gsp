<%@ page import="legpiece.Kitchen" %>



<div class="fieldcontain ${hasErrors(bean: kitchenInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="kitchen.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${kitchenInstance?.name}"/>
</div>


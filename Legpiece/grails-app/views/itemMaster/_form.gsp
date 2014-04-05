<%@ page import="legpiece.ItemMaster" %>



<div class="fieldcontain ${hasErrors(bean: itemMasterInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="itemMaster.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${itemMasterInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemMasterInstance, field: 'unitOfMeasure', 'error')} required">
	<label for="unitOfMeasure">
		<g:message code="itemMaster.unitOfMeasure.label" default="Unit Of Measure" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="unitOfMeasure" required="" value="${itemMasterInstance?.unitOfMeasure}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemMasterInstance, field: 'vendor', 'error')} required">
	<label for="vendor">
		<g:message code="itemMaster.vendor.label" default="Vendor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="vendor" name="vendor.id" from="${legpiece.Vendor.list()}" optionKey="id" required="" value="${itemMasterInstance?.vendor?.id}" class="many-to-one"/>
</div>


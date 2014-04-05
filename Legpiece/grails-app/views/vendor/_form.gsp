<%@ page import="legpiece.Vendor" %>



<div class="fieldcontain ${hasErrors(bean: vendorInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="vendor.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${vendorInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vendorInstance, field: 'mobileNumber', 'error')} ">
	<label for="mobileNumber">
		<g:message code="vendor.mobileNumber.label" default="Mobile Number" />
		
	</label>
	<g:textField name="mobileNumber" value="${vendorInstance?.mobileNumber}"/>
</div>


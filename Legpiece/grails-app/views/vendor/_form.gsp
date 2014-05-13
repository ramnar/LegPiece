<%@ page import="legpiece.Vendor" %>



<div class="fieldcontain ${hasErrors(bean: vendorInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="vendor.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${vendorInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vendorInstance, field: 'contactNumber', 'error')} ">
	<label for="contactNumber">
		<g:message code="vendor.contactNumber.label" default="Contact Number" />
		
	</label>
	<g:textField name="contactNumber" value="${vendorInstance?.contactNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vendorInstance, field: 'comments', 'error')} ">
	<label for="comments">
		<g:message code="vendor.comments.label" default="Comments" />
		
	</label>
	<g:textArea name="comments" cols="40" rows="5" value="${vendorInstance?.comments}"/>
</div>


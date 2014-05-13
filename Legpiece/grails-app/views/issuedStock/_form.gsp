<%@ page import="legpiece.IssuedStock" %>



<div class="fieldcontain ${hasErrors(bean: issuedStockInstance, field: 'item', 'error')} required">
	<label for="item">
		<g:message code="issuedStock.item.label" default="Item" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="item" name="item.id" from="${legpiece.ItemMaster.list()}" optionKey="id" required="" value="${issuedStockInstance?.item?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: issuedStockInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="issuedStock.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantity" value="${fieldValue(bean: issuedStockInstance, field: 'quantity')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: issuedStockInstance, field: 'kitchen', 'error')} required">
	<label for="kitchen">
		<g:message code="issuedStock.kitchen.label" default="Kitchen" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="kitchen" name="kitchen.id" from="${legpiece.Kitchen.list()}" optionKey="id" required="" value="${issuedStockInstance?.kitchen?.id}" class="many-to-one"/>
</div>


<%@ page import="legpiece.AvailableStock" %>



<div class="fieldcontain ${hasErrors(bean: availableStockInstance, field: 'item', 'error')} required">
	<label for="item">
		<g:message code="availableStock.item.label" default="Item" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="item" name="item.id" from="${legpiece.ItemMaster.list()}" optionKey="id" required="" value="${availableStockInstance?.item?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: availableStockInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="availableStock.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantity" value="${fieldValue(bean: availableStockInstance, field: 'quantity')}" required=""/>
</div>


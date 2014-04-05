<%@ page import="legpiece.PurchasedStock" %>



<div class="fieldcontain ${hasErrors(bean: purchasedStockInstance, field: 'item', 'error')} required">
	<label for="item">
		<g:message code="purchasedStock.item.label" default="Item" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="item" name="item.id" from="${legpiece.ItemMaster.list()}" optionKey="id" required="" value="${purchasedStockInstance?.item?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: purchasedStockInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="purchasedStock.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantity" value="${fieldValue(bean: purchasedStockInstance, field: 'quantity')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: purchasedStockInstance, field: 'totalPrice', 'error')} required">
	<label for="totalPrice">
		<g:message code="purchasedStock.totalPrice.label" default="Total Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="totalPrice" value="${fieldValue(bean: purchasedStockInstance, field: 'totalPrice')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: purchasedStockInstance, field: 'vendor', 'error')} required">
	<label for="vendor">
		<g:message code="purchasedStock.vendor.label" default="Vendor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="vendor" name="vendor.id" from="${legpiece.Vendor.list()}" optionKey="id" required="" value="${purchasedStockInstance?.vendor?.id}" class="many-to-one"/>
</div>


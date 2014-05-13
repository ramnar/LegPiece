package legpiece

import java.util.Date;

class PurchasedStock {
	Date dateCreated;
	ItemMaster item;
	Double quantity;
	Double totalPrice;//TODO
	Vendor vendor;
    static constraints = {
		dateCreated(blank : false)
		item()
		quantity(blank : false)
		totalPrice(blank : false)
		vendor()
    }
	
	static mapping = {
		autoTimestamp true
	 }
}

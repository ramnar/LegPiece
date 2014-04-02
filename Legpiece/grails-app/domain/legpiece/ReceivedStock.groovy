package legpiece

import java.util.Date;

class ReceivedStock {
	Date dateCreated;//TODO:time is not coming
	ItemMaster item;
	Double quantity;
	Double totalPrice;//TODO
	Vendor vendor;
    static constraints = {
		dateCreated(blank : false)
		quantity(blank : false)
		totalPrice(blank : false)
    }
	
	static mapping = {
		autoTimestamp true
	 }
}

package legpiece

class IssuedStock {
	Date purchasedTime;//TODO:time is not coming
	ItemMaster item;
	Double quantity;
	Kitchen kitchen;
	Date dateCreated;
	static constraints = {
		purchasedTime(display : false)
		item()
		quantity(blank : false)
		kitchen()
		dateCreated(blank : false, display : true)
	}
	static mapping = {
		autoTimestamp true
	 }

}

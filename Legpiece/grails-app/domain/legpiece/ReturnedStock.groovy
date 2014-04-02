package legpiece

class ReturnedStock {
	Date receivedTime;//TODO:time is not coming
	ItemMaster item;
	Double quantity;
	Kitchen kitchen;
	Date dateCreated;
	static constraints = {
		receivedTime(blank : false)
		quantity(blank : false)
	}
	static mapping = {
		autoTimestamp true
	 }
}

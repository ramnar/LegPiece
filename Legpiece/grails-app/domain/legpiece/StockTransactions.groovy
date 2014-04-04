package legpiece

class StockTransactions {
	Date purchasedTime;//TODO:time is not coming
	ItemMaster item;
	Double quantity;
	Kitchen kitchen;
	Date dateCreated;
	String transactionType
	static constraints = {
		purchasedTime(display : false)
		item()
		quantity(blank : false)
		kitchen()
		transactionType(blank : false, inList : ["Issue", "Return"])
	}
	static mapping = {
		autoTimestamp true
	 }

}

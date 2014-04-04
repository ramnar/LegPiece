package legpiece

class AvailableStock {
	Date purchasedTime;
    ItemMaster item;
	Double quantity;
	static constraints = {
		purchasedTime(display : false)
    }
}

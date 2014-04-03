package legpiece

class AvailableStock {
	Date receivedTime;
    ItemMaster item;
	Double quantity;
	static constraints = {
		receivedTime(display : false)
    }
}

package legpiece

class Vendor {
	String id;
	String name;
	String mobileNumber;
	//static hasMany = [itemList : ItemMaster]
    static constraints = {
		name(blank : false, unique : true)
		//TODO : Validation mobileNumber(blank : false, phoneNumber : [strict: true]);
	}
}

package legpiece

class Vendor {
	String name;
	String contactNumber;//TODO:Validation
	String comments;
	//static hasMany = [items :ItemMaster]
	String toString() {
		"${name}"
	}
    static constraints = {
		name(blank : false, unique : true)
		contactNumber()
		comments(widget : 'textarea')
		//Validation mobileNumber(blank : false, phoneNumber : [strict: true]);
	}
}

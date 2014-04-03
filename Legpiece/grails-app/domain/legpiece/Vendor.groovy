package legpiece

class Vendor {
	String name;
	String mobileNumber;
	String toString() {
		"${name}"
	}
    static constraints = {
		name(blank : false, unique : true)
		//TODO : Validation mobileNumber(blank : false, phoneNumber : [strict: true]);
	}
}

package legpiece

class Kitchen {
	String name;
	String toString() {
		"${name}"
	}
    static constraints = {
		name(blank : false, unique : true)
    }
}

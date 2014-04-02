package legpiece

class Kitchen {
	String name;
    static constraints = {
		name(blank : false, unique : true)
    }
}

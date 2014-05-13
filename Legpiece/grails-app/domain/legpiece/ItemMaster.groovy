package legpiece

class ItemMaster {
	String name;
	String unitOfMeasure;
	//static belongsTo = [vendors:Vendor]
	Vendor vendor;//TODO:Multiple Vendors
	String toString() {
		"${name}"
	}
    static constraints = {		
		name(blank:false, unique:true)
		unitOfMeasure(blank:false)
		vendor(blank:false)
    }
}

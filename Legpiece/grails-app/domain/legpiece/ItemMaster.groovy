package legpiece

class ItemMaster {
	String id;//TODO:id autogeneration
	String name;
	String unitOfMeasure;
	Vendor vendor;//TODO:Multiple Vendors
	
    static constraints = {		
		name(blank:false, unique:true)
		unitOfMeasure(blank:false)
		vendor(blank:false)
    }
}

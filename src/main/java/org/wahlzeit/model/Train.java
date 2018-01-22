
/* Method calls for new object:
 * The new Train-object is created in the constructor:
 * Train(TrainsType type, String name) which sets the attributes type and name.
 * 
 * 
 * Object creation:
 * 1.Delegation:
 * by delegation to separate object, new trains are created by the TrainFactory-class
 * 2.Selection:
 * on-the-spot, in this class
 * 3.Configuration:
 * ---
 * 4.Instantiation:
 * in-code, constructor
 * 5.Initialization:
 * default
 * 6.Building:
 * ---
 */

package org.wahlzeit.model;

public class Train {

	protected TrainsType type;
	protected String name;
	
	public Train(TrainsType type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public TrainsType getType() {
		return type;
	}
	
	public void setType(TrainsType t) {
		this.type = t;
	}
}

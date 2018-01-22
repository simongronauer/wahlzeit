package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/* Method calls for new object: 
 * The new TrainsPhoto-object is created in the constructor:
 * TrainsPhoto(PhotoId id, String country, int power, int topSpeed) which sets the attributes
 * id, country, power and topSpeed.
 * 
 * 
 * 
 * Object creation:
 * 1.Delegation:
 * on-the-spot, by constructor TrainsPhoto
 * 2.Selection:
 * by subclassing, this class is subclass of Photo
 * 3.Configuration:
 * ---
 * 4.Instantiation:
 * in-code, by constructor
 * 5.Initialization:
 * by key-value-pair, two constructors
 * 6.Building:
 * Default, builts itself
 */

@Subclass
public class TrainsPhoto extends Photo {

	private String country;
	private int power;
	private int topSpeed;
	
	public TrainsPhoto() {
		super();
	}
	
	public TrainsPhoto(PhotoId id, String country, int power, int topSpeed) {
		super(id);
		this.country = country;
		this.power = power;
		this.topSpeed = topSpeed;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int getTopSpeed() {
		return this.topSpeed;
	}
}

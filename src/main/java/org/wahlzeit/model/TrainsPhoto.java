package org.wahlzeit.model;

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

package org.wahlzeit.model;

public class Location {

	private CartesianCoordinate coordinate;
	
	public Location () {
		this(new CartesianCoordinate());
	}
	
	public Location (CartesianCoordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public CartesianCoordinate getCoordinate() {
        return coordinate;
    }
	
	public void setCoordinate(CartesianCoordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public void setCoordinate(double x, double y, double z) {
		this.coordinate.setX(x);
		this.coordinate.setY(y);
		this.coordinate.setZ(z);
	}
}

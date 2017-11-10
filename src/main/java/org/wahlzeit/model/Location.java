package org.wahlzeit.model;

public class Location {

	private Coordinate coordinate;
	
	public Location () {
		this(new Coordinate());
	}
	
	public Location (Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
        return coordinate;
    }
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public void setCoordinate(double x, double y, double z) {
		this.coordinate.setX(x);
		this.coordinate.setY(y);
		this.coordinate.setZ(z);
	}
}

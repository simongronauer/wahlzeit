package org.wahlzeit.model;

public interface Coordinate {
	
	public CartesianCoordinate cartesianCoordinate();
	public double getCartesianDistance(Coordinate c);
	public SphericCoordinate sphericCoordinate();
	public double getSphericDistance(Coordinate c);
	public double getDistance(Coordinate c);
	public boolean isEqual(Coordinate c);

}
package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();
	
	@Override
	public abstract SphericCoordinate asSphericCoordinate();

	

	@Override
	public double getCartesianDistance(Coordinate c) {
		return this.asCartesianCoordinate().calcDistance(c);
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		return this.asSphericCoordinate().calcDistance(c);
	}

	public abstract double calcDistance(Coordinate c);
	
	@Override
	public abstract double getDistance(Coordinate c);

	@Override 
    public boolean equals(Object obj) {
        if(obj instanceof Coordinate){
            return isEqual((Coordinate) obj);
        }
        return false;
    }

	@Override
	public abstract boolean isEqual(Coordinate c);
	
	public abstract int hashCode();
	
}

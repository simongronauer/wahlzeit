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
	
	@Override
	public abstract int hashCode();
	
	public abstract void assertClassInvariants();
	
	protected void assertNotNegative(double v) {
		if (v < 0) throw new IllegalStateException("value must not be negative");
	}
	
	protected void assertDouble(double v) {
		if ((Double.isNaN(v)) || (v > Double.MAX_VALUE)) throw new IllegalStateException("value must be a double");
	}
	
}

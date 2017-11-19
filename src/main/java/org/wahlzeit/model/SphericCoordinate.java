package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {
	
	private double latitude;
	private double longitude;
	private double radius;
	
	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	public SphericCoordinate() {
		this(0, 0, 0);
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
    
	public double getLatitude() {
        return latitude;
    }
	
	public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }
    
    @Override
    public double getDistance(Coordinate c) {
		return getSphericDistance(c);
	}
    
    @Override
    public boolean isEqual(Coordinate other){
    	CartesianCoordinate b = this.cartesianCoordinate();
    	CartesianCoordinate c = other.cartesianCoordinate();
    	double epsilon = 0.00001;
        return ((Math.abs(b.getX() - c.getX()) < epsilon) && 
				(Math.abs(b.getY() - c.getY()) < epsilon) &&
				(Math.abs(b.getZ() - c.getZ()) < epsilon));
    }
    
    @Override 
    public boolean equals(Object obj) {
        if(obj instanceof CartesianCoordinate){
            return isEqual((CartesianCoordinate) obj);
        }
        return false;
    }

	@Override
	public CartesianCoordinate cartesianCoordinate() {
		if( radius == 0 ) return new CartesianCoordinate();
		double x = radius * Math.sin(longitude) * Math.cos(latitude);
		double y = radius * Math.sin(longitude) * Math.sin(latitude);
		double z = radius * Math.cos(longitude);
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	public double getCartesianDistance(Coordinate c) {
		return c.cartesianCoordinate().getDistance(cartesianCoordinate());
	}

	@Override
	public SphericCoordinate sphericCoordinate() {
		return this;
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		return c.sphericCoordinate().getDistance(this);
	}

}

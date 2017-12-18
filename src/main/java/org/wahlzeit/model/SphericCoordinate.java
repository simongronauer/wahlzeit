package org.wahlzeit.model;

import java.util.HashMap;

public class SphericCoordinate extends AbstractCoordinate {
	
	private final double EARTHRADIUS = 6371.0;
	private final double latitude;
	private final double longitude;
	private final double radius;
	private static final HashMap<Integer, SphericCoordinate> instances = new HashMap<> ();
	
	public SphericCoordinate(double latitude, double longitude, double radius) throws IllegalArgumentException {
		assertClassInvariants();
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		assertNotNull(this);
		assertClassInvariants();
	}
	
	public SphericCoordinate() throws IllegalArgumentException {
		this(0, 0, 0);
		assertNotNull(this);
	}
	
	public double getLatitude() {
		assertClassInvariants();
        return this.latitude;
    }
	
	public double getLongitude() {
		assertClassInvariants();
        return this.longitude;
    }

    public double getRadius() {
		assertClassInvariants();
        return this.radius;
    }
    
    public static synchronized SphericCoordinate getInstance(double latitude, double longitude, double radius) {
    	SphericCoordinate c = new SphericCoordinate(latitude, longitude, radius);
    	SphericCoordinate d = c.instances.get(c.hashCode());
    	if (d == null) {
    		instances.put(c.hashCode(), c);
    		d = c;
    	}
    	return d;
    }
    
    @Override
    public double getDistance(Coordinate c) throws IllegalArgumentException {
    	assertNotNull(this);
    	assertNotNull(c);
    	this.assertClassInvariants();
		return getSphericDistance(c);
	}
    
    @Override
    public boolean isEqual(Coordinate other){
    	assertNotNull(this);
    	assertNotNull(other);
    	CartesianCoordinate b = this.asCartesianCoordinate();
    	CartesianCoordinate c = other.asCartesianCoordinate();
    	double epsilon = 0.00001;
    	assertClassInvariants();
        return ((Math.abs(b.getX() - c.getX()) < epsilon) && 
				(Math.abs(b.getY() - c.getY()) < epsilon) &&
				(Math.abs(b.getZ() - c.getZ()) < epsilon));
    }

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		if( radius == 0 ) return new CartesianCoordinate();
		double x = radius * Math.sin(longitude) * Math.cos(latitude);
		double y = radius * Math.sin(longitude) * Math.sin(latitude);
		double z = radius * Math.cos(longitude);
		assertClassInvariants();
		return CartesianCoordinate.getInstance(x,y,z);
	}


	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		return this;
	}

	public int hashCode() {
		 final int prime = 31;
		 int result = 1;
		 long temp;
		 temp = Double.doubleToLongBits(latitude);
		 result = prime * result + (int) (temp ^ (temp >>> 32));
		 temp = Double.doubleToLongBits(longitude);
		 result = prime * result + (int) (temp ^ (temp >>> 32));
		 temp = Double.doubleToLongBits(radius);
		 result = prime * result + (int) (temp ^ (temp >>> 32));
		 return result;
	}

	@Override
	public double calcDistance(Coordinate c) throws IllegalArgumentException {
		SphericCoordinate s = c.asSphericCoordinate();
		assertClassInvariants();
		s.assertClassInvariants();
		double sum = 2 * this.radius * s.radius * (Math.sin(Math.toRadians(this.longitude)) *
					 Math.sin(Math.toRadians(s.longitude)) *
					 Math.cos(Math.toRadians(this.latitude - s.latitude)) + Math.cos(Math.toRadians(this.longitude)) *
					 Math.cos(Math.toRadians(s.longitude)));
		assertClassInvariants();
		return Math.sqrt(this.radius * this.radius + s.radius * s.radius - sum);
	}

	@Override
	public void assertClassInvariants() {
		assertNotNegative(radius);
		assertDouble(latitude);
		assertDouble(longitude);
	}

}

package org.wahlzeit.model;

import java.util.HashMap;

public class CartesianCoordinate extends AbstractCoordinate {
	
	private final double x;
	private final double y;
	private final double z;
	private final static HashMap<Integer, CartesianCoordinate> instances = new HashMap<> ();
	
	public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException {
		assertClassInvariants();
		this.x = x;
		this.y = y;
		this.z = z;
		assertNotNull(this);
		assertClassInvariants();
	}
	
	public CartesianCoordinate() throws IllegalArgumentException {
		this(0, 0, 0);
		assertNotNull(this);
	}
	
	public double getX() {
		assertClassInvariants();
        return this.x;
    }
	
	public double getY() {
		assertClassInvariants();
        return this.y;
    }

    public double getZ() {
		assertClassInvariants();
        return this.z;
    }
    
    public static synchronized CartesianCoordinate getInstance(double x, double y, double z) {
    	CartesianCoordinate c = new CartesianCoordinate(x, y, z);
    	CartesianCoordinate d = c.instances.get(c.hashCode());
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
		return getCartesianDistance(c);
	}
    
    @Override
    public boolean isEqual(Coordinate other){
    	assertNotNull(this);
    	assertNotNull(other);
    	CartesianCoordinate c = other.asCartesianCoordinate();
    	double epsilon = 0.00001;
    	assertClassInvariants();
        return ((Math.abs(getX() - c.getX()) < epsilon) && 
				(Math.abs(getY() - c.getY()) < epsilon) &&
				(Math.abs(getZ() - c.getZ()) < epsilon));
    }
    
    @Override
	public CartesianCoordinate asCartesianCoordinate() {
    	assertClassInvariants();
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		double latitude, longitude, radius;
		if ((x == 0) && (y == 0) && (z == 0)) return new SphericCoordinate();
		radius = Math.sqrt(x*x + y*y + z*z);
		latitude = Math.atan2(y, x);
		longitude = Math.acos(z/radius);
		assertClassInvariants();
		return SphericCoordinate.getInstance(latitude, longitude, radius);
	}

	@Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

	@Override
	public double calcDistance(Coordinate c) throws IllegalArgumentException {
		CartesianCoordinate c1 = c.asCartesianCoordinate();
		assertClassInvariants();
		c1.assertClassInvariants();
		double diffx = (c1.getX() - this.x);
		double diffy = (c1.getY() - this.y);
		double diffz = (c1.getZ() - this.z);
		double root = (diffx * diffx) + (diffy * diffy) + (diffz * diffz);
		double distance = Math.sqrt(root);
		assertClassInvariants();
		return distance;
	}

	public void assertClassInvariants() {
		assertDouble(x);
		assertDouble(y);
		assertDouble(z);
	}
}

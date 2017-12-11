package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
	
	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException {
		this.x = x;
		this.y = y;
		this.z = z;
		assertClassInvariants();
	}
	
	public CartesianCoordinate() {
		this(0, 0, 0);
	}
	
	public void setX(double x) throws IllegalArgumentException {
		assertDouble(x);
		this.x = x;
	}
	
	public void setY(double y) throws IllegalArgumentException {
		assertDouble(y);
		this.y = y;
	}
	
	public void setZ(double z) throws IllegalArgumentException {
		assertDouble(z);
		this.z = z;
	}
    
	public double getX() {
        return x;
    }
	
	public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    
    @Override
    public double getDistance(Coordinate c) throws IllegalArgumentException {
    	this.assertClassInvariants();
		return getCartesianDistance(c);
	}
    
    @Override
    public boolean isEqual(Coordinate other){
    	CartesianCoordinate c = other.asCartesianCoordinate();
    	double epsilon = 0.00001;
        return ((Math.abs(getX() - c.getX()) < epsilon) && 
				(Math.abs(getY() - c.getY()) < epsilon) &&
				(Math.abs(getZ() - c.getZ()) < epsilon));
    }
    
    @Override
	public CartesianCoordinate asCartesianCoordinate() {
    	this.assertClassInvariants();
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double latitude, longitude, radius;
		if ((x == 0) && (y == 0) && (z == 0)) return new SphericCoordinate();
		radius = Math.sqrt(x*x + y*y + z*z);
		latitude = Math.atan2(y, x);
		longitude = Math.acos(z/radius);
		return new SphericCoordinate(latitude, longitude, radius);
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
		c1.assertClassInvariants();
		double diffx = (c1.getX() - this.x);
		double diffy = (c1.getY() - this.y);
		double diffz = (c1.getZ() - this.z);
		double root = (diffx * diffx) + (diffy * diffy) + (diffz * diffz);
		double distance = Math.sqrt(root);
		return distance;
	}

	public void assertClassInvariants() {
		assertDouble(x);
		assertDouble(y);
		assertDouble(z);
	}
}

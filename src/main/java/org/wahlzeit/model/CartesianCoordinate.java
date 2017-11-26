package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
	
	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public CartesianCoordinate() {
		this(0, 0, 0);
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = x;
	}
	
	public void setZ(double z) {
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
    public double getDistance(Coordinate c) {
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
	public double calcDistance(Coordinate c) {
		CartesianCoordinate c1 = c.asCartesianCoordinate();
		double diffx = (c1.getX() - this.x);
		double diffy = (c1.getY() - this.y);
		double diffz = (c1.getZ() - this.z);
		double root = (diffx * diffx) + (diffy * diffy) + (diffz * diffz);
		double distance = Math.sqrt(root);
		return distance;
	}
}

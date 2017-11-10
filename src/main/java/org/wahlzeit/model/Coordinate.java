package org.wahlzeit.model;

public class Coordinate {
	
	private double x;
	private double y;
	private double z;
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Coordinate() {
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
    
    public double getDistance(Coordinate c2) {
		double diffx = (c2.getX() - this.x);
		double diffy = (c2.getY() - this.y);
		double diffz = (c2.getZ() - this.z);
		double root = (diffx * diffx) + (diffy * diffy) + (diffz * diffz);
		double distance = Math.sqrt(root);
		return distance;
	}
    
    protected boolean isEqual(Coordinate other){
    	double epsilon = 0.00001;
        return ((Math.abs(getX() - other.getX()) < epsilon) && 
				(Math.abs(getY() - other.getY()) < epsilon) &&
				(Math.abs(getZ() - other.getZ()) < epsilon));
    }
    
    @Override 
    public boolean equals(Object obj) {
        if(obj instanceof Coordinate){
            return isEqual((Coordinate) obj);
        }
        return false;
    }

}

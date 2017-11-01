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
        return getX()== other.getX() && getY() == other.getY() && getZ() == this.getZ();
    }
    
    @Override 
    public boolean equals(Object obj) {
        if(obj instanceof Coordinate){
            return isEqual((Coordinate) obj);
        }
        return false;
    }

}

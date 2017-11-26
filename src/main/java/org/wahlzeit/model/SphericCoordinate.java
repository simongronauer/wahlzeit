package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
	
	private final double EARTHRADIUS = 6371.0;
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
    	CartesianCoordinate b = this.asCartesianCoordinate();
    	CartesianCoordinate c = other.asCartesianCoordinate();
    	double epsilon = 0.00001;
        return ((Math.abs(b.getX() - c.getX()) < epsilon) && 
				(Math.abs(b.getY() - c.getY()) < epsilon) &&
				(Math.abs(b.getZ() - c.getZ()) < epsilon));
    }

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		if( radius == 0 ) return new CartesianCoordinate();
		double x = radius * Math.sin(longitude) * Math.cos(latitude);
		double y = radius * Math.sin(longitude) * Math.sin(latitude);
		double z = radius * Math.cos(longitude);
		return new CartesianCoordinate(x,y,z);
	}


	@Override
	public SphericCoordinate asSphericCoordinate() {
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
	public double calcDistance(Coordinate c) {
		SphericCoordinate s = c.asSphericCoordinate();
		double sum = 2 * this.radius * s.radius * (Math.sin(Math.toRadians(this.longitude)) *
					 Math.sin(Math.toRadians(s.longitude)) *
					 Math.cos(Math.toRadians(this.latitude - s.latitude)) + Math.cos(Math.toRadians(this.longitude)) *
					 Math.cos(Math.toRadians(s.longitude)));

		return Math.sqrt(this.radius * this.radius + s.radius * s.radius - sum);
	}

}

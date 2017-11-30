package org.wahlzeit.model;

public class Location {

	private Coordinate coordinate;
	
	public Location () {
		this(null);
	}
	
	public Location (Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
        return coordinate;
    }
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	@Override 
    public boolean equals(Object o) {
        if(o instanceof Location){
            return isEqual((Location) o);
        }
        return false;
    }

	public boolean isEqual(Location l) {
		return getCoordinate().isEqual(l.coordinate);
	}
}

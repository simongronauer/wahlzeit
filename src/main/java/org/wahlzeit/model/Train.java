package org.wahlzeit.model;

public class Train {

	protected TrainsType type;
	protected String name;
	
	public Train(TrainsType type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public TrainsType getType() {
		return type;
	}
	
	public void setType(TrainsType t) {
		this.type = t;
	}
}

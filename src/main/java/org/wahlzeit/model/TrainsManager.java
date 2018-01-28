package org.wahlzeit.model;

import java.util.HashMap;

/* Collaboration:
 * Type: Client Service
 * Role: Service
 */

/*
 * Collaboration:
 * Type: Type Object
 * Role: Base Object
 */

/*
 * Collaboration:
 * Type: Manager
 * Role: Element
 */

public class TrainsManager {

	protected static HashMap<String, Train> Trains = new HashMap<String, Train>();
	protected static HashMap<String, TrainsType> TrainsTypes = new HashMap<String, TrainsType>();
	
	public Train getTrain(int i) {
		return Trains.get(i);
	}
	
	public TrainsType getTrainsType(int i) {
		return TrainsTypes.get(i);
	}
	
	public TrainsType createTrain(String typeName) {
		TrainsType ts = TrainsTypes.get(typeName);
		if (ts == null) {
			ts = new TrainsType(typeName);
			TrainsTypes.put(typeName, ts);
		}
		return ts;
	}
}

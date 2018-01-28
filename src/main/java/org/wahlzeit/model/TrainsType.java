package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Set;
import org.wahlzeit.services.DataObject;

/*Collaboration:
 * 
 *Type: Type Object
 *Role: Type Object
 */

public class TrainsType extends DataObject {
	
	final protected String typeName;
	protected TrainsType superType = null;
	protected Set<TrainsType> subTypes = new HashSet<TrainsType>();
	
	public TrainsType(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public TrainsType getSuperType() {
		return superType;
	}
	
	public void setSuperType(TrainsType ts) {
		superType = ts;
	}
	
	public Set<TrainsType> getSubTypes() {
		return subTypes;
	}
	
	public void addSubType(TrainsType ts) {
		subTypes.add(ts);
	}
	
	public boolean isSubType(TrainsType ts) {
		return subTypes.contains(ts);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof TrainsType) {
			TrainsType ts = (TrainsType) obj;
			return this.getTypeName().equals(ts.getTypeName());
		}
		return false;
	}
	
	public boolean hasInstance(Train t) {
		if (this.equals(t.getType())) return true;
		for (TrainsType ts: subTypes) {
			return ts.hasInstance(t);
		}
		return false;
	}

}

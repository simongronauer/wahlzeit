package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class LocationTest {

	private Location a, b, c;
	private Coordinate d;
	
	@Before
	public void init() {
		d = new CartesianCoordinate(1, 2, 3);
		a = new Location(d);
		b = new Location(new CartesianCoordinate(1.0, 2.0, 3.0));
		c = new Location(new CartesianCoordinate(2, 3, 4));
	}
	
	@Test
	public void testEquals() {
		assertTrue(a.equals(new Location(new CartesianCoordinate(1, 2, 3))));
		assertTrue(a.equals(b));
		assertFalse(a.equals(c));		
	}
	
	@Test
	public void testIsEqual() {
		assertTrue(a.isEqual(new Location(new CartesianCoordinate(1, 2, 3))));
		assertTrue(a.isEqual(b));
		assertFalse(a.isEqual(c));
	}
	
}

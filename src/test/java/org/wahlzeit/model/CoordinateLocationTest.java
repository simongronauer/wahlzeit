package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.*;

public class CoordinateLocationTest {
	
	private Location locA;
	private Location locB;
	private Coordinate coordA; 
	private Coordinate coordB;
	
	@Before
	public void start() {
		coordA = new Coordinate();
		coordB = new Coordinate(1.0, 2.0, 3.0);
		locA = new Location (coordA);
		locB = new Location (coordB);
	}

	@Test
	public void testGetters() {
		assertEquals(0.0, coordA.getX(), 0.05);
		assertEquals(0.0, coordA.getY(), 0.05);
		assertEquals(0.0, coordA.getZ(), 0.05);
		assertEquals(1.0, coordB.getX(), 0.05);
		assertEquals(2.0, coordB.getY(), 0.05);
		assertEquals(3.0, coordB.getZ(), 0.05);
	}
	
	@Test
	public void testDist() {
		double dist = Math.sqrt(1.0 * 1.0 + 2.0 * 2.0 + 3.0 * 3.0);
		assertEquals (dist, coordA.getDistance(coordB), 0.0005);
	}
	
	@Test
	public void testEquals() {
		Coordinate coordC = new Coordinate (1.0, 2.0, 3.0);
		assertFalse(coordC.isEqual(coordA));
		assertFalse(coordC.equals(coordA));
		assertTrue(coordC.isEqual(coordB));
		assertTrue(coordC.equals(coordB));
	}
}

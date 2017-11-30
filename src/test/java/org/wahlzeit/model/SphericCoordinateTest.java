package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.*;

public class SphericCoordinateTest {
	
	private SphericCoordinate a, b, c, d;
	private CartesianCoordinate e = new CartesianCoordinate(0, 0, 0);
	
	@Before
	public void init() {
		a = new SphericCoordinate();
		b = new SphericCoordinate(1.0, 2.0, 3.0);
		c = new SphericCoordinate(1, 2, 3);
		d = new SphericCoordinate(2, 3, 4);
	}

	@Test
	public void testGetters() {
		assertEquals(0.0, a.getLatitude(), 0.05);
		assertEquals(0.0, a.getLatitude(), 0.05);
		assertEquals(0.0, a.getLongitude(), 0.05);
		assertEquals(1.0, b.getLongitude(), 0.05);
		assertEquals(2.0, b.getRadius(), 0.05);
		assertEquals(3.0, b.getRadius(), 0.05);
	}
	
	@Test
	public void testDist() {
		double dist = a.getSphericDistance(b);
		assertEquals(dist, b.getDistance(a), 0.0005);
		assertEquals(0, a.getDistance(new SphericCoordinate(0, 0, 0)), 0.0005);
		assertEquals(0, e.asSphericCoordinate().getDistance(a), 0.0005);
	}
	
	@Test
	public void testEquals() {
		assertFalse(c.isEqual(a));
		assertFalse(c.equals(a));
		assertTrue(c.isEqual(b));
		assertTrue(c.equals(b));
	}
}

package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.*;

public class CartesianCoordinateTest {
	
	private CartesianCoordinate a, b, c, d;
	private SphericCoordinate e = new SphericCoordinate(0, 0, 0);
	
	@Before
	public void init() {
		a = new CartesianCoordinate();
		b = new CartesianCoordinate(1.0, 2.0, 3.0);
		c = new CartesianCoordinate(1, 2, 3);
		d = new CartesianCoordinate(2, 3, 4);
	}

	@Test
	public void testGetters() {
		assertEquals(0.0, a.getX(), 0.05);
		assertEquals(0.0, a.getY(), 0.05);
		assertEquals(0.0, a.getZ(), 0.05);
		assertEquals(1.0, b.getX(), 0.05);
		assertEquals(2.0, b.getY(), 0.05);
		assertEquals(3.0, b.getZ(), 0.05);
	}
	
	@Test
	public void testDist() {
		double dist = Math.sqrt(1.0 * 1.0 + 2.0 * 2.0 + 3.0 * 3.0);
		assertEquals(dist, a.getDistance(b), 0.0005);
		assertEquals(0, a.getDistance(new CartesianCoordinate(0, 0, 0)), 0.0005);
		assertEquals(0, e.asCartesianCoordinate().getDistance(a), 0.0005);
	}
	
	@Test
	public void testEquals() {
		assertFalse(c.isEqual(a));
		assertFalse(c.equals(a));
		assertTrue(c.isEqual(b));
		assertTrue(c.equals(b));
	}
}

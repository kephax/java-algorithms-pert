package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pert.Vertex;
import pert.Edge;

/**
 * 
 * @author Pietro Bua
 *
 */
public class testEdge
{

	@Before
	public void setUp() throws Exception
	{
	}
	
	@Test
	public void testEdge0()
	{
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		
		Edge edge = new Edge(v1, v2, 10);
		
		assertEquals( "A", edge.getStart().getName() );
		assertEquals( "B", edge.getDestination().getName() );
	}
	
	@Test
	public void testEdge1()
	{
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		
		Edge edge = new Edge(v1, v2, 10);
		
		assertFalse( v1 == edge.getDestination() );
	}	
}

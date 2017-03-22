package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pert.Vertex;
import pert.GenericGraph;


/**
 * 
 * @author Pietro Bua
 *
 */
public class testVertex
{
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testVertex0()
	{
		Vertex vertex = new Vertex("A");
		assertEquals( "A", vertex.getName() );
	}
	
	@Test
	public void testVertexArrInc()
	{
		Vertex vertex = new Vertex("A");
		assertEquals( 0, vertex.getIncoming().size() );
	}
	
	@Test
	public void testVertexArrOut()
	{
		Vertex vertex = new Vertex("A");
		assertEquals( 0, vertex.getOutgoing().size() );
	}
	
	@Test
	public void testVertexArrInc1()
	{
		GenericGraph genericGraph = new GenericGraph();
		
		genericGraph.addVertex( "A" );	
		genericGraph.addVertex( "B" );
		
		Vertex vertex = genericGraph.getVertex("B");
		genericGraph.addEdge("A", "B", 10);
		
		assertEquals( 1, vertex.getIncoming().size() );
	}
	
	@Test
	public void testVertexArrInc2()
	{
		GenericGraph genericGraph = new GenericGraph();
		
		genericGraph.addVertex( "A" );	
		genericGraph.addVertex( "B" );
		genericGraph.addVertex( "C" );
		
		Vertex vertex = genericGraph.getVertex("C");
		genericGraph.addEdge("A", "C", 10);
		genericGraph.addEdge("B", "C", 10);
		
		assertEquals( 2, vertex.getIncoming().size() );
	}
	
	@Test
	public void testVertexArrOut1()
	{
		GenericGraph genericGraph = new GenericGraph();
		
		genericGraph.addVertex( "A" );	
		genericGraph.addVertex( "B" );
		
		Vertex vertex = genericGraph.getVertex("A");
		genericGraph.addEdge("A", "B", 10);
		
		assertEquals( 1, vertex.getOutgoing().size() );
	}
	
	@Test
	public void testVertexArrOut2()
	{
		GenericGraph genericGraph = new GenericGraph();
		
		genericGraph.addVertex( "A" );	
		genericGraph.addVertex( "B" );
		genericGraph.addVertex( "C" );
		
		Vertex vertex = genericGraph.getVertex("A");
		genericGraph.addEdge("A", "B", 10);
		genericGraph.addEdge("A", "C", 10);
		
		assertEquals( 2, vertex.getOutgoing().size() );
	}	


}

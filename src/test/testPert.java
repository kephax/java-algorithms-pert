package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pert.GenericGraph;
import pert.PERTNetwork;

/**
 * 
 * @author Pietro Bua
 * 
 * Third value in AssertEquals because of this explanation: 
 * http://stackoverflow.com/questions/5686755/meaning-of-epsilon-argument-of-assertequals-for-double-values
 * 
 *
 */
public class testPert
{
	
	@Before
	public void setUp() throws Exception
	{
		
	}

	@Test
	public void testExersise()
	{
		System.out.println("-- TESTING: testExersise --");
		
		PERTNetwork pertNetwork = new PERTNetwork();
		GenericGraph genericGraph = pertNetwork.getGenericGraph();
				
		genericGraph.addVertex("A");
		genericGraph.addVertex("B");
		genericGraph.addVertex("C");
		genericGraph.addVertex("D");
		genericGraph.addVertex("E");
		genericGraph.addVertex("F");
		genericGraph.addVertex("G");
		
		genericGraph.addEdge( "A", "B", 3 );
		genericGraph.addEdge( "A", "D", 1 );
		genericGraph.addEdge( "A", "G", 3 );
		genericGraph.addEdge( "B", "C", 1 );
		genericGraph.addEdge( "B", "F", 1 );
		genericGraph.addEdge( "D", "E", 1 );
		genericGraph.addEdge( "G", "F", 2 );
		genericGraph.addEdge( "E", "F", 1 );
		genericGraph.addEdge( "F", "C", 1 );
		
	/*	LinkedList<String> list = pertNetwork.topologicalSort();
		pertNetwork.earliestTime( list );
		pertNetwork.latestTime( list );*/

		assertEquals( 0.0, pertNetwork.tests().get("A").getEarliestTime(), 0.001 );
		assertEquals( 0.0, pertNetwork.tests().get("A").getLastTime()	 , 0.001 );

		assertEquals( 3.0, pertNetwork.tests().get("B").getEarliestTime(), 0.001 );
		assertEquals( 4.0, pertNetwork.tests().get("B").getLastTime()	 , 0.001 );

		assertEquals( 6.0, pertNetwork.tests().get("C").getEarliestTime(), 0.001 );
		assertEquals( 6.0, pertNetwork.tests().get("C").getLastTime()	 , 0.001 );

		assertEquals( 1.0, pertNetwork.tests().get("D").getEarliestTime(), 0.001 );
		assertEquals( 3.0, pertNetwork.tests().get("D").getLastTime()    , 0.001 );

		assertEquals( 2.0, pertNetwork.tests().get("E").getEarliestTime(), 0.001 );
		assertEquals( 4.0, pertNetwork.tests().get("E").getLastTime()	 , 0.001 );

		assertEquals( 5.0, pertNetwork.tests().get("F").getEarliestTime(), 0.001 );
		assertEquals( 5.0, pertNetwork.tests().get("F").getLastTime()	 , 0.001 );

		assertEquals( 3.0, pertNetwork.tests().get("G").getEarliestTime(), 0.001 );
		assertEquals( 3.0, pertNetwork.tests().get("G").getLastTime()	 , 0.001 );
	}

	@Test
	public void testEmpty()
	{
		System.out.println("-- TESTING: testEmpty --");

		PERTNetwork pertNetwork = new PERTNetwork();
		//GenericGraph genericGraph = pertNetwork.getGenericGraph();
			
		assertFalse( pertNetwork.tests().size()>0);
	}
	
	@Test
	public void testSmall()
	{
		System.out.println("-- TESTING: testSmall --");

		PERTNetwork pertNetwork = new PERTNetwork();
		GenericGraph genericGraph = pertNetwork.getGenericGraph();
	
		genericGraph.addVertex("A");
		genericGraph.addVertex("B");
		genericGraph.addVertex("C");
		
		genericGraph.addEdge( "A", "B", 3 );
		genericGraph.addEdge( "A", "C", 1 );
		
		assertEquals( 0.0, pertNetwork.tests().get("A").getEarliestTime(), 0.001 );
		assertEquals( 0.0, pertNetwork.tests().get("A").getLastTime()	 , 0.001 );

		assertEquals( 3.0, pertNetwork.tests().get("B").getEarliestTime(), 0.001 );
		assertEquals( 3.0, pertNetwork.tests().get("B").getLastTime()	 , 0.001 );

		assertEquals( 1.0, pertNetwork.tests().get("C").getEarliestTime(), 0.001 );
		assertEquals( 1.0, pertNetwork.tests().get("C").getLastTime()	 , 0.001 );

	}
	
	@Test
	public void createMedium()
	{
		PERTNetwork pertNetwork = new PERTNetwork();
		GenericGraph genericGraph = pertNetwork.getGenericGraph();
	}
}

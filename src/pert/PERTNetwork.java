package pert;
import java.util.*;

/**
 * 
 * @author Pietro Bua
 *
 */
public class PERTNetwork
{
	private GenericGraph genericGraph;
	
	/**
	 * 
	 */
	public PERTNetwork()
	{
		genericGraph = new GenericGraph();
	}
	
	public void exersisePert()
	{
		System.out.println("=== PERT Network ===");
		
		System.out.println("-- Creating PERT --");
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
		
		System.out.println("-- Printing PERT --");
		System.out.println( genericGraph.toString() );

		
		LinkedList<String> list = topologicalSort();

		System.out.println("-- Earliest Time --");
		earliestTime( list );

		System.out.println("-- Latest Time --");
		latestTime( list );
		
		System.out.println("=== End Script ===");
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 */
	public void earliestTime( LinkedList<String> sortedList ) 	// vroegsteTijden() - opdracht naam 
	{
		for(String s: sortedList )
		{
			Vertex v = genericGraph.getVertex(s);
			if (v.getIncoming().isEmpty()) 						// Geef alle knooppunten zonder voorgangers tijd nul
			{
				v.setEearliestTime(0);
				System.out.println("Setting earliestTime: " + v.toStringSmall() + " 0" );
			}
			else
			{
				v.setEearliestTime( calculateEarliestTime(v) );
				System.out.println("Setting earliestTIme: " + v.toStringSmall() + " " + calculateEarliestTime(v) );
			}
		}
	}
	
	/**
	 * 
	 * @param vertex
	 * @return
	 */
    public double calculateEarliestTime( Vertex vertex )		// MAX alle voorgangers van vertex
    {
        double max = -Double.MAX_VALUE;
        for( Edge e : vertex.getIncoming() )
        {
            if( (e.getStart().getEarliestTime()+e.getStart().getCostToNeighbour(vertex)) > max )
            {
                max = e.getStart().getEarliestTime() + e.getStart().getCostToNeighbour(vertex);
            }
        }
        return max;
    }

	////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 
     */
	public void latestTime( LinkedList<String> sortedList ) 	// laatsteTijden() - opdracht naam
	{
        Collections.reverse(sortedList);
       
        for (String s: sortedList )
        {
            Vertex v = genericGraph.getVertex(s);
            if (v.getOutgoing().isEmpty())
            {
                v.setLastTime( v.getEarliestTime() );
                System.out.println("Setting latestTime: " + v.toStringSmall() + " " + v.getEarliestTime() );
            }
            else
            {
                v.setLastTime( calculateMinLastTime(v) );
                System.out.println("Setting latestTime: " + v.toStringSmall() + " " + calculateMinLastTime(v) );
            }
        }
	} 
   
	/**
	 * 
	 * @param vertex
	 * @return
	 */
	public double calculateMinLastTime( Vertex vertex )			// MIN alle opvolgers van vertex
	{
        double min = Double.MAX_VALUE;
        for (Edge e : vertex.getOutgoing() )
        {
            if( (e.getDestination().getLastTime()-vertex.getCostToNeighbour(e.getDestination())) < min )
            {
                min = e.getDestination().getLastTime() - vertex.getCostToNeighbour(e.getDestination());
            }
        }
        return min;
    }
     
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 * @return
	 */
    public LinkedList<String> topologicalSort()
    {
        LinkedList<String> sortedList = new LinkedList<String>();
       
        while(hasUncheckedEdges())
        {
            for (String s : genericGraph.getVertices().keySet() )
            {
                Vertex vertex = genericGraph.getVertex(s);
                if( (! vertex.hasPredecessors())&&(! vertex.vertexVisited()) )
                {
                    sortedList.add(vertex.getName());
                    vertex.setVertexVisited();
                }
            }
        }
        resetVisited();
       
        return sortedList;
    }
    
    /**
     * 
     * @return
     */
    private boolean hasUncheckedEdges()
    {
        for(String s : genericGraph.getVertices().keySet() )
        {
            Vertex v = genericGraph.getVertex(s);
            if ( ! v.vertexVisited())
            {
                return true;
            }
        }
        return false;
    }    
	
    /**
     *    
     */
    public void resetVisited()
    {
        for (String s : genericGraph.getVertices().keySet())
        {
            Vertex v = genericGraph.getVertex(s);
            v.resetVertexVisited();
        }
    }

    /**
     * 
     */
    public void clearGraph()
    {
    	genericGraph.getVertices().clear();
    }
    
    /**
     * 
     * @return
     */
    public LinkedHashMap<String, Vertex> tests()
    {
        LinkedList<String> list = topologicalSort();
        System.out.println("Topologic sorted: " + list);
        earliestTime( list );
        latestTime( list );
       
        return (LinkedHashMap<String, Vertex>) genericGraph.getVertices();
    }

    /**
     * 
     * @return
     */
	public GenericGraph getGenericGraph()
	{
		// TODO Auto-generated method stub
		return genericGraph;
	}    
}

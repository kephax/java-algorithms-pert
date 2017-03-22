package pert;
import java.util.*;

/**
 * 
 * @author Pietro Bua
 *
 */
public class Vertex
{
	private String myName;
	private ArrayList<Edge> myIncoming;
	private ArrayList<Edge> myOutgoing;
	
    private double myTimeEarliest;
    private double myTimeLatest;

    private boolean visited;
   
	/**
	 * 
	 * @param name
	 */
	public Vertex( String name )
	{
		myName = name;

		myIncoming = new ArrayList<Edge>();
		myOutgoing = new ArrayList<Edge>();
		
		visited = false;
	}

	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return myName;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Edge> getIncoming()
	{
		return myIncoming;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Edge> getOutgoing()
	{
		return myOutgoing;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getTimeEarliest()
	{
		return myTimeEarliest;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getTimeLatest()
	{
		return myTimeLatest;
	}
	
	/**
	 * 
	 * @param a
	 */
	public void addArrowIn( Edge e )
	{
		myIncoming.add(e);
	}

	/**
	 * 
	 * @param a
	 */
	public void addArrowOut( Edge e )
	{
		myOutgoing.add(e);
	}

	/**
	 * 
	 * @param e
	 */
    public void addOutgoingEdge( Edge e )
    {
    	myOutgoing.add(e);
    }
   
    /**
     * 
     * @param e
     */
    public void addIncomingEdge( Edge e )
    {
    	myIncoming.add(e);
    }

    /**
     * 
     * @return
     */
    public double getEarliestTime()
    {
    	return myTimeEarliest;
    }

    /**
     * 
     * @return
     */
    public double getLastTime()
    {
    	return myTimeLatest;
    }
   
    /**
     * 
     * @return
     */
    public boolean vertexVisited()
    {
    	return visited;
    }

    /**
     * 
     */
    public void setVertexVisited()
    {
    	visited = true;
    }
   
    /**
     * 
     */
    public void resetVertexVisited()
    {
    	visited = false;
    }

    /**
     * 
     * @param v
     * @return
     */
    public double getCostToNeighbour( Vertex v )
    {
        for (Edge edge : myOutgoing)
        {
            if(v == edge.getDestination())
            {
                return edge.getValue();
            }
        }
        return Double.MIN_VALUE;
    }

    /**
     * 
     * @param time
     */
    public void setEearliestTime( double time )
    {
        myTimeEarliest = time;
    }

    /**
     * 
     * @param time
     */
    public void setLastTime( double time )
    {
        myTimeLatest = time;
    }
   
    /**
     * 
     * @return
     */
    public boolean hasPredecessors()
    {
        if( ! myIncoming.isEmpty())
        {
	        for(Edge edge : myIncoming )
	        {
	            if ( ! edge.getStart().vertexVisited() )
	            {
	                return true;
	            }
	        }
        }
        return false;
    }

    /**
     * 
     */
    public String toString()
    {
    	return "Vertex @" + System.identityHashCode(this) + ": [" + myName + "]\r\n" +
                "\tEarliest time: " + myTimeEarliest + " - Latest time: " + myTimeLatest + "\r\n" +
    			"\tIncoming: " + myIncoming + "\r\n" +
    			"\tOutgoing: " + myOutgoing;
    }
    
    /**
     * 
     */
    public String toStringSmall()
    {
    	return "Vertex [" + myName + "]";
    }    
}

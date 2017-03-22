package pert;
/**
 * 
 * @author Pietro Bua
 *
 */
public class Edge
{
	private double myValue;
	private Vertex myStartVertex;
	private Vertex myDestVertex;

	
	/**
	 * 
	 * @param distance
	 */
	public Edge( Vertex start, Vertex dest, double distance )
	{
		myStartVertex = start;
		myDestVertex = dest;
		myValue = distance;
	}

	/**
	 * 
	 * @return
	 */
	public double getValue()
	{
		return myValue;
	}
	
	/**
	 * 
	 * @return
	 */
	public Vertex getStart()
	{
		return myStartVertex;
	}
	
	/**
	 * 
	 * @return
	 */
	public Vertex getDestination()
	{
		return myDestVertex;
	}
	
	/**
	 * 
	 */
	public String toString()
	{
		return "{Edge @" + System.identityHashCode(this)+ ": [" + myStartVertex.getName() + "]--" + myValue + "-->[" + myDestVertex.getName() + "]}";
	}
}

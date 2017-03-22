package pert;
import java.util.*;

/**
 * 
 * @author Pietro Bua
 *
 */
public class GenericGraph
{
    private Map <String, Vertex> vertices;

	/**
	 * 
	 */
    public GenericGraph()
    {
        vertices = new LinkedHashMap<String, Vertex>();
	}
	
    /**
     * 
     * @param name
     */
	public void addVertex( String name )
	{
		Vertex v = new Vertex(name);
        vertices.put( name, v );
        System.out.println("Vertex @" + System.identityHashCode(v) + ": [" + name + "] created");
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Vertex getVertex( String name )
	{
        return vertices.get(name);
	}
	
	/**
	 * 
	 * @return
	 */
	public Map<String, Vertex> getVertices()
	{
        return vertices;
	}
	
	/**
	 * 
	 * @param value
	 * @param vertexStart
	 * @param vertexDest
	 */
	public void addEdge( String vertexStart, String vertexDest, int value )
	{
		Vertex start = getVertex( vertexStart );
		Vertex dest = getVertex( vertexDest );

		Edge e = new Edge( start, dest, value);
		System.out.println("Edge @" + System.identityHashCode(e) + ": [" + start.getName() + "]--" + value + "-->[" + dest.getName() + "] created");
		if ((start != null) && (dest != null))
		{
			start.addArrowOut(e);
			dest.addArrowIn(e);
			//System.out.println("Edge binded with vertices");
		}
		else
		{
			System.out.println("ERROR  - GenericGraph->addEdge: One of the vertices is null");
		}
	}
	
	/**
	 * 
	 */
	public String toString()
	{
		String ret = "";
		for(String key : getVertices().keySet())
		{
			ret += getVertex( key ) + "\r\n";
		}
		
		return ret;
	}

}

import java.util.Iterator;
import java.util.*;
import java.io.*;
import ADTPackage.*; // Classes that implement various ADTs

public class DirectedGraph<T> implements GraphInterface<T>
{
	private DictionaryInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;
	
	public DirectedGraph()
	{
		vertices = new LinkedDictionary<>();
		edgeCount = 0;
	} // end default constructor

    
} // end DirectedGraph

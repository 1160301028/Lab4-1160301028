package edge;

import java.util.List;

import vertex.Vertex;

public class SameMovieHyperEdgeFactory extends EdgeFactory {

	
	public static Edge createEdge(String label, String type, List<Vertex> vertices, double weight) {
		// TODO Auto-generated method stub
		Edge re = new SameMovieHyperEdge(label,type);
		re.addVertices(vertices);
		return re;
	}
	
	public static Edge creatEdge(String label, String type,List<Vertex> vertices)
	{
		Edge re = new SameMovieHyperEdge(label,type);
		re.addVertices(vertices);
		return re;
	}

}

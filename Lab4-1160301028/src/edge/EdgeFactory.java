package edge;

import java.util.List;

import vertex.Vertex;


public  class EdgeFactory {
	
	public static Edge createEdge(String label, String type, List<Vertex> vertices, double weight){
		Edge re = new helpEdge(label,weight,type);
		re.addVertices(vertices);
		return re;
	}
	
	
}

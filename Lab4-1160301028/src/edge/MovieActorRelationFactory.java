package edge;

import java.util.List;

import vertex.Vertex;

public class MovieActorRelationFactory extends EdgeFactory {

	
	public static Edge createEdge(String label, String type, List<Vertex> vertices, double weight) {
		// TODO Auto-generated method stub
		Edge re = new MovieDirectorRelation(label,weight,type);
		re.addVertices(vertices);
		return re;
	}

}

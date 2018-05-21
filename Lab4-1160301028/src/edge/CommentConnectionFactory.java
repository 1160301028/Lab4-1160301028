package edge;

import java.util.List;

import vertex.Vertex;

public class CommentConnectionFactory extends EdgeFactory {
	public static Edge creatEdge(String label, String type, double weight,List<Vertex> vertices)
	{
		Edge re = new CommentConnection(label,weight,type);
		re.addVertices(vertices);
		return re;
	}
}

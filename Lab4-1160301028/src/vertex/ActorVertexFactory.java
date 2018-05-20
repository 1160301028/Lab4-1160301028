package vertex;

public class ActorVertexFactory extends VertexFactory {

	public static Vertex createVertex(String label, String type, String[] args)
	{
		Vertex re;
		if(type.equals("Actor"))
		{
			re = new Actor(label,args,type);
		}
		else
		{
			re = VertexFactory.createVertex(label, type, args);
		}
		return re;
	}
	
}

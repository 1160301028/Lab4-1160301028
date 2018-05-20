package vertex;

public class RouterVertexFactory extends VertexFactory {

	public static Vertex createVertex(String label, String type, String[] args)
	{
		Vertex re;
		if(type.equals("Router"))
		{
			re = new Router(label,args,type);
		}
		else
		{
			re = VertexFactory.createVertex(label, type, args);
		}
		return re;
	}
	
}

package vertex;

public class DirectorVertexFactory extends VertexFactory {

	public static Vertex createVertex(String label, String type, String[] args)
	{
		Vertex re;
		if(type.equals("Director"))
		{
			re = new Director(label,args,type);
		}
		else
		{
			re = VertexFactory.createVertex(label, type, args);
		}
		return re;
	}
	
}

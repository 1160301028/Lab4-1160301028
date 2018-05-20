package vertex;

public class PersonVertexFactory extends VertexFactory {

	public static Vertex createVertex(String label, String type, String[] args)
	{
		Vertex re;
		if(type.equals("Person"))
		{
			re = new Person(label,args,type);
		}
		else
		{
			re = VertexFactory.createVertex(label, type, args);
		}
		return re;
	}
	
}

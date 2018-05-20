package vertex;

public class WordVertexFactory extends VertexFactory {

	public static Vertex createVertex(String label, String type, String[] args)
	{
		Vertex re;
		if(type.equals("Word"))
		{
			re = new Word(label,args,type);
		}
		else
		{
			re = VertexFactory.createVertex(label, type, args);
		}
		return re;
	}
	
}

package vertex;

public abstract class VertexFactory {

	public static Vertex createVertex(String label, String type, String[] args)
	{
		Vertex re = new Word(label,args,type);
		return re;
	}
	
}

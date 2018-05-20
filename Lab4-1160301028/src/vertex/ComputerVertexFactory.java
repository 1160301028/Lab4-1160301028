package vertex;

public class ComputerVertexFactory extends VertexFactory {

	public  static Vertex createVertex(String label, String type, String[] args)
	{
		Vertex re;
		if(type.equals("Computer"))
		{
			re = new Computer(label,args,type);
		}
		else
		{
			re = VertexFactory.createVertex(label, type, args);
		}
		return re;
	}
}

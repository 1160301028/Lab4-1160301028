package edge;

import java.util.List;

import vertex.Vertex;

public class NetworkConnectionFactory extends EdgeFactory {

	
	public static Edge createEdge(String label, String type, List<Vertex> vertices, double weight) {
		// TODO Auto-generated method stub
		Edge re = new NetworkConnection(label,weight,type);
		Vertex fir = vertices.get(0);
		String lab1 = fir.getType();
		Vertex sec = vertices.get(1);
		String lab2 = sec.getType();
		if(match(lab1,lab2))
		{
			re.addVertices(vertices);
			return re;
		}
		else
			return null;
	}
	
	private static boolean match(String lab1,String lab2)
	{
		return type1(lab1,lab2)||type1(lab2,lab1)||type2(lab1,lab2)||type2(lab2,lab1)||type3(lab1,lab2)||type3(lab2,lab1)||type4(lab1,lab2)?true:false;
	}
	private static boolean type1(String lab1,String lab2)
	{
		return lab1.equals("Computer")&&lab2.equals("Server")?true:false;
	}
	private static boolean type2(String lab1,String lab2)
	{
		return lab1.equals("Computer")&&lab2.equals("Router")?true:false;
	}
	private static boolean type3(String lab1,String lab2)
	{
		return lab1.equals("Router")&&lab2.equals("Server")?true:false;
	}
	private static boolean type4(String lab1,String lab2)
	{
		return lab1.equals("Router")&&lab2.equals("Router")?true:false;
	}

}

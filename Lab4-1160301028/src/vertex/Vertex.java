package vertex;

public abstract class Vertex {
	
	private String label;
	private String type;
	
	
	public Vertex(String str,String type)
	{
		this.label = str;
		this.type = type;
	}
	
	abstract void fillVertexInfo (String[] args);
	
	public boolean changeLabel(String str)
	{
		this.label = str;
		if(this.label==str)
			return true;
		else
			return false;
	}
	
	public String getLabel()
	{
		return this.label;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	@Override
	public String toString()
	{
		return "Class Vertex and Label "+this.label;
	}
}

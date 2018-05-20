package edge;

import java.util.*;

import vertex.Vertex;

public abstract class Edge {
	
	protected List<Vertex> vertices;
	private String label;
	private double weight;
	private String type;
	
	public Edge(String label,double weight,String type)
	{
		this.label = label;
		this.weight = weight;
		this.type = type;
		this.vertices = new ArrayList<Vertex>();
		
	}
	
	abstract public boolean addVertices(List<Vertex> vertices);
	
	boolean containVertex(Vertex v)
	{
		return this.vertices.contains(v)?true:false;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getLabel()
	{
		return this.label;
	}
	
	public boolean changeLabel(String str)
	{
		this.label = str;
		if(this.label==str)
			return true;
		else
			return false;
	}
	
	public boolean changeWeight(double value)
	{
		this.weight = value;
		if(this.weight==value)
			return true;
		else
			return false;
	}
	
	public Set<Vertex> vertices()
	{
		Set<Vertex> re = new HashSet<Vertex>();
		for(Vertex i:this.vertices)
			re.add(i);
		return re;
	}
	
	public abstract Set<Vertex> sourceVertices();
	
	public abstract Set<Vertex> targetVertices();
	
	@Override
	public String toString()
	{
		return "Class Edge and this Edge's label is "+this.label+" and the weight is "+this.weight+" ."+" contains vertex "+names();
	}
	
	private String names()
	{
		String re = "";
		for(Vertex i:this.vertices)
		{
			re += i.getLabel();
			re +=",";
		}
		return re;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}

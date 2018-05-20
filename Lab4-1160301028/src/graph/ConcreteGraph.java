package graph;

import java.util.*;

import edge.Edge;
import vertex.Vertex;

public class ConcreteGraph implements Graph<Vertex, Edge>{
	private String name;
	private Collection<Vertex> vertices;//节点的集合
	private Collection<Edge> edges;//边的集合
	Set<Edge> edgelist = new HashSet<Edge>();
	
	public ConcreteGraph(String str)
	{
		this.vertices = new ArrayList<>();
		this.edges = new ArrayList<>();
		this.name = str;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public boolean addVertex(Vertex v) {
		// TODO 自动生成的方法存根
		if(this.vertices.contains(v))
			return false;
		else
		{
			this.vertices.add(v);
			return true;
		}
	}
	@Override
	public boolean removeVertex(Vertex v) {
		// TODO 自动生成的方法存根
		if(this.vertices.contains(v))
		{
			this.vertices.remove(v);
			return true;
		}
		else
			return false;
	}
	@Override
	public Set<Vertex> vertices() {
		// TODO 自动生成的方法存根
		Set<Vertex> re = new HashSet<>();
		for(Vertex i:this.vertices)
		{
			re.add(i);
		}
		return re;
	}
	@Override
	public Map<Vertex, Double> sources(Vertex target) {//返回以target为源点的节点
		// TODO 自动生成的方法存根
		Map<Vertex,Double> re = new HashMap<>();
		for(Edge i:this.edges)//遍历图中的每条边
		{
			if(i.targetVertices().contains(target))//如果该边的目标节点集中有target
			{
				for(Vertex j:i.sourceVertices())//遍历这样边的源节点集合
				{
					if(!j.equals(target))//如果源节点不等于target，及该边不是由target指向target的循环边
						re.put(j,i.getWeight());//
				}
			}
		}
		return re;
	}
	@Override
	public Map<Vertex, Double> targets(Vertex source) {
		// TODO 自动生成的方法存根
		Map<Vertex,Double> re = new HashMap<>();
		for(Edge i:this.edges)
		{
			if(i.sourceVertices().contains(source))
			{
				for(Vertex j:i.targetVertices())
				{
					if(!j.equals(source))
						re.put(j, i.getWeight());
				}
			}
		}
		return re;
	}
	@Override
	public boolean addEdge(Edge edge) {
		// TODO 自动生成的方法存根
		if(this.edges.contains(edge))
			return false;
		else
		{
			this.edges.add(edge);
			return true;
		}
	}
	@Override
	public boolean removeEdge(Edge edge) {
		// TODO 自动生成的方法存根
		if(this.edges.contains(edge))
		{
			this.edges.remove(edge);
			return true;
		}
		else
			return false;
	}
	@Override
	public Set<Edge> edges() {
		// TODO 自动生成的方法存根
		Set<Edge> re = new HashSet<>();
		for(Edge i:this.edges)
		{
			re.add(i);
		}
		return re;
	}
	@Override
	public boolean isDirected() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void clearVertex() {//清除没有边连接的节点
		// TODO 自动生成的方法存根
		Set<Vertex> a = new HashSet<>();
		Set<Vertex> tbr = new HashSet<>();
		for(Edge i:this.edges)
		{
			a.addAll(i.vertices());
		}
		for(Vertex i:this.vertices)
		{
			if(!a.contains(i))
				tbr.add(i);		
		}
		for(Vertex i:tbr)
		{
			this.removeVertex(i);
		}
	}

	@Override
	public void clearEdge() {//清除两端没有节点的边
		// TODO 自动生成的方法存根
		for(Edge i:this.edges)
		{
			if(!this.vertices.containsAll(i.vertices()))
				this.removeEdge(i);
		}
	}
}

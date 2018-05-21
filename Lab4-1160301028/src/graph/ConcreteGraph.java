package graph;

import java.util.*;

import edge.Edge;
import vertex.Vertex;

public class ConcreteGraph implements Graph<Vertex, Edge>{
	private String name;
	private Collection<Vertex> vertices;//�ڵ�ļ���
	private Collection<Edge> edges;//�ߵļ���
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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		Set<Vertex> re = new HashSet<>();
		for(Vertex i:this.vertices)
		{
			re.add(i);
		}
		return re;
	}
	@Override
	public Map<Vertex, Double> sources(Vertex target) {//������targetΪԴ��Ľڵ�
		// TODO �Զ����ɵķ������
		Map<Vertex,Double> re = new HashMap<>();
		for(Edge i:this.edges)//����ͼ�е�ÿ����
		{
			if(i.targetVertices().contains(target))//����ñߵ�Ŀ��ڵ㼯����target
			{
				for(Vertex j:i.sourceVertices())//���������ߵ�Դ�ڵ㼯��
				{
					if(!j.equals(target))//���Դ�ڵ㲻����target�����ñ߲�����targetָ��target��ѭ����
						re.put(j,i.getWeight());//
				}
			}
		}
		return re;
	}
	@Override
	public Map<Vertex, Double> targets(Vertex source) {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		Set<Edge> re = new HashSet<>();
		for(Edge i:this.edges)
		{
			re.add(i);
		}
		return re;
	}
	@Override
	public boolean isDirected() {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public void clearVertex() {//���û�б����ӵĽڵ�
		// TODO �Զ����ɵķ������
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
	public void clearEdge() {//�������û�нڵ�ı�
		// TODO �Զ����ɵķ������
		for(Edge i:this.edges)
		{
			if(!this.vertices.containsAll(i.vertices()))
				this.removeEdge(i);
		}
	}
}

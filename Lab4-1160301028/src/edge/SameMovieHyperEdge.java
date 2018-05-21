package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public class SameMovieHyperEdge extends Edge {
	
	private Set<Vertex> points = new HashSet<Vertex>();
	
	public SameMovieHyperEdge(String label, String type) {
		super(label, -1, type);
		checkRep();
		// TODO Auto-generated constructor stub
	}
	
	private void checkRep() {
		assert this.getWeight() == -1;
		assert this.sourceVertices().size() == 0;
		assert this.targetVertices().size() == 0;
		assert this.getPoints().size() == 0 || this.getPoints().size() >= 2;
	}
	
	public Set<Vertex> getPoints() {
		return new HashSet<Vertex>(points);
	}

	@Override
	public boolean addVertices(List<Vertex> vertices) {
		// TODO Auto-generated method stub
		if(vertices.size()>1)
		{
			for(Vertex i:vertices)
			{
				super.vertices.add(i);
			}
			return true;
		}
		else
		{
			System.out.println("error.");
			return false;
		}
	}

	@Override
	public Set<Vertex> sourceVertices() {
		// TODO Auto-generated method stub
		Set<Vertex> re = new HashSet<>();
		return re;
	}

	@Override
	public Set<Vertex> targetVertices() {
		// TODO Auto-generated method stub
		Set<Vertex> re = new HashSet<>();
		return re;
	}

}

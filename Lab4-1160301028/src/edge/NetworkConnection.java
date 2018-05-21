package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public class NetworkConnection extends Edge {
	
	private Set<Vertex> points = new HashSet<Vertex>();
	
	public NetworkConnection(String label, double weight, String type) {
		super(label, weight, type);
		checkRep();
		// TODO Auto-generated constructor stub
	}
	
	private void checkRep() {
		assert this.getWeight() >= 0;
		assert this.sourceVertices().size() == 0;
		assert this.targetVertices().size() == 0;
		assert this.getPoints().size() == 0 || this.getPoints().size() == 2;
	}
	
	public Set<Vertex> getPoints() {
		return new HashSet<Vertex>(points);
	}
	
	@Override
	public boolean addVertices(List<Vertex> vertices) {
		// TODO Auto-generated method stub
		if(vertices.size()==2)
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
		for(Vertex i:super.vertices())
			re.add(i);
		return re;
	}

	@Override
	public Set<Vertex> targetVertices() {
		// TODO Auto-generated method stub
		Set<Vertex> re = new HashSet<>();
		for(Vertex i:super.vertices())
			re.add(i);
		return re;
	}

}

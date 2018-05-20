package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public class CommentConnection extends Edge {
	
	
	public CommentConnection(String label, double weight, String type) {
		super(label, weight, type);
		checkRep();
		// TODO Auto-generated constructor stub
	}
	
	
	private void checkRep() {
		assert this.getWeight() >= 0 && this.getWeight() <= 1;
		assert this.sourceVertices().size() == 0 || this.sourceVertices().size() == 1;
		assert this.targetVertices().size() == 0 || this.targetVertices().size() == 1;
		assert this.sourceVertices().containsAll(this.targetVertices());
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
		Set<Vertex> sv = new HashSet<>();
		sv.add(super.vertices.get(0));
		return sv;
	}

	@Override
	public Set<Vertex> targetVertices() {
		// TODO Auto-generated method stub
		Set<Vertex> tv = new HashSet<>();
		tv.add(super.vertices.get(1));
		return tv;
	}

}

package graph;

import java.util.ArrayList;

import edge.CommentConnection;
import edge.Edge;
import edge.ForwardConnection;
import edge.FriendConnection;
import vertex.Vertex;

public class SocialNetwork extends ConcreteGraph {

	public SocialNetwork(String str) {
		super(str);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isDirected()
	{
		return true;
	}
	
	private void checkRep() {
		for (Edge edge : this.edges()) {
			assert (edge instanceof CommentConnection) || (edge instanceof FriendConnection)
					|| (edge instanceof ForwardConnection);
			assert !(new ArrayList<Vertex>(edge.sourceVertices()).get(0)
					.equals(new ArrayList<Vertex>(edge.targetVertices()).get(0)));
			for (Edge edge1 : this.edges()) {
				assert edge1.getLabel() != edge.getLabel();
			}
		}
		for (Vertex vertex : this.vertices()) {
			for (Vertex vertex1 : this.vertices()) {
				assert vertex1.getLabel() != vertex.getLabel();
			}
		}
	}

	@Override
	public boolean addEdge(Edge edge) {
		double weight = edge.getWeight();
		for (Edge x : edgelist) {
			x.setWeight(x.getWeight() * (1 - weight));
		}
		this.edgelist.add(edge);
		checkRep();
		return true;
	}

	@Override
	public boolean removeEdge(Edge edge) {
		double weight = edge.getWeight();
		for (Edge x : edgelist) {
			x.setWeight(x.getWeight() / (1 - weight));
		}
		this.edgelist.remove(edge);
		checkRep();
		return true;
	}

	public void setEdges(Edge edge, double weight) {
		double weightfor = edge.getWeight();
		for (Edge value : edgelist) {
			value.setWeight(value.getWeight() * (1 - weight) / (1 - weightfor));
		}
		edge.setWeight(weight);
	}
}

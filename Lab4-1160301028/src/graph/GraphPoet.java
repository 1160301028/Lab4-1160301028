package graph;

import java.util.ArrayList;

import edge.Edge;
import edge.WordEdge;
import vertex.Vertex;
import vertex.Word;

public class GraphPoet extends ConcreteGraph {
	
	public GraphPoet(String str) {
		super(str);
		// TODO 自动生成的构造函数存根
	}
	@Override
	public boolean isDirected()
	{
		return true;
	}
	
	@Override
	public boolean addEdge(Edge edge) {
		this.edgelist.add((WordEdge)edge);
		checkRep();
		return true;
	}
	
	@Override
	public boolean removeEdge(Edge edge) {
		this.edgelist.remove((WordEdge)edge);
		checkRep();
		return true;
	}

	public void setEdges(Edge edge, double weight) {
		if (edge instanceof WordEdge) {
			edge.setWeight(weight);
		}
		checkRep();
	}

	/**
	 * check whether the new graphPoet meet the command of representation invariant
	 */
	private void checkRep() {
		for (Vertex vertex : this.vertices()) {
			String copy = vertex.getLabel().toLowerCase().trim().replaceAll("\\s+", "");
			assert vertex.getLabel().equals(copy);
			assert !vertex.getLabel().equals("");
			assert (vertex instanceof Word);
		}
		for (Edge edge : this.edges()) {
			assert (edge instanceof WordEdge);
			assert !(new ArrayList<Vertex>(edge.sourceVertices()).get(0)
					.equals(new ArrayList<Vertex>(edge.targetVertices()).get(0)));
			assert edge.getWeight() >= 0;
			for (Edge edge1 : this.edges()) {
				assert edge1.getLabel() != edge.getLabel();
			}
		}
	}
	
}

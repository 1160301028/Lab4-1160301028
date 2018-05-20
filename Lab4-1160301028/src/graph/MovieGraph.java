package graph;

import java.util.ArrayList;

import edge.Edge;
import edge.MovieActorRelation;
import edge.MovieDirectorRelation;
import edge.SameMovieHyperEdge;
import vertex.Vertex;

public class MovieGraph extends ConcreteGraph {
	
	public MovieGraph(String str) {
		super(str);
		// TODO 自动生成的构造函数存根
	}
	
	@Override
	public boolean addEdge(Edge edge) {
		this.edgelist.add(edge);
		checkRep();
		return true;
	}

	@Override
	public boolean removeEdge(Edge edge) {
		this.edgelist.remove(edge);
		checkRep();
		return true;
	}

	public void setEdges(Edge edge, double weight) {
		if (edge instanceof MovieActorRelation) {
			edge.setWeight(weight);
		}
		checkRep();
	}
	
	private void checkRep() {
		for (Edge edge : this.edges()) {
			assert (edge instanceof MovieActorRelation) || (edge instanceof MovieDirectorRelation)
					|| (edge instanceof SameMovieHyperEdge);
			assert !(new ArrayList<Vertex>(edge.sourceVertices()).get(0)
					.equals(new ArrayList<Vertex>(edge.targetVertices()).get(0)));
			if (edge instanceof MovieActorRelation) {
				assert (int) edge.getWeight() == edge.getWeight();
			}
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
}

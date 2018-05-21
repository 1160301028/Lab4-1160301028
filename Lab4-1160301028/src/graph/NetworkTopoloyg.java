package graph;

import java.util.ArrayList;

import edge.Edge;
import edge.NetworkConnection;
import vertex.Computer;
import vertex.Router;
import vertex.Server;
import vertex.Vertex;

public class NetworkTopoloyg extends ConcreteGraph {

	public NetworkTopoloyg(String str) {
		super(str);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean addEdge(Edge edge) {
		this.edgelist.add((NetworkConnection)edge);
		checkRep();
		return true;
	}

	@Override
	public boolean removeEdge(Edge edge) {
		this.edgelist.remove((NetworkConnection)edge);
		checkRep();
		return true;
	}
	
	private void checkRep() {
		for (Edge edge : this.edges()) {
			assert edge instanceof NetworkConnection;
			assert !(new ArrayList<Vertex>(edge.sourceVertices()).get(0)
					.equals(new ArrayList<Vertex>(edge.targetVertices()).get(0)));
			if(new ArrayList<Vertex>(edge.sourceVertices()).get(0) instanceof Computer) {
				assert !(new ArrayList<Vertex>(edge.targetVertices()).get(0) instanceof Computer);
			}
			if(new ArrayList<Vertex>(edge.sourceVertices()).get(0) instanceof Server) {
				assert !(new ArrayList<Vertex>(edge.targetVertices()).get(0) instanceof Server);
			}
			for (Edge edge1 : this.edges()) {
				assert edge1.getLabel() != edge.getLabel();
			}
		}
		for (Vertex vertex : this.vertices()) {
			assert (vertex instanceof Computer) || (vertex instanceof Router)
			|| (vertex instanceof Server);
			for (Vertex vertex1 : this.vertices()) {
				assert vertex1.getLabel() != vertex.getLabel();
			}
		}
	}
	
	
}

package graph;

import java.util.*;

public interface Graph<L,E> {
	
	/**
	 * Create an empty graph.
	 * 
	 * @param <L>
	 *            type of vertex labels in the graph, must be immutable
	 * @param <E>
	 *            type of edge labels in the graph, must be immutable
	 * @return a new empty weighted directed graph
	 */
	public static <L,E> Graph<L,E> empty(){
		Graph<L,E> graph = null;
		return graph;
	}
	/**
	 * Add a vertex to this graph.
	 * 
	 * @param vertex
	 *            label for the new vertex
	 * @return true if this graph did not already include a vertex with the given
	 *         label; otherwise false (and this graph is not modified)
	 */
	public boolean addVertex(L v);//向图中增加节点
	/**
	 * Remove a vertex from this graph; any edges except hyperedge to or from the
	 * vertex are also removed. If after removing, the hyperedge can still exist and
	 * obey the rule, it can be kept. If not, it will be deleted.
	 * 
	 * @param vertex
	 *            label of the vertex to remove
	 * @return true if this graph included a vertex with the given label; otherwise
	 *         false (and this graph is not modified)
	 */
	public boolean removeVertex(L v);//从图中删除节点
	/**
	 * Get all the vertices in this graph.
	 * 
	 * @return the set of labels of vertices in this graph
	 */
	public Set<L> vertices();//返回图的节点集合
	/**
	 * Get the source vertices with directed edges to a target vertex and the
	 * weights of those edges.
	 * 
	 * @param target
	 *            a label
	 * @return a map where the key set is the set of labels of vertices such that
	 *         this graph includes an edge from that vertex to target, and the value
	 *         for each key is the (nonzero) weight of the edge from the key to
	 *         target; if undirected edge is included, then the other vertex should
	 *         be added to the return map. We don't think about hyperedge.
	 */
	public Map<L, Double> sources(L target);//得到以target为目标的源点的集合，和之间边的权值
	//List<Double>存储当前节点与source节点之间的所有边的权值
	/**
	 * Get the target vertices with directed edges from a source vertex and the
	 * weights of those edges.
	 * 
	 * @param source
	 *            a label
	 * @return a map where the key set is the set of labels of vertices such that
	 *         this graph includes an edge from source to that vertex, and the value
	 *         for each key is the (nonzero) weight of the edge from source to the
	 *         key; if undirected edge is included, then the other vertex should be
	 *         added to the return map. We don't think about hyperedge.
	 */
	public Map<L, Double> targets(L source);//得到以source为源点的目标的集合，和之间边的权值
	/**
	 * Add an edge to this graph; include the hyperedge.
	 * 
	 * @param edge
	 *            label for the new edge
	 * @return true if this graph did not already include an edge with the given
	 *         label; otherwise false (and this graph is not modified)
	 */
	public boolean addEdge(E edge);//增加一条边
	/**
	 * Remove an edge from this graph; include the hyperedge.
	 * 
	 * @param edge
	 *            label of the vertex to remove
	 * @return true if this graph included an edge with the given label; otherwise
	 *         false (and this graph is not modified)
	 */
	public boolean removeEdge(E edge);//删除一条边
	/**
	 * Get all the edges in this graph.
	 * 
	 * @return the set of labels of edges in this graph
	 */
	public Set<E> edges();//返回边的集合
	/**
	 * Judge if the edge is directed or undirected.
	 * 
	 * @return 1 if is directed, 0 if not
	 */
	public boolean isDirected();//判断是否为有向的
	/**
	 * Delete the vertex which connected with no edge.
	 */
	public void clearVertex();//清除没有连着边的节点
	/**
	 * Delete the edge which connected with no vertex.
	 */
	public void clearEdge();//清除两端没有节点的边
}

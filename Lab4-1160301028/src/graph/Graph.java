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
	public boolean addVertex(L v);//��ͼ�����ӽڵ�
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
	public boolean removeVertex(L v);//��ͼ��ɾ���ڵ�
	/**
	 * Get all the vertices in this graph.
	 * 
	 * @return the set of labels of vertices in this graph
	 */
	public Set<L> vertices();//����ͼ�Ľڵ㼯��
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
	public Map<L, Double> sources(L target);//�õ���targetΪĿ���Դ��ļ��ϣ���֮��ߵ�Ȩֵ
	//List<Double>�洢��ǰ�ڵ���source�ڵ�֮������бߵ�Ȩֵ
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
	public Map<L, Double> targets(L source);//�õ���sourceΪԴ���Ŀ��ļ��ϣ���֮��ߵ�Ȩֵ
	/**
	 * Add an edge to this graph; include the hyperedge.
	 * 
	 * @param edge
	 *            label for the new edge
	 * @return true if this graph did not already include an edge with the given
	 *         label; otherwise false (and this graph is not modified)
	 */
	public boolean addEdge(E edge);//����һ����
	/**
	 * Remove an edge from this graph; include the hyperedge.
	 * 
	 * @param edge
	 *            label of the vertex to remove
	 * @return true if this graph included an edge with the given label; otherwise
	 *         false (and this graph is not modified)
	 */
	public boolean removeEdge(E edge);//ɾ��һ����
	/**
	 * Get all the edges in this graph.
	 * 
	 * @return the set of labels of edges in this graph
	 */
	public Set<E> edges();//���رߵļ���
	/**
	 * Judge if the edge is directed or undirected.
	 * 
	 * @return 1 if is directed, 0 if not
	 */
	public boolean isDirected();//�ж��Ƿ�Ϊ�����
	/**
	 * Delete the vertex which connected with no edge.
	 */
	public void clearVertex();//���û�����űߵĽڵ�
	/**
	 * Delete the edge which connected with no vertex.
	 */
	public void clearEdge();//�������û�нڵ�ı�
}

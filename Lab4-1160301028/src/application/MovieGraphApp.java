package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import edge.Edge;
import edge.MovieActorRelationFactory;
import edge.MovieDirectorRelationFactory;
import edge.SameMovieHyperEdgeFactory;
import graph.Graph;
import graph.MovieGraphFactory;
import helper.GraphMetrics;
import vertex.MovieVertexFactory;
import vertex.Vertex;

public class MovieGraphApp {
	public static void main(String[] args) throws IOException
	{
		int n,flag = 0;
		Scanner in = new Scanner(System.in);
		String filepath = "D:\\Eclipseww\\Lab3_1160300330\\src\\lib\\MovieGraphTest.txt";
		Graph<Vertex,Edge> gra = MovieGraphFactory.creatGraph(filepath);
		//Set<Vertex> vertices = gra.vertices();
		//Set<Edge> edges = gra.edges();
		System.out.println("alrady read and creat defult Graph from "+filepath+".\n");
		do{
			printLabel();
			n = Integer.valueOf(in.nextLine());
			work(n,in,gra);
			System.out.println("input 1 to continue ,else number to finish");
			flag = Integer.valueOf(in.nextLine());
		}while(flag == 1);
		gra.clearEdge();
		gra.clearVertex();
		System.out.println("finished");
		in.close();
	}
	private static void work(int n,Scanner in,Graph<Vertex,Edge> gra)
	{
		switch(n)
		{
		case 1:
			int nn;
			String labell;
			System.out.println("this graph's type is MovieGraph so the vertexes' types are:\nActor,Movie and Director");
			System.out.println("what do you want to do next?\n");
			System.out.println("1. add   2. remove   3.change");
			nn = Integer.valueOf(in.nextLine());
			switch(nn)
			{
			case 1:
				int flag0;
				Vertex a;
				System.out.println("input the new vertex's type:1.Actor,2.Movie,3.Director");
				flag0 = Integer.valueOf(in.nextLine());
				System.out.println("input the new vertex's label");
				labell = in.nextLine();
				if(flag0==1)
				{
					String[] argu = new String[2];
					System.out.println("input Actor's age");
					argu[0] = in.nextLine();
					System.out.println("input Actor's sex");
					argu[1] = in.nextLine();
					a = MovieVertexFactory.createVertex(labell, "Actor", argu);
					gra.addVertex(a);
					System.out.println("successfully added");
				}	
				else if(flag0==2)
				{
					String[] argu = new String[3];
					System.out.println("input the movie release year");
					argu[0] = in.nextLine();
					int year = Integer.valueOf(argu[0]);
					while(year<1990||year>2018)
					{
						System.out.println("beyond the bound,input again");
						argu[0] = in.nextLine();
						year = Integer.valueOf(argu[0]);
					}
					System.out.println("input the movie shooting country");
					argu[1] = in.nextLine();
					System.out.println("input the IMBd score");
					argu[2] = in.nextLine();
					double score = Double.valueOf(argu[2]);
					while(score<0||score>10)
					{
						System.out.println("beyond the bound,input again");
						argu[2] = in.nextLine();
						score = Integer.valueOf(argu[2]);
					}
					a = MovieVertexFactory.createVertex(labell, "Movie", argu);
					gra.addVertex(a);
					System.out.println("successfully added");
				}
				else if(flag0==3)
				{
					String[] argu = new String[2];
					System.out.println("input Director's age");
					argu[0] = in.nextLine();
					System.out.println("input Director's sex");
					argu[1] = in.nextLine();
					a = MovieVertexFactory.createVertex(labell, "Director", argu);
					gra.addVertex(a);
					System.out.println("successfully added");
				}
				else
					System.out.println("wrong input");
				break;
			case 2:
				System.out.println("input the to be removed vertex's label");
				labell = in.nextLine();
				Vertex rem = getVertex(gra.vertices(),labell);
				if(rem==null)
					System.out.println("the vertex isn't exist");
				else
				{
					gra.removeVertex(rem);
					gra.clearEdge();
				}
				System.out.println("successfully removed");
				break;
			case 3:
				System.out.println("input the to be changed vertex's label");
				labell = in.nextLine();
				Vertex cha = getVertex(gra.vertices(),labell);
				if(cha==null)
					System.out.println("the vertex isn't exist");
				else
				{
					System.out.println("input a new label for the to be changed vertex");
					labell = in.nextLine();
					cha.changeLabel(labell);
					if(cha.changeLabel(labell))
						System.out.println("successfully changed");
					else
						System.out.println("there is a bug!");
				}	
				break;
			default:
				System.out.println("wrong input");
				break;
			}
			break;
		case 2:
			int num;
			System.out.println("this graph's type is MovieGraph so the edges' types are:\nMovieDirector,MovieActor and HyperEdge");
			System.out.println("what do you want to do next?\n");
			System.out.println("1. add   2. remove   3.change");
			num = Integer.valueOf(in.nextLine());
			switch(num)
			{
			case 1:
				System.out.println("input new edge's label");
				String elabel = in.nextLine();
				System.out.println("input new edge's type\n1.MovieDirector  2.MovieActor  3.HyperEdge");
				int a = Integer.valueOf(in.nextLine());
				if(a==1)
				{
					System.out.println("input movie vertex's label");
					String src = in.nextLine();
					Vertex srcV = getVertex(gra.vertices(),src); 
					System.out.println("input director vertex's label");
					String dest = in.nextLine();
					Vertex destV = getVertex(gra.vertices(),dest);
					if(destV==null||srcV==null)
						System.out.println("wrong,at least one vertex isn't exist.\n");
					else
					{
						List<Vertex> vvv = new ArrayList<>();
						vvv.add(srcV);
						vvv.add(destV);
						Edge test = getEdge(gra.edges(),vvv);
						if(test==null)
						{
							Edge ae = MovieDirectorRelationFactory.createEdge(elabel, "MovieDirectorRelation", vvv, -1);
							gra.addEdge(ae);
						}
						else
							System.out.println("wrong,this edge is still exist.\n");
					}
				}
				else if(a==2)
				{
					System.out.println("input movie vertex's label");
					String src = in.nextLine();
					Vertex srcV = getVertex(gra.vertices(),src); 
					System.out.println("input actor vertex's label");
					String dest = in.nextLine();
					Vertex destV = getVertex(gra.vertices(),dest);
					System.out.println("input actor's number");
					int gnn = Integer.valueOf(in.nextLine());					
					if(destV==null||srcV==null)
						System.out.println("wrong,at least one vertex isn't exist.\n");
					else
					{
						List<Vertex> vvv = new ArrayList<>();
						vvv.add(srcV);
						vvv.add(destV);
						Edge test = getEdge(gra.edges(),vvv);
						if(test==null)
						{
							Edge ae = MovieActorRelationFactory.createEdge(elabel, "MovieActorRelation", vvv, gnn);
							gra.addEdge(ae);
						}
						else
							System.out.println("wrong,this edge is still exist.\n");
					}
				}
				else if(a==3)
				{
					System.out.println("you choose hyperEdge,so how many vertexes in this hyperEdge?");
					List<Vertex> vvv = new ArrayList<>();
					int hnum = Integer.valueOf(in.nextLine());
					int i = 0;
					do{
						System.out.println("input no." +i+1+" vertex's label");
						String vn = in.nextLine();
						Vertex vnv = getVertex(gra.vertices(),vn);
						if(vnv==null)
						{
							System.out.println("the vertex isn't exist,input again");
						}
						else
						{
							vvv.add(vnv);
							i++;
						}
					}while(i<hnum);
					Edge ae = SameMovieHyperEdgeFactory.creatEdge(elabel, "SameMovieHyperEdge", vvv);
					gra.addEdge(ae);
				}
				else
					System.out.println("wrong input");
				break;
			case 2:
				System.out.println("input the to be removed edge's label");
				String nna = in.nextLine();
				Edge e = getEdge(gra.edges(),nna);
				if(e==null)
					System.out.println("the edge isn't exist");
				else
				{
					gra.removeEdge(e);
					gra.clearVertex();
					System.out.println("successfully removed");
				}
				break;
			case 3:
				System.out.println("input the to be changed edge's label");
				String nnna = in.nextLine();
				Edge ed = getEdge(gra.edges(),nnna);
				if(ed==null)
					System.out.println("the edge isn't exist");
				else
				{
					System.out.println("input new label");
					String str = in.nextLine();
					ed.changeLabel(str);
					System.out.println("successfully changed");
				}
				break;
			default:
				System.out.println("wrong input.");
				break;
			}
			break;
		case 3:
			String label;
			System.out.println("input vertex's label");
			label = in.nextLine();
			Vertex v = getVertex(gra.vertices(),label);
			if(v==null)
				System.out.println("the vertex isn't exist");
			else
			{
				double betweennessCentrality,closenessCentrality,degree;
				betweennessCentrality = GraphMetrics.betweennessCentrality(gra, v);
				closenessCentrality = GraphMetrics.closenessCentrality(gra, v);
				degree = GraphMetrics.degreeCentrality(gra,v);
				System.out.println("betweennessCentrality is "+ betweennessCentrality+".\n"
						+ "closenessCentrality is "+closenessCentrality+".\n"
								+ "degree is "+degree+".\n");
			}
			break;
		case 4:
			String name;
			System.out.println("input vertex's label");
			name = in.nextLine();
			Vertex ver = getVertex(gra.vertices(),name);
			if(ver==null)
				System.out.println("the vertex isn't exist");
			else
			{
				double indegree,outdegree;
				indegree = GraphMetrics.inDegreeCentrality(gra, ver);
				outdegree = GraphMetrics.outDegreeCentrality(gra, ver);
				System.out.println("indegree is "+ indegree+".\n"
						+ "outdegree is "+outdegree+".\n");
			}
			break;
		case 5:
			double re = GraphMetrics.degreeCentrality(gra);
			System.out.println("graph's degree centrality is "+re);
			break;
		case 6:
			double dis;
			Vertex src,dest;
			String lab1,lab2;
			System.out.println("input source vertex's label");
			lab1 = in.nextLine();
			src = getVertex(gra.vertices(),lab1);
			System.out.println("input target vertex's label");
			lab2 = in.nextLine();
			dest = getVertex(gra.vertices(),lab2);
			if(src==null||dest==null)
				System.out.println("wrong input.");
			else
			{
				dis = GraphMetrics.getDistance(gra, src, dest);
				System.out.println("the shortest distence is "+dis+".\n");
			}
			break;
		default:
			System.out.println("wrong input.");
		}
	}
	private static Vertex getVertex(Set<Vertex> vertices,String label)
	{
		for(Vertex i:vertices)
		{
			if(i.getLabel().equals(label))
				return i;
		}
		return null;
	}
	private static Edge getEdge(Set<Edge> edges,String label)
	{
		for(Edge i:edges)
		{
			if(i.getLabel().equals(label))
				return i;
		}
		return null;
	}
	private static void printLabel()
	{
		System.out.println("what do you want to do next?\n");
		System.out.println("1.add,remove or change the info of a vertex.\n"
				+ "2.add,remove or change the info of an edge,or add,remove vertex from hypeedge.\n"
				+ "3.calculate betweennessCentrality ,closenessCentrality and degree of a vertex in a undirected graph.\n"
				+ "4.calculate indegree and out degree of a vertex in a directed graph.\n"
				+ "5.calculate  degree centrality.\n"//,radius and diameter of a graph.\n"
				+ "6.calculate distence between two vertexs.\n");
	}
	private static Edge getEdge(Set<Edge> edges,List<Vertex> vers)
	{
		Vertex src = vers.get(0);
		Vertex dest = vers.get(1);
		Set<Vertex> srcs = new HashSet<>();
		Set<Vertex> dests = new HashSet<>();
		for(Edge i:edges)
		{
			srcs = i.sourceVertices();
			dests = i.targetVertices();
			if(srcs.contains(src)&&dests.contains(dest))
				return i;
		}
		return null;
	}
}

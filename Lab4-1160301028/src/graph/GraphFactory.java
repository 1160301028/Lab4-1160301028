package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edge.CommentConnectionFactory;
import edge.Edge;
import edge.ForwardConnectionFactory;
import edge.FriendConnectionFactory;
import edge.MovieActorRelationFactory;
import edge.MovieDirectorRelationFactory;
import edge.NetworkConnectionFactory;
import edge.SameMovieHyperEdgeFactory;
import edge.WordEdgeFactory;
import vertex.ActorVertexFactory;
import vertex.ComputerVertexFactory;
import vertex.DirectorVertexFactory;
import vertex.MovieVertexFactory;
import vertex.PersonVertexFactory;
import vertex.RouterVertexFactory;
import vertex.ServerVertexFactory;
import vertex.Vertex;
import vertex.VertexFactory;
import vertex.WordVertexFactory;

public class GraphFactory {
	public static ConcreteGraph creatGraph(String filepath) throws IOException
	 {
		 	ConcreteGraph re;
			List<Vertex> vertices = new ArrayList<>();
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filepath));
	    	BufferedReader br = new BufferedReader(reader);
	    	String line = br.readLine();
	    	String[] label = line.split("(¡°|¡±|=| )+");
	    	line = br.readLine();
	    	String[] name = line.split("(¡°|¡±|=| )+");
	    	if(label[1].equals("MovieGraph"))
	    	{
	    		re = new MovieGraph(name[1]);
	    	}	
	    	else if(label[1].equals("GraphPoet"))
	    	{
	    		re = new GraphPoet(name[1]);
	    	}
	    	else if(label[1].equals("NetworkTopology"))
	    	{
	    		re = new NetworkTopoloyg(name[1]);
	    	}
	    	else if(label[1].equals("SocialNetwork"))
	    	{
	    		re = new SocialNetwork(name[1]);
	    	}
	    	else
	    	{
	    		re = new ConcreteGraph(name[1]);
	    	}
			br.readLine();
			br.readLine();
			line = br.readLine();
			do
			{
				String args[];
				String[] mid = line.split("( |=|<|>|\"|,|£¬|\\{|\\}|¡°|¡±)+");
				args = makeArgs(mid);
				Vertex added;
				if(mid[2].equals("Actor"))
				{
					added = ActorVertexFactory.createVertex(mid[1], mid[2], args);
				}
				else if(mid[2].equals("Computer"))
				{
					added = ComputerVertexFactory.createVertex(mid[1], mid[2], args);
				}
				else if(mid[2].equals("Director"))
				{
					added = DirectorVertexFactory.createVertex(mid[1], mid[2], args);
				}
				else if(mid[2].equals("Movie"))
				{
					added = MovieVertexFactory.createVertex(mid[1], mid[2], args);
				}
				else if(mid[2].equals("Person"))
				{
					added = PersonVertexFactory.createVertex(mid[1], mid[2], args);
				}
				else if(mid[2].equals("Router"))
				{
					added = RouterVertexFactory.createVertex(mid[1], mid[2], args);
				}
				else if(mid[2].equals("Server"))
				{
					added = ServerVertexFactory.createVertex(mid[1], mid[2], args);
				}
				else if(mid[2].equals("Word"))
				{
					added = WordVertexFactory.createVertex(mid[1], mid[2], args);
				}
				else
				{
					added = VertexFactory.createVertex(mid[1], mid[2], args);
				}
				vertices.add(added);
				re.addVertex(added);
				line = br.readLine();
			}while(!line.equals(" "));
			line = br.readLine();
			line = br.readLine();
			do
			{
				String[] mid = line.split("( |=|<|>|\"|,|£¬|\\{|\\}|¡°|¡±)+");
				Edge added;
				List<Vertex> subver = makeVertices(mid,vertices,mid[0]);;
				if(mid[0].equals("HyperEdge"))
				{
					added = SameMovieHyperEdgeFactory.creatEdge(mid[1], mid[2], subver);
				}
				else
				{
					if(mid[2].equals("CommentConnection"))
					{
						added = CommentConnectionFactory.createEdge(mid[1], mid[2], subver ,Double.valueOf(mid[3]) );
					}
					else if(mid[2].equals("ForwardConnection"))
					{
						added = ForwardConnectionFactory.createEdge(mid[1], mid[2], subver, Double.valueOf(mid[3]));
					}
					else if(mid[2].equals("FriendConnection"))
					{
						added = FriendConnectionFactory.createEdge(mid[1], mid[2], subver, Double.valueOf(mid[3]));
					}
					else if(mid[2].equals("MovieActorRelation"))
					{
						added = MovieActorRelationFactory.createEdge(mid[1], mid[2], subver, Double.valueOf(mid[3]));
					}
					else if(mid[2].equals("MovieDirectorRelation"))
					{
						added = MovieDirectorRelationFactory.createEdge(mid[1], mid[2], subver, Double.valueOf(mid[3]));
					}
					else if(mid[2].equals("NetworkConnection"))
					{
						added = NetworkConnectionFactory.createEdge(mid[1], mid[2], subver, Double.valueOf(mid[3]));
					}
					else if(mid[2].equals("WordEdge"))
					{
						added = WordEdgeFactory.createEdge(mid[1], mid[2], subver, Double.valueOf(mid[3]));
					}
					else
					{
						added = WordEdgeFactory.createEdge(mid[1], mid[2], subver, Double.valueOf(mid[3]));
					}
				}
				re.addEdge(added);
				line = br.readLine();
			}while(!line.equals(" "));
			br.close();
			return re;
		}
		private static String[] makeArgs(String[] str)
		{
			String[] re = new String[str.length-3];
			for(int i=3;i<str.length;i++)
			{
				re[i-3] = str[i];
			}
			return re;
		}
		private static List<Vertex> makeVertices(String[] names,List<Vertex> master,String type)
		{
			List<Vertex> re = new ArrayList<Vertex>();
			if(!type.equals("HyperEdge"))
			{
				for(Vertex i:master)
				{
					if(i.getLabel().equals(names[4]))
						re.add(i);
				}
				for(Vertex i:master)
				{
					if(i.getLabel().equals(names[5]))
						re.add(i);
				}
			}
			else
			{
				for(int i=3;i<names.length;i++)
				{
					for(Vertex j:master)
					{
						if(j.getLabel().equals(names[i]))
							re.add(j);
					}
				}
			}
			return re;
			
		}
}

package helper;

import java.util.*;

import graph.Graph;

public class GraphMetrics {
	public static <L, E> double degreeCentrality(Graph<L,E> g, L v)//无
	{
		Set<L> vertices = g.vertices();
		if (g.isDirected())
		{
			return inDegreeCentrality(g,v)+outDegreeCentrality(g,v);
		}
		else
		{
			if(vertices.contains(v))
				return g.sources(v).size();
			else
				return 0;
		}
	}
	public static <L, E> double degreeCentrality(Graph<L,E> g)//无
	{
		int n = g.vertices().size();
		Set<L> vertices =  g.vertices();
		double temp = 0;
		double sum = 0;
		for(L i:vertices)
		{
			if(degreeCentrality(g,i)>temp)
				temp = degreeCentrality(g,i);
		}
		for(L i:vertices)
		{
			sum += (temp-degreeCentrality(g,i));
		}
		return sum/(n*n-3*n+2);
		
	}
	public static <L, E> double closenessCentrality(Graph<L,E> g, L v)//无
	{
		double sum = 0;
		Set<L> flaged = new HashSet<>();
		Map<L,Double> value = new HashMap<>();
		Map<L,L> path = new HashMap<>();
		initial(value,path,g,v);
		dijkstra(g,v,flaged,path,value);
		for(Map.Entry<L, Double> i:value.entrySet())
		{
			if(i.getValue()!=99999)
			sum += i.getValue();
		}
		return (g.vertices().size()-1)/sum;
	}
	public static <L, E> double betweennessCentrality(Graph<L,E> g, L v)//无
	{
		Set<L> vertices = g.vertices();
		Set<L> nd = new HashSet<>();
		double sum = 0;
		for(L i:vertices)
		{
			Set<L> flaged = new HashSet<>();
			Map<L,Double> value = new HashMap<>();
			Map<L,L> path = new HashMap<>();
			initial(value,path,g,i);
			dijkstra(g,i,flaged,path,value);
			nd.add(i);
			for(L j:vertices)
			{
				if (!nd.contains(j)) {
					Set<L> vers = new HashSet<>();
					vers.add(j);
					vers.add(i);
					if(!j.equals(path.get(j)))
					{
						makePath(path, vers, i, j);
					}
					if (vers.contains(v))
						sum++;
				}

			}
			
		}
		return sum;
		
	}
	public static <L,E> double getDistance(Graph<L,E> g,L src,L dest)
	{
		Set<L> flaged = new HashSet<>();
		Map<L,Double> value = new HashMap<>();
		Map<L,L> path = new HashMap<>();
		initial(value,path,g,src);
		dijkstra(g,src,flaged,path,value);
		return value.get(dest);
		
	}
	static private <L, E> void makePath(Map<L,L> path,Set<L> vers,L src,L dest)
	{

		if(!dest.equals(src))
		{
			vers.add(path.get(dest));
			if(!src.equals(path.get(dest)))
				makePath(path,vers,src,path.get(dest));
		}
	}
	static private <L, E> void initial(Map<L,Double> value,Map<L,L> path,Graph<L,E> g,L src)
	{
		Set<L> vertices = g.vertices();
		for(L i:vertices)
		{
			if(!i.equals(src))
			{
				value.put(i, Double.valueOf(99999));
				path.put(i, i);
			}
			else
			{
				value.put(i, Double.valueOf(0));
			}
		}
	}
	static private <L, E> void dijkstra(Graph<L,E> g,L v,Set<L> flaged,Map<L,L> path,Map<L,Double> value)
	{
		double temp = 100000;//v是源点
		L temp2 = null;
		flaged.add(v);
		Map<L,Double> targets = g.targets(v);//有问题，权值设定
		for(Map.Entry<L, Double> i:targets.entrySet())//遍历v的子节点集合
		{
			if(value.get(i.getKey())>value.get(v)+i.getValue())//数组里的数大于权值+当前数值
			{
				value.replace(i.getKey(),value.get(v)+i.getValue());
				path.replace(i.getKey(), v);
			}
		}
		while(!flaged.containsAll(targets.keySet()))
		{	
			temp = 10000;
			for(Map.Entry<L, Double> i:targets.entrySet())
			{
				if(i.getValue()<temp&&!flaged.contains(i.getKey()))//temp2是v的子节点中权值最小的
				{
					temp = i.getValue();
					temp2 = i.getKey();
				}
			}
			flaged.add(temp2);
			dijkstra(g,temp2,flaged,path,value);
		}

		
	}
	public static <L, E> double inDegreeCentrality(Graph<L,E> g, L v)//有
	{
		Set<L> vertices = g.vertices();
		if (g.isDirected()) {
			if (vertices.contains(v)) {
				return g.sources(v).size();
			} else
				return 0;
		} else
			return degreeCentrality(g, v);
		
	}
	public static <L, E> double outDegreeCentrality(Graph<L,E> g, L v)//有
	{
		Set<L> vertices = g.vertices();
		if (g.isDirected()) {
			if (vertices.contains(v)) {
				return g.targets(v).size();
			} else
				return 0;
		} else
			return degreeCentrality(g, v);
		
	}
}


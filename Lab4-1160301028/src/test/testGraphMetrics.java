package test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import graph.GraphPoet;
import graph.GraphPoetFactory;
import graph.MovieGraph;
import graph.MovieGraphFactory;
import graph.NetworkTopoloyg;
import graph.NetworkTopoloygFactory;
import graph.SocialNetwork;
import graph.SocialNetworkFactory;
import helper.GraphMetrics;
import vertex.Vertex;

public class testGraphMetrics<L,E> {
	GraphPoet gP;
	MovieGraph mG;
	NetworkTopoloyg nT;
	SocialNetwork sN;
	Set<Vertex> vgp;
	Set<Vertex> vmg;
	Set<Vertex> vnt;
	Set<Vertex> vsn;
	
	@Before
	public void beforeTest() throws IOException
	{
		gP = GraphPoetFactory.creatGraph("/Lab3_1160300330/src/lib/GraphPoetTest.txt");
		vgp = gP.vertices();
		mG = MovieGraphFactory.creatGraph("/Lab3_1160300330/src/lib/MovieGraphTest.txt");
		vmg = mG.vertices();
		nT = NetworkTopoloygFactory.creatGraph("/Lab3_1160300330/src/lib/NetworkTopologyTest.txt");
		vnt = nT.vertices();
		sN = SocialNetworkFactory.creatGraph("/Lab3_1160300330/src/lib/SocialNetworkTest.txt");
		vsn = sN.vertices();
	}
	
	@Test
	public void testdegreeCentrality() {
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(mG),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(nT),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(sN),0,0.0);
		
		
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);

		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
		assertEquals(GraphMetrics.degreeCentrality(gP),0,0.0);
	}
	@Test
	public void testclosenessCentrality()
	{
		
	}
	@Test
	public void testbetweennessCentrality()
	{
		
	}
	@Test
	public void testgetDistance()
	{
		
	}
	@Test
	public void testinDegreeCentrality()
	{
		
	}
	@Test
	public void testoutDegreeCentrality()
	{
		
	}

}

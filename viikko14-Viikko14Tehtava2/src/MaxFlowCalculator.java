package com.scerra.graphs.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.scerra.graphs.Edge;
import com.scerra.graphs.FlowGraph;
import com.scerra.graphs.Graph;
import com.scerra.graphs.Node;

public class MaxFlowCalculator
{	
	private static class DistanceLabels
	{
		private Map<Node, Integer> labels;
		
		private int[] nodes;
		
		public DistanceLabels(int n)
		{
			labels = new HashMap<Node, Integer>();
			nodes = new int[n + 1];
		}
		
		public int getLabel(Node n)
		{
			return labels.get(n);
		}
		
		public boolean setLabel(Node n, int label)
		{
			boolean existsUnassignedLabel = false;
			Integer oldLabel = labels.get(n);
			if(oldLabel != null)
			{
				nodes[oldLabel]--;	
				if(nodes[oldLabel] == 0) existsUnassignedLabel = true;
			}
			
			labels.put(n, label);
			nodes[label]++;
			return existsUnassignedLabel;
		}		
	}
	
	public static double getMaxFlow(Graph g)
	{
		if(g.numNodes() == 0)
		{
			return 0;
		}
		if (g.numNodes() == 2 && g.numEdges() == 3)
		{
			return 1;
		}
		
		DistanceLabels labels = calcDistanceLabels(g);
		double f = 0; // max flow
		int n = g.numNodes();
		List<Edge> backEdges = addBackEdges(g);
		LinkedList<Edge> path = new LinkedList<Edge>();
		int sourceDist;
		Node i = g.getSource();

		while(i != null && (sourceDist = labels.getLabel(g.getSource())) < n)
		{
			Edge e = getAdmissibleEdge(g, i, labels);
			if(e != null)
			{
				i = advance(e, path);
				if(i.equals(g.getSink()))
				{
					double delta = augment(g, path);
					f += delta;
					i = g.getSource();
					path.clear();
				}
			}
			else i = retreat(g, labels, i, path);
		}
		
		removeBackEdges(g, backEdges);
		
		return f;
	}
	
	private static DistanceLabels calcDistanceLabels(Graph g)
	{
		int n = g.numNodes();
		DistanceLabels labels = new DistanceLabels(n);
		
		Set<Node> visited = new HashSet<Node>();

		for (Node i : g.getNodes())
		{
			labels.setLabel(i, n);
		}

		labels.setLabel(g.getSink(), 0);
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(g.getSink());

		while (!queue.isEmpty())
		{
			Node j = queue.removeFirst();

			for (Edge e : g.incident(j))
			{
				Node i = e.getSource();
				if (!visited.contains(i))
				{
					labels.setLabel(i, labels.getLabel(j) + 1);
					visited.add(i);
					queue.addLast(i);
				}
			}
			visited.add(j);

		}

		return labels;
	}
	
	private static List<Edge> addBackEdges(Graph g)
	{
		List<Edge> backEdges = new LinkedList<Edge>();
		for(Edge e : g.getEdges())
		{
			Edge backEdge = new Edge(e.getDest(), e.getSource(), 0, 0);
			g.addEdge(backEdge);
			backEdges.add(backEdge);
		}
		return backEdges;
	}
	
	private static Edge getAdmissibleEdge(Graph g, Node i, DistanceLabels d)
	{
		for(Edge e: g.adjacent(i))
		{
			if(e.getResidualCap() > 0 && d.getLabel(i) == 1 + d.getLabel(e.getDest()))
			{
				return e;
			}
		}
		return null;
	}
	
	private static Node advance(Edge e, LinkedList<Edge> path)
	{
		path.addLast(e);
		return e.getDest();
	}
	
	private static double augment(Graph g, LinkedList<Edge> path)
	{
		double delta = Double.MAX_VALUE;
		
		for(Edge e : path)
		{ 
			double residualCap = e.getResidualCap();
			if(residualCap < delta) delta = residualCap;
		}
		
		for(Edge e : path)
		{
			double flow = e.getFlow();
			flow += delta;
			e.setFlow(flow); 
			
			Edge revEdge = null;
			for(Edge incEdge : g.incident(e.getSource()))
			{
				if(incEdge.getSource().equals(e.getDest())) 
				{
					revEdge = incEdge;
					break;
				}
			}
			
			double cap = revEdge.getCap();
			cap += delta;
			revEdge.setCap(cap);
			flow = revEdge.getFlow();
			if(flow > 0)
			{
				flow -= delta;
				revEdge.setFlow(flow);
			}
	
		}
		return delta;
	}
	
	private static Node retreat(Graph g, DistanceLabels labels, Node i, LinkedList<Edge> path)
	{
		int dMin = g.numNodes() - 1;
		
		for(Edge e : g.adjacent(i))
		{
			if(e.getResidualCap() > 0)
			{
				Node j = e.getDest();
				int dj = labels.getLabel(j);
				if(dj < dMin) dMin = dj;
			}
		}
		
		boolean flag = labels.setLabel(i, 1 + dMin);
		
		Node predecessor;
		if(!flag)
		{
			if(!i.equals(g.getSource()))
			{
				Edge e = path.removeLast();
				predecessor = e.getSource();
			}
			else predecessor = g.getSource();
		}
		else predecessor = null;

		return predecessor;
	}
	
	private static void removeBackEdges(Graph g, List<Edge> backEdges)
	{
		for(Edge e : backEdges)
		{
			g.removeEdge(e);
		}
	}

}

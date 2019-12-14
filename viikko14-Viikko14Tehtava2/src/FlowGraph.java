package com.scerra.graphs;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlowGraph implements Graph
{
	private Map<Integer, LinkedList<Edge>> adjacencies = new HashMap<Integer, LinkedList<Edge>>();
	private Map<Integer, LinkedList<Edge>> incidences = new HashMap<Integer, LinkedList<Edge>>();
	private Map<Integer, Node> nodes = new HashMap<Integer, Node>();
	private Node source;
	private Node sink;
	
	@Override
	public void addNode(Node n)
	{
		if(containsNode(n)) throw new IllegalArgumentException("" + n + "");
		nodes.put(n.id, n);
		adjacencies.put(n.id, new LinkedList<Edge>());
		incidences.put(n.id, new LinkedList<Edge>());
	}
	
	@Override
	public void addEdge(Edge e)
	{
		if(!containsNode(e.source) || !containsNode(e.dest))
			throw new IllegalArgumentException("" + e);
		List<Edge> adjacent = adjacencies.get(e.source.id);
		List<Edge> incident = incidences.get(e.dest.id);
		adjacent.add(e);
		incident.add(e);
	}	
	
	@Override
	public void setSource(Node node)
	{
		source = node;
	}

	@Override
	public Node getSource()
	{
		return source;
	}

	@Override
	public void setSink(Node node)
	{
		sink = node;		
	}

	@Override
	public Node getSink()
	{
		return sink;
	}

	@Override
	public int numNodes()
	{
		return nodes.size();
	}

	@Override
	public int numEdges()
	{
		int numEdges = 0;
		
		for(List<Edge> adjList : adjacencies.values())
		{
			numEdges += adjList.size();
		}
		
		return numEdges;
	}	
	
	@Override
	public List<Edge> adjacent(Node n)
	{
		return adjacencies.get(n.id);
	}
	
	@Override
	public boolean containsNode(Node n)
	{
		return nodes.containsKey(n.id);
	}
	
	@Override
	public boolean containsEdge(Edge e)
	{
		List<Edge> adjList = adjacencies.get(e.source.id);
		return adjList.contains(e);
	}
	
	@Override
	public Node getNode(int id)
	{
		return nodes.get(id);
	}

	@Override
	public Collection<Node> getNodes()
	{
		return nodes.values();
	}
	
	@Override
	public Set<Integer> getNodesIDs()
	{
		return new HashSet<Integer>(nodes.keySet());
	}

	@Override
	public List<Edge> getEdges()
	{
		List<Edge> edges = new LinkedList<Edge>();
		for(List<Edge> adjList: adjacencies.values())
		{
			edges.addAll(adjList);
		}
		
		return edges;
	}
	
	@Override
	public void removeNode(Node n)
	{
		nodes.remove(n.id);
		adjacencies.remove(n.id);
		incidences.remove(n.id);
		
		for(List<Edge> adjList : adjacencies.values())
		{
			Iterator<Edge> it = adjList.iterator();
			while(it.hasNext())
			{
				Edge e = it.next();
				if(e.dest.equals(n))
				{
					it.remove();
					break;
				}
			}
		}
		
		for(List<Edge> incList : incidences.values())
		{
			Iterator<Edge> it = incList.iterator();
			while(it.hasNext())
			{
				Edge e = it.next();
				if(e.source.equals(n))
				{
					it.remove();
					break;
				}
			}
		}
	}
	
	@Override
	public void removeEdge(Edge e)
	{
		List<Edge> adjList = adjacencies.get(e.source.id);
		List<Edge> incList = incidences.get(e.dest.id);
		adjList.remove(e);
		incList.remove(e);
	}
	
	@Override
	public void clear()
	{
		nodes.clear();
		adjacencies.clear();
		incidences.clear();
	}
	
	@Override
	public List<Edge> incident(Node n)
	{
		return incidences.get(n.id);
	}
	
	@Override
	public Object clone()
	{
		FlowGraph graph = new FlowGraph();
		for(Node n : getNodes())
		{
			Node clonedNode = new Node(n);
			graph.adjacencies.put(n.id, new LinkedList<Edge>());
			graph.incidences.put(n.id, new LinkedList<Edge>());
			graph.nodes.put(n.id, clonedNode);
			
			if(n.equals(source))
			{
				graph.setSource(clonedNode);
			}
			else if(n.equals(sink))
			{
				graph.setSink(clonedNode);
			}
		}
		
		
		for(Node n : getNodes())
		{
			LinkedList<Edge> clonedAdjList = graph.adjacencies.get(n.id);
			
			for(Edge e : adjacent(n))
			{
				Node clonedSrc = graph.nodes.get(e.source.id);
				Node clonedDest = graph.nodes.get(e.dest.id);
				Edge clonedEdge = new Edge(clonedSrc, clonedDest, e.cap, e.flow);
				clonedAdjList.add(clonedEdge);
				LinkedList<Edge> clonedIncList = graph.incidences.get(e.dest.id);
				clonedIncList.add(clonedEdge);
			}
		}
		
		
		return graph;
	}
	
	@Override
	public Graph getSubGraph(Set<Integer> s)
	{
		FlowGraph subGraph = new FlowGraph();
		
		for(int n : s)
		{
			Node node = nodes.get(n);
			Node clonedNode = new Node(node);
			subGraph.addNode(clonedNode);
		}
		
		if(source != null)
		{
			Node clonedSource = new Node(source);
			subGraph.addNode(clonedSource);
			subGraph.setSource(clonedSource);
		}
		if(sink != null)
		{
			Node clonedSink = new Node(sink);
			subGraph.addNode(clonedSink);
			subGraph.setSink(clonedSink);
		}
		
		for(int n : subGraph.getNodesIDs())
		{
			LinkedList<Edge> clonedAdjList = subGraph.adjacencies.get(n);
			Node node = nodes.get(n);
			for(Edge e : adjacent(node))
			{
				if(subGraph.containsNode(e.dest))
				{
					Node clonedSrc = subGraph.nodes.get(e.source.id);
					Node clonedDest = subGraph.nodes.get(e.dest.id);
					Edge clonedEdge = new Edge(clonedSrc, clonedDest, e.cap, e.flow);
					clonedAdjList.add(clonedEdge);
					LinkedList<Edge> clonedIncList = subGraph.incidences.get(e.dest.id);
					clonedIncList.add(clonedEdge);
				}
			}
		}

		return subGraph;
	}

}

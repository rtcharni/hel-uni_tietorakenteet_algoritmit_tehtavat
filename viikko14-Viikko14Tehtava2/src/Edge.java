package com.scerra.graphs;


public class Edge
{
	final Node source;
	final Node dest;
	double cap = 0.0d;
	double flow = 0.0d;
	
	public Edge(Node source, Node dest, double cap)
	{
		this.source = source;
		this.dest = dest;
		this.cap = cap;
	}
	
	public Edge(Node source, Node dest, double cap, double flow)
	{
		this.source = source;
		this.dest = dest;
		this.cap = cap;
		this.flow = flow;
	}
	
	public Edge(Edge e)
	{
		source = e.source;
		dest = e.dest;
		cap = e.cap;
		flow = e.flow;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o == null) return false;
		if(!(o instanceof Edge)) return false;
		Edge e = (Edge)o;
		return e.source.equals(source) && e.dest.equals(dest) && e.flow == flow && e.cap == cap;
	}

	@Override
	public String toString()
	{
		return "(" + source.id + ", " + dest.id + ") [" + flow + " / " + cap + "]";
	}	
	
	public double getFlow()
	{
		return flow;
	}

	public void setFlow(double flow)
	{
		if(flow > cap) throw new IllegalArgumentException(""
				+ "");
		this.flow = flow;
	}

	public Node getSource()
	{
		return source;
	}

	public Node getDest()
	{
		return dest;
	}

	public double getCap()
	{
		return cap;
	}
	
	public void setCap(double cap)
	{
		this.cap = cap;
	}
	
	public double getResidualCap()
	{
		return cap - flow;
	}

}
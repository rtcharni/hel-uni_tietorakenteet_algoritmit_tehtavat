package com.scerra.graphs;

public class Node
{
	final int id;
	String label = "";

	public Node(int id)
	{
		this.id = id;
	}
	
	public Node(int id, String label)
	{
		this.id = id;
		this.label = label;
	}
	
	public Node(Node n)
	{
		id = n.getId();
		if(n.label != null) label = new String(n.label);
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(!(obj instanceof Node)) return false;
		Node n = (Node)obj;
		return n.id == id;
	}

	@Override
	public int hashCode()
	{
		return id;
	}
	
	@Override
	public String toString()
	{
		return "Node [id = " + id + ", label = " + label + "]";
	}	
}

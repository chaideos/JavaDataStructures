package edu.personal.linkedlists;

// TODO: Convert this class to use generics
public class LinkedListNode
{

	/**
	 * An element representing data
	 */
	private int data;

	public int getData()
	{
		return data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public LinkedListNode getNext()
	{
		return next;
	}

	public void setNext(LinkedListNode next)
	{
		this.next = next;
	}

	/**
	 * A pointer or reference to the next node.
	 */
	private LinkedListNode next;

	public LinkedListNode(int data)
	{
		this(data, null);
	}

	public LinkedListNode(int data, LinkedListNode nextNode)
	{
		this.data = data;
		this.next = nextNode;
	}

	@Override
	public String toString()
	{
		return "Data: " + data;
	}
}

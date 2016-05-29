package edu.personal.linkedlists;

// TODO: Convert this class to use generics
public class LinkedListNode<D>
{

	/**
	 * An element representing data
	 */
	private D data;

	public D getData()
	{
		return data;
	}

	public void setData(D data)
	{
		this.data = data;
	}

	public LinkedListNode<D> getNext()
	{
		return next;
	}

	public void setNext(LinkedListNode<D> next)
	{
		this.next = next;
	}

	/**
	 * A pointer or reference to the next node.
	 */
	private LinkedListNode<D> next;

	public LinkedListNode(D data)
	{
		this(data, null);
	}

	public LinkedListNode(D data, LinkedListNode<D> nextNode)
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

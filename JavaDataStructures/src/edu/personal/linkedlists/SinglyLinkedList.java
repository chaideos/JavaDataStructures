package edu.personal.linkedlists;

public class SinglyLinkedList
{

	private LinkedListNode head;

	private int count;

	public SinglyLinkedList()
	{
		this.head = null;
		this.count = 0;
	}

	public void add(int element)
	{
		LinkedListNode addedNode = new LinkedListNode(element);
		count++;
		if (head == null)
		{
			head = addedNode;
		}
		else
		{
			LinkedListNode current = head;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(addedNode);
		}
	}

	public LinkedListNode remove(int data)
	{
		LinkedListNode current = head;
		if (!isEmpty())
		{
			if (current.getData() == data)
			{

			}
		}
		return current;
	}

	public LinkedListNode reverse()
	{
		return head;
	}

	public LinkedListNode sort()
	{
		return head;
	}

	public LinkedListNode removeDuplicates()
	{
		return head;
	}

	public boolean isEmpty()
	{
		return size() == 0;
	}

	public int size()
	{
		return count;
	}

	@Override
	public String toString()
	{
		if (!isEmpty())
		{
			StringBuilder builder = new StringBuilder();
			LinkedListNode current = head;
			while (current.getNext() != null)
			{
				builder.append(current.toString() + "-->");
				current = current.getNext();
			}
			return builder.toString();
		}
		else
			return "Empty List";
	}
}

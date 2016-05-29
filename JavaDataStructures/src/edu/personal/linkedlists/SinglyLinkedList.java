package edu.personal.linkedlists;

public class SinglyLinkedList<D>
{

	private LinkedListNode<D> head;

	private int count;

	public SinglyLinkedList()
	{
		this(null);
		this.count = 0;
	}

	public SinglyLinkedList(LinkedListNode<D> head)
	{
		this.head = head;
		this.count = 1;
	}

	public void add(D element)
	{
		LinkedListNode<D> addedNode = new LinkedListNode<>(element);
		count++;
		if (head == null)
		{
			head = addedNode;
		}
		else
		{
			LinkedListNode<D> current = head;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(addedNode);
		}
	}

	public LinkedListNode<D> remove(D data)
	{
		LinkedListNode<D> current = head;
		if (!isEmpty())
		{
			if (current.getData() == data)
			{
				// Add something
			}
		}
		return current;
	}

	public LinkedListNode<D> reverse()
	{
		return head;
	}

	public LinkedListNode<D> sort()
	{
		return head;
	}

	public LinkedListNode<D> removeDuplicates()
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
			LinkedListNode<D> current = head;
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

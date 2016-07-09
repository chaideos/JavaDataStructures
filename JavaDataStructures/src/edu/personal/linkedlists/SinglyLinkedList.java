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

	/**
	 * Adds the specified element at the end of the list
	 * 
	 * @param element
	 *           - An element to be added to the list
	 */
	public LinkedListNode<D> add(D element)
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
		return head;
	}

	/**
	 * Adds the element to the list at the specified position
	 * 
	 * @param index
	 *           - an index to insert the element at
	 * @param element
	 *           - An element to be added to the list
	 * 
	 * @throws IndexOutOfBoundsException
	 *            - if index < 0 || index >= size()
	 */
	public LinkedListNode<D> add(int index, D element)
	{
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Index out of range");
		if (index == 0)
			addHead(element);
		else
		{
			LinkedListNode<D> previous = null, current = head;
			LinkedListNode<D> newNode = new LinkedListNode<D>(element);
			int i = 0;
			while (current != null && i < index)
			{
				i++;
				previous = current;
				current = current.getNext();
			}
			newNode.setNext(current);
			previous.setNext(newNode);
		}
		return head;
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
		LinkedListNode<D> previous = null, current = head;
		if (head != null)
		{
			while (current != null)
			{
				LinkedListNode<D> next = current.getNext();
				current.setNext(previous);
				previous = current;
				current = next;
			}
			head = previous;
		}
		return head;
	}

	public LinkedListNode<D> sort()
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

	public String display(LinkedListNode<D> head)
	{
		StringBuilder builder = new StringBuilder();
		LinkedListNode<D> current = head;
		while (current != null)
		{
			builder.append(current.toString());
			current = current.getNext();
		}
		return builder.toString();
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

	private void addHead(D element)
	{
		LinkedListNode<D> newNode = new LinkedListNode<>(element);
		if (isEmpty())
			head = newNode;
		else
		{
			newNode.setNext(head);
			head = newNode;
		}
	}
}

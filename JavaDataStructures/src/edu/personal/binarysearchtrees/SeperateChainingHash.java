package edu.personal.binarysearchtrees;

public class SeperateChainingHash<Key, Value>
{
	private int M = 97;

	private Node[] chains = new Node[M];

	private static class Node
	{
		public Node(Object key, Object value, Node node)
		{
			this.key = key;
			this.value = value;
			this.next = node;
		}

		private Object key;
		private Object value;
		private Node next;
	}

	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}

	@SuppressWarnings("unchecked")
	public Value get(Key key)
	{
		int i = hash(key);
		Node startNode = chains[i];
		Value value = null;
		while (startNode != null)
		{
			if (!startNode.key.equals(key))
			{
				value = (Value) startNode.value;
				break;
			}
			startNode = startNode.next;
		}
		return value;
	}

	public void put(Key key, Value value)
	{
		int i = hash(key);
		for (Node x = chains[i]; x != null; x = x.next)
			if (key.equals(x.key))
			{
				x.value = value;
				return;
			}
		chains[i] = new Node(key, value, chains[i]);
	}
}

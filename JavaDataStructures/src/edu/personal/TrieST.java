package edu.personal;

public class TrieST<Value>
{
	private static final int R = 256;

	private TrieNode root = new TrieNode();

	private static class TrieNode
	{
		private Object value;

		private TrieNode[] next = new TrieNode[R];
	}

	public void put(String key, Value value)
	{
		put(root, key, value, 0);
	}

	private TrieNode put(TrieNode x, String key, Value val, int d)
	{
		if (x == null)
			x = new TrieNode();
		if (d == key.length())
		{
			x.value = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

	public boolean contains(String key)
	{
		return get(key) != null;
	}

	public Value get(String key)
	{
		TrieNode node = get(root, key, 0);
		if (node == null)
			return null;
		return (Value) node.value;
	}

	private TrieNode get(TrieNode x, String key, int d)
	{
		if (x == null)
			return null;
		if (d == key.length())
		{
			return x;
		}
		else
		{
			char c = key.charAt(d);
			return get(x.next[c], key, d + 1);
		}
	}
}

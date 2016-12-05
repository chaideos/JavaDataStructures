package edu.personal;

public class TernaryTrieST<Value>
{
	private TrieNode root;

	private class TrieNode
	{
		private Value value;

		private char c;

		private TrieNode left, mid, right;
	}

	public void put(String key, Value value)
	{
		root = put(root, key, value, 0);
	}

	private TrieNode put(TrieNode x, String key, Value val, int d)
	{
		char c = key.charAt(d);
		if (x == null)
		{
			x = new TrieNode();
			x.c = c;
		}
		if (d == key.length() - 1)
		{
			x.value = val;
			return x;
		}
		if (c < x.c)
			x.left = put(x.left, key, val, d);
		else if (c > x.c)
			x.right = put(x.right, key, val, d);
		else if (d < key.length() - 1)
			x.mid = put(x.mid, key, val, d + 1);
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
		return node.value;
	}

	private TrieNode get(TrieNode x, String key, int d)
	{
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else
			return x;
	}

	public static void main(String s[])
	{
		TernaryTrieST<Integer> test = new TernaryTrieST<>();
		test.put("she", 0);
		System.out.println(test.get("she"));

		test.put("shells", 1);
		test.put("sea", 2);
		test.put("abc", 3);
		test.put("the", 4);

		System.out.println(test.get("she"));
		System.out.println(test.get("the"));

	}
}

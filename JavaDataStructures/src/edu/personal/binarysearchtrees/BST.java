package edu.personal.binarysearchtrees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value>
{
	private Node root;

	private class Node
	{
		private Key key;

		private Value value;

		private Node left, right;

		private int count;

		public Node(Key key, Value value, int count)
		{
			this.key = key;

			this.value = value;

			this.count = count;
		}
	}

	public void put(Key key, Value value)
	{
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value)
	{
		Node node = new Node(key, value, 1);
		if (x == null)
			return node;
		if (key.compareTo(x.key) > 0)
			x.right = put(x.right, key, value); // assigning the right pointers
		else if (key.compareTo(x.key) < 0)
			x.left = put(x.left, key, value); // assigning the left pointers
		else
			x.value = value; // Updating the value of the existing key
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	public Value get(Key key)
	{
		Node x = root;
		while (x != null)
		{
			int cmp = key.compareTo(x.key);
			if (cmp > 0)
				x = x.right;
			else if (cmp < 0)
				x = x.left;
			else
				return x.value;
		}
		return null;
	}

	public int size()
	{
		return size(root);
	}

	private int size(Node x)
	{
		if (x == null)
			return 0;
		return x.count;
	}

	/**
	 * return all keys < k
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key key)
	{
		return rank(root, key);
	}

	private int rank(Node x, Key k)
	{
		if (x == null)
			return 0;

		int cmp = k.compareTo(x.key);
		if (cmp > 0)
			return 1 + size(x.left) + rank(x.right, k); // Add 1 for the root and
																		// size of the whole left
																		// sub-tree. Then repeat
																		// the algo in the right
																		// sub-tree
		else if (cmp < 0)
			return rank(x.left, k);
		else
			return size(x.left); // Easy case if root key = k, rank is left subtree
	}

	/**
	 * Returns the largest key smaller than the specified key
	 * 
	 * @param key
	 * @return
	 */
	public Key floor(Key key)
	{
		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node floor(Node x, Key key)
	{
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);

		if (cmp == 0)
			return x;

		if (cmp < 0)
			return floor(x.left, key);

		Node t = floor(x.right, key);
		if (t != null)
			return t;
		return x;
	}

	public Iterator<Key> keys()
	{
		Queue<Key> queue = new LinkedList<>();
		inorder(root, queue);
		return queue.iterator();
	}

	private void inorder(Node x, Queue<Key> q)
	{
		if (x == null)
			return;
		inorder(x.left, q);
		q.add(x.key);
		inorder(x.right, q);
	}

	public void delete(Key key)
	{
		root = delete(root, key);
	}

	private Node delete(Node x, Key k)
	{
		if (x == null)
			return null;

		int cmp = k.compareTo(x.key);
		if (cmp > 0)
			x.right = delete(x.right, k);
		else if (cmp < 0)
			x.left = delete(x.left, k);
		else
		{
			// Case 0: where node to be deleted has no children
			if (x.left == null) // no left child
				return x.right;
			if (x.right == null) // no right child
				return x.left;

			Node t = x;
			x = min(t.right); // find successor of t
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	private Node min(Node x)
	{
		if (x == null)
			return null;
		while (x.left != null)
			x = x.left;
		return x;
	}

	public void deleteMin()
	{
		root = deleteMin(root);
	}

	private Node deleteMin(Node x)
	{
		if (x == null)
			return null;
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	public void deleteMax()
	{
		root = deleteMax(root);
	}

	private Node deleteMax(Node x)
	{
		if (x == null)
			return null; // base case where tree is empty
		if (x.right == null)
			return x.left;
		x.right = deleteMin(x.right);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
}

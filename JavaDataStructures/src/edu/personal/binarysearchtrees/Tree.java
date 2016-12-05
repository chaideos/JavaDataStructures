package edu.personal.binarysearchtrees;

public interface Tree<D extends Comparable<D>>
{
	int size();

	boolean isEmpty();

	boolean contains(D data);

	TreeNode<D> add(D data);

}

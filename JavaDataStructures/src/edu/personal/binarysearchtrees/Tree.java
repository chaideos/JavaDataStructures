package edu.personal.binarysearchtrees;

public interface Tree<D extends Comparable<D>>
{
	int size();

	boolean isEmpty();

	boolean contains(D data);

	BinarySearchTreeNode<D> add(D data);

}

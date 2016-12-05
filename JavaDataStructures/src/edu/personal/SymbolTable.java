package edu.personal;

/**
 * @author chaitanyadeosthale
 *
 * @param <Key>
 * @param <Value>
 */
interface SymbolTable<Key extends Comparable<Key>, Value>
{
	void put(Key key, Value value);

	Value get(Key key);

	void delete(Key key);

	boolean isEmpty();

	boolean contains(Key key);

	int size();

	Key min();

	Key max();

	Key floor(Key key);

	Key ceiling(Key key);

	int rank(Key key);

	/**
	 * Selects a key of rank k
	 * 
	 * @param k
	 *           - rank for a key
	 * @return
	 */
	Key select(int k);

	void deleteMin();

	void deleteMax();

	/**
	 * Number of keys between lo..hi
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	int size(Key lo, Key hi);

	/**
	 * Keys in [lo..hi] in sorted order
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	Iterable<Key> keys(Key lo, Key hi);

	Iterable<Key> keys();
}

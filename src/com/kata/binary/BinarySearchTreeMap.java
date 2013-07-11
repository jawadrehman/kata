package com.kata.binary;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import com.kata.priority.Entry;
import com.kata.priority.Position;

public class BinarySearchTreeMap<K, V> extends LinkedBinaryTree<Entry<K, V>>
		implements Map<K, V> {
	protected Comparator<K> C;
	protected Position<Entry<K,V>> actionPos;
	protected int numEntries = 0;

	public BinarySearchTreeMap() throws Exception {
		C = new DefaultComparator<K>();
//		addRoot(null);
	}
	
	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}

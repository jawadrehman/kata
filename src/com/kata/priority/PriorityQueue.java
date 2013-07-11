package com.kata.priority;

public interface PriorityQueue<K,V> {
	
	public int size();
	
	public boolean isEmpty();
	
	public Entry<K, V> getMin()throws EmptyPriorityQueueException;
	
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException;
	
	public void insert(K key, V value) throws InvalidKeyException;

	class EmptyPriorityQueueException extends Exception{
		public EmptyPriorityQueueException() {
			super("Priority Queue Is Empty");
		}
	}
	
	class InvalidKeyException extends Exception{
		public InvalidKeyException() {
			super("Invalid Key provided");
		}
	}
}

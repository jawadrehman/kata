package com.kata.structures;

public class Node<E> {

	E element;

	Node prev, next;

	public Node(E element) {
		// this.index = index;
		this.element = element;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public void setElement(E element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}

	public E getElement() {
		return element;
	}

	public boolean hasNext() {
		return next != null;
	}

	public boolean hasPrev() {
		return prev != null;
	}

}
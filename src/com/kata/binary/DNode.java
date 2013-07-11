package com.kata.binary;

import com.kata.priority.Position;

public class DNode<E> implements Position<E> {
	private E element;
	private DNode<E> prev, next;
	
	public DNode(DNode<E> newPrev, DNode<E> newNext, E element) {
		this.element = element;
		prev = newPrev;
		next = newNext;
		
//		DNode<E>
	}
	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setNext(DNode<E> newNext) {
		next = newNext;
	}
	
	public void setPrev(DNode<E> newPrev) {
		prev = newPrev;
	}
	
	public void setElement(E newElement) {
		element = newElement;
	}
	
	public DNode<E> getPrev(){
		return prev;
	}
	
	public DNode<E> getNext(){
		return next;
	}

}

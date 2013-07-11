package com.kata.binary;

import com.kata.priority.Position;

public class BTNode<E> implements Position<E> {

	private E element;
	private Position<E> left, right, parent;
	
	public BTNode(E element, Position<E> parent, Position<E> left, Position<E> right) {
		this.element = element;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	
	public Position<E> getLeft() {
		return left; 
	}
	
	public Position<E> getRight(){
		return right;
	}
	
	public Position<E> getParent(){
		return parent;
	}
	
	@Override
	public E element() {
		return element;
	}
	
	public void setLeft(Position<E> left) {
		this.left = left;
	}
	
	public void setRight(Position<E> right) {
		this.right = right;
	}
	
	public void setParent(Position<E> parent) {
		this.parent = parent;
	}
	
	public void setElement(E e) {
		this.element = e;
	}
	

}

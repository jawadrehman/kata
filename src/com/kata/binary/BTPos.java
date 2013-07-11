package com.kata.binary;

import com.kata.priority.Position;

public class BTPos<E> implements Position<E> {
	E element;
	int index;

	public BTPos(E elt, int i) {
		element = elt;
		index = i;
	}

	@Override
	public E element() {
		return element;
	}

	public int index() {
		return index;
	}

	public E setElement(E elt) {
		E temp = element;
		element = elt;
		return temp;
	}

}
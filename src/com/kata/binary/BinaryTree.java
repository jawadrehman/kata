package com.kata.binary;

import com.kata.exceptions.BoundryViolationException;
import com.kata.exceptions.InvalidPositionException;
import com.kata.priority.Position;

public interface BinaryTree<E> extends Tree<E> {
	public Position<E> left(Position<E> v) throws InvalidPositionException,
			BoundryViolationException;

	public Position<E> right(Position<E> v) throws InvalidPositionException,
			BoundryViolationException;

	public boolean hasLeft(Position<E> v) throws InvalidPositionException;

	public boolean hasRight(Position<E> v) throws InvalidPositionException;

}

package com.kata.binary;

import com.kata.exceptions.BoundryViolationException;
import com.kata.exceptions.InvalidPositionException;
import com.kata.priority.Position;

public interface PositionList<E> extends Iterable<E> {
	public Iterable<Position<E>> positions();

	public int size();

	public boolean isEmpty();

	public Position<E> first();

	public Position<E> last();

	public Position<E> next(Position<E> p) throws InvalidPositionException,
			BoundryViolationException;

	public Position<E> prev(Position<E> p) throws InvalidPositionException,
			BoundryViolationException;

	public void addFirst(E e);

	public void addLast(E e);

	public void addAfter(Position<E> p, E e) throws InvalidPositionException;

	public void addBefore(Position<E> p, E e) throws InvalidPositionException;

	public E remove(Position<E> p) throws InvalidPositionException;

	public E set(Position<E> p, E e) throws InvalidPositionException;

}

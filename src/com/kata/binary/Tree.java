package com.kata.binary;

import java.util.Iterator;

import com.kata.exceptions.BoundryViolationException;
import com.kata.exceptions.InvalidPositionException;
import com.kata.priority.Position;

public interface Tree<E> {

	public int size();

	public boolean isEmpty();

	public Iterator<E> iterator();

	public Iterable<Position<E>> positions();

	public E replace(Position<E> v, E e) throws InvalidPositionException;

	public Position<E> root();

	public Position<E> parent(Position<E> v) throws InvalidPositionException,
			BoundryViolationException;

	public Iterable<Position<E>> children(Position<E> v)
			throws InvalidPositionException;

	public boolean isInternal(Position<E> v) throws InvalidPositionException;

	public boolean isExternal(Position<E> v) throws InvalidPositionException;

	public boolean isRoot(Position<E> v) throws InvalidPositionException;
}

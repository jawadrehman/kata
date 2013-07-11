package com.kata.binary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.kata.exceptions.BoundryViolationException;
import com.kata.exceptions.InvalidPositionException;
import com.kata.priority.Position;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
	LinkedList<BTNode<E>> list = new LinkedList<BTNode<E>>();

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Iterator<E> iterator() {

		ArrayList<E> listElements = new ArrayList<E>();
		for (BTNode<E> pos : list) {
			listElements.add(pos.element());
		}
		return listElements.iterator();
	}

	@Override
	public Iterable<Position<E>> positions() {
		return null;
	}

	@Override
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTNode<E> pos = checkPosition(v);
		E oldE = pos.element();
		pos.setElement(e);
		return oldE;
	}

	@Override
	public Position<E> root() {
		return list.getFirst();
	}

	@Override
	public Position<E> parent(Position<E> v) throws InvalidPositionException,
			BoundryViolationException {
		BTNode<E> vv = checkPosition(v);
		return vv.getParent();
	}

	@Override
	public Iterable<Position<E>> children(Position<E> v)
			throws InvalidPositionException {

		PositionList<Position<E>> children = new NodePositionList<Position<E>>();
		if (hasLeft(v))
			try {
				children.addLast(left(v));
			} catch (BoundryViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}

	@Override
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		BTNode<E> vv = checkPosition(v);
		return hasLeft(vv) || hasRight(vv);
	}

	@Override
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		return !isInternal(v);
	}

	@Override
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return v == list.getFirst();
	}

	@Override
	public Position<E> left(Position<E> v) throws InvalidPositionException,
			BoundryViolationException {
		// TODO Auto-generated method stub

		BTNode<E> vv = checkPosition(v);

		return vv.getLeft();
	}

	@Override
	public Position<E> right(Position<E> v) throws InvalidPositionException,
			BoundryViolationException {
		BTNode<E> vv = checkPosition(v);
		return vv.getRight();
	}

	@Override
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTNode<E> vv = checkPosition(v);
		return vv.getLeft() != null;
	}

	@Override
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTNode<E> vv = checkPosition(v);
		return vv.getRight() != null;
	}

	protected BTNode<E> checkPosition(Position<E> v)
			throws InvalidPositionException {
		if (v == null || !(v instanceof BTPos))
			throw new InvalidPositionException();
		return (BTNode<E>) v;
	}

}

package com.kata.binary;

import java.util.ArrayList;
import java.util.Iterator;

import com.kata.exceptions.BoundryViolationException;
import com.kata.exceptions.InvalidPositionException;
import com.kata.priority.Position;

public class ArrayListCompleteBinaryTree<E> implements CompleteBinaryTree<E> {

	protected ArrayList<BTPos<E>> T;

	

	@Override
	public Position<E> left(Position<E> v) throws InvalidPositionException,
			BoundryViolationException {
		if (!hasLeft(v))
			throw new BoundryViolationException();
		BTPos<E> vv = checkPosition(v);
		return T.get(2 * vv.index());

	}

	@Override
	public Position<E> right(Position<E> v) throws BoundryViolationException,
			InvalidPositionException {

		if (!hasRight(v))
			throw new BoundryViolationException();
		BTPos<E> vv = checkPosition(v);
		return T.get(2 * vv.index() + 1);
	}

	@Override
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		if (2 * vv.index() <= size())
			return true;
		return false;
	}

	@Override
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		if (2 * vv.index() + 1 <= size())
			return true;
		return false;
	}

	@Override
	public int size() {
		return T.size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Iterator<E> iterator() {
		ArrayList<E> list = new ArrayList<E>();
		Iterator<BTPos<E>> iter = T.iterator();
		iter.next();
		while (iter.hasNext()) {
			list.add(iter.next().element());
		}
		return list.iterator();
	}

	@Override
	public Iterable<Position<E>> positions() {
		
		
		return null;
	}

	@Override
	public E replace(Position<E> v, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> root() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> parent(Position<E> v) throws InvalidPositionException,
			BoundryViolationException {
		// TODO Auto-generated method stub
		if (isRoot(v))
			throw new BoundryViolationException();
		
		BTPos<E> p = checkPosition(v);
		int position = p.index();
		Position<E> parent = T.get(position / 2);
		return parent;
	}

	@Override
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
		ArrayList<E> list = new ArrayList<E>();
		BTPos<E> p = checkPosition(v);
		
		if(T.size() <2*p.index()+1) throw new InvalidPositionException();
		list.add((E) T.get(p.index()*2));
		list.add((E) T.get(p.index()*2 + 1));
		
		
		return (Iterable<Position<E>>) list.iterator();
	}

	@Override
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		// TODO Auto-generated method stub
		BTPos<E> p = checkPosition(v);

		return hasLeft(p);
	}

	@Override
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		return !isInternal(v);
	}

	@Override
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		BTPos<E> p = checkPosition(v);
		return (p.index() == 1);
	}

	@Override
	public Position<E> add(E elem) {

		// TODO just use size
		int i = size() + 1;
		BTPos<E> p = new BTPos<E>(elem, i);
		T.add(i, p);
		return p;
	}

	@Override
	public E remove() throws Exception {
		if (isEmpty()) {
			throw new Exception("Tree is empty");
		}
		BTPos<E> p = T.get(size() - 1);
		T.remove(size() - 1);
		return p.element();
	}

	protected BTPos<E> checkPosition(Position<E> v)
			throws InvalidPositionException {
		if (v == null || !(v instanceof BTPos))
			throw new InvalidPositionException();
		return (BTPos<E>) v;
	}

}

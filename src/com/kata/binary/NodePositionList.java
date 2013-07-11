package com.kata.binary;

import java.util.Iterator;

import com.kata.exceptions.BoundryViolationException;
import com.kata.exceptions.InvalidPositionException;
import com.kata.priority.Position;

public class NodePositionList<E> implements PositionList<E> {
	protected int numElts;
	protected DNode<E> header, trailer;

	public NodePositionList() {
		numElts = 0;
		header = new DNode<E>(null, null, null);
		trailer = new DNode<E>(null, null, null);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> positions(){

		PositionList<Position<E>> P = new NodePositionList<>();
		 if(!isEmpty()) {
			 Position<E> p = first();
			 while(true) {
				 P.addLast(p);
				 if(p == last()) {
					 break;
				 }
				 try {
					p = next(p);
				} catch (InvalidPositionException | BoundryViolationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }
		 }
		return P;
	}

	@Override
	public int size() {
		return numElts;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Position<E> first() {
		return header.getNext();
	}

	@Override
	public Position<E> last() {
		return trailer.getPrev();
	}

	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException,
			BoundryViolationException {
		DNode<E> temp = checkPosition(p);
		return temp.getNext();
	}

	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException,
			BoundryViolationException {

		DNode<E> vv = checkPosition(p);
		return vv.getPrev();
	}

	@Override
	public void addFirst(E e) {
		
		DNode<E> prevFirst = header.getNext();
		DNode<E> node = new DNode<E>(header, prevFirst, e);
		prevFirst.setPrev(node);
		header.setNext(node);
		numElts++;
	}

	@Override
	public void addLast(E e) {
		DNode<E> prevLast = trailer.getPrev();
		DNode<E> node = new DNode<E>(header, prevLast, e);
		prevLast.setNext(node);
		trailer.setPrev(node);
		numElts++;
	}

	@Override
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {

		DNode<E> prevFirst = checkPosition(p);;
		DNode<E> node = new DNode<E>(prevFirst, prevFirst.getNext(), e);
		prevFirst.setNext(node);
		prevFirst.getNext().setPrev(node);
		numElts++;

	}

	@Override
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> temp = checkPosition(p);;
		DNode<E> node = new DNode<E>(temp.getPrev(), temp, e);
		temp.setPrev(node);
		temp.getPrev().setNext(node);
		numElts++;

	}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		
		DNode<E> temp = checkPosition(p);
		temp.getPrev().setNext(checkPosition(temp.getNext()));
		temp.getNext().setPrev(checkPosition(temp.getPrev()));
		return temp.element();
	}

	@Override
	public E set(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> temp = checkPosition(p);
		E oldE = temp.element();
		temp.setElement(e);
		return oldE;
	}

	public DNode<E> checkPosition(Position<E> p)
			throws InvalidPositionException {
		if (p == null || p == header || p == trailer) {
			throw new InvalidPositionException();
		}
		try {
			DNode<E> temp = (DNode<E>) p;
			if (temp.getNext() == null || temp.getPrev() == null) {
				throw new InvalidPositionException();
			}

			return temp;
		} catch (ClassCastException e) {
			throw new InvalidPositionException();
		}

	}
}


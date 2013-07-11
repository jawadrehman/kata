package com.kata.binary;

import com.kata.priority.Position;

public interface CompleteBinaryTree<E> extends BinaryTree<E> {
	public Position<E> add(E elem);
	public E remove() throws Exception;

 }

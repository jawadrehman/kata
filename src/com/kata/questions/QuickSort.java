package com.kata.questions;

import java.util.ArrayList;
import java.util.LinkedList;

import com.kata.structures.Node;

public class QuickSort {
	public QuickSort() {
		// new QuickSortInPlace();
		new QuickSortDoubleLinked();
	}

	public static void main(String[] args) {
		new QuickSort();
	}

	private class QuickSortDoubleLinked {
		LinkedList<Node<Integer>> list;

		public QuickSortDoubleLinked() {
			list = new LinkedList<Node<Integer>>();
			add(23);
			add(3);
			add(2);
			add(10);
			add(8);

			quickSort(list.getFirst(), list.getLast());

			Node n = list.getFirst();
			while(n!=null) {
				System.out.println(n.getElement());
				n = n.getNext();
			}
			
		}

		public void add(int i) {
			if (list.size() == 0) {
				list.addFirst(new Node<Integer>(i));
			} else {
				Node<Integer> newNode = new Node<Integer>(i);
				newNode.setPrev(list.getLast());
				
				list.getLast().setNext(newNode);
				list.addLast(newNode);
			}
		}
		
		public void swap(Node<Integer> first, Node<Integer> second) {
			System.out.println("SWAP ---- \n first " + first.getElement());
			System.out.println(" second " + first.getElement());
			Integer i = first.getElement();
			first.setElement(second.getElement());
			second.setElement(i);
		}

		public Node<Integer> partition(Node<Integer> l, Node<Integer> h) {
			int x = h.getElement();
			System.out.println("x = " + x);
			Node<Integer> i = l;
			
			for (Node<Integer> j = l; j != h && j.hasNext(); j = j.getNext()) {
				System.out.println("j element "+ j.getElement());
				if (j.getElement() <= x) {
					if (i != null) {
						swap(i, j);
						i = i.getNext();
					}
					
					

				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (i != null) {
				i.getNext();
			}

			swap(i, h);

			return i;
		}

		public void quickSort(Node<Integer> l, Node<Integer> r) {
			

			if (r != null && l != r  && l != r.getNext()) {
				System.out.println("starts");
				Node<Integer> p = partition(l, r);
				quickSort(l, p.getPrev());
				quickSort(r, p.getNext());
				System.out.println("stop");
			}

		}
	}

	private class QuickSortInPlace {

		public QuickSortInPlace() {
			ArrayList<Integer> list = new ArrayList<Integer>();

			list.add(23);
			list.add(3);
			list.add(2);
			list.add(10);
			list.add(8);
			quickSort(list, 0, list.size() - 1);

			for (int i : list) {
				System.out.print(i + " ");
			}
		}

		public void quickSort(ArrayList<Integer> list, int left, int right) {
			if (left < right) {
				int pivotIndex = (left + right) / 2;

				int pivotNewIndex = partition(list, left, right, pivotIndex);

				quickSort(list, left, pivotNewIndex - 1);
				quickSort(list, pivotNewIndex + 1, right);
			}
		}

		private int partition(ArrayList<Integer> list, int left, int right,
				int pivotIndex) {
			
			int pivotValue = list.get(pivotIndex);
			swap(list, pivotIndex, right);

			int storeIndex = left;

			for (int i = left; i < right; i++) {
				if (list.get(i) <= pivotValue) {
					swap(list, i, storeIndex);
					storeIndex++;
				}
			}

			swap(list, storeIndex, right);
			return storeIndex;
		}

		public void swap(ArrayList<Integer> list, int i, int j) {
			int temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
	}

	private class QuickSortSimple {

		public QuickSortSimple() {

			ArrayList<Integer> list = new ArrayList<Integer>();

			list.add(23);
			list.add(3);
			list.add(2);
			list.add(10);
			list.add(8);

			ArrayList<Integer> sorted = quickSort(list);

			for (int i : sorted) {
				System.out.print(i + ",");
			}
		}

		public ArrayList<Integer> quickSort(ArrayList<Integer> list) {
			if (list.size() <= 1) {
				return list;
			}
			int pivot = list.remove((list.size() - 1) / 2);
			ArrayList<Integer> lowList = new ArrayList<Integer>();
			ArrayList<Integer> highList = new ArrayList<Integer>();

			for (int p : list) {
				if (p <= pivot) {
					lowList.add(p);
				}

				else if (p > pivot) {
					highList.add(p);
				}

			}
			// System.out.println("l = " + cursorL);
			return concatenate(quickSort(lowList), pivot, quickSort(highList));

		}

		public ArrayList<Integer> concatenate(ArrayList<Integer> first,
				int pivot, ArrayList<Integer> second) {

			ArrayList<Integer> list = new ArrayList<Integer>();
			addToList(list, first);
			list.add(pivot);
			addToList(list, second);

			return list;
		}

		public void addToList(ArrayList<Integer> list,
				ArrayList<Integer> original) {
			for (int i = 0; i < original.size(); i++) {
				try {
					list.add(original.get(i));
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}

	}

}

package com.kata.sort;

import java.util.LinkedList;

public class MergeSort {

	int[] A = { 2, 1, 0, 23, 19 };

	public static void main(String[] args) {
		new MergeSort();
	}

	public MergeSort() {
		mergeSort(A, 0, A.length - 1);
		for (int i : A) {
			System.out.println(i);
		}
	}

	public int[] mergeSort(int[] S, int p, int r) {
		if (S.length <= 1) {
			return S;
		} else {
			if (p < r) {
				int q = (int) Math.ceil((r + p) / 2);
				
				mergeSort(S, p, q);
				mergeSort(S, q + 1, r);

				merge(S, p, q, r);

			}
		}
		return S;
	}

	public void merge(int[] S, int p, int q, int r) {

		LinkedList<Integer> S1 = copyToList(S, p, q);
		LinkedList<Integer> S2 = copyToList(S, q + 1, r);

		int k = p;
		
		while(!S1.isEmpty() || !S2.isEmpty()) {
			
			if(!S1.isEmpty() && !S2.isEmpty()) {
				
			int e1 = S1.peek();
			int e2 = S2.peek();

				if (e1 <= e2) {
					S[k] = S1.pop();
				} else if (e2 < e1) {
					S[k] = S2.pop();
				}
			}
			
			else if(!S1.isEmpty()) {
				S[k] = S1.pop();
			}
			
			else if(!S2.isEmpty()) {
				S[k] = S2.pop();
			}
			k++;
		}

	}

	public LinkedList<Integer> copyToList(int[] originalA, int p, int r) {

		LinkedList<Integer> S = new LinkedList<Integer>();
		for (int i = p; i < r; i++) {
			S.add(i);
		}

		return S;
	}
}

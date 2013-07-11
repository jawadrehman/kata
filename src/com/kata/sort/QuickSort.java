package com.kata.sort;

import java.util.Random;

public class QuickSort {

	int[] arrayNumbers = new int[10];

	public static void main(String[] args) {
		new QuickSort();
	}

	public QuickSort() {
		addToArray();
		inPlaceQuickSort(arrayNumbers, 0, arrayNumbers.length - 1);

		for (Integer i : arrayNumbers) {
			System.out.println(i);
		}
	}

	public void addToArray() {
		Random random = new Random();
		for (int i = 0; i < arrayNumbers.length; i++) {
			int r = random.nextInt(100);
			System.out.println("r = " + r);
			arrayNumbers[i] = r;
		}
	}

	
	public int[] inPlaceQuickSort(int[] S, int a, int b) {
		if (a>=b) {
			return S;
		}
		
		int pivot = S[b];
		int left = a;
		int right = b -1;
		
		while(left<=right) {
			while(left<=right && S[left]<= pivot) {
				left++;
			}
			
			while(right>=left && S[right]>=pivot) {
				right--;
			}
			
			if(left<right) {
				int temp = S[left];
				S[left] = S[right];
				S[right] = temp;
			}
			
			int temp = S[left];
			S[left] = S[b];
			S[b] = temp;
			
			inPlaceQuickSort(S, a, left-1);
			inPlaceQuickSort(S, left+1, b);
			
		}
		
		
		return null;
	}
	
}

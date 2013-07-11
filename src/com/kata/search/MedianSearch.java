package com.kata.search;

public class MedianSearch {
	public MedianSearch(){
		
	}
	
	public int getMedian(int[] ar1, int[] ar2, int left, int right){
		int n = ar2.length;
		int i = (int)Math.ceil(( left + right )/2);
		int j = n - i - 1;
		
		if(ar1[i]>=ar2[j] && ar1[i]<= ar2[j+1]){
			return (ar1[i] + ar2[j])/2;
		}
		
		else if(ar1[i]> ar2[j] && ar1[i]>ar2[j+1]){
			
		}
		
		else if(ar1[i]<ar2[j] && ar1[i] < ar2[j+1]){
			
		}
		
		return 0;
	}
	
	
}

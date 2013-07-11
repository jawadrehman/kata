package com.kata.questions;

public class Permutation {

	public static void main(String[] args) {
		new Permutation();
	}
	

	public Permutation() {
		String word = "ABcD";
		permute(word);
	}
	
	
	public void permute(String input) {
		int inputLength = input.length();
		boolean[] used = new boolean[inputLength];
		
		StringBuffer outputString = new StringBuffer();
		char[] in = input.toCharArray();
		
		doPermute(in, outputString, used, inputLength, 0);
	}
	
	public void doPermute(char[] in, StringBuffer outputString, boolean[] used, int inputLength, int level) {
		if(level == inputLength) {
			System.out.println(outputString.toString());
			return;
		}
		
		for(int i = 0; i<inputLength; i++) {
			if(used[i]) {
			}
			else {
				outputString.append(in[i]);
				used[i] = true;
				doPermute(in, outputString, used, inputLength, level+1);
				used[i]  = false;
				outputString.setLength(outputString.length() - 1);
			}
		}
	}
}

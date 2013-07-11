package com.kata.anagram;

import java.util.Scanner;

public class Palindrome {
	Scanner in;
	String input;

	public static void main(String[] args) {
		new Palindrome();
	}

	public Palindrome() {
		in = new Scanner(System.in);

		while (true) {
			System.out.println("input your sentence");
			input = inputString();
			System.out.println("it is " + checkPalindrome(input));
		}
	}

	/** takes input from the console */
	public String inputString() {
		return in.nextLine();
	}

	/** checks for palindrome by traversing in both the directions ignoring spaces*/
	public boolean checkPalindrome(String s) {

		Cursor head = new Cursor(0, input);
		Cursor tail = new Cursor(s.length() - 1, input);
		while (head.hasNext() && tail.hasPrev()
				&& head.getIndex() < tail.getIndex()) {

			while (head.getNext() == ' ') {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			while (tail.getPrev() == ' ') {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (head.getChar() != tail.getChar())
				return false;
		}
		return true;
	}

	/**
	 * Navigates between a String in the forward and backward direction, one
	 * character at a time
	 * 
	 * @author jawad
	 * 
	 */
	private class Cursor {

		int index;
		char element;
		String s;

		Cursor(int index, String s) {
			this.index = index;
			this.s = s;
		}

		public char getNext() {
			if (hasNext())
				element = s.charAt(index++);
			return element;
		}

		public char getPrev() {
			element = s.charAt(index--);
			return element;
		}

		public char getChar() {
			return element;
		}

		public boolean hasNext() {
			return index + 1 < s.length();
		}

		public boolean hasPrev() {
			return index - 1 >= 0;
		}

		public int getIndex() {
			return index;
		}

	}
}

package com.kata.anagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Anagram {

	HashMap<String, ArrayList<String>> wordMap = new HashMap<String, ArrayList<String>>();
	ArrayList<String> words = new ArrayList<String>();

	public static void main(String[] args) {
		new Anagram();
		
	}

	public Anagram() {
		words.add("team");
		words.add("meat");
		words.add("eat");
		words.add("tea");
		
		addToMap();
		printOutWords();
	}

	public void addToList(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String line = "";

		while ((line = br.readLine()) != null) {
			words.add(line);

		}
	}
	
	public void addToMap() {

		for (String word : words) {
			String alphabetizeWord = alphabetizeWord(word);
			if (!wordMap.containsKey(alphabetizeWord)) {
				wordMap.put(alphabetizeWord, new ArrayList<String>());
				wordMap.get(alphabetizeWord).add(word);
				
			} else {
				wordMap.get(alphabetizeWord).add(word);
			}
		}

	}
	
	public void printOutWords() {
		Iterator<String> i = wordMap.keySet().iterator();
		
		while(i.hasNext()) {
			String key = (String) i.next();
			ArrayList<String> values = wordMap.get(key);
			for (String string : values) {
				System.out.print(string + ",");
			}
			
			System.out.println();
		}
	}

	/**
	 * @param inputWord
	 *            the word given to be alphabetized
	 * @return the alphabetized word
	 */
	public String alphabetizeWord(String inputWord) {
		char[] wordChar = inputWord.toLowerCase().toCharArray();
		Arrays.sort(wordChar);
		String alphabetizedWord = new String(wordChar);
		return alphabetizedWord;
	}
}

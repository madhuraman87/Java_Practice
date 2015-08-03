package asperaInc;

import java.io.*;
import java.util.*;

public class LongestWordFromOtherWords {
	private static final String inputFile = "/home/madhuajeeth/workspace/Java_Practice/src/asperaInc/wordsforproblem.txt";
	private static ArrayList<String> list = new ArrayList<String>();

	private static Trie trieStruc = new Trie();

	private static void readfromFile() { // read the words from the file and put them in an ArrayList.
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			try {
				String line = br.readLine();
				while (line != null) {
//					System.out.println(line);
					list.add(line);
					line = br.readLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void buildTrie() { //build the Trie data structure. Insert the words from the file into the Trie.
		for (String letter : list) {
			trieStruc.insertWord(letter);
		}
	}

	public static ArrayList<String> longestWordFromOther(ArrayList<String> list) { //method to compute the longest word made from other words.
		ArrayList<String> wordList = new ArrayList<String>();
		for (String word : list) {
			if (isValidWord(word,true)) {
				wordList.add(word);
			}
		}
		Collections.sort(wordList, new Comparator<String>() { //sort the arrayList in accordance to length of the Strings.
			@Override
			public int compare(String o1, String o2) {
				return ((Integer) o2.length()).compareTo(o1.length());
			}
		});
		return wordList;
	}

	private static boolean isValidWord(String word, boolean originalWord) { //function to check if the word is a combination of other words and are valid and contained in the trie.
		if (!originalWord && trieStruc.doesContainString(word)){
        	return true;
        }             
        for (int i = 1; i < word.length(); ++i) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (isValidWord(left, false) && isValidWord(right, false)){
            	return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readfromFile();
		buildTrie();
		// trieStruc.deleteWord("mouse");
		// System.out.println(trieStruc.doesContainString("mouse"));
		// for(String letter : list)
		// System.out.println(letter);
		ArrayList<String> result = longestWordFromOther(list);
		System.out.println("First longest word made from others: " + result.get(0));
		System.out.println("Second longest word made from others: " + result.get(1));
		System.out.println("Number of words that can be made from others: " + result.size());
	}

}



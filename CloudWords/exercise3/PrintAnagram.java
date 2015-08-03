package exercise3;

/**
 * 
Exercise 3 

An anagram is a type of word play, the result of rearranging the letters of a word or phrase to 
produce a new word or phrase, using all the original letters exactly once.  In other words, “cat” 
and “act” would be considered anagrams since they share the exact same letters­­ just in 
different order.  Whereas “act” would not be an anagram of “acts” because “acts” has an “s” and 
“act” does not.   
 
Taking the the list of words below, output all word pairs that are “anagrams” of each other. 
Please display each anagram word pair to System.out in format like this: 
 
wordX wordY 
wordA wordB 
 
Word List:   
vase bat gods latte name apres spit joke ham dog act tale parse pits asper tab table mane late 
god cat table save spare 
 * 
 * Time Complexity for checking if two strings are anagram of each other : O(nlogn).
 */

import java.util.*;


public class PrintAnagram {	
	
	private boolean isAnagram(String a, String b) {
		// if the two string lengths are not same then they are not anagrams.
		if(a.length() != b.length()){ 
			return false;
		}
		
		// sort the characters of the two strings 
		a = sortString(a);
		b = sortString(b);
		
		// after sorting, if the two strings are equal then they are anagrams.
		return a.equals(b);
	}
	
	private String sortString(String a) {
		char[] charString = a.toLowerCase().toCharArray();
		Arrays.sort(charString);
		return String.valueOf(charString);
	}
	
	private void findAllAnagrams(String arr[])
	{
	    for (int i = 0; i < arr.length; i++)
	        for (int j = i+1; j <arr.length; j++)
	            if (isAnagram(arr[i], arr[j]))	            	
	                System.out.println(arr[i] + " " + arr[j]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inputarray = new String[]{"vase","bat","gods","latte","name","apres","spit","joke","ham","dog","act","tale","parse","pits","asper","tab","table","mane","late","god","cat","table","save","spare"};
		
		PrintAnagram list = new PrintAnagram();
		list.findAllAnagrams(inputarray);

	}

}

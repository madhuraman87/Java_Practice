package bitmanipulation;
import java.util.*;
//Time Complexity: Time complexity of below code is O(4^n) where n is number of digits in input number.
public class LetterCombinations {
	public static HashMap<Character,String> hm = new HashMap<Character,String>();	
	public static void letterCombinations(String digits) {
		char[] soln = new char[digits.length()];
		int start = 0;
	    int end = digits.length()-1;	 
		//char end = '#'; 
		getCombinations(soln,digits.toCharArray(),start,end,hm);
	}
	public static void getCombinations(char[] soln, char[] digits, int start, int end, HashMap<Character,String> hm){
        if(start == end){
            System.out.println(new String(soln));
			return;
        }
        for(char c : hm.get(digits[start]).toCharArray()){
			soln[start] = c;
			getCombinations(soln, digits, (start + 1), end, hm);
		}
    }
	
	public static void main(String args[]){
		hm.put('0', "");
		hm.put('1', "");
		hm.put('2',"abc");
	    hm.put('3',"def");
	    hm.put('4',"ghi");
	    hm.put('5',"jkl");
	    hm.put('6',"mno");
	    hm.put('7',"pqrs");
	    hm.put('8',"tuv");
	    hm.put('9',"wxyz");
	    System.out.println("Letter combinations of 234# : ");
	    letterCombinations("234#");	
	    System.out.println("-------------");
	    System.out.println("Letter combinations of 789234# : ");
	    letterCombinations("789234#");
	}
}
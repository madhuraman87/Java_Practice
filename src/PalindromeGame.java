import java.io.*;

/**
 * Problem Statement
 * 
 * You are given a set of cards. Each card has a string written on the front and
 * a number on the back. The strings on all the cards have the same length. You
 * must choose some of these cards (at least one, possibly all) and place them
 * in a row with the front sides visible, such that the concatenated string is a
 * palindrome
 * 
 * You are given a list of strings "front" and a list of numbers "back"
 * describing the set of cards you are given. The i-th card has front[i] written
 * on the front and back[i] on the back
 * 
 * Find the maximum possible score you can achieve with these cards. Score is
 * obtained by summing up all the "front" values that were used
 * 
 * Problem Constraints
 * 
 * front will contain between 1 and 50 elements, inclusive
 * 
 * Each element of front will contain between 1 and 50 characters, inclusive
 * 
 * Each element of front will contain the same number of characters
 * 
 * Each character in front will be a lowercase letter ('a' - 'z')
 * 
 * front and back will contain the same number of elements
 * 
 * Each element of back will be between 1 and 1,000,000, inclusive
 * 
 * Input Format
 * 
 * Line 1: Comma separated list of front strings
 * 
 * Line 2: Comma separated list of back numbers
 * 
 * Sample Input
 * 
 * abc,abc,def,cba,fed
 * 
 * 24,7,63,222,190
 * 
 * Sample Output
 * 
 * 499
 */
public class PalindromeGame {

	static int getMaximum(String[] front, int[] back) {
		int result = 0;
		boolean[] usedChar = new boolean[front.length];
		boolean found = false;
		while (true) {
			found = false;
			int max = 0, a, b;
			a = b = -1;
			for (int i = 0; i < front.length; i++) {
				for (int j = 0; j < front.length; j++) {
					if (i != j && !usedChar[i] && !usedChar[j]
							&& isPalindrome(front[i], front[j])) {
						found = true;
						if ((back[i] + back[j]) > max) {
							max = back[i] + back[j];
							a = i;
							b = j;
						}

					}
				}
			}
			if (!found)
				break;
			usedChar[a] = true;
			usedChar[b] = true;
			result += max;
		}
		int max = 0;
		for (int i = 0; i < front.length; i++) {
			if (!usedChar[i] && isPalindorme(front[i]))
				max = Math.max(max, back[i]);
		}
		result += max;
		return result;
	}

	static boolean isPalindrome(String a, String b) {
		int n = a.length();
		for (int i = 0; i < n; i++) {
			if (a.charAt(i) != b.charAt(n - 1 - i))
				return false;
		}
		return true;
	}

	static boolean isPalindorme(String a) {
		int i = 0, j = a.length() - 1;
		while (i < j) {
			if (a.charAt(i) != a.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String[] front = str.split(",");
		String str2 = in.readLine();
		String[] back = str2.split(",");
		int[] back1 = new int[back.length];
		int i = 0;
		for (String b : back) {
			back1[i] = Integer.parseInt(b);
			i++;
		}
		System.out.println(getMaximum(front, back1));
		in.close();
	}

}

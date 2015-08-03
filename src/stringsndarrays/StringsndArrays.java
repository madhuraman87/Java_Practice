package stringsndarrays;

import java.util.*;

public class StringsndArrays {

	public static boolean isUnique(String str) {
		HashSet<Character> hs = new HashSet<Character>();
		if (str == null || str.isEmpty())
			return false;
		for (int i = 0; i < str.length(); i++) {
			if (!hs.contains(str.charAt(i))) {
				hs.add(str.charAt(i));
			} else
				return false;
		}
		return true;
	}

	public static boolean isUnique2(String str) {
		if (str.length() > 256)
			return false;
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int var = str.charAt(i);
			if (char_set[var]) {
				return false;
			}
			char_set[var] = true;
		}
		return true;
	}

	public static String reverseString(String str) {
		int last = str.length() - 1;
		int strt = 0;
		StringBuilder reverse = new StringBuilder();
		if (str.isEmpty() || str == null)
			return null;
		while (last >= strt) {
			reverse.append(str.charAt(last));
			--last;
		}
		return reverse.toString();
	}

	public static String reverse1(String string) {

		byte[] array = string.getBytes();
		byte swap;

		for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
			swap = array[j];
			array[j] = array[i];
			array[i] = swap;
		}
		return new String(array);
	}

	public String reverse2(String string) {

		byte[] array = string.getBytes();

		for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {

			array[i] ^= array[j];
			array[j] ^= array[i];
			array[i] ^= array[j];
		}
		return new String(array);
	}

	public static boolean isPermutation(String A, String B) {
		if (A.length() != B.length())
			return false;
		int[] char_set = new int[256];
		for (int i = 0; i < A.length(); i++) {
			int val = A.charAt(i);
			char_set[val]++;
		}
		for (int j = 0; j < B.length(); j++) {
			int val2 = B.charAt(j);
			if (--char_set[val2] < 0)
				return false;
		}
		return true;
	}

	public static String replaceSpace(String str) {
		System.out.println("'" + str + "'");
		String str1 = str.trim();
		System.out.println("'" + str1 + "'");
		int length = str1.length();
		int newlength, i, count = 0;
		for (i = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			if (c == ' ')
				count++;
		}
		newlength = length + (count * 2);
		StringBuilder sb = new StringBuilder(newlength);
		for (i = 0; i < str1.length(); i++) {
			char d = str1.charAt(i);
			if (d == ' ')
				sb.append("%20");
			else
				sb.append(d);
		}

		return sb.toString();
	}

	public static String StringCompression(String str) {
		int count = 0;
		int i;
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < str.length() - 1; i++) {
			count++;
			if (str.charAt(i) != str.charAt(i + 1)) {
				sb.append(str.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		sb.append(str.charAt(i));
		sb.append(count + 1);
		String output = sb.toString();
		if (str.length() < output.length()) {
			System.out.println("Compressed string is longer than input string");
			return str;
		} else {
			return output;
		}
	}

	public static int[][] setZeros(int[][] matrix) {
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}

		for (int k = 0; k < rows.length; k++) {
			if (rows[k])
				nullifyRows(matrix, k);
		}

		for (int l = 0; l < columns.length; l++) {
			if (columns[l])
				nullifyColumns(matrix, l);
		}
		return matrix;
	}

	public static boolean isRotation(String A, String B) {
		if (A.length() != B.length() && A.length() < 0)
			return false;
		else {
			String BB = B + B;
			return isSubstring(A, BB);
		}
	}

	private static boolean isSubstring(String a, String b) {
		return b.contains(a);
	}

	public static void nullifyRows(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}

	public static void nullifyColumns(int[][] matrix, int column) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][column] = 0;
		}
	}

	public static int[][] rotateMatrix(int[][] matrix1, int n) {
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - first;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix1[first][i];
				matrix1[first][i] = matrix1[last - offset][first];// left->top
				matrix1[last - offset][first] = matrix1[last][last - offset];// bottom->left
				matrix1[last][last - offset] = matrix1[i][last];// right->bottom
				matrix1[i][last] = top;// top->right
			}
		}
		return matrix1;
	}

	public static int[][] mirrorMatrix(int[][] matrix2, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix2[i][j];
				matrix2[i][j] = matrix2[i][n - 1 - j];
				matrix2[i][n - 1 - j] = tmp;
			}
		}
		return matrix2;
	}

	public static int[][] mirrorMatrixNWSE(int[][] matrix3, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				int tmp = matrix3[i][j];
				matrix3[i][j] = matrix3[n - 1 - j][n - 1 - i];
				matrix3[n - 1 - j][n - 1 - i] = tmp;
			}
		}
		return matrix3;
	}

	public static int[][] mirrorMatrixNESW(int[][] matrix4, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int tmp = matrix4[i][j];
				matrix4[i][j] = matrix4[j][i];
				matrix4[j][i] = tmp;
			}
		}
		return matrix4;
	}

	public static void displayMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			// for each number in the row
			for (int j : row) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}

	public static void getRange(int[] arr, int sum) {
		int i;
		int j;
		int curr;
		for (i = 0; i < arr.length - 1; i++) {
			curr = arr[i];
			for (j = i + 1; j <= arr.length - 1; j++) {

				if (curr == sum) {
					System.out.println("Sum" + sum + "is found between indexes"
							+ i + "and" + j);
					break;
				}
				if (curr > sum || j == arr.length) {
					break;
				}
				curr = curr + arr[j];
			}
		}
		System.out.println("Sum" + sum + "is not found");
	}

	public static boolean findMatchingBracket(String s) {
		if (s.isEmpty()) {
			return false;
		}
		char[] text = s.toCharArray();
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < text.length; i++) {
			if (text[i] == '{' || text[i] == '(' || text[i] == '[') {
				st.push(text[i]);
			}
			if (text[i] == '}' || text[i] == ')' || text[i] == ']') {
				if (st.isEmpty()) {
					return false;
				}
				char curr = st.peek();
				if (curr == '{' && text[i] == '}' || curr == '('
						&& text[i] == ')' || curr == '[' && text[i] == ']')
					st.pop();
				else
					return false;
			}
		}
		return st.isEmpty();
	}
	
	// find first occurrence and last occurrence of an element in an array with duplicates
	public static int findOccurence(int[] a, int x, boolean flag) { 
		int len = a.length;
		int low = 0;
		int high = len - 1;
		int mid;
		int result = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (x == a[mid]) {
				result = mid;
				if (flag)
					high = mid - 1;// for first occurrence move towards left
				else
					low = mid + 1;// for last occurrence move towards right
			} else if (x < a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}
	
    //count the occurrence of an element in an array with duplicates
	public static void countOfOccurence(int[] a, int x) {
		int count;
		int firstIndex = findOccurence(a, x, true);
		if (firstIndex == -1) {
			System.out.println("Count of " + x + " is " + firstIndex);
		} else {
			int lastIndex = findOccurence(a, x, false);
			count = (lastIndex - firstIndex) + 1;
			System.out.println("Count of " + x + " is " + count);
		}
	}

	// the index of the minimum element will give the no of rotations
	public static int noOfRotations(int[] a) {
		int len = a.length;
		int low = 0;
		int high = len - 1;
		while (low <= high) {
			// case 1 : when there are no rotations
			if (a[low] <= a[high]) 
				return low;
			int mid = (low + high) / 2;
			int next = (mid + 1) % len;
			int prev = (mid + len - 1) % len;
			// case 2 : when the minimum element is somewhere in middle, according to pivot property of cyclic array, the pivot will be 
			// lesser than the next and previous element, thereby that pivot will be the minimum element.
			if (a[mid] <= a[prev] && a[mid] <= a[next]) 
				return mid; 
			// case 3 : when the array is not sorted, BST prop - move towards right, discarding left window of elements
			if (a[mid] >= a[low]) 
				low = mid + 1;
			// case 4 : when the array is not sorted, BST prop - move towards left, discarding right window of elements
			else if (a[mid] <= a[high]) 
				high = mid - 1;
		}
		return -1;
	}

	public static int findElementInCArray(int[] a, int x) {
		int len = a.length;
		int low = 0;
		int high = len - 1;
		while (low <= high) {

			int mid = (low + high) / 2;
			if (x == a[mid]) // case 1
				return mid;
			if (a[mid] <= a[high]) { // case 2 : right array is sorted
				if (x > a[mid] && x <= a[high])
					low = mid + 1;
				else
					high = mid - 1;
			} else if (a[mid] >= a[low]) { // case 3 : left array is sorted
				if (x >= a[low] && x < a[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		return -1;
	}
	
	//find if two strings are anagram or permutation of each other - http://collabedit.com/wcc2s
	public static boolean isAnagram(String a, String b){
		if(a.length() != b.length() || a == null || b == null || a.isEmpty() || b.isEmpty()){
			return false;
		}
		
		char[] aStr = a.toCharArray();
		char[] bStr = b.toCharArray();
		Arrays.sort(aStr);
		Arrays.sort(bStr);
		a = String.valueOf(aStr);
		b = String.valueOf(bStr);
		
		for(int i=0; i<aStr.length; i++){
			if(aStr[i] != bStr[i]){
				return false;
			}
		}
		return true;
		
//		return Arrays.equals(aStr, bStr);
//		return a.equals(b);
	}
	
	//find the fibonacci number given the nth number - recursive
	public static int fibonacciR(int n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}		
		return (fibonacciR(n-1) + fibonacciR(n-2));
	}
	
	//find the fibonacci number given the nth number - iterative
	public static int fibonaccI(int n){
		int fib1 = 0;
		int fib2 = 1;
		int fibonacci = 0;
		for(int i=2; i<=n; i++){
			fibonacci = fib1 + fib2;
			fib1 = fib2;
			fib2 = fibonacci;
		}
		return fibonacci;
	}
	
	//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
	//(assume that the array is non-empty and the majority element always exist in the array.)
	public static int majorityElement(int[] num){
		if(num.length == 0){
			return -1;
		}
		if(num.length == 1){
			return num[0];
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : num){
			if(!map.containsKey(i)){
				map.put(i, 1);
			}else{
				map.put(i, (map.get(i)+1));
			}
		}
		for(int key : map.keySet()){
			if(map.get(key) > num.length/2){
				return key;
			}
		}
		return -1;		
	}
	
	public static int majorityElementS(int[] num){
		if(num.length == 0){
			return -1;
		}
		if(num.length == 1){
			return num[0];
		}
		Arrays.sort(num);
		return num[num.length/2];
	}
	
	// "123" --> 123 https://code.stypi.com/ypsk4yzi
	public static int atoi(char[] str, int len) {
//		String tmp = new String(str);
//		int result = Integer.parseInt(tmp);
//		return result;		
		
//		String y = String.valueOf(str);
//		int result = Integer.parseInt(y);
//		return result;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char x = str[i];
//			int y = Character.getNumericValue(x);//returns integer value
			String y = String.valueOf(x); //returns string value
			sb.append(y);
		}
		int result = Integer.parseInt(sb.toString());//returns integer value of string--string to int conv
		return result;
	}

	public static void main(String[] args) {

		// Scanner obj = new Scanner(System.in);
		// System.out.print("Enter the input string for white space replace : "
		// );
		// String input3 = obj.nextLine();
		// System.out.println("The output string : " + replaceSpace(input3));
		// System.out.print("Enter the input string for reversal : " );
		// String input = obj.next();
		// System.out.println("The output string : " + reverseString(input));
		// System.out.print("Enter the input string for compression : " );
		// String input2 = obj.next();
		// System.out.println("The output string : " +
		// StringCompression(input2));
		// System.out.print("Enter the input string for rotation check : " );
		// String input1 = obj.next();
		// String input2 = obj.next();
		// System.out.println("Output : " + isRotation(input1, input2));
		// obj.close();
		// int input[][] = { { 5, 1, 4, 0 }, { 6, 0, 7, 8 }, { 1, 5, 0, 1 },
		// { 2, 2, 2, 1 } };
		// displayMatrix(input);
		// System.out.println("Output Matrix: ");
		// displayMatrix(mirrorMatrixNESW(input, 4));

		// int[] iparray = new int[] {23,28,31,5,6,8,10,12,15,22};
		// //System.out.println(findOccurence(iparray, 5, false));
		// //countOfOccurence(iparray,6);
		// System.out.println("No of rotations is " +noOfRotations(iparray));

//		char[] str = new char[]{'1','2','3','4'};
//		System.out.println("The output : " + atoi(str, 4));
		
		System.out.println(isAnagram("abcc", "ccb"));
		System.out.println(fibonaccI(7));
		int[] iparray = new int[] {1,1,5,1,4,1,6,1,1};
		System.out.println(majorityElementS(iparray));
		//obj.close();
	}
}

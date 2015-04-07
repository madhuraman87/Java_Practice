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
	
	public static String reverse1( String string ) {

	    byte[] array = string.getBytes();
	    byte swap;

	    for( int i = 0, j = array.length - 1; i < array.length / 2; i++, j-- ) {
	        swap = array[ j ];
	        array[ j ] = array[ i ];
	        array[ i ] = swap;
	    }
	    return new String( array );
	}
	
	public String reverse2( String string ) {

	    byte[] array = string.getBytes();

	    for( int i = 0, j = array.length - 1; i < array.length / 2; i++, j-- ) {

	        array[ i ] ^= array[ j ];
	        array[ j ] ^= array[ i ];
	        array[ i ] ^= array[ j ];
	    }
	    return new String( array );
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
		int input[][] = { { 5, 1, 4, 0 }, { 6, 0, 7, 8 }, { 1, 5, 0, 1 },
				{ 2, 2, 2, 1 } };
		displayMatrix(input);
		System.out.println("Output Matrix: ");
		displayMatrix(mirrorMatrixNESW(input, 4));
	}
}

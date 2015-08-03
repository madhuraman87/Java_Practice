/**
 * Given two strings. Find the index of the second string in the first string
 * without using any java methods.
 * 
 * Eg :
 * 
 * string1 = "HI HELLO" string2= "HELL"
 * 
 * output : 3
 * 
 * string1 = "AAAABCDE" string2 = "AAAB"
 * 
 * output : 1
 * 
 * Just checking that you intend to be reinventing-the-wheel, you can do:
 * 
 * System.out.println("happy".indexOf("app")); You did know that, right?
 * 
 * Or, if you want to reformat the 'signature' to match yours, it is:
 * public static int subStringIndex(String str, String substr) { 
 *  return str.indexOf(substr); } 
 * 
 * There are a number of helper methods on String which will help:
 * 
 * String.indexOf(substr) - return the index of the first occurrence of substr
 * String.indexOf(substr, start) - return the index of the first occurrence of substr on or after the start position. 
 * String.lastIndexOf(substr) - return the index of the last occurrence of substr 
 * String.lastIndexOf(substr, start) - return the index of the last occurrence of substr starting before the start position.
 * 
 *
 */
public class Oracle {

	public static int findIndexOfSubString(String str, String substr){
		if(str == null || substr == null || str.length() == 0 || substr.length() == 0){
			return -1;
		}
		if(str.length() < substr.length()){
			return -1;
		}
		int i = 0; 
		int j = 0;
		while(i < str.length() && j < substr.length()){
			if(str.charAt(i) == substr.charAt(j)){
				i++;
				j++;				
			}else{
				if(j > 0){
					i = i - j;
					j = 0;
				}
				i++;
			}
		}
		if(j == substr.length()){
			return i - j;
		}
		return -1;
	}
	
	public static int findIndexOfSubString2(String str, String substr){
		if(str == null || substr == null || str.length() == 0 || substr.length() == 0){
			return -1;
		}
		if(str.length() < substr.length()){
			return -1;
		}
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == substr.charAt(0)){
				if(i + substr.length() <= str.length()){
					if(str.substring(i,  i + substr.length()).equals(substr)){
						return i;
					}					
				}else{
					return -1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(findIndexOfSubString2("HI HELLO", "HELL"));
		System.out.println(findIndexOfSubString2("AAAABCDE", "AAAB"));
		System.out.println(findIndexOfSubString2("Internnet", "net"));
		System.out.println("----");
		System.out.println(findIndexOfSubString("HI HELLO", "HELL"));
		System.out.println(findIndexOfSubString("AAAABCDE", "AAAB"));
		System.out.println(findIndexOfSubString("Internnet", "net"));	
	}

}


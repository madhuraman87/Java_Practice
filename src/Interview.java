//replace all AB pairs with C
public class Interview {
	public static void replaceString(String s){
		StringBuilder sb = new StringBuilder(s);
		String guess = "AB";
		int p = s.indexOf(guess);
		int[] index = new int[10];
		int i=0;
		int count = 0;
		while (p >= 0) {
			count++;
		    System.out.println(p);		    
			index[i++] = p;
		    p = s.indexOf(guess, p+1);
		}
		int[] newIndex = new int[count];
		System.arraycopy(index, 0, newIndex, 0, count);
		for(int j=0;j< newIndex.length;j++){
			int strt = newIndex[j];
			int end = strt + 1;
			sb.replace(strt, end+1, "*%");			
		}
		String result = sb.toString();
		System.out.println(s);
		System.out.println(result);		
		StringBuilder sb1 = new StringBuilder();
		for (i = 0; i < result.length(); i++) {
			char d = result.charAt(i);
			if (d == '*')
				sb1.append("C");
			else if (d == '%')
				continue;
			else
				sb1.append(d);
		}
		System.out.println(sb1.toString());
	}
	
	public static void  nonOverlap (String s){
		if(s == null || s.isEmpty()){
			System.out.println("No");			
		}
		
	}
	public static void main(String[] args) {

		 replaceString("helABlowABorlAB");
		
	}	
}

//#include <stdio.h>
//
//void translate(char *s){
//	int i;
//	int k;
//	char *c;
//	int count=0;
//	while (s[i+1]!='\0'){
//         if(s[i]=='A' && s[i+1]=='B'){
//            c[k]='C';
//                i=i+2;
//                k++;
//                count++;
//           }
//         else{
//           c[k]=c[i];
//           i++;
//               k++;         
//         }
//       }
//        c[k+1]='\0';
//	}
//int main(void) {
//	//char astring[] = "helloABworld";
//	translate(astring);
//	// your code goes here
//	return 0;
//}
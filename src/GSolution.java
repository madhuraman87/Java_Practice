
public class GSolution {
	public static String solution(String S, int K) {
        // write your code in Java SE 8
    	if(S.isEmpty() || S == null){
    		return null;
    	}
//    	//int i = S.indexOf('-');
//    	System.out.println(S.toUpperCase());
//    	int i = S.indexOf('-');
//    	char[] str = S.toUpperCase().toCharArray();
//    	//System.out.println(i);
//    	System.out.println(S.indexOf('-', i+1));
        String[] splitStr = S.toUpperCase().split("-");
        int noOfSplits = splitStr.length;
        StringBuilder sb = new StringBuilder();
//        StringBuilder finalS = new StringBuilder();
        for(int i=noOfSplits-1;i>0;i--){
        	StringBuilder s = new StringBuilder(splitStr[i]);
        	System.out.println("s- " +s);
        	int borrow = s.length()-K;
        	if(borrow > 0){
        		String stay = s.substring(borrow, s.length());
        		String left = s.substring(0, borrow);
        		sb.append('-');
        		sb.append(stay);        		
            	System.out.println("left " +left);
            	System.out.println(sb.toString());
        	}
        	
//        	if(s.length() != K){
//        		int rest = K-s.length();
//        		System.out.println("rest " + rest);  
//        		//r.reverse();
//        		int borrow = r.length()-rest;
//        		String borrowed = r.substring(borrow, r.length());
//        		
//        		System.out.println("borrowed " +borrowed);
//        		System.out.println("rest " +restStr);
//        		sb.append(restStr);
//        		sb.append('-');
//        		sb.append(borrowed); 
//        		sb.append(s);   		
//        		
//        		System.out.println(sb.toString());
//        	}
//        	finalS.append(sb.toString());
//        	finalS.append("-");
        }
        return null;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	solution("2-4A0r7-4k",4);
	}

}

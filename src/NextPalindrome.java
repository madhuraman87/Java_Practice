
public class NextPalindrome {
//	example:  60    output 66
//	117            output 121
	public static void next_palindrome(int n){
	    int r; 
	    for(int i=n+1;i>0;i++){
	        r=0;
	        int t = i;
	        while(t != 0){ //118
	           r = r*10; //0
	           r = r + t%10; //8 
	           t = t/10;  
	        }        
	        if(r == i){
	            System.out.println("Next palindrome " +r);
	            break;
	        }    
	    }
	}
	
	public static void main(String[] args) {

		 next_palindrome(60);
		
	}

}

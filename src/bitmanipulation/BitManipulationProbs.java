package bitmanipulation;
import java.util.*;

public class BitManipulationProbs {

	public static boolean isGrayCode(String a, String b){
		int num1 = Integer.parseInt(a, 2);
		int num2 = Integer.parseInt(b, 2);
		int count = 0;
		while(num1>0 && num2>0){
			if((num1 & 1) != (num2 & 1)){
				count++;
			}
			num1 = num1 >> 1;
			num2 = num2 >> 1;
		}
		if(num1>0 || num2>0){
			return false;
		}
		return (count==1);
	}
	
	public static void main(String args[]){
		System.out.println("Enter the two binary numbers :");
		Scanner obj1 = new Scanner(System.in);
		String input1 = obj1.next();
		String input2 = obj1.next();
		System.out.println("Are the two numbers consecutive in the gray code sequence? " + isGrayCode(input1, input2));
		obj1.close();
	}
}
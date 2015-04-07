package bitmanipulation;
import java.util.*;
//Other imports go here

//Do NOT change the class name
class MySolution {
 public static void main(String[] args) {
     // Write your code here
     Scanner obj = new Scanner(System.in);
     ArrayList<String> inputList = new ArrayList<String>();
     int num = obj.nextInt();
     //System.out.println(+num);
     while(num > 0){
         String input = obj.next();
         inputList.add(input);
         num--;
     }
     for(String io : inputList){
    	 int output = Integer.parseInt(io, 2);
         System.out.println(+output);
     }     
     obj.close();
 }
}
package popSugar;
import java.util.*;
public class Survivor {	
	// Note : utilizing circular linked list as the data structure to solve the problem. Time Complexity is O(n^2). 
	public static int getSurvivor(int chairNum){
		ChairNode prevChair = buildCircle(chairNum);
		int size = chairNum;
		while(size > 1){
			ChairNode toLeave = prevChair.next; //chair to be taken away - starts with the first chair
			prevChair.next = toLeave.next;
			toLeave.next = null;
			size--;
			int skip = (chairNum - size) % size; // number of chairs to skip (1,2,3,4...etc)
			while(skip-- > 0){ 
				prevChair = prevChair.next;
			}			
		}
		return prevChair.data; //last chairNode's data
	}
	
	public static ChairNode buildCircle(int chairNumber){  //helper code to build the circular linked list of chairNodes
		
		final ChairNode last = new ChairNode(chairNumber);
		ChairNode tmp = last;
		while(--chairNumber > 0){
			ChairNode c = new ChairNode(chairNumber);
			c.next = tmp;
			tmp = c;
		}
		last.next = tmp;
		return last; // returns pointer pointing to the last chairNode before the beginning of the circle.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter no of People : ");
		int input = obj.nextInt();
		System.out.println("For chair seating of "+input+", lone survivor is: Chair number " +getSurvivor(input));
		obj.close();
//		System.out.println("For chair seating of 100, lone survivor is: Chair number " +getSurvivor(100));
//		System.out.println("For 5 " +getSurvivor(5));
//		System.out.println("For 10 " +getSurvivor(10));
//		System.out.println("For 15 " +getSurvivor(15));
//		System.out.println("For 20 " +getSurvivor(20));
//		System.out.println("For 25 " +getSurvivor(25));
//		System.out.println("For 30 " +getSurvivor(30));

		
	}
}
package hackkerank;

import java.util.*;

public class MaxOfList {
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int t = in.nextInt();
		Integer[] data = new Integer[size];
		Arrays.fill(data, new Integer(0));
		List<Integer> list = Arrays.asList(data);		
		for(int i=0;i<t;i++){
			int strt = in.nextInt();
			int end = in.nextInt();
			int val = in.nextInt();
			for(int j=strt-1;j<=end-1;j++){
				int num = list.get(j);
				num+=val;
				list.set(j, num);
			}
		}
		System.out.println(Collections.max(list));
		in.close();
	}
}

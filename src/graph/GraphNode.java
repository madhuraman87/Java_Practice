package graph;

import java.util.*;

public class GraphNode {
	
	private static int input[][] = {{0,1,1,0},
			 {0,0,1,0},
			 {1,0,0,1},
			 {0,0,0,1}};
	
	private static HashMap<Integer, ArrayList<Vertex>> hashmap = new HashMap<Integer, ArrayList<Vertex>>();	
	
	public static void main(String args[]){
		
		ArrayList<Vertex> l1 = new ArrayList<Vertex>();
		l1.add(new Vertex(1,7));
		l1.add(new Vertex(2,9));
		l1.add(new Vertex(5,14));
//		l1.add(new Vertex(1,1));
//		l1.add(new Vertex(2,4));
		
		ArrayList<Vertex> l2 = new ArrayList<Vertex>();
		l2.add(new Vertex(2,10));
		l2.add(new Vertex(3,15));
//		l2.add(new Vertex(2,2));
//		l2.add(new Vertex(3,6));
				
		ArrayList<Vertex> l3 = new ArrayList<Vertex>();
		l3.add(new Vertex(3,11));
		l3.add(new Vertex(5,2));
//		l3.add(new Vertex(3,3));
		
		ArrayList<Vertex> l4 = new ArrayList<Vertex>();
		l4.add(new Vertex(4,6));
		
		ArrayList<Vertex> l5 = new ArrayList<Vertex>();
		l5.add(new Vertex(5,9));
		
		ArrayList<Vertex> l6 = new ArrayList<Vertex>();
								
		hashmap.put(new Integer(0), l1);
		hashmap.put(new Integer(1), l2);
		hashmap.put(new Integer(2), l3);
		hashmap.put(new Integer(3), l4);
		hashmap.put(new Integer(4), l5);
		hashmap.put(new Integer(5), l6);				
	
//		System.out.println("BreadthFirstSearch thro Adjacency List");
//		Traversal.lBreadthFirstSearch(hashmap, 2);
//		System.out.println("--");
//		System.out.println("DepthFirstSearch thro Adjacency List");
//		Traversal.lDepthFirstSearch(hashmap,2,new HashSet<Integer>());
//		System.out.println("--");
		System.out.println("BreadthFirstSearch thro Adjacency Matrix");
		Traversal.mBreadthFirstSearch(input, 2);
		System.out.println("--");
		System.out.println("DepthFirstSearch thro Adjacency Matrix");
		Traversal.mDepthFirstSearch(input,2,new HashSet<Integer>());
		System.out.println("--");
		Traversal.displayMap(hashmap);
		Traversal.dijsktraShortPath(hashmap, 6, 0, 4);
	}
}

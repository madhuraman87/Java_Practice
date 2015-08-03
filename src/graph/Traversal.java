package graph;
import java.util.*;
import java.util.Map.Entry;

public class Traversal {
	
//	static Queue<Integer> q = new LinkedList<Integer>(); 
//	static HashSet<Integer> visited = new HashSet<Integer>();
	
	public static void lBreadthFirstSearch(HashMap<Integer, ArrayList<Integer>> map, int root){
		Queue<Integer> q = new LinkedList<Integer>(); 
		HashSet<Integer> visited = new HashSet<Integer>();
		q.add(root);
		visited.add(root);
		while(!q.isEmpty()){	
			root = q.remove();
			System.out.println(root);
			Object[] a = map.get(root).toArray();
			for(int i = 0; i < a.length; i++){
				if(!visited.contains(a[i])){
					visited.add((Integer) a[i]);
					q.add((Integer) a[i]);
				}
			}
		}
	}
	
	public static void lDepthFirstSearch(HashMap<Integer, ArrayList<Integer>> map, int root, HashSet<Integer> visited){
		visited.add(root);
		System.out.println(root);
		Object[] a = map.get(root).toArray();
		for(int i = 0; i < a.length; i++){
			if(!visited.contains(a[i])){
				lDepthFirstSearch(map, (int)a[i], visited);
			}
		}
	}

	public static void mBreadthFirstSearch(int[][] matrix, int root){
		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		q.add(root);
		visited.add(root);
		while(!q.isEmpty()){
			root = q.remove();
			System.out.println(root);
			for(int i = 0; i < matrix.length; i++){
				if(matrix[root][i] == 1 && !visited.contains(i)){
					visited.add(i);
					q.add(i);
				}
			}
		}
	}
	
	public static void mDepthFirstSearch(int[][] matrix, int root, HashSet<Integer> visited){
		visited.add(root);
		System.out.println(root);
		for(int i = 0; i < matrix.length; i++){
			if(!visited.contains(i)){
				mDepthFirstSearch(matrix, i,visited);
			}
		}
	}
	
	public static void displayMap(HashMap<Integer, ArrayList<Vertex>> hashmap){
		// display all the elements
		// Get a set of the entries
		Set<Entry<Integer, ArrayList<Vertex>>> setMap = hashmap.entrySet();
		// Get an iterator
		Iterator<Entry<Integer, ArrayList<Vertex>>> iteratorMap = setMap.iterator();
		System.out.println("HashMap with Multiple Values");
		
		while(iteratorMap.hasNext()) {

			Map.Entry<Integer, ArrayList<Vertex>> entry = (Map.Entry<Integer, ArrayList<Vertex>>) iteratorMap.next();
			Integer key = entry.getKey();
			ArrayList<Vertex> values = entry.getValue();
			System.out.println("Key = '" + key + "' has values: " + values.toString());
		}
	}
	
	public static void dijsktraShortPath(HashMap<Integer, ArrayList<Vertex>> graph, int vertices, int src, int dest){
		//initial set up
		int[] distance = new int[vertices];
		Arrays.fill(distance, src+1, vertices, Integer.MAX_VALUE);
		ArrayList<Vertex> neighbours = getNeighbours(graph, src);
//		System.out.println("Neighbours" + neighbours.toString());
		List<Vertex> fringe = new ArrayList<Vertex>();
		for(Vertex n : neighbours){
			int vertex = n.getVertex();
			distance[vertex] = n.getWeight();
			fringe.add(n);
		}
		List<Vertex> checker = makeCopy(fringe);		
//		Collections.copy(checker, fringe);//shallow copy-changing original will change the copied list too
//		System.out.println("Distance Array" + Arrays.toString(distance));//print element in array;for printing elements in ArrayList : System.out.println(Arrays.toString(list.toArray()));
//		System.out.println("Fringe" + fringe.toString());
//		System.out.println("----------------------------");
		while (!fringe.isEmpty()){
			Vertex mini = min(fringe);
//			System.out.println("Minimum Vertex" + mini.toString());
			fringe.remove(mini);
//			System.out.println("Fringe" + fringe.toString());
//			System.out.println("----------------------------");
			ArrayList<Vertex> neigh = getNeighbours(graph, mini.getVertex());
			for(Vertex w : neigh){
				
//				System.out.println("Vertex" + w.toString());
				if(distance[w.getVertex()] == Integer.MAX_VALUE){
//					System.out.println("Fringe" + fringe.toString());
					distance[w.getVertex()] = distance[mini.getVertex()] + w.getWeight();
					w.setWeight(distance[w.getVertex()]);
					w.setPrev(mini.getVertex());
					checker.add(w);
					fringe.add(w);					
//					System.out.println("Distance Array" + Arrays.toString(distance));
//					System.out.println("Fringe" + fringe.toString());
//					System.out.println("----------------------------");
				}
				else{
					int prev = mini.getVertex();
					distance[w.getVertex()] = Math.min(distance[w.getVertex()], (distance[mini.getVertex()] + w.getWeight()));
					updateVertex(checker,w,distance[w.getVertex()],prev);
					w.setWeight(distance[w.getVertex()]);
//					System.out.println("Distance Array" + Arrays.toString(distance));
//					System.out.println("Fringe" + fringe.toString());
				}
			}
		}
		System.out.println("Checker : " + checker.toString());
		System.out.print("Final Path : " );
		displayPath(checker,dest);
		System.out.println("Path Weight : " + distance[dest]);
	}
	
	public static void displayPath(List<Vertex> checker, int dest){
		List<Integer> finalVertex = new ArrayList<Integer>();
		finalVertex.add(dest);
		int prev = dest;
		while(!checker.isEmpty()){
			Iterator<Vertex> i = checker.iterator();
			while(i.hasNext()){
				Vertex v = i.next();
				if(v.getVertex() == prev){
					prev = v.getPrev();
					finalVertex.add(prev);					
				}
				else if(v.getVertex() > prev){
					i.remove();			
				}
			}			
		}	
		Collections.reverse(finalVertex);
		for(int j = 0; j < finalVertex.size(); j++){
			if (j != finalVertex.size()-1)
				System.out.print(finalVertex.get(j) + "->");
			else
				System.out.println(finalVertex.get(j));
		}
	} 
	
	public static ArrayList<Vertex> getNeighbours(HashMap<Integer, ArrayList<Vertex>> graph, int src){
		ArrayList<Vertex> neighbours = new ArrayList<Vertex>();
		neighbours = graph.get(src);
		return neighbours;
	}
	
	public static List<Vertex> makeCopy(List<Vertex> fringe){
		List<Vertex> copy = new ArrayList<Vertex>();
		Iterator<Vertex> i = fringe.iterator();
		while(i.hasNext()){
			copy.add(i.next().clone());
		}
		return copy;
	}
	
	public static Vertex min(List<Vertex> fringe){
		List<Integer> dist = new ArrayList<Integer>();
		if(fringe.isEmpty()) return null;
		for(Vertex v : fringe){
			int weight = v.getWeight();
			dist.add(weight);
		}
		int min = Collections.min(dist);
		Vertex vert = new Vertex();
		for(Vertex v : fringe){
			int weight = v.getWeight();
			if(weight == min){
				vert = v;
			}
		}
		return vert;
	}
	
	public static void updateVertex(List<Vertex> checker, Vertex w, int weight, int miniVertex ){
		
		Iterator<Vertex> i = checker.iterator();
		while(i.hasNext()){
			Vertex v = i.next();
			if(v.getVertex() == w.getVertex()){
				if(weight < v.getWeight()){
					v.setWeight(weight);
					v.setPrev(miniVertex);
					break;
				}	
				else if (weight == v.getWeight())
					break;
			}
		}
	}
}


//int[] distance = new int[vertices];
//List<Integer> path = new ArrayList<Integer>();
//
//Arrays.fill(distance, src+1, vertices, Integer.MAX_VALUE);
//System.out.println("Actual values: ");
//for (int value : distance) {
//  System.out.println("Value = " + value);
//}
//List<Integer> X = new ArrayList<Integer>();
//List<Integer> Y = new ArrayList<Integer>();
//
//X.add(new Integer(src));
//for(int i = src+1; i < graph.length;i++){
//	Y.add(new Integer(i));
//}
////System.out.println(Y.toString());	
//
//while(!Y.isEmpty()){
//	int minval = Integer.MAX_VALUE;
//	int minnode = 0;
//	for(int x : X){
//		for (int y : Y){
//			int curr = distance[x] + graph[x][y];
//			if(distance[y] > curr){
//				distance[y] = curr;
//			}
//			if(curr < minval){ 
//				minval = curr;
//				minnode = y;
//			}
//		}
//	}
//	int ele = Y.remove(minnode);
//	X.add(ele);
//	path.add(ele);
//}	
//
//path.add(new Integer(distance[dest]));
//System.out.println(path.toString());
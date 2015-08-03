package trieADT;
//
//
//import java.io.*;
//import java.util.*;
//
//public class LongestWord {
//
//	private static final String inputFile = "/home/madhuajeeth/workspace/Java_Practice/src/asperaInc/wordsforproblem.txt";
//	private static ArrayList<String> list = new ArrayList<String>();
//	private static Queue<Pair> holder1 = new LinkedList<Pair>();
//	private static ArrayList<String> wordList = new ArrayList<String>();	
//	 
//	private static Trie trieStruc = new Trie();
//	
//	private static void readfromFile() {
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(inputFile));
//			try {
//				String line = br.readLine();				
//				while (line != null) {
////					System.out.println(line);
//					list.add(line);
//					line = br.readLine();
//				}
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if (br != null)
//						br.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void buildTrie(){
//		
//		for(String letter : list){
//			trieStruc.insertWord(letter);	
//			
//		}
//	}
//	
//	public static ArrayList<String> longestWordFromOther(){
//		
//		for(String letter : list){
//			addPrefix(letter, holder1);
//		}
//		checkPairQueue(wordList,holder1);
//		Collections.sort(wordList, new Comparator<String>(){
//			@Override
//			public int compare(String o1, String o2) {
//                return ((Integer) o2.length()).compareTo(o1.length());
//            }
//		});
////		for(String lr : wordList)
////			System.out.println("R " +lr);		
//		
//		return wordList;
//	}
//	
//	public static ArrayList<String> checkPairQueue(ArrayList<String> wordList, Queue<Pair> holder1){
//				
//		while(!holder1.isEmpty()){
//			Pair p = holder1.remove();
////			System.out.println(p.toString());
//			addPrefix(p.getOriginal(), p.getPs(), holder1);
//			if(trieStruc.doesContainString(p.getPs())){
//				wordList.add(p.getOriginal());
//			}
//		}
//		return wordList;
//	}
//	
//	public static void addPrefix(String s, Queue<Pair> holder1){		
//		if(!holder1.contains(s)){
//			for (int i = 1; i < s.length(); ++i) {
//				String left = s.substring(0, i);
//		        String right = s.substring(i);
//		        if(trieStruc.doesContainString(left)){
//		        	holder1.add(new Pair(s, right));
////		        	holder.put(s, right);		        	  
//		        }
//		    }	
//		}
//	}
//	
//	public static void addPrefix(String orig, String s, Queue<Pair> holder1){		
//		if(!holder1.contains(s)){
//			for (int i = 1; i < s.length(); ++i) {
//				String left = s.substring(0, i);
//		        String right = s.substring(i);
//		        if(trieStruc.doesContainString(left)){
//		        	holder1.add(new Pair(orig, right));
////		        	holder.put(s, right);		        	  
//		        }
//		    }	
//		}
//	}
//	
//
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		readfromFile();		
//		buildTrie();
////		trieStruc.deleteWord("mouse");
////		System.out.println(trieStruc.doesContainString("mouse"));
////		for(String letter : list)
////			System.out.println(letter);	
//		ArrayList<String> result = longestWordFromOther();
//		System.out.println("First longest word made from others: " +result.get(0));
//		System.out.println("Second longest word made from others: " +result.get(1));	
//		System.out.println("Number of words that can be made from others: " +result.size());
////		String[] arr = new String[list.size()];	
////		System.out.println("Answer " +findLongestWord(list.toArray(arr)));
//
//	}
//
//}
//
//

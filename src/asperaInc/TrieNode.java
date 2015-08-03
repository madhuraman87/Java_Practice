package asperaInc;

import java.util.*;

public class TrieNode {
	private HashMap<Character,TrieNode> childNodes;
	private boolean wordEnds = false;
	private char data;
	
	public TrieNode(char data){
		this.childNodes = new HashMap<Character, TrieNode>();
		this.data = data;
	}
	
	public char getData(){
		return data;		
	}
	
	public TrieNode getChildNode(char d){
		return childNodes.get(d);
	}
	
	public void setChildNode(char d, TrieNode n){
		childNodes.put(d, n);
	}
	
	public void removeNode(char d){
		childNodes.remove(d);
	}
	
	public boolean isEndOfWord(){
		return wordEnds;
	}
	
	public void setWordEnds(boolean t){
		wordEnds = t;
	}
}
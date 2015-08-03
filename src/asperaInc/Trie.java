package asperaInc;

public class Trie {
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode('#');
	}
	
	public TrieNode getTrieRoot(){
		return root;
	}
	
	public void insertWord(String str){
		TrieNode curr = root;
		if(str == null || str.isEmpty()){
			return;
		}
		for(int i = 0; i < str.length(); i++){			
			char letter = str.charAt(i);
			TrieNode child = curr.getChildNode(letter);
			
			if(child != null){
				curr = child;
			}else{
				curr.setChildNode(letter, new TrieNode(letter));
				curr = curr.getChildNode(letter);
			}	
			
			if(i == str.length()-1){
				curr.setWordEnds(true);				
			}				
		}		
	}	
	
	public void deleteWord(String str) {
		if(doesContainString(str) == false){
            return;
		}   
		TrieNode curr = root;
		for(int i=0; i < str.length(); i++){
			char letter = str.charAt(i);
			TrieNode child = curr.getChildNode(letter);
			if(child != null){
				curr.removeNode(child.getData());
				return;				
			}else{
				curr = child;
			}
		}
		curr.setWordEnds(false);
	}
		
	public boolean doesContainString(String str){
		TrieNode curr = root;
		if(str == null || str.isEmpty()){
			return false;
		}
		while(curr != null){
			for(int i = 0; i < str.length(); i++){
				char letter = str.charAt(i);
				TrieNode child = curr.getChildNode(letter);
				if(child == null)
					return false;
				else
					curr = child;
			}
			if(curr.isEndOfWord() == true)
				return true;
			else 
				return false;
		}
		return false;
	}
	

}
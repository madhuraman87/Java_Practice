package trieADT;

public class Pair {
	
	private String originalWord;
	private String ps;
	
	public Pair(String originalWord,String ps){
		this.originalWord = originalWord;
		this.ps = ps;
	}

	public String getOriginalWord() {
		return originalWord;
	}

	public void setOriginalWord(String originalWord) {
		this.originalWord = originalWord;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}
	
	public String toString(){
		return getOriginalWord() + " : " + getPs();
	}

}

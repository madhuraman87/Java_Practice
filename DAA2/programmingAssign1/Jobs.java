package programmingAssign1;

public class Jobs {
	
	private Double weight;
	private Double length;
	private Double completiont;
	private Double comparator;
	
	public Jobs(Double weight, Double length, Double comparator){
		this.weight = weight;
		this.length = length;
		this.comparator = comparator;
	}
	
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getCompletiont() {
		return completiont;
	}
	public void setCompletiont(Double completiont) {
		this.completiont = completiont;
	}	
	public Double getComparator() {
		return comparator;
	}
	public void setComparator(Double comparator) {
		this.comparator = comparator;
	}

	@Override
	public String toString(){
		return "(" + weight + "," + length + "," + comparator + ")" ;
	}
}
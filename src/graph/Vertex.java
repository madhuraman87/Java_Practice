package graph;

public class Vertex implements Cloneable {
	
	private int vertex;
	private int weight;
	private int prev;
	
	public Vertex(int vertex, int weight) {
		
		this.vertex = vertex;
		this.weight = weight;
		//this.prev = 0;
	}	
	
	public Vertex(){
		
	}
	public int getVertex() {
		return vertex;
	}
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public String toString(){
		return "(" + vertex + "," + weight + "," + prev + ")" ;
	}
	@Override 
	protected Vertex clone() { 
		Vertex clone = null; 
		try{ 
			clone = (Vertex) super.clone(); 
		}
		catch(CloneNotSupportedException e){ 
			throw new RuntimeException(e); // won't happen 
		} 
		return clone; 
	}
}
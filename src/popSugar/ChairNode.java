package popSugar;

public class ChairNode {
	int data;
	ChairNode next;
	
	public ChairNode(int data){
		this.data = data;	
		this.next = null;
	}
	
	public ChairNode addNode(ChairNode head, int data) {
		ChairNode newNode = new ChairNode(data);
		if (head == null) {
			head = newNode;
			head.next = head;
		} else {
			ChairNode current = head;
			while (current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
		}
		return head;
	}

	public void deleteNode(ChairNode head,ChairNode i) {
		ChairNode tmp = head; // storing head in a temp variable
		
		while (tmp.next.data != i.data) {
			tmp = tmp.next;
			if(tmp.next == head){
				throw new IllegalArgumentException();				
			}	
		}	
		tmp.next = tmp.next.next;
	}
	

}

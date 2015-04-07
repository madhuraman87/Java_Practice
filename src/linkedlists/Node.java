package linkedlists;
public class Node {
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	public Node(){
				
	}
	
	public void addtoTail(int data){
		Node end = new Node(data);
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
	public Node deleteNode(Node head, int data){
		Node n = head; //storing head in a temp variable
		
		if(n.data == data){
			return head.next; //return new head
		}
		
		while(n.next != null){
			if(n.next.data == data){
				n.next = n.next.next;
				return head; //return unchanged head
			}
			n = n.next;
		}
		return head; //if the data to be deleted is not found.
	}
	
	public int sizeOfLL(Node head){
		Node n = head;
		int size = 0;
		if (n == null) return size;
		
		while(n.next != null){
			size++;
			n = n.next;
		}
		
		return size;
	}
	
	public static Node reverseNode(Node head){
		if(head == null || head.next == null) return null;
		Node curr = head.next;
		Node prev = head;
		head.next = null;
		while(curr!= null){
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	public static Node buildList(int[] a) {
        Node n = new Node(a[0]);
        Node head = n;
        for (int i = 1; i < a.length; ++i) {
            n.next = new Node(a[i]);
            n = n.next;
        }
        return head;
    }
    
    public static void printList(Node n) {
        if (n == null) System.out.print("NULL");
        while (n != null) {
        	if(n.next == null) System.out.print(n.data);
        	else System.out.print(n.data + "->");
        	n = n.next;
        }
        System.out.println();
    }
}

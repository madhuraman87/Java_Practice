package linkedlists;
import java.util.*;

public class LinkedListProbs {
	
	public static void deleteDuplicates(Node n){ //with a buffer in form of hashmap
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		Node previous = null;
		while(n.next != null){
			if(!map.containsKey(n.data)){
			map.put(n.data,n);
			previous = n;
			}
			else{
				previous.next = n.next;
			}
			n = n.next;
		}
	}
	
	public static Node kthElement(Node head, int k){ //here k=0 means last element, k=1 means last but one etc.
		if(k <= 0) return null;
		
		Node n1 = head;
		Node n2 = head;
		
		//move node n2 k elements apart from node n1
		for(int i=0; i< k; i++){
			if(n2 == null) return null; 
			n2 = n2.next;			
		}
		
		if(n2 == null) return null; 
		
		while(n2.next != null){
			n1 = n1.next;
			n2 = n2.next;			
		}
				
		return n1; 
	}
	
	public static boolean deleteNode(Node n){
				
		if(n == null || n.next == null) return false; 
		
		Node current = n;
		current.data = current.next.data;
		current.next = current.next.next;
		return true;
	
	}
	
	public static Node partitionNode(Node n, int value){
		
		Node nodee = n;
		Node n1 = null; //less than x
		Node n2 = null; //greater than equal to x
		
		while(nodee != null){
			Node next = nodee.next;
			if(nodee.data <= value){
				nodee.next = n1;
				n1 = nodee;
			}
			else{
				nodee.next = n2;
				n2 = nodee;
			}
			nodee = next;
		}
		
		if(n1 == null) return n2; //if there r no elements less than the value
		
		Node head = n1; // assign start of first linkedlist to head to be returned.
		while(n1.next != null){ //travesring to end of the first linked list
			n1 = n1.next;
		}
		n1.next = n2;
		
		return head; 
	}
	
	public static Node addOfNodes(Node n1, Node n2){
		
		Node nodee = new Node();
		Node outputHead = nodee;
		int digit, sum = 0, carryover = 0;
		while (n1 != null || n2 != null || carryover != 0) {
			int val1 = 0;
			int val2 = 0;
			if (n1 != null) {
				val1 = n1.data;		
				n1 = n1.next;
			}
			if (n2 != null) {
				val2 = n2.data;		
				n2 = n2.next;
			}
			sum = val1 + val2 + carryover;
			digit = sum % 10;			
			carryover = sum / 10;
			nodee.next = new Node(digit);
			nodee = nodee.next;						
		}
		return outputHead.next;
	}
	
	public static Node circularListEntry(Node head){
		Node slow = head;
		Node fast = head;
		
		if(fast == null || fast.next == null) return null;
		
		while(fast != null && fast.next != null){ //moving slow once for every 2 fast nodes hop
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){ break; }
		}
		
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
	
	public static boolean isPalindrome(Node head){
		Node slow = head;
		Node fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null){
			slow = slow.next;
		}
		
		while (slow != null){
			if(slow.data != stack.pop())
			return false;
			slow = slow.next;
		}		
		return true;
	}
	
	public static Node reverseNode(Node head){
		if(head == null || head.next == null) return null;
		Node curr = head.next;
		Node prev = head;
		head.next = null;
		while(curr != null){
			Node nnext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nnext;
		}
		head = prev;
		return head;
	}
	
	public static void main(String[] args) {
        Node l1 = Node.buildList(new int[] {1,2,2,2,1});
        //Node l2 = Node.buildList(new int[] {5,9,2});
        Node.printList(l1);
//        Node.printList(Node.reverseNode(l1));
        //System.out.println(Node.reverseNode(l1));
        System.out.println(isPalindrome(l1));
        //      Node.printList(l1);
    }
	
}
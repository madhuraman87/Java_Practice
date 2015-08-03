package trees;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public static void main(String args[]){	
		
		TreeTraversal.createTree(8);
		TreeTraversal.createTree(10);		
		TreeTraversal.createTree(4);
		TreeTraversal.createTree(9);
		TreeTraversal.createTree(2);
		TreeTraversal.createTree(6);
		TreeTraversal.createTree(1);
		TreeTraversal.createTree(3);
		TreeTraversal.createTree(5);
		TreeTraversal.createTree(7);
		TreeTraversal.createTree(11);
		
		System.out.println("In Order Traversal"); 
		TreeTraversal.inorderTraversal(TreeTraversal.root);
		System.out.println("--");
		System.out.println("Pre Order Traversal");
		TreeTraversal.preorderTraversal(TreeTraversal.root);
		System.out.println("--");
		System.out.println("Post Order Traversal");
		TreeTraversal.postorderTraversal(TreeTraversal.root);
		System.out.println("--");
		System.out.println("Level Order Traversal");
		TreeTraversal.levelorderTraversal(TreeTraversal.root);
	}	
}

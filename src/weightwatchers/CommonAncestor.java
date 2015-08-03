package weightwatchers;

public class CommonAncestor {
	/**
	 * Determine the first common ancestor
	 * @param root
	 * @param a
	 * @param b
	 * @return TreeNode
	 */
	private TreeNode firstcommonancestor(TreeNode root, TreeNode a, TreeNode b){
		/* base case */
		if(root == null){
			return null;
		}		
		if(root.equals(a) && root.equals(b)){
			return root;
		}
		
		TreeNode left = firstcommonancestor(root.left, a, b);
		if(left != null && left != a && left != b) {
			return left;
		}
		TreeNode right = firstcommonancestor(root.right, a, b);
		if(right != null && right != a && right != b) {
			return right;
		}
		
		if(left != null && right != null){
			return root;
		} else if (root == a || root == b) {
			return root;
		} else if (left != null){
			return left;
		} else {
			return right;
		}				
	}
	
	public static void main(String args[]){	
		/* Creating the Tree */
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
		
		System.out.println("Level Order Traversal");
		TreeTraversal.levelorderTraversal(TreeTraversal.root);
		
		/* Assigning two random nodes to determine the ancestor.*/
		TreeNode a = TreeTraversal.root.left.left;
		TreeNode b = TreeTraversal.root.left.right.left;
		
		CommonAncestor commonAncestorInstance = new CommonAncestor();
		
		/* Calling the method to find the First Common Ancestor.*/
		TreeNode result = commonAncestorInstance.firstcommonancestor(TreeTraversal.root, a, b);
		System.out.println("First common ancestor of Node "+ a.data +" and Node "+ b.data +" is Node " +result.data);
	}
}
package trees;


public class TreeProb {
	
	public static TreeNode findFirstCommonAncestor(TreeNode root, TreeNode a, TreeNode b ){
		
		if(root == null){
			return null;
		}
		if(root.equals(a) && root.equals(b)){
			return root;
		}
		
		TreeNode left = findFirstCommonAncestor(root.left, a, b);
		if(left != null && left != a && left != b){
			return left;
		}
		TreeNode right = findFirstCommonAncestor(root.right, a, b);
		if(right != null && right != a && right != b){
			return right;
		}
		
		if(left != null && right != null){
			return root;
		}
		else if(root == a || root == b){
			return root;
		}
		else if(left != null){
			return left;
		}
		else {
			return right;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(4);
		
		TreeNode a = root.left.left;
		TreeNode b = root.left.right.left;
		TreeNode result = findFirstCommonAncestor(root, a, b);
		
		System.out.println(result.data);
	}
	

}

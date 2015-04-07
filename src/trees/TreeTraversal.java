package trees;
import java.util.*;
public class TreeTraversal {
	
	static TreeNode root;
	static Queue<TreeNode> q = new LinkedList<TreeNode>(); 
	
	public static void createTree(int data){
		
		TreeNode newNode = new TreeNode(data);
		
		if(root == null){
			root = newNode;			
		}
		else{
			TreeNode focusNode = root;
			TreeNode parent;
						
			while(true){
				parent = focusNode;
				if(data < focusNode.data){
					focusNode = focusNode.left;
					if(focusNode == null){
						parent.left = newNode;
						return;
					}
				}
				else{
					focusNode = focusNode.right;
					if(focusNode == null){
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
		
	public static void inorderTraversal(TreeNode root){
		
		if(root != null){
			inorderTraversal(root.left);
			System.out.println(root.data);
			inorderTraversal(root.right);
		}
	}
	
	public static void preorderTraversal(TreeNode root){
		
		if(root != null){
			System.out.println(root.data);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}
	
	public static void postorderTraversal(TreeNode root){
		
		if(root != null){
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.println(root.data);
		}	
	}
	
	public static void levelorderTraversal(TreeNode root){
		TreeNode temp;
		if(root != null){
			q.add(root);
			while(!q.isEmpty()){
				temp = q.remove();
				System.out.println(temp.data);
				if(temp.left != null){
					q.add(temp.left);
				}
				if(temp.right != null){
					q.add(temp.right);
				}
			}
			q.clear();
		}
	}

}

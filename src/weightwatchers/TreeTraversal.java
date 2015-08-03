package weightwatchers;

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
			TreeNode currentNode = root;
			TreeNode parent;
						
			while(true){
				parent = currentNode;
				if(data < currentNode.data){
					currentNode = currentNode.left;
					if(currentNode == null){
						parent.left = newNode;
						return;
					}
				}
				else{
					currentNode = currentNode.right;
					if(currentNode == null){
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
		int level = 1;
		int child = 0;
		if(root != null){
			q.add(root);
			while(!q.isEmpty()){
				temp = q.remove();
				level--;
				System.out.print(temp.data + " ");
				if(temp.left != null){
					q.add(temp.left);
					child++;
				}
				if(temp.right != null){
					q.add(temp.right);
					child++;
				}
				if(level == 0){
					System.out.println();
					level = child;
					child = 0;
				}
			}			
		}
		q.clear();
	}

}

package treeDSA;

public class TreeTraversal {

	static class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int value){
			key=value;
			left=null;
			right=null;
		}
		
	}
	
	static class BinaryTree{
		public static Node root;
		
		public BinaryTree(int value){
			root=new Node(value);
		}
	}
	
	public static void inOrder(Node node){
		if(node==null){
			return;
		}
		
		inOrder(node.left);
		System.out.println(node.key);
		inOrder(node.right);
		
	}
	public static void postOrder(Node node){
		if(node==null){
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.key);
		
		
	}
	
	public static void preOrder(Node node){
		if(node==null){
			return;
		}
		
		System.out.println(node.key);
		preOrder(node.left);
		preOrder(node.right);
		
		
		
	}
	 static int height(Node root) 
	    { 
	        if (root == null) 
	           return 0; 
	        else
	        { 
	            /* compute  height of each subtree */
	            int lheight = height(root.left); 
	            int rheight = height(root.right); 
	              
	            /* use the larger one */
	            if (lheight > rheight) 
	                return(lheight+1); 
	            else return(rheight+1);  
	        } 
	    } 
	public static void main(String[] args) {
	//	TreeTraversal tree=new TreeTraversal();
		BinaryTree tree=new BinaryTree(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		System.out.println("InOrder traversal");
		inOrder(tree.root);
		System.out.println("postOrder traversal");
		postOrder(tree.root);
		System.out.println("preOrder traversal");
		preOrder(tree.root);
		System.out.println("\n");
		System.out.println(height(tree.root));
		
	}

}

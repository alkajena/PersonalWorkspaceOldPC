package treeGeeksForGeeksQuestions;

import treeGeeksForGeeksQuestions.MirrorBinaryTree.Node;

public class BinaryFoldedTree {
	Node root;
	public BinaryFoldedTree(int key){
		root=new Node(key);
	}
	static class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key){
			this.key=key;
			left=null;
			right=null;
		}
	}
	
	static Node mirrorBinaryTree(Node root){
		if(root==null)
			return root;
		root.left=mirrorBinaryTree(root.left);
		root.right=mirrorBinaryTree(root.right);
		
		Node temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		return root;
	}
	
	static boolean isStructure(Node left,Node right){
		if(left==null && right==null)
			return true;
		else if(left!=null && right!=null && isStructure(left.left,right.left) && isStructure(left.right,right.right))
			return true;
		else
			return false;
	}
	
	static boolean foldedBinaryTree(Node root){
		if(root==null)
			return true;
		else{
			mirrorBinaryTree(root.left);
			boolean res=isStructure(root.left,root.right);
			//To get the original tree back
			mirrorBinaryTree(root.left);
			return res;
		}
	}
	public static void main(String[] args) {
		BinaryFoldedTree tree=new BinaryFoldedTree(1);
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.right.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	  if(foldedBinaryTree(tree.root)){
		  System.out.println("Binary tree can be folded");
	  }
	  else{
		  System.out.println("Binary tree can not be folded");
	  }

	}

}

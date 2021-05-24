package treeGeeksForGeeksQuestions;

public class MirrorBinaryTree {
	
	Node root;
	public MirrorBinaryTree(int key){
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
	
	static void inOrder(Node node){
		if(node==null)
			return;
		inOrder(node.left);
		System.out.println(node.key);
		inOrder(node.right);
	}
	public static void main(String[] args) {
		MirrorBinaryTree tree=new MirrorBinaryTree(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.right.left=new Node(4);
		tree.root.right.right=new Node(5);
		tree.root=mirrorBinaryTree(tree.root);
		inOrder(tree.root);

	}

}

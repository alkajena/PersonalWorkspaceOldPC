package treeGeeksForGeeksQuestions;

public class SymmetricTree {
	Node root;
	
	public SymmetricTree(int key){
		root=new Node(key);
	}
	static class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key){
			this.key=key;
			left=right=null;
		}
	}
	
	static boolean checkSymmetric(Node left,Node right){
		if(left==null && right==null)
			return true;
		else if(left==null || right==null)
			return false;
		else{
			if(left.key==right.key && checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left)){
				return true;
			}
			return false;
		}
	}
	public static void main(String[] args) {
		SymmetricTree tree=new SymmetricTree(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(2);
		tree .root.left.left=new Node(3);
		tree .root.left.right=new Node(4);
		tree.root.right.left=new Node(4);
		tree.root.right.right=new Node(3);
		if(checkSymmetric(tree.root, tree.root)){
			System.out.println("Given binary tree is symmetric");
		}
		else{
			System.out.println("Given binary tree is not symmetric");
		}

	}

}

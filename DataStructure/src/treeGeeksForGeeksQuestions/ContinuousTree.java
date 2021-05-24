package treeGeeksForGeeksQuestions;

public class ContinuousTree {
	Node root;
	public ContinuousTree(int key){
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
	static boolean checkContinuous(Node root){
		if(root == null)
			return true;
		if(root.left==null && root.right==null)
			return true;
		if(root.left==null || root.right==null){
			if(root.left==null){
				return Math.abs(root.key-root.right.key)==1 && checkContinuous(root.right);
			}
			else{
				return Math.abs(root.key-root.left.key)==1 && checkContinuous(root.left);
			}
		}
		
		if(root.left!=null && root.right!=null){
			return Math.abs(root.key-root.left.key)==1 && Math.abs(root.key-root.right.key)==1 && checkContinuous(root.left) && checkContinuous(root.right);
		}
		return false;
	}

	public static void main(String[] args) {
		ContinuousTree tree=new ContinuousTree(3);
		tree.root.left=new Node(2);
		tree.root.right=new Node(4);
		tree.root.left.left=new Node(1);
		tree.root.left.right=new Node(9);
		tree.root.right.right=new Node(5);
		
		if(checkContinuous(tree.root)){
			System.out.println("continuous tree");
		}
		else{
			System.out.println("not continuous tree");
		}
		
	}

}

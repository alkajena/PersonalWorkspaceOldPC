package treeDSA;

public class LevelOrderTraversal {
	
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
	
	static class Binarytree{
		Node root;
		
		public Binarytree(int value){
			root=new Node(value);
		}
	}

	static int height(Node node){
		if(node==null){
			return 0;
		}
		else{
			int lHeight=height(node.left);
			int rHeight=height(node.right);
			
			if(lHeight>rHeight){
				return lHeight+1;
			}
			else{
				return rHeight+1;
			}
		}
	}
	
	static void levelTraversal(int h,Node root){
		for(int i=1;i<=h;i++){
			givenLevelTraversal(i,root);
		}
	}
	
	static void givenLevelTraversal(int i,Node node){
		if(node==null){
			return;
		}
		else if (i==1){
			System.out.println(node.key);
		}
		else{
			givenLevelTraversal(i-1,node.left);
			givenLevelTraversal(i-1,node.right);
		}
	}
	public static void main(String[] args) {
		Binarytree tree=new Binarytree(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.left=new Node(6);
		tree.root.right.right=new Node(7);
		int height=height(tree.root);
		levelTraversal(height, tree.root);
	}

}

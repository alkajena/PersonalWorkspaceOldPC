package treeGeeksForGeeksQuestions;

public class MorrisTraversal {
	Node root;
	
	public MorrisTraversal(int key){
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
	
	static void morrisTraversal(Node root){
		Node current=root;
		while(current!=null){
			if(current.left==null){
				System.out.println(current.key);
				current=current.right;
			}
			else{
				Node pre=current.left;
				while(pre.right!=null || pre.right!=root)
					pre=pre.right;
				
				if(pre.right==null){
					pre.right=current;
					current=current.left;
				}
				else{
					pre.right=null;
					current=current.right;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		MorrisTraversal tree=new MorrisTraversal(1);
	}

}

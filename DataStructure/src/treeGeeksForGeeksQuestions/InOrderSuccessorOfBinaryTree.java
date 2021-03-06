package treeGeeksForGeeksQuestions;

public class InOrderSuccessorOfBinaryTree {
	Node root;
	
	public InOrderSuccessorOfBinaryTree(int key){
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

		public Node() {
			
		}
	}
	
	static Node temp = new Node(); 
	
	static Node leftMostNode(Node node){
		Node temp = null;
		while(node!=null){
			temp=node;
			node=node.left;
		}
		return temp;
	}
	
	static Node rightMostNode(Node node){
		Node temp = null;
		while(node!=null){
			temp=node;
			node=node.right;
		}
		return temp;
	}
	static Node findInorderRecusrsive(Node root,Node x){
		 if (root==null)  
		        return null;
		
		if(root==x || (temp=findInorderRecusrsive(root.left,x))!=null || (temp=findInorderRecusrsive(root.right, x))!=null){
			if(temp!=null){
				if(root.left==temp){
					System.out.println("inorder successor is :"+root.key);
					return null;
				}
			}
			return root;
		}
		return null;
	}
	static Node inOrderSuccessor(Node root,Node x){
		if(x.right!=null){
			return leftMostNode(x.right);
		}
		else if(x.right==null){
			Node rightMostNode=rightMostNode(root);
			if(rightMostNode==x){
				System.out.print("right most node of tree. So can not have inorder successor");
				return null;
			}
			else{
				return findInorderRecusrsive(root,x);
				
			}
		}
		return null;
	}
	public static void main(String[] args) {
		InOrderSuccessorOfBinaryTree tree=new InOrderSuccessorOfBinaryTree(1);
		 
		    tree.root.left = new Node(2);  
		    tree.root.right = new Node(3);  
		    tree.root.left.left = new Node(4);  
		    tree.root.left.right = new Node(5);  
		    tree.root.right.right = new Node(6);  
		  
		    // Case 1  
		    //System.out.println(inOrderSuccessor(tree.root, tree.root.right).key); 
		    inOrderSuccessor(tree.root, tree.root.left.right);  
		    inOrderSuccessor(tree.root, tree.root.right.right);  

	}

}

package treeDSA;



public class AVLTree {
	Node root;
	static class Node{
		int key;
		int height;
		Node left;
		Node right;
		
		public Node(int value){
			key=value;
			height=1;
			left=null;
			right=null;
		}
	}
	
	static int height(Node node){
		if(node==null)
			return 0;
		return node.height;
	}
	
	static int max(int a,int b){
		return a>b?a:b;
	}
	
	static int balanceFactor(Node node){
		if(node==null)
			return 0;
		return height(node.left)-height(node.right);
	}
	static Node LLRotation(Node node){
		Node x=node;
		Node child=x.left;
		Node childRight=child.right;
		
		//change the position
		child.right=x;
		x.left=childRight;
		
		//change the height after insertion of new node
		x.height=1+(max(height(x.left),height(x.right)));
		child.height=1+(max(height(child.left),height(child.right)));
		
		//return updated root node
		return child;
		
		
	}
	
	static Node RRRotation(Node node){
		Node x=node;
		Node child=x.right;
		Node childLeft=child.left;
		
		//change the position
		child.left=x;
		x.right=childLeft;
		
		//change the height after insertion of new node
		x.height=1+(max(height(x.left),height(x.right)));
		child.height=1+(max(height(child.left),height(child.right)));
		
		//return updated root node
		return child;
		
		
	}
	static Node insert(Node node,int key){
		//normal Binary Serach tree insertion using recursion
		if(node==null)
			return new Node(key);
		else if(key>node.key)
			node.right=insert(node.right,key);
		else if(key<node.key)
			node.left=insert(node.left,key);
		//get the updated height of the node
		node.height=1+(max(height(node.left),height(node.right)));
		//get the balance factor
		int balanceFactor=balanceFactor(node);
		//Do the appropriate rotation according to the balance factor
		if(balanceFactor>1 && key<node.left.key)
			return LLRotation(node);
		else if(balanceFactor<-1 && key>node.right.key)
			return RRRotation(node);
		else if(balanceFactor>1 && key>node.left.key){
			node.left=RRRotation(node.left);
			return LLRotation(node);
		}
		else if(balanceFactor<-1 && key<node.right.key){
			node.right=LLRotation(node.right);
			return RRRotation(node);
		}
		return node;
	}
	static Node minValue(Node node){
		Node temp=node;
		while(temp.left!=null)
			temp=temp.left;
		return temp;
	}
	static Node delete(Node root,int key){
		if(root==null)
			return root;
		//traversing
		else if(key<root.key)
			root.left=delete(root.left,key);
		else if(key>root.key)
			root.right=delete(root.right,key);
		else
			//we finally got the node to be deleted
			//if deleted node has only one child or no children at all
			if(root.left==null || root.right==null){
				Node temp=null;
				if(root.left==null)
					temp=root.right;
				else
					temp=root.left;
				//no child case
				if(temp==null){
					temp=root;
					root=null;
				}
				//single child case
				else
					root=temp;
			}
			else{
				//if node has two children then we have to find the inorder successor of taht node 
				Node temp=minValue(root.right);
				root.key=temp.key;
				root.right=delete(root.right,root.key);
			}
		if(root==null)
			return root;
		root.height=1+(max(height(root.left),height(root.right)));
		
		int balanceFactor=balanceFactor(root);
		
		if(balanceFactor>1 && balanceFactor(root.left)>=0)
			return LLRotation(root);
		else if(balanceFactor>1 && balanceFactor(root.left)<0){
			root.left=RRRotation(root.left);
			return LLRotation(root);
		}
		else if(balanceFactor<-1 && balanceFactor(root.right)<=0)
			return RRRotation(root);
		else if(balanceFactor<-1 && balanceFactor(root.right)>0){
			root.right=LLRotation(root.right);
			return RRRotation(root);
		}
		else
			return root;
			
			
	}
	public static void main(String[] args) {
		 AVLTree tree = new AVLTree(); 
		  
	        /* Constructing tree given in the above figure */
	        tree.root = tree.insert(tree.root, 10); 
	        tree.root = tree.insert(tree.root, 20); 
	        tree.root = tree.insert(tree.root, 30); 
	        tree.root = tree.insert(tree.root, 40); 
	        tree.root = tree.insert(tree.root, 50); 
	        tree.root = tree.insert(tree.root, 25); 
	        tree.inOrder(tree.root);
	       // tree.root = tree.delete(tree.root, 10); 
	        System.out.println("\n");
	        //tree.preOrder(tree.root);
	}
	static void inOrder(Node node){
		if(node==null)
			return;
		inOrder(node.left);
		System.out.println(node.key);
		inOrder(node.right);
		
	}
	 void preOrder(Node node) { 
	        if (node != null) { 
	            System.out.print(node.key + " "); 
	            preOrder(node.left); 
	            preOrder(node.right); 
	        } 
	    } 

}

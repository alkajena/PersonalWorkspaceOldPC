package treeGeeksForGeeksQuestions;

public class AVLTreeWithDuplicateKey {
	static Node root;
	
	static class Node{
		int key;
		Node left;
		Node right;
		int height;
		int count;
		
		public Node(int key){
			this.key=key;
			left=null;
			right=null;
			height=1;
			count=1;
		}
	}
	
	static int max(int a,int b){
		return a>b?a:b;
	}
	
	static int height(Node node){
		if(node==null)
			return 0;
		return max(height(node.left),height(node.right));
	}
	
	static int balanceFactor(Node node){
		if(node==null)
			return 0;
		return height(node.left)-height(node.right);
	}
	
	static Node LLRotation(Node node){
		Node parent=node;
		Node child=parent.left;
		Node childRight=child.right;
		
		child.right=parent;
		parent.left=childRight;
		
		 child.height=1+(max(height(child.left),height(child.right)));
		 parent.height=1+(max(height(parent.left),height(parent.right)));
		
		return child;
	
	}
	
	static Node RRRotation(Node node){
		Node parent=node;
		Node child=parent.right;
		Node childLeft=child.left;
		
		child.left=parent;
		parent.right=childLeft;
		
		 child.height=1+(max(height(child.left),height(child.right)));
		 parent.height=1+(max(height(parent.left),height(parent.right)));
		
		return child;
	
	}
	
	static Node insert(Node node,int key){
		if(node==null){
			return new Node(key);
		}
		else if(key>node.key)
			node.right=insert(node.right,key);
		else if(key<node.key)
			node.left=insert(node.left,key);
		else{
			node.count++;
			return node;
		}
		node.height=1+max(height(node.left),height(node.right));
		
		int balance=balanceFactor(node);
		
		if(balance>1 && key<node.left.key){
			return LLRotation(node);
		}
		else if(balance>1 && key>node.left.key){
			node.left=RRRotation(node.left);
			return LLRotation(node);
		}
		else if(balance<-1 && key>node.right.key){
			return RRRotation(node);
		}
		else if(balance<-1 && key<node.right.key){
			node.right=LLRotation(node.right);
			return RRRotation(node);
		}
		return node;
	}
	static Node minValue(Node node){
		while(node.left!=null){
			node=node.left;
		}
		return node;
	}
	static Node delete(Node node,int key){
		if(node==null)
			return node;
		else if(key>node.key){
			node.right=delete(node.right,key);
		}
		else if(key<node.key){
			node.left=delete(node.left,key);
		}
		else{
			if(node.count>1){
				node.count--;
				return null;
			}
			else{
				Node temp=null;
				if(node.left==null || node.right==null){
					if(node.left==null)
						temp=node.right;
					else
						temp=node.left;
					
					if(temp==null){
						temp=node;
						node=null;
					}
					else{
						node=temp;
					}
				}
				else{
					Node min=minValue(node.right);
					node.key=min.key;
					node.right=delete(node.right,node.key);
				}
		}
		}
		if(node==null)
			return node;
		node.height=1+max(height(node.left),height(node.right));
		
		int balance=balanceFactor(node);
		
		if(balance>1 && balanceFactor(node.left)>=0){
			return LLRotation(node);
		}
		else if(balance>1 && balanceFactor(node.left)<0){
			node.left=RRRotation(node.left);
			return LLRotation(node);
		}
		else if(balance<-1 && balanceFactor(node.right)<=0){
			return RRRotation(node);
		}
		else if(balance<-1 && balanceFactor(node.right)<=0){
			node.right=RRRotation(node.right);
			return LLRotation(node);
		}
		return node;
	}
	
	static void inOrder(Node node){
		if(node==null)
			return;
		inOrder(node.left);
		System.out.println("key "+node.key+" "+"count "+node.count);
		inOrder(node.right);
		
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		AVLTreeWithDuplicateKey tree= new AVLTreeWithDuplicateKey();
		tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 20); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 40); 
        tree.root = tree.insert(tree.root, 50); 
        tree.root = tree.insert(tree.root, 10); 
        inOrder(tree.root);
        tree.delete(tree.root, 20);
        System.out.println("\n");
        inOrder(tree.root);
	}

}

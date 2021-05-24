package treeDSA;

import java.util.ArrayList;
import java.util.List;

public class BSTSearchAndInsertion extends LevelOrderTraversal{

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
	
	static class BinarySearchTree{
		Node root;
		
		public BinarySearchTree(int value){
			root=new Node(value);
		}
	
	static Node searchInIteration(Node root,int key){
		List list=new ArrayList();
		list.add(root);
		while(list.size()!=0){
			Node node= (Node) list.remove(0);
			//System.out.println(node.key);
			if(node.key==key){
				return node;
			}
			else if(key>node.key){
				list.add(node.right);
				continue;
			}
			else if(key<node.key){
				list.add(node.left);
				continue;
			}	
		}
		return null;
	}
	
	static Node searchInRecursion(Node root,int key){
		Node node=root;
			//System.out.println(node.key);
			if(node.key==key){
				return node;
			}
			else if(key>node.key){
				return searchInRecursion(node.right,key);
			}
			else {
				return searchInRecursion(node.left,key);
			}	
	}
	
	static void insertion(Node root,int key){
		List list=new ArrayList();
		list.add(root);
		while(list.size()!=0){
			Node node= (Node) list.remove(0);
			//System.out.println(node.key);
			//when tree does not have any node
			if(root==null){
				root=new Node(key);
			}
			if(key>node.key){
				 if(node.right!=null)
					 list.add(node.right);
				 else
					 node.right=new Node(key);	 	
			}
			else if(key<node.key){
				 if(node.left!=null)
					 list.add(node.left);
				 else
					 node.left=new Node(key);	 
			}	
		}
	}
	}
	
	public static void LevelOrderTraversal(Node root){
		List list=new ArrayList<>();
		list.add(root);
		while(list.size()!=0){
			Node node=(Node) list.remove(0);
			System.out.println(node.key);
			if(node.left!=null)
				list.add(node.left);
			
			if(node.right!=null)
				list.add(node.right);
		}
	}
	
	public static void inOrder(Node root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);
	}
	public static void main(String[] args) {
		BinarySearchTree tree=new BinarySearchTree(8);
		tree.insertion(tree.root,1);
		tree.insertion(tree.root,2);
		tree.insertion(tree.root,3);
		tree.insertion(tree.root,4);
		tree.insertion(tree.root,5);
		tree.insertion(tree.root,6);
		tree.insertion(tree.root,7);
		LevelOrderTraversal(tree.root);
		System.out.println("\n");
		inOrder(tree.root.left.right);
		
	}

}

package treeDSA;

import java.util.List;

import treeDSA.BSTSearchAndInsertion.BinarySearchTree;

import java.util.ArrayList;

public class BSTDeletion {

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
		
		static void insertion(Node root,int key){
			List list=new ArrayList<>();
			if(root==null){
				root=new Node(key);
				return;
			}
			list.add(root);
			while(list.size()!=0){
				Node node=(Node) list.remove(0);
				if(key<node.key){
					if(node.left!=null)
						list.add(node.left);
					else
						node.left=new Node(key);
				}
				else{
					if(node.right!=null)
						list.add(node.right);
					else
						node.right=new Node(key);
				}
				
			}
		}
		
		static void delete(Node root,int key){
			List list=new ArrayList<>();
			list.add(root);
			while(list.size()!=0){
				Node node=(Node)list.remove(0);
				
				if(node.right!=null){
					list.add(node.right);
					if(node.right.key==key){
						//when node is a leaf node
						Node temp=node.right;
						if(temp.right==null && temp.left==null){
							temp=null;
						}
						//when deleted node has only one child
						/*else if((temp.right==null && temp.left!=null) || (temp.right!=null && temp.left==null)){
							temp.key=temp.right!=null?temp.right.key:temp.left.key;
							if(temp.right==null)
								temp.left=null;
							else
								temp.right=null;
						}*/
						//when deleted node has both children
						else /*if(temp.right!=null && temp.left!=null)*/{
							List<Integer> list1=new ArrayList<>();
							list1=inOrderTraversal(temp.right,list1);
							if(temp.right.left==null)
								temp.right=null;
							else
								deleteNode(temp.right,list1.get(0));
							temp.key=list1.get(0);
						}
					}
				}
				
				if(node.left!=null){
					
				}
			}
			
		}
		static void deleteNode(Node node,int key){
			if(node==null)
				return;
			if(node.left!=null){
				Node prev=node.left;
				if(prev.left!=null){
					deleteNode(node.left,key);
				}
				else{
					node.left=null;
				}
			}
		}
		static  List<Integer> inOrderTraversal(Node node, List<Integer> list){
			if(node==null)
				return list;
			inOrderTraversal(node.left,list);
			System.out.println(node.key);
			list.add(node.key);
			inOrderTraversal(node.right,list);
			return list;
		}
	}
	public static void main(String[] args) {
		BinarySearchTree tree=new BinarySearchTree(8);
		//tree.insertion(tree.root,8);
		tree.insertion(tree.root,2);
		tree.insertion(tree.root,9);
		tree.insertion(tree.root,6);
		tree.insertion(tree.root,5);
		tree.insertion(tree.root,7);
		tree.insertion(tree.root,15);
		tree.insertion(tree.root,20);
		tree.insertion(tree.root,17);
		tree.insertion(tree.root,23);
		tree.insertion(tree.root,16);
		tree.insertion(tree.root,18);
		tree.insertion(tree.root,22);
		tree.insertion(tree.root,24);
		List<Integer> list=new ArrayList<>();
		//list=tree.inOrderTraversal(tree.root,list);
		tree.delete(tree.root,15);
		list=tree.inOrderTraversal(tree.root,list);
		//System.out.println("\n");
		//inOrder(tree.root.left.right);
		

	}
	
}

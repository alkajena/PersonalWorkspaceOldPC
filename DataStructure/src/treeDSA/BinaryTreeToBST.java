package treeDSA;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeToBST {
	static List inOrderList=new ArrayList<>();
	
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
	
	static class BinaryTree{
		Node root;
		
		public BinaryTree(int key){
			root=new Node(key);
		}
		
		static void insertion(Node root,int key){
			List list=new ArrayList<>();
			if(root==null){
				root=new Node(key);
			}
			list.add(root);
			while(list.size()!=0){
				Node node=(Node)list.remove(0);
				if(node.left!=null){
					list.add(node.left);
				}
				else{
					node.left=new Node(key);
					break;
				}
				
				if(node.right!=null){
					list.add(node.right);
				}
				else{
					node.right=new Node(key);
					break;
				}
			}
			
		}
		
		static void inOrder(Node root){
			if(root==null)
				return;
			inOrder(root.left);
			System.out.println(root.key);
			inOrderList.add(root.key);
			inOrder(root.right);
		}
			
		static void inOrderPostsorting(Node root){
			if(root==null)
				return;
			inOrderPostsorting(root.left);
				root.key=(int) inOrderList.get(0);
				inOrderList.remove(0);
			System.out.println(root.key);
			inOrderPostsorting(root.right);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree(10);
		tree.insertion(tree.root, 2);
		tree.insertion(tree.root, 7);
		tree.insertion(tree.root, 8);
		tree.insertion(tree.root, 4);
		tree.inOrder(tree.root);
		Collections.sort(inOrderList);
		System.out.print(inOrderList);
		tree.inOrderPostsorting(tree.root);
	}

}

package treeGeeksForGeeksQuestions;

import java.util.ArrayList;
import java.util.List;

import treeGeeksForGeeksQuestions.SymmetricTree.Node;

public class TreeTraversalWithoutRecursion {
	Node root;
	
	public TreeTraversalWithoutRecursion(int key){
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
	
	public void inOrder(Node root){
		List list=new ArrayList<>();
		Node current=root;
		//list.add(current);
		while(list.size()!=0 || current!=null){
			while(current!=null){
				list.add(current);
				current=current.left;
			}
			Node temp=(Node) list.remove(list.size()-1);
			System.out.println(temp.key);
			current=temp.right;
			//list.add(current);
		}
	}
	//using two stack/list
	public void postOrder(Node root){
		List list1=new ArrayList<>();
		List<Node> list2=new ArrayList<>();
		list1.add(root);
		while(list1.size()!=0){
			Node node=(Node)list1.remove(list1.size()-1);
			if(node!=null){
				list2.add(node);
				list1.add(node.left);
				list1.add(node.right);
			}
		}
	for(Node node:list2)
		System.out.println(node.key);
	}
	
	public void preOrder(Node root){
		List list=new ArrayList<>();
		List<Node> list1=new ArrayList<>();
		Node current=root;
		//list.add(current);
		while(list.size()!=0 || current!=null){
			while(current!=null){
				list.add(current);
				list1.add(current);
				current=current.left;
			}
			Node temp=(Node) list.remove(list.size()-1);
			//System.out.println(temp.key);
			current=temp.right;
			//list.add(current);
		}
		
		for(Node x:list1){
			System.out.println(x.key);
		}
	}
	public static void main(String[] args) {
		TreeTraversalWithoutRecursion tree=new TreeTraversalWithoutRecursion(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(2);
		tree .root.left.left=new Node(3);
		tree .root.left.right=new Node(4);
		tree.root.right.left=new Node(4);
		tree.root.right.right=new Node(3);
		tree.inOrder(tree.root);
		//tree.preOrder(tree.root);
		tree.postOrder(tree.root);

	}

}

package treeGeeksForGeeksQuestions;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalSpiralForm {
	Node root;
	public LevelOrderTraversalSpiralForm(int key){
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
	static void spiralTraversalEvery2Level(Node root){
		List list1=new ArrayList<>();
		List list2=new ArrayList<>();
		list1.add(root);
		int count=0;
		while(list1.size()!=0 || list2.size()!=0){
			
			
			while(list1.size()!=0){
				Node node=(Node)list1.remove(list1.size()-1);
				System.out.println(node.key);
				if(count%2!=0){
					if(node.right!=null)
						list2.add(node.right);
					if(node.left!=null)
						list2.add(node.left);
				}
				else{
					if(node.left!=null)
						list2.add(node.left);
					if(node.right!=null)
						list2.add(node.right);
				}
			}
			while(list2.size()!=0){
					Node node=(Node)list2.remove(0);
					System.out.println(node.key);
					if(count%2==0){
						if(node.left!=null)
							list1.add(node.left);
						if(node.right!=null)
							list1.add(node.right);
					}
					else{
						if(node.right!=null)
							list1.add(node.right);
						if(node.left!=null)
							list1.add(node.left);
						}
					}
			count++;
		}
	}
	static void spiralTraversal(Node root){
		List list1=new ArrayList<>();
		List list2=new ArrayList<>();
		list1.add(root);
		
		while(list1.size()!=0 || list2.size()!=0){
			while(list1.size()!=0){
				Node node=(Node)list1.remove(list1.size()-1);
				System.out.println(node.key);
				if(node.right!=null)
					list2.add(node.right);
				if(node.left!=null)
					list2.add(node.left);
				}
			
			while(list2.size()!=0){
				Node node=(Node)list2.remove(list2.size()-1);
				System.out.println(node.key);
				if(node.left!=null)
					list1.add(node.left);
				if(node.right!=null)
					list1.add(node.right);
				}
				
		}
	}
	public static void main(String[] args) {
		LevelOrderTraversalSpiralForm tree = new LevelOrderTraversalSpiralForm(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(7); 
        tree.root.left.right = new Node(6); 
        tree.root.right.left = new Node(5); 
        tree.root.right.right = new Node(4); 
        tree.root.left.left.left=new Node(15);
        tree.root.left.left.right=new Node(14);
        tree.root.left.right.left=new Node(13);
        tree.root.left.right.right=new Node(12);
        tree.root.right.left.left=new Node(11);
        tree.root.right.left.right=new Node(10);
        tree.root.right.right.left=new Node(9);
        tree.root.right.right.right=new Node(8);
        spiralTraversal(tree.root);
        System.out.println("\n");
        spiralTraversalEvery2Level(tree.root);
	}

}

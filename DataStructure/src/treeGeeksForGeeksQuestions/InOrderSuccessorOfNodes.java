package treeGeeksForGeeksQuestions;

import java.util.ArrayList;
import java.util.List;

public class InOrderSuccessorOfNodes {
	Node root;
	static List<Node> inOrderList=new ArrayList<>();
	static class Node{
		int key;
		Node left,right,next;
		
		public Node(int key){
			this.key=key;
			left=right=next=null;
		}
	}
	
	static void inOrder(Node node){
		if(node==null)
			return;
		inOrder(node.left);
		inOrderList.add(node);
		inOrder(node.right);
	}
	public static void main(String[] args) {
		InOrderSuccessorOfNodes tree = new InOrderSuccessorOfNodes(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(12); 
        tree.root.left.left = new Node(3);
        inOrder(tree.root);
        int i=0;
        int k=i;
        for( i=0;i<inOrderList.size()-1;i++){
        	
        	inOrderList.get(i).next=inOrderList.get(++k);
        }
        inOrderList.get(i).next=new Node(-1);
	
	for( int j=0;j<inOrderList.size();j++){
		System.out.println(inOrderList.get(j).key+" next "+inOrderList.get(j).next.key);
	}
	}
}

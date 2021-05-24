package treeGeeksForGeeksQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class SumOfInorderPredecessorAndSuccessor {

	Node root;
	static List<Node> inOrderList=new ArrayList<>();
	static class Node{
		int key;
		Node left,right,next,prev,sum;
		
		public Node(int key){
			this.key=key;
			left=right=next=prev=sum=null;
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
		SumOfInorderPredecessorAndSuccessor tree = new SumOfInorderPredecessorAndSuccessor(); 
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
       Collections.reverse(inOrderList); 
       int j=0;
       int h=j;
       for( j=0;j<inOrderList.size()-1;j++){
       	
       	inOrderList.get(j).prev=inOrderList.get(++h);
       }
       inOrderList.get(j).prev=new Node(-1);
       Collections.reverse(inOrderList); 
       
	for( int m=0;m<inOrderList.size();m++){
		int sum=inOrderList.get(m).next.key+inOrderList.get(m).prev.key;
		inOrderList.get(m).sum=new Node(sum);
		System.out.println(inOrderList.get(m).key+" sum "+sum);
	}
	}

}

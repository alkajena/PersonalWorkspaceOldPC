package greedyAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
/*Time compalexity of this is o(nlogn) as the input is not in sorted manner so first we have to sort then build Hoffman tree
 */
public class HoffmanCoding {
	static Node root;
	static class Node{
		char c;
		int freq;
		Node left;
		Node right;
		
		public Node(char c,int freq){
			this.freq=freq;
			this.c=c;
			left=right=null;
		}
	}
	
	class MyComparator implements Comparator<Node>{

		@Override
		public int compare(Node n1, Node n2) {
			return n1.freq-n2.freq;
		}
		
	}
	
	static void print(Node root,String s){
		if(root.left==null && root.right==null && Character.isLetter(root.c)){
			System.out.println("char is : "+root.c+" code : "+s);
			return;
		}
		
		print(root.left,s+"0");
		print(root.right,s+"1");
	}
	public static void main(String[] args) {
		HoffmanCoding hf=new HoffmanCoding();
		PriorityQueue<Node> pq=new PriorityQueue<>(6,hf.new MyComparator());
		
		Node n1=new Node('a',5);
		Node n2=new Node('b',12);
		Node n3=new Node('c',13);
		Node n4=new Node('d',14);
		Node n5=new Node('e',15);
		Node n6=new Node('f',16);
		
		pq.add(n1);
		pq.add(n2);
		pq.add(n3);
		pq.add(n4);
		pq.add(n5);
		pq.add(n6);
		
		while(pq.size()>1){
			Node left=pq.peek();
			pq.poll();
			Node right=pq.peek();
			pq.poll();
			
			Node newNode=new Node('-',left.freq+right.freq);
			newNode.left=left;
			newNode.right=right;
			pq.add(newNode);
			root=newNode;
		}
		print(root,"");
	}

}

package treeGeeksForGeeksQuestions;

import java.util.ArrayList;
import java.util.List;

import stackDSA.StackOperation;

public class ExpressionTree {
	
	static Node root;
	static class Node{
		char key;
		Node left;
		Node right;
		
		public Node(char key){
			this.key=key;
			left=right=null;
		}
	}
	
	static void expressionTree(String expression){
		List<Node> stack=new ArrayList<>();
		char[] charArr=expression.toCharArray();
		Node t;
		for(char ch:charArr){
			if(Character.isLetterOrDigit(ch)){
				//t=new Node(ch);
				stack.add(new Node(ch));
			}
			else{
				t=new Node(ch);
				t.right=stack.remove(stack.size()-1);
				t.left=stack.remove(stack.size()-1);
				stack.add(t);
			}
		}
		t=stack.remove(stack.size()-1);
		inOrder(t);
	}
	
	static void inOrder(Node root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);
	}
	public static void main(String[] args) {
		String expression="ab+ef*g*-";
		expressionTree(expression);

	}

}

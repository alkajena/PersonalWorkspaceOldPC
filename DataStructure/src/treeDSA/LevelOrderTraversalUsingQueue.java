package treeDSA;

import java.util.ArrayList;
import java.util.List;

import treeDSA.LevelOrderTraversal.Binarytree;
import treeDSA.LevelOrderTraversal.Node;

public class LevelOrderTraversalUsingQueue extends LevelOrderTraversal{
	
	static void printLevelOrder(Node root){
		List list=new ArrayList<>();
		list.add(root);
		while(list.size()!=0){
			Node node=(Node) list.remove(0);
			System.out.println(node.key);
			if(node.left!=null){
				list.add(node.left);
			}
			if(node.right!=null){
				list.add(node.right);
			}
		}
		
	}

	public static void main(String[] args) {
		Binarytree tree=new Binarytree(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.left=new Node(6);
		tree.root.right.right=new Node(7);
		printLevelOrder(tree.root);
	}

}

package treeDSA;

import java.util.ArrayList;
import java.util.List;

import treeDSA.LevelOrderTraversal.Binarytree;
import treeDSA.LevelOrderTraversal.Node;

public class InsertionAndDeletionInBinaryTree extends LevelOrderTraversalUsingQueue{

	static void insertLevelOrder(Node root,int newKey){
		List list=new ArrayList<>();
		list.add(root);
		while(list.size()!=0){
			Node node=(Node) list.remove(0);
			//System.out.println(node.key);
			if(node.left!=null){
				list.add(node.left);
			}
			else{
				node.left=new Node(newKey);
				break;
			}
			if(node.right!=null){
				list.add(node.right);
			}
			else{
				node.right=new Node(newKey);
				break;
			}
		}
		
	}
		static Node searchNode(Node root,int key){
			Node temp;
			List list=new ArrayList<>();
			list.add(root);
			while(list.size()!=0){
				Node node=(Node) list.remove(0);
				//System.out.println(node.key);
				if(node.key==key){
					return node;
				}
				if(node.left!=null){
					if(node.left.key==key){
						temp=node.left;
						return temp;
					}
					list.add(node.left);
				}
				if(node.right!=null){
					if(node.right.key==key){
						temp=node.right;
						return temp;
					}
					list.add(node.right);
				}
			}
			return null;
		}
	static Node rightMostNode(Node root){
		List list=new ArrayList<>();
		list.add(root);
		Node temp = root;
		Node prev=null;
		while(list.size()!=0){
			Node node=(Node) list.remove(0);
			//System.out.println(node.key);
			
			if(temp!=null){
				list.add(node.right);
				prev=temp;
				temp=temp.right;
			}
			if(temp.right==null){
				break;
			}
		}
		prev.right=null;
		return temp;
	}

	static void deleteNode(Node deletedNode,Node rightMostNode,Node root){
		List list=new ArrayList<>();
		list.add(root);
		Node temp = null;
		while(list.size()!=0){
			Node node=(Node) list.remove(0);
			//System.out.println(node.key);
			if(node.left!=null){
				if(node.left==deletedNode){
					node.left.key=rightMostNode.key;
					break;
				}
				list.add(node.left);
			}
			if(node.right!=null){
				if(node.right==deletedNode){
					node.right.key=rightMostNode.key;
					break;
				}
				list.add(node.right);
			}
		}
	}
	
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
		//printLevelOrder(tree.root);
		insertLevelOrder(tree.root,8);
		printLevelOrder(tree.root);
		Node deletedNode=searchNode(tree.root, 3);
		Node rightMostNode=rightMostNode(tree.root);
		deleteNode(deletedNode, rightMostNode,tree.root);
		System.out.println("\n");
		printLevelOrder(tree.root);
	}

}

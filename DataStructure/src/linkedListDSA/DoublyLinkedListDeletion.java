package linkedListDSA;

import linkedListDSA.DoublyLinkedListInsertion.Node;

public class DoublyLinkedListDeletion {

	Node head;
	
	static class Node{
		int data;
		Node prev;
		Node next;
		
		Node(int data){
			this.data=data;
			this.prev=null;
			this.next=null;
		}
	}
	public static DoublyLinkedListDeletion insert(DoublyLinkedListDeletion list,int data){
		//create new node
		Node newNode=new Node(data);
		if(list.head==null){
			newNode.next=null;
			newNode.prev=null;
			newNode.data=data;
			list.head=newNode;
		}
		else{
			//to add the node at the end of list
			Node temp=list.head;
			while(temp.next!=null){
				temp=temp.next;
		}
			newNode.data=data;
			newNode.next=null;
			newNode.prev=temp;
			temp.next=newNode;
		}
		return list;
	/*	Node temp=list.head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}*/
	}
	public static DoublyLinkedListDeletion deletefromLast(DoublyLinkedListDeletion list){
		Node temp=list.head;
		Node prev=null;
		while(temp.next!=null){
			prev=temp;
			temp=temp.next;
		}
		prev.next=null;
		return list;
	}
	
	public static DoublyLinkedListDeletion deletefromFirst(DoublyLinkedListDeletion list){
		
		list.head.next.prev=null;
		list.head=list.head.next;
		return list;
	}
	
public static DoublyLinkedListDeletion deleteinBetween(DoublyLinkedListDeletion list,Node prevNode){
		
		prevNode.next=prevNode.next.next;
		prevNode.next.prev=prevNode;

		return list;
	}
	
	public static void main(String[] args) {
		DoublyLinkedListDeletion list = new DoublyLinkedListDeletion(); 
		  list=insert(list, 1); 
		  list=insert(list, 2); 
		  list= insert(list, 3); 
		  list= insert(list, 4); 
		  list= insert(list, 5); 
		  Node temp=list.head;
			while(temp!=null){
				System.out.println(temp.data);
				temp=temp.next;
			}
			System.out.println("\n");
		 
		 list=deleteinBetween(list,list.head);
		  Node temp1=list.head;
			while(temp1!=null){
				System.out.println(temp1.data);
				temp1=temp1.next;
			}
			System.out.println("\n");
			list=deletefromLast(list);
			 list=deletefromFirst(list);
			 
			 Node temp2=list.head;
				while(temp2!=null){
					System.out.println(temp2.data);
					temp2=temp2.next;
				}
	}


}

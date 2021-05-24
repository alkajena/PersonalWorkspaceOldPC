package linkedListDSA;

import linkedListDSA.DoublyLinkedListInsertion.Node;

public class CircularLinkedListInsertion {

	Node head;
	
	 static class Node{
		 int data;
		 Node next;
		 
		 Node(int data){
			 this.data=data;
			 this.next=null;
		 }
	 }
	 
	 public static CircularLinkedListInsertion insertAtEnd(CircularLinkedListInsertion list,int data){
		 //craete new node
		 Node newNode=new Node(data);
		 
		 if(list.head==null){
			 list.head=newNode;
			 newNode.next=list.head;
		 }
		 else{
			 Node temp=list.head;
			 Node prev=null;
			 while(temp!=null){
				 prev=temp;
				 temp=temp.next;
				 if(temp==list.head){
					 break;
				 }
			 }
			 newNode.next=temp;
			 prev.next=newNode;
		 }
		 return list;
	 }
	 
	 public static CircularLinkedListInsertion insertAtFirst(CircularLinkedListInsertion list,int data){
		 //craete new node
		 Node newNode=new Node(data);
		 
		 if(list.head==null){
			 list.head=newNode;
			 newNode.next=list.head;
		 }
		 else{
			 
			 newNode.next=list.head;
			 Node temp=list.head;
			 Node prev=null;
			 while(temp!=null){
				 prev=temp;
				 temp=temp.next;
				 if(temp==list.head){
					 break;
				 }
			 }
			 list.head=newNode;
			 prev.next=newNode;
			 
		 }
		 return list;
	 }
	 
	 public static void insertInBetween(Node PrevNode,int data){
		 //craete new node
		 Node newNode=new Node(data);
		 
		newNode.next=PrevNode.next;
		PrevNode.next=newNode;
		
	 }
	 
	public static void main(String[] args) {
		CircularLinkedListInsertion list = new CircularLinkedListInsertion(); 
		  list=insertAtEnd(list, 1); 
		  list=insertAtEnd(list, 2); 
		  list= insertAtEnd(list, 3); 
		  list= insertAtEnd(list, 4); 
		  list= insertAtEnd(list, 6); 
		  list=insertAtFirst(list,8);
		  list=insertAtFirst(list,9);
		  list=insertAtFirst(list,10);
		 // list=insertAtfirst(list,89);
		  insertInBetween(list.head,90);
		  Node temp=list.head;
			while(temp!=null){
				System.out.println(temp.data);
				temp=temp.next;
				if(temp==list.head){
					break;
				}
			}

	}

}

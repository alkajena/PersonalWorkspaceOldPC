package linkedListDSA;

import linkedListDSA.CircularLinkedListInsertion.Node;

public class CisularLinkedListDeletion {

	Node head;
	
	 static class Node{
		 int data;
		 Node next;
		 
		 Node(int data){
			 this.data=data;
			 this.next=null;
		 }
                       	 }
	 public static CisularLinkedListDeletion insertAtEnd(CisularLinkedListDeletion list,int data){
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
	 public static CisularLinkedListDeletion deleteAtEnd(CisularLinkedListDeletion list){
		 //craete new node
		Node temp=list.head;
		Node prev=null;
		while(temp.next!=null){
			prev=temp;
			temp=temp.next;
			if(temp.next==list.head){
				break;
			}
		}
		prev.next=list.head;
		
		 return list;
	 }
	 
	 
	 public static CisularLinkedListDeletion deleteFromFirst(CisularLinkedListDeletion list){
		 //craete new node
		Node temp=list.head;
		list.head=temp.next;
		 return list;
	 }
	 
	 
	 public static void deleteInBetween(Node prevNode){
		 //craete new node
		prevNode.next=prevNode.next.next;
		
		
	 }
	 
	
	 
	public static void main(String[] args) {
		CisularLinkedListDeletion list = new CisularLinkedListDeletion(); 
		  list=insertAtEnd(list, 1); 
		  list=insertAtEnd(list, 2); 
		  list= insertAtEnd(list, 3); 
		  list= insertAtEnd(list, 4); 
		  list= insertAtEnd(list, 6); 
		  list=deleteAtEnd(list);
		  Node temp=list.head;
			while(temp!=null){
				System.out.println(temp.data);
				temp=temp.next;
				if(temp==list.head){
					break;
				}
			}
			System.out.println("\n");
		  list=deleteFromFirst(list);
		  deleteInBetween(list.head);
		//  list=insertAtFirst(list,8);
		 // list=insertAtFirst(list,9);
		  //list=insertAtFirst(list,10);
		 // list=insertAtfirst(list,89);
		 // insertInBetween(list.head,90);
		  Node temp1=list.head;
			while(temp1!=null){
				System.out.println(temp1.data);
				temp1=temp1.next;
				if(temp1==list.head){
					break;
				}
			}

	}
}

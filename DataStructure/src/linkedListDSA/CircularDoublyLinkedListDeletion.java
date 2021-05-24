package linkedListDSA;

public class CircularDoublyLinkedListDeletion {

Node head;
	
	static class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data=data;
			next=null;
			prev=null;
		}
		
	}
	
	public static Node getNode(CircularDoublyLinkedListDeletion list,int data){
		Node temp=list.head;
		while(temp!=null)
		{
			temp=temp.next;
			if(temp==list.head){
				break;
			}
			if(temp.data==data){
				return temp;
			}
		}
		return temp;

	}

	public static CircularDoublyLinkedListDeletion insertAtEnd(CircularDoublyLinkedListDeletion list,int data){
		//create new node
		Node newNode=new Node(data);
		if(list.head==null){
			list.head=newNode;
			newNode.next=newNode;
			newNode.prev=list.head;
		}
		else{
			Node temp=list.head;
			Node prev=list.head.prev;
			newNode.prev=prev;
			newNode.next=temp;
			prev.next=newNode;
			temp.prev=newNode;
		}
		return list;
	}
	
	public static CircularDoublyLinkedListDeletion insertAtFirst(CircularDoublyLinkedListDeletion list,int data){
		//create new node
		Node newNode=new Node(data);
		if(list.head==null){
			list.head=newNode;
			newNode.next=newNode;
			newNode.prev=list.head;
		}
		else{
			Node temp=list.head;
			Node prev=list.head.prev;
			newNode.prev=prev;
			newNode.next=temp;
			prev.next=newNode;
			temp.prev=newNode;
			list.head=newNode;
		}
		return list;
	}
	
	public static void insertInBetween(Node prevNode,int data){
		Node newNode=new Node(data);
		newNode.next=prevNode.next;
		newNode.prev=prevNode;
		prevNode.next=newNode;
		newNode.next.prev=newNode;
		
	}
	
	public static void deleteFromEnd(CircularDoublyLinkedListDeletion list){
		Node temp=list.head;
		Node prev=list.head.prev;
		prev.prev.next=temp;
		temp.prev=prev.prev;
	}
	
	public static void deleteFromFirst(CircularDoublyLinkedListDeletion list){
		Node temp=list.head;
		Node prev=list.head.prev;
		prev.next=temp.next;
		temp.next.prev=prev;
		list.head=temp.next;
	}
	
	
	public static void deleteInBetween(Node prevNode){
		prevNode.next=prevNode.next.next;
		prevNode.next.next.prev=prevNode;
	}
	
	public static void main(String[] args) {
		CircularDoublyLinkedListDeletion list=new CircularDoublyLinkedListDeletion();
		list=list.insertAtEnd(list, 1);
		list=list.insertAtEnd(list, 2);
		list=list.insertAtEnd(list, 3);
		list=list.insertAtEnd(list, 4);
		list=list.insertAtEnd(list, 5);
		list=list.insertAtEnd(list, 6);
		list=list.insertAtFirst(list, 8);
		list=list.insertAtFirst(list, 9);
		insertInBetween(list.head,10);
		insertInBetween(list.getNode(list, 8),11);
		deleteFromEnd(list);
		deleteFromFirst(list);
		list.deleteInBetween(list.getNode(list, 2));
		Node temp=list.head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
			if(temp==list.head){
				break;
			}
		}

	}

}

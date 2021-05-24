package linkedListDSA;

public class DoublyLinkedListInsertion {
	
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
	public static DoublyLinkedListInsertion insert(DoublyLinkedListInsertion list,int data){
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
	
	public static DoublyLinkedListInsertion insertAtfirst(DoublyLinkedListInsertion list,int data){
		//craete new node
		Node newNode=new Node(data);
		Node temp=list.head;
		newNode.prev=null;
		newNode.data=data;
		newNode.next=temp;
		list.head=newNode;
		return list;
	}
	
	public static void insertinBetween(int data,Node prevNode){
		//craete new node
		Node newNode=new Node(data);
		newNode.prev=prevNode;
		newNode.data=data;
		newNode.next=prevNode.next;
		prevNode.next.prev=newNode;
		prevNode.next=newNode;
		
	}
	public static void main(String[] args) {
		DoublyLinkedListInsertion list = new DoublyLinkedListInsertion(); 
		  list=insert(list, 1); 
		  list=insert(list, 2); 
		  list= insert(list, 3); 
		  list= insert(list, 4); 
		  list= insert(list, 5); 
		  list=insertAtfirst(list,8);
		  list=insertAtfirst(list,89);
		  insertinBetween(90,list.head);
		  Node temp=list.head;
			while(temp!=null){
				System.out.println(temp.data);
				temp=temp.next;
			}
	}

}

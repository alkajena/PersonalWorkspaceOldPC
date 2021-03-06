package linkedListDSA;

public class SingleLinkedListInsertion {
	
	Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	public static void insert(SingleLinkedListInsertion list,int data){
		//create a new node
		Node newNode=new Node(data);
		 
		if(list.head==null){
			list.head=newNode;
		}
		else{
			//traverse the whole linkedlist to insert the node at the end of linkedlist
			
			while(list.head.next!=null){
				list.head=list.head.next;
			}
			list.head.next=newNode;
		}
		
		while(list.head!=null){
			System.out.println(list.head.data);
			list.head=list.head.next;
		}
	}

	public static void main(String[] args) {
		SingleLinkedListInsertion list = new SingleLinkedListInsertion(); 
		  insert(list, 1); 
		  insert(list, 2); 
		  insert(list, 3); 
		  insert(list, 4); 
		  insert(list, 5); 
	      

	}

}

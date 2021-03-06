package linkedListDSA;

import linkedListDSA.SingleLinkedListInsertion.Node;

public class SingleLinkedListDeletion {

	Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	public static SingleLinkedListDeletion insert(SingleLinkedListDeletion list,int data){
		//create a new node
		Node newNode=new Node(data);
		 
		if(list.head==null){
			list.head=newNode;
		}
		else{
			//traverse the whole linkedlist to insert the node at the end of linkedlist
			Node last=list.head;
			while(last.next!=null){
				last=last.next;
			}
			last.next=newNode;
		}
		
	/*	while(list.head!=null){
			System.out.println(list.head.data);
			list.head=list.head.next;
		}*/
		
		return list;
	}
	
	public static void delete(SingleLinkedListDeletion list,int data){
		Node prev;
		if(list.head!=null){
			if(list.head.next!=null){
				if(list.head.data==data){
					list.head=list.head.next;
				}
				else{
					prev=list.head;
					while(prev!=null){
						if(prev.next.data==data){
							prev.next=prev.next.next;
							break;
						}
						prev=prev.next;
					}
				}
			}
		}
		
		
		while(list.head!=null){
			System.out.println(list.head.data);
			list.head=list.head.next;
		}
	}
	
	public static void deleteByPosition(SingleLinkedListDeletion list,int index){
		Node prev = null;
		Node current;
		int counter=0;
		if(list.head!=null){
			if(list.head.next!=null){
				if(counter==index){
					list.head=list.head.next;
				}
				else{
					current=list.head;
					while(current!=null){
						if(counter==index){
							prev.next=current.next;
							break;
						}
						prev=current;
						current=current.next;
						counter++;
					}
				}
			}
		}
		
		
		while(list.head!=null){
			System.out.println(list.head.data);
			list.head=list.head.next;
		}
	}

	public static void main(String[] args) {
		SingleLinkedListDeletion list= new SingleLinkedListDeletion(); 
		 list= insert(list, 1); 
		 list=  insert(list, 2); 
		 list= insert(list, 3); 
		 list=  insert(list, 4); 
		 list=  insert(list, 5); 
		  deleteByPosition(list,2);

	}

}

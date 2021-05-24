package queueDSA;

public class QueueUsingLinkedList {
	static Node front;
	static Node rear;
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	
	@SuppressWarnings("null")
	public void enQueue(int data){
		Node newNode=new Node(data);
		if(rear==null){
			rear=newNode;
			front=newNode;
		}
		else{
			Node temp=rear;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=newNode;
			rear=newNode;
		}
	}
	
	public Node deQueue(){
		if(front==null){
			return null;
		}
		
		Node temp=front;
		front=front.next;
		
		//when all the data are deleted from queue front becomes null but rear is not null...So it is required to make rear also null so
		//that next insertion starts from beginning
		if(front==null)
			rear=null;
		return temp;
	}
	public static void main(String[] args) {
		QueueUsingLinkedList q = new QueueUsingLinkedList(); 
        q.enQueue(10); 
        q.enQueue(20); 
        q.deQueue(); 
        q.deQueue(); 
        q.enQueue(30); 
        q.enQueue(40); 
        q.enQueue(50); 
        
        Node temp=front;
        while(temp!=rear){
        	System.out.println(temp.data);
        	temp=temp.next;
        }
        System.out.println(temp.data);

	}

}

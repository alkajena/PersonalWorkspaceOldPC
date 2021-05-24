package stackDSA;

public class StackUsingLinkedList {
	Node top;
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	//insert from front operation
	public void Push(int data){
		Node newNode=new Node(data);
		if(top==null){
			top=newNode;
		}
		else{
			newNode.next=top;
			top=newNode;
		}
	}
	
	//delete from front operation
		public void Pop(){
			
			if(top==null){
				System.out.println("Stack is underflowing");
			}
			else{
				top=top.next;
			}
		}
//getting top element
		public void Peek(){
			if(top==null){
				System.out.println("Stack is underflowing");
			}
			else{
				System.out.println("Top element is :"+ top.data);
			}
		}
	public static void main(String[] args) {
		StackUsingLinkedList list=new StackUsingLinkedList();
		list.Push(1);
		list.Push(2);
		list.Push(3);
		list.Push(4);
		list.Push(5);
		list.Peek();
		list.Pop();
		list.Peek();
		Node temp=list.top;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}

}

package queueDSA;

public class QueueOperations {
	 static int front;
	 static int rear;
	static int max=8;
	static int[] arr;
	
	
	public QueueOperations(){
		rear=-1;
		front=0;
		arr=new int[max];
	}
	
	public  boolean isEmpty(){
		if(front<-1 || front>=rear){
			return true;
		}
		return false;
	}
	
	public  boolean isFull(){
		if(rear>=max){
			return true;
		}
		return false;
	}
	
	public  int peek(){
		return arr[front];
	}
	
	public int[] enQueue(int data){
		if(isFull()){
			System.out.println("queue is overflowing");
		}
		else{
			arr[++rear]=data;
		}
		return arr;
	}
	
	public int deQueue(){
		if(isEmpty()){
			System.out.println("queue is underflowing");
		}
		else{
			int data=arr[front++];
			return data;
		}
		return 0;
	}
	public static void main(String[] args) {
		QueueOperations queue=new QueueOperations();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.deQueue();
	for(int i=front;i<=rear;i++){
		System.out.println(arr[i]);
	}

	}

}

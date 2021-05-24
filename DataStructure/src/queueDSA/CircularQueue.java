package queueDSA;

public class CircularQueue {
	static int max=10;
	static int front;
	static int rear;
	
	static int[] arr=new int[max];
	
	CircularQueue(){
		rear=front=-1;
	}
	
	public void enQueue(int data){
		if((front==0 && rear==max-1) || (rear==front-1)){
			System.out.println("queue is full");
		}
		else if(front==-1 && rear==-1){
			front=rear=0;
			arr[front]=data;
		}
		//when queue is full but deletion happened
		else if (rear==max-1 && front!=0){
			rear=0;
			arr[rear]=data;
		}
		else{
			rear+=1;
			arr[rear]=data;
		}
	}
	public void deQueue(){
		if(front==-1){
			System.out.println("queue is empty");
		}
		else if(front==max-1){
			int data=arr[front];
			front=0;
		}
		else if (front==rear){
			rear=front=-1;
			int data=arr[front];
		}
		else{
			int data=arr[front++];
		}
	}
	
	public static void main(String[] args) {
		CircularQueue queue=new CircularQueue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.deQueue();
		queue.enQueue(8);
		queue.enQueue(6);
		queue.deQueue();
	for(int i=front;i<=rear;i++){
		System.out.println(arr[i]);
	}

	}

}

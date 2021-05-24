package queueDSA;

public class DeQueueUsingCircularArray {

	int front;
	int rear;
	static int max=10;
	static int[] arr=new int[max];
	
	DeQueueUsingCircularArray(){
		front=-1;
		rear=-1;
	}
	
	public boolean isFull(){
		return ((rear==max-1 && front!=0) || (rear==front-1));
	}
	
	public boolean isEmpty(){
		return front==-1;
	}
	
	public void insertrear(int data){
		if(isFull()){
			System.out.println("Queue is full");
		}
		else if(rear==-1 && front==-1){
			rear=0;
			front=0;
		}
		else if(rear==max-1 && front!=0){
			rear=0;
		}
		else{
			rear++;
		}
		arr[rear]=data;
	}
	
	public void insertfront(int data){
		if(isFull()){
			System.out.println("Queue is full");
		}
		else if(rear==-1 && front==-1){
			rear=0;
			front=0;
		}
		else if(front==0){
			front=max-1;
		}
		else{
			front=front-1;
		}
		arr[front]=data;
	}
	
	public int deleterear(){
		int x=arr[rear];
		arr[rear]=0;
		if(isEmpty()){
			System.out.println("Queue is empty");
		}
		else if(front==rear){
			front=rear=0;
		}
		else if(rear==0){
			rear=max-1;
		}
		else{
			rear=rear-1;
		}
		return x;
	}
	
	public int deletefront(){
		int x=arr[front];
		arr[front]=0;
		if(isEmpty()){
			System.out.println("Queue is empty");
		}
		else if(front==rear){
			front=rear=0;
		}
		else if(front==max-1){
			front=0;
		}
		else{
			front=front+1;
		}
		return x;
	}
	
	public int getRear(){
		if(!isEmpty())
			return arr[rear];
		return 0;
	}
	
	public int getFront(){
		if(!isEmpty())
			return arr[front];
		return 0;
	}
	
	public static void main(String[] args) {
		DeQueueUsingCircularArray dq=new DeQueueUsingCircularArray();
		System.out.println("Insert element at rear end  : 5 "); 
        dq.insertrear(5); 
          
        System.out.println("insert element at rear end : 10 "); 
        dq.insertrear(10); 
          
        System.out.println("get rear element : "+ dq.getRear()); 
          
        dq.deleterear(); 
        System.out.println("After delete rear element new rear become : " +  
                               dq.getRear()); 
          
        System.out.println("inserting element at front end"); 
        dq.insertfront(15); 
          
        System.out.println("get front element: " +dq.getFront()); 
          
        dq.deletefront(); 
          
        System.out.println("After delete front element new front become : " + 
                                   +  dq.getFront()); 

	}

}

package stackDSA;

public class StackOperation {
	static final int max=1000;
	int top;
	static int[] arr=new int[max];
	
	//default constructor
	public StackOperation(){
		top=-1;
	}
	
	//push operation
	public void push(int data){
		if(top>=max){
			System.out.println("stack is overflowing");
		}
		else{
			arr[++top]=data;
			System.out.println(data +" is pushed");
		}
	}
	
	//push operation
		public int pop(){
			if(top<0){
				System.out.println("stack is underflowing");
				return 0;
			}
			else{
				int x=arr[top--];
				System.out.println(x +" is poped");
				return x;
			}
		}
	//To get top element
		
	public int peek(){
		if(top<0){
			System.out.println("stack is underflowing");
			return -1;
		}
		else{
			int x=arr[top];
			System.out.println("Top element is :"+x);
			return x;
		}
	}
	
	public boolean isEmpty(){
		if(top<0){
			System.out.println("stack is underflowing");
			return true;
		}
		else{
		return false;
		}
	}
	public static void main(String[] args) {
		StackOperation stack=new StackOperation();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		stack.peek();
		/*for(int x:arr){
			System.out.println(x);
		}*/

	}

}

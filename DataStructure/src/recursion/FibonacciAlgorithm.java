package recursion;

public class FibonacciAlgorithm {
	static void fibonacci(){
		int n=0;
		int i=0;
		int j=1;
		//while()
	}

	public static void main(String[] args) {
		int n=0;
		int i=0;
		int j=1;
		int sum=0;
		System.out.println(i);
		System.out.println(j);
		while(n<=8){
			sum=i+j;
			System.out.println(i+j);
			i=j;
			j=sum;
			n++;
		}
	}

}

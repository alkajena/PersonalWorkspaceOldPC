package greedyAlgorithm;

public class SmallestNumber {
	//The task is to find the smallest number with given sum of digits as s and number of digits as d.
	public static void main(String[] args) {
		int sum=64;//31,31,2
		int digits=3;
		
		if((sum%digits)==0){
			System.out.println(-1);
		}
		else if(digits==2){
			System.out.println(1);
		}
		else{
			int remainder=sum%(digits-1);
			if(remainder==0){
				System.out.println(digits-1);
			}
			else{
				System.out.println(remainder);
			}
		}

	}

}

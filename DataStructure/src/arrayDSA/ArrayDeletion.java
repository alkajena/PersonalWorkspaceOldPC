package arrayDSA;

public class ArrayDeletion {

	public static void main(String[] args) {
		int arr[]=new int[]{10,20,30,40,50};
		int index=2;
		int x=0;
		for(int i=0;i<arr.length;i++){	
			if(index<i){
				arr[i-1]=arr[i];
			}	
		}
		for(int i=0;i<arr.length-1;i++){
			System.out.println(arr[i]);
		}
	}
}

package sortingTechniques;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr={12,11,13,5,6,7};
		for(int i=1;i<arr.length;i++){
			int j=i-1;
			while(j>=0){
			if(arr[j]>arr[j+1]){
				int temp=arr[j+1];
				arr[j+1]=arr[j];
				arr[j]=temp;
			}
			j--;
			
		}
	}
		
		for(int x:arr){
			System.out.println(x);
		}
}

}

package sorting;

public class Selectionsort {

	public static void main(String[] args) {
		 Integer arr[] = {64,25,12,22,11}; 
		 selectionsort(arr);

	}
	/*TC=O(n2)..Memory write is best as number of swap is only o(n)
	 * it always select the minimum element of unsorted half and add that to sorted half
	 * Auxiliary space=O(1) and it is not stable but can make as stable
	 */
	public static void selectionsort(Integer[] arr){
		for(int i=0;i<arr.length;i++){
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[minIndex] > arr[j]){
					minIndex=j;
				}
			}
			
			int temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
		
		for(int i:arr){
			System.out.println(i);
		}
	}
}

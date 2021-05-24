package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		Integer[] arr={12,11,13,5,6,4};
		insertionsort(arr);

	}
	/*This sort has time complexity o(n2)...the element compares itself with the sorted sub array..
	 * it is suitable when array is almost sorted and only 2-3 elements are there for sorting
	 * if array is reversely sorted then it gives worst time complexity
	 * if array is sorted then it gives best time complexity
	 */
	public static void insertionsort(Integer[] arr){
		for(int i=1;i<arr.length;i++){
			int k=i;
			for(int j=i-1;j>=0;j--){
				if(arr[j] > arr[k] ){
					int temp=arr[j];
					arr[j]=arr[k];
					arr[k]=temp;
				}
				k--;
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}

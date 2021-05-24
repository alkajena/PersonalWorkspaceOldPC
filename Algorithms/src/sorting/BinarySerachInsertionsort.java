package sorting;

public class BinarySerachInsertionsort {

	public static void main(String[] args) {
		Integer[] arr={37, 23, 0, 17, 12, 72, 31, 
                46, 100, 88, 54};
		binarySearchInsertionSort(arr);

	}
	public static void binarySearchInsertionSort(Integer[] arr){
		
		int index = 0;
	    int element = 0;
	    int[] returnArray = new int[arr.length];

	    for (int i = 1; i < arr.length - 1; i++)
	    {
	    	 int lowIndex = 0;
	         int highIndex = i;
	         int b = arr[i];

	         //while loop for binary search
	         while(lowIndex < highIndex) {
	             int middle = lowIndex + (highIndex - lowIndex)/2; //avoid int overflow
	             if (b >= arr[middle]) {
	                 lowIndex = middle+1;
	             }
	             else {
	                 highIndex = middle;
	             }
	         }
	         //replace elements of array
	         System.arraycopy(arr, lowIndex, arr, lowIndex+1, i-lowIndex);
	         arr[lowIndex] = b;
	        returnArray[index + 1] = element;
	    }
	    for(int x:arr){
	    	System.out.println(x);
	    }
	}
	public static int Binarysearch(Integer[] arr,int l,int h, int x){
		if(l<=h){
			int mid=l+((h-l)/2);
			if(arr[mid]==x){
				return mid;
			}
			else if(x < arr[mid]){
				return Binarysearch(arr,l,mid-1,x);
			}
			else{
				return Binarysearch(arr,mid+1,h,x);
			}
		}
		return -1;
	}
}

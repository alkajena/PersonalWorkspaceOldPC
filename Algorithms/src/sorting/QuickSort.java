package sorting;

public class QuickSort {

	public static void main(String[] args) {
		Integer[] arr={37, 23, 0, 17, 12, 72, 31, 
                46, 100, 88, 54};
		Quicksort(arr,0,arr.length-1);
		for(int i:arr){
			System.out.println(i);
		}

	}
	/*Time complexity is O(n/2)+O(n/2)+O(n)=2O(n/2)+O(n)=o(nLog(N))(best TC) where O(n/2):-TC for each half,O(N):- to find partition
	 * O(n2) is worst time complexity= O(k)+O(n-k-1)+O(n) where k=no of smaller elements than pivot,n=length of total array
	 * It is mainly used in sorting of array as all data in array is kept in contiguous memory location
	 * Auxiliary space:-O(N) as to store recursive calls
	 */
	public static void Quicksort(Integer[] arr,int l,int h){
		if(l<h){
			int pos=partition(arr,l,h);
			
			Quicksort(arr,l,pos-1);
			Quicksort(arr,pos+1,h);
		}
		
		
	}
	//This function places the pivot at correct place and left to pivot all shorter elements will be there
	//and right to pivot all greater elements are present...
	public static int partition(Integer[] arr,int l,int h){
		int pivot=arr[h];
		
		int i=l-1;
		
	
		for(int j=l;j<h;j++){
			if(arr[j] < pivot){
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		//swap pivot with the element which is present the exact position of pivot...
		int temp=arr[i+1];
		arr[i+1]=arr[h];
		arr[h]=temp;
		
		return i+1;
	}
}

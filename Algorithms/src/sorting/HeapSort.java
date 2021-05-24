package sorting;

public class HeapSort {

	public static void main(String[] args) {
		Integer[] arr={37, 23, 0, 17, 12, 72, 31, 
                46, 100, 88, 54};
		heapsort(arr);
		for(int i:arr){
			System.out.println(i);
		}

	}	
	/*TimeCompalexity is O(nLog(N)) where hepify requires O(Logn) and n is for the whole array
	 * It is mainly used for Binary Heap tree...
	 */
	public static void heapsort(Integer[] arr){
		//first find the max heap
		for(int i=(arr.length/2)-1;i>=0;i--){
			Hepify(arr,arr.length,i);
		}
		
		//max element is at parent node..so replace the parent node with last node and reduce array size by 1 and again apply
		//hepify in reduced array size
		for(int i=arr.length-1;i>0;i--){
			
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			
			Hepify(arr,i,0);
		}
	}
	
	public static void Hepify(Integer[] arr,int n,int i){
		int largest=i;
		int l=(2*i)+1;
		int r=(2*i)+2;
		
		if(l<n && arr[largest]< arr[l])
			largest=l;
		if(r<n && arr[largest] < arr[r])
			largest = r;
		
		if(largest!=i){
			
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			
			Hepify(arr,n,largest);
		}
	}
}

package sortingTechniques;

public class HeapSort {
	public static void sort(int[] arr,int n){
		//to find the first heap of the array as arr[0] does not contain max element
		for(int i=n/2-1;i>=0;i--){
			hepify(arr,n,i);
		}
		
		for(int x:arr){
			System.out.println(x);
		}
		
		//here we are going from bottom as we are having max element at the top arr[0]. so we are swapping with the last element and changing the 
		//array size from n to n-1
		for(int i=n-1;i>=0;i--){
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			
			hepify(arr,i,0);
		}
		
		for(int x:arr){
			System.out.println(x);
		}
	}
	public static void hepify(int[] arr,int n,int i){
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		if(l<n && arr[largest]<arr[l]){
			largest=l;
		}
		if(r<n && arr[largest]<arr[r]){
			largest=r;
		}
		if(largest!=i){
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;	
			hepify(arr,n,largest);
		}
	}
	public static void main(String[] args) {
		 int arr[] = {12, 11, 13, 5, 6, 7}; 
	        int n = arr.length; 
	        sort(arr,n);
	}

}

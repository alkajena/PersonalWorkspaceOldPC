package miscellaneous;

public class KthSmallestElementByQuickSort {

	public static void main(String[] args) {
		 Integer arr[] = new Integer[] { 12, 3, 5, 7, 4, 19, 26 }; 
	        int k = 3; 
	        System.out.println(kthSmallestElement(arr,k,0,arr.length-1));
	}
	/*Time Complexity of normal quick sort is o(nlogn) but in worst case it is o(n2) which happens when we choose max or min number as pivot
	 * when random number in between l to r is choosen as pivot then TC=o(n)
	 * 
	 * 
	 */
	public static int partition(Integer[] arr,int l,int r){
		int pivot=arr[r];
		int i= l-1;
		for(int j=l;j<arr.length;j++){
			if(arr[j] < pivot){
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[r];
		arr[r]=temp;
		
		return i+1;
	}
	public static int randompartition(Integer[] arr,int l,int r){
		int n=(r-l)+1;
		int pivot=((int)Math.random())*(n-1);
		int temp=arr[pivot+l];
		arr[pivot+l]=arr[r];
		arr[r]=temp;
		return partition(arr, l, r);
	}
	public static int kthSmallestElement(Integer[] arr,int k,int l,int r){
		if(k > 0 && k <= (r-l)+1){
			int pos=partition(arr,l,r);
			
			if(pos-l==k-1)
				return arr[pos];
			
			if(pos-l > k-1)
				return kthSmallestElement(arr,k,l,pos-1);
			else
				return kthSmallestElement(arr,k - pos + l - 1,pos+1,r);
		}
		return Integer.MAX_VALUE;
	}
	
	public static int kthSmallestElementRandomPivot(Integer[] arr,int k,int l,int r){
		if(k > 0 && k <= (r-l)+1){
			
			int pos=randompartition(arr,l,r);
			
			if(pos-l==k-1)
				return arr[pos];
			
			if(pos-l > k-1)
				return kthSmallestElement(arr,k,l,pos-1);
			else
				return kthSmallestElement(arr,k - pos + l - 1,pos+1,r);
		}
		return Integer.MAX_VALUE;
	}
}

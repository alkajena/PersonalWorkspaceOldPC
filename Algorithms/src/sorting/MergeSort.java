package sorting;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] arr={37, 23, 0, 17, 12, 72, 31, 
                46, 100, 88, 54};
		mergeSort(arr,0,arr.length-1);
		for(int i:arr){
			System.out.println(i);
		}

	}
	/*Time complexity is o(logn)(best,worst,average).. 
	 * This is mainly used for sorting of linkedlist as in linkedlist no data present in contiguous memory location so while merging data we need merge sort
	 * It uses divide and conquer approach
	 * Auxiliary space=o(n)(as recursive call are there so it will take temporary space)
	 * 
	 */
	public static void mergeSort(Integer[] arr,int l,int h){
		if(l < h){
			int m=l+((h-l)/2);
			
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,h);
			
			merge(arr,l,m,h);
		}
	}
	
	public static void merge(Integer[] arr,int l,int m,int h){
		int lsize=m-l+1;
		int rsize=h-m;
		
		Integer[] larr=new Integer[lsize];
		Integer[] rarr=new Integer[rsize];
		
		for(int i=0;i<lsize;i++){
			larr[i]=arr[l+i];
		}
		
		for(int i=0;i<rsize;i++){
			rarr[i]=arr[m+1+i];
		}
		
		int i=0;int j=0;int k=l;
		
		while(i<lsize && j<rsize){
			if(larr[i] <= rarr[j]){
				arr[k]=larr[i];
				i++;
			}else{
				arr[k]=rarr[j];
				j++;
			}
			k++;
		}
		
		while(i<lsize){
			arr[k]=larr[i];
			i++;
			k++;
		}
		
		while(j<rsize){
			arr[k]=rarr[j];
			j++;
			k++;
		}
	}
}

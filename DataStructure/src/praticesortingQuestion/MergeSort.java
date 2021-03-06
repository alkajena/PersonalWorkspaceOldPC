package praticesortingQuestion;

public class MergeSort {
	
	public static void sort(int[] arr,int l,int r){
		if(l<r){
			int m=(l+r)/2;
			sort(arr,0,m);
			sort(arr,m+1,r);
			mergeSort(arr,l,m,r);
		}
	}
	
	public static void mergeSort(int[] arr,int l,int m, int r){
		int lsize=m-l+1;
		int rsize=r-m;
		
		int[] larr=new int[lsize];
		int[] rarr=new int[rsize];
		
		for(int i=0;i<lsize;i++)
			larr[i]=arr[l+i];
		for(int j=0;j<rsize;j++)
			rarr[j]=arr[m+1+j];
		
		int i=0;
		int j=0;
		int k=l;
		
		while(i<lsize && j<rsize){
			if(larr[i]<arr[k]){
				arr[k]=larr[i];
				i++;
			}
			else{
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
			k++;
			j++;
		}
	}

	public static void main(String[] args) {
		int[] arr=new int[]{12,11,13,5,6};
		sort(arr,0,arr.length-1);
		System.out.println(arr);

	}

}

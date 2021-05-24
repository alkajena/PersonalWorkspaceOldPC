package sortingTechniques;

public class MergeSort {

	public static void sort(int[] arr,int low,int high){
		int mid=low+(high-low)/2;
		if(low<high){
			sort(arr,low,mid);
			sort(arr,mid+1,high);
			merge(arr,mid,low,high);
		}
	}
	public static void merge(int[] arr,int m,int l,int h){
		int lSize=m-l+1;
		int rSize=h-m;
		int[] lArr=new int[lSize];
		int[] rArr=new int[rSize];
		
		for(int i=0;i<lSize;i++){
			lArr[i]=arr[l+i];
		}
		
		for(int i=0;i<rSize;i++){
			rArr[i]=arr[m+1+i];
		}
		
		int i=0;
		int j=0;
		int k=l;
		
		while(i<lSize && j<rSize){
			if(lArr[i]<rArr[j]){
				arr[k]=lArr[i];
				i++;
			}
			else{
				arr[k]=rArr[j];
				j++;
			}
			k++;
		} 
		
		while(i<lSize){
			arr[k]=lArr[i];
			i++;
			k++;
		}
		
		while(j<rSize){
			arr[k]=rArr[j];
			j++;
			k++;
		}
	}
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		sort(arr,0,arr.length-1);

		for(int x:arr){
			System.out.println(x);
		}
	}

}

package praticesortingQuestion;

public class QuickSort {
	
	public static int partition(int[] arr,int l,int h){
		int pivot=arr[h];
		int i=l-1;
		for(int j=l;j<h;j++){
			if(arr[j]<pivot){
				i++;
				
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[h];
		arr[h]=temp;
		
		return i+1;
	}
	
	public static void sort(int[] arr,int l,int h){
		if(l<h){
			int p=partition(arr,l,h);
			sort(arr,l,p-1);
			sort(arr,p+1,h);
		}
	}

	public static void main(String[] args) {
		int[] arr=new int[]{12,11,13,5,6};
		sort(arr,0,arr.length-1);

	}

}

package sortingTechniques;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr=new int[]{64,25,12,22,11};
		for(int i=0;i<arr.length-1;i++){
			int min_index=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[min_index]){
					min_index=j;
					//arr[min_index]=arr[j];
				}
			}
			int temp=arr[i];
			arr[i]=arr[min_index];
			arr[min_index]=temp;
			
		}
		for(int x:arr){
			System.out.println(x);
		}
	}

}

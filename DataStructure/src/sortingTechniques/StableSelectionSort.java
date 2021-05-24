package sortingTechniques;

public class StableSelectionSort {

	public static void main(String[] args) {
		//Stable means if similar kind of datas are present then post sorting the order of similar datas should remain same.
		//if array contains [4a,15,1,3,8,4b].here 4a and 4b are similar kind of data. before sorting 4a is before 4b so after sorting 4a must be 
		//before sorting.that is called stable sorting.
		int[] arr=new int[]{4,5,3,2,4,1};
		for(int i=0;i<arr.length-1;i++){
			int min=arr[i];
			int k=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<min){
					min=arr[j];
					k=j;
				}
			}
			//here we are not swapping like in normal selection sort. we are doing forward pushing instead of swapping to maintain the order of similar data.
			while(k>i){
				arr[k]=arr[k-1];
				k--;
			}
			arr[i]=min;
		}
		for(int x:arr){
			System.out.println(x);
		}
	}

}

package praticesortingQuestion;

public class InsertionSort {

	public static void sort(int[] arr,int l,int h){
		for(int i=1;i<arr.length;i++){
			int j=i-1;
			int key=arr[i];
			while(j>=0 && arr[j]>key){
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

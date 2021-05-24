package sortingTechniques;

public class BubbleSort {

	public static void main(String[] args) {
		boolean swap=false;
		Integer[] arr=new Integer[]{1,2,3,4,5,6,7};
		for(int j=0;j<arr.length;j++){
			for(int i=0;i<arr.length-i-1;i++){
				if(arr[i]>arr[i+1]){
					int temp=arr[i+1];
					arr[i+1]=arr[i];
					arr[i]=temp;
					swap=true;
				}
			}
			if(swap==false){
				break;
			}
	}
		for(int x:arr){
			System.out.println(x);
		}

	}

}

package sortingTechniques;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr={12, 34, 54, 2, 3,84,1,13,76,50};
		int size=arr.length;
		for(int gap=size/2;gap>0;gap=gap/2){
			for(int i=gap;i<size;i++){
				int j=i-gap;
			
				while(j>=0){
					if(arr[j]>arr[j+gap]){
						int temp1=arr[j];
						arr[j]=arr[j+gap];
						arr[j+gap]=temp1;
					}
					j--;
				}
				
			}
		}
		
		for(int x:arr){
			System.out.println(x);
		}
		

	}

}

package sorting;

public class ShellSort {

	public static void main(String[] args) {
		Integer[] arr={12, 34, 54, 2, 3};
		shellShort(arr);
	}
	/*Time complexity for this sort is o(n2) which is not that good and same as insertion sort..
	 * We can change this by changing the gap size/reducing the gap size in different manner
	 */
	public static void shellShort(Integer[] arr){
		int size=arr.length;
		//we are dividing the whole array in to 2 parts(we are taking a range in which we are doing insertion sorting)
		for(int i=size/2;i>0;i=i/2){
			//same as insertion sort but in this case we are not comparing the data linearly rather 
			//than 1st we are taking a range then we are doing comparison
			for(int j=i;j<arr.length;j++){
				int x=j;
				for(int k=j-i;k>=0;k--){
					if(arr[k]>arr[x]){
						int temp=arr[k];
						arr[k]=arr[x];
						arr[x]=temp;
					}
					x--;
				}
			}
		}
		for(int i:arr){
			System.out.println(i);
		}
		
	}
}

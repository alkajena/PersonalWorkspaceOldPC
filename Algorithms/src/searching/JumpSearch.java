package searching;

public class JumpSearch {

	public static void main(String[] args) {
		Integer[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		int x=18;
		System.out.println("Index of searched element : "+jumpSearch(arr,x));

	}
	
	/*This search is in between linear search and binary search i.e. better than linear serach and worse than binary search
	 * time complexity is o(sqrt(n))==(n/m)+(m-1) where n=size of array,m=step size... when m = sqrt(n) then it will give optimum result
	 * when you are seraching data is smallest or smaller then this search is helpful(best) than binary search..
	 * it is applied in sorted array...
	 * space complexity=1(auxiliary space) 
	 */
	public static int jumpSearch(Integer[] arr,int x){
		Integer step=(int) Math.floor(Math.sqrt(arr.length));//floor takes lower value and ceil takes larger value
		int y=0;
		int i=0;
		for(i=0;i<=arr.length-1  ;i+=step){
			/*if(i>arr.length-1 && y<i){
				if(arr[arr.length-1]>=x){
					y=arr.length-1;
					break;
				}
				else{
					return -1;
				}
			}*/
			if(arr[i]==x)
				return i;
			else if(arr[i]>x){
				y=Math.min(i, arr.length-1);
				break;
			}
			
		}
		y=Math.min(i, arr.length-1);
		for(int k=y-step;k<=y;k++){
			if(arr[k]==x)
				return k;
		}
		return -1;
	}
}

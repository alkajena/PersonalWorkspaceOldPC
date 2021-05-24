package searching;

public class InterpolationSearch {

	public static void main(String[] args) {
		Integer[] arr={1,2,3,4,5,6,7,8,9};
		int x=9;
		System.out.println("The index of searched element is : "+interpolationSearch(arr,x,0,8));
		

	}
	/*This is better than binary search as time complexity of this search is log(logn)
	 * if the searched element is nearer to left end then the "pos" is mostly towards left side..
	 * Space complexity is log(logn) for recursive method and 1 for iterative method... 
	 */
	public static int interpolationSearch(Integer[] arr,int x,int l,int r){
		if(l<=r){
			int pos=l+((x-arr[l])*(r-l)/(arr[r]-arr[l]));
			if(x==arr[pos])
				return pos;
			else if(x > arr[pos]){
				l=pos+1;
				interpolationSearch(arr,x,l,r);
				
			}
			else{
				r=pos-1;
				interpolationSearch(arr,x,l,r);
			}
		}
		return -1;
	}
}

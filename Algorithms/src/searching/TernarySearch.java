package searching;

public class TernarySearch {

	public static void main(String[] args) {
		Integer[] arr={1,2,3,4,5,6,7,8,9};
		int x=9;
		System.out.println(Ternarysearch(arr,x,0,arr.length-1));

	}
	/*This search is similar as binary search..Time complexity of this search is log(n) base as 3
	 * which is greater than binary search's time complexity(log(n) base as 2)...
	 * In this case whle array is divided into 3 sections and then searching happens
	 * space complexity is log(n) for recursive way and 1 for iterative way..
	 */
	public static int Ternarysearch(Integer[] arr,int x,int l,int h){
		int mid1=l+((h-l)/3);
		int mid2=mid1+((h-l)/3);
		if(l<=h){
			if(arr[mid1]==x){
				return mid1;
			}
			if(arr[mid2]==x){
				return mid2;
			}
			if(x<arr[mid1]){
				h=mid1-1;
				return Ternarysearch(arr, x, l, h);
			}
			else if(x>arr[mid2]){
				l=mid2+1;
				return Ternarysearch(arr, x, l, h);
			}
			else{
				l=mid1+1;
				h=mid2-1;
				return Ternarysearch(arr, x, l, h);
			}
		}
		return -1;
	}
}

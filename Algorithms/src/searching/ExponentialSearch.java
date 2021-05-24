package searching;

public class ExponentialSearch {

	public static void main(String[] args) {
		Integer[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int x=14;
		System.out.println(exponentialSearch(arr,x));
		

	}
	/*This is the search similar to jump search.We have to search exponentially means we have to take step like i,2*i,4*i,8*i...
	 * Once we get the interval then we have to do binary search..so time compelxity of this search is log(n)
	 *This is useful for infinite Binary search..unbounded binary search ..
	 *Space complexity is 1 for iterative approach and log(n) for recursive approach...
	 */
	public static int exponentialSearch(Integer[] arr,int x){
		int i=1;
		int y=0;
		if(arr[0]==x)
			return 0;
		for(i=1;i<arr.length;i*=2){
			if(arr[i]==x)
				return i;
			else if(arr[i]>x){
				y=Math.min(i, arr.length-1);
				break;
			}
		}
		y=Math.min(i, arr.length-1);
		int m=y/2+((y-y/2)/2);
		return BinaryserachRecursiveWay(arr,x,y/2,y,m);
		
	}
	public static int BinaryserachRecursiveWay(Integer[] searchArr,int x,int l,int h,int m){
		if(l<=h){
			if(searchArr[m]==x){
				return m;
			}
			else if(x < searchArr[m]){
				h=m-1;
				m=l+((h-l)/2);
				return BinaryserachRecursiveWay(searchArr,x,l,h,m);
			}
			else{
				l=m+1;
				m=l+((h-l)/2);
				return BinaryserachRecursiveWay(searchArr,x,l,h,m);
			}
		}
		return -1;
	}
}

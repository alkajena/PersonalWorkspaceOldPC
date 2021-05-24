package searching;

public class BinarySerach {
//This is a search for sorted arrays unlike linear search
	public static void main(String[] args) {
		Integer[] searchArr={1,2,3,4,5,6,7,8,9};
		int x=8;
		int index=0;
		int low=0;
		int high=searchArr.length-1;
		int mid=low +((high-low)/2);
		index=BinaryserachRecursiveWay(searchArr,x,low,high,mid);
		System.out.println("BinaryserachRecursiveWay() index is :"+index);
		index=BinarySerachIterativeWay(searchArr,x,low,high,mid);
		System.out.println("BinarySerachIterativeWay() index is :"+index);

	}
/*BinaryserachRecursiveWay is having time complexity O(logn) which is much 
 * less than linear search thats why it is preferred search over linear one
 * auxiliary space(space taken by temporary variable) taken by this search is log(n) as number of recursive call happens is log(n)...
 * space complexity=auxiliary space+space taken by input 
 */
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
	
	/*BinarySerachIterativeWay is having time complexity O(logn) which is much 
	 * less than linear search thats why it is preferred search over linear one
	 * auxiliary space(space taken by temporary variable) taken by this search is 1 as no recursive call happens...
	 * space complexity=auxiliary space+space taken by input 
	 */
	
	public static int BinarySerachIterativeWay(Integer[] searchArr,int x,int l,int h,int m){
		while(l<=h){
			if(searchArr[m]==x){
				return m;
			}
			else if(x < searchArr[m]){
				h=m-1;
				m=l+((h-l)/2);
			}
			else{
				l=m+1;
				m=l+((h-l)/2);
			}
		}
		return -1;
	}
}

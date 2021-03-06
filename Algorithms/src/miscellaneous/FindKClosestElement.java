package miscellaneous;

/*Time complexity=O(logN+k)..O(logn) for binary search and O(k)  for k no of comparisons
 * here below number given is 35..k=4 i.e. we have to find 4 values which is closest to 35 in the array
 * first we have to do binary search to get index of given number then get l=index-1 and r=index+1
 * By comparison of arr[index] with arr[l] and arr[index] with arr[r] we choose which closest value to print
 */
public class FindKClosestElement {

	public static void main(String[] args) {
		Integer arr[] = {12, 16, 22, 30, 35, 39, 42, 
                45, 48, 50, 53, 55, 56
               }; 
   int n = arr.length; 
   int x = 35, k = 4; 
   findKclosestElement(arr, x, 4); 

	}
	public static int crossOverPoint(Integer[] arr,int x,int l,int h){
		int m=l+((h-l)/2);
		
		if(arr[m]==x)
			return m;
		if(x < arr[m])
			return crossOverPoint(arr,x,l,m);
		else
			return crossOverPoint(arr,x,m+1,h);
	
	}
	public static void findKclosestElement(Integer[] arr,int x,int k){
		int l=crossOverPoint(arr,x,0,arr.length-1);
		int r=l+1;
		int count=0;
		if(arr[l]==x)
			l--;
		
		while(l>=0 && r<arr.length && count < k){
			if(x-arr[l] < arr[r]-x){
				System.out.println(arr[l]);
				l--;
			}
			else{
				System.out.println(arr[r]);
				r++;
			}
			count++;
		}
		
		while(count<k && l>=0){
			System.out.println(arr[l]);
			l--;
		}
		
		while(count<k && r<arr.length){
			System.out.println(arr[r]);
			r++;
		}
	}

}

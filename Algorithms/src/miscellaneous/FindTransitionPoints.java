package miscellaneous;

public class FindTransitionPoints {
/*You are given a sorted array containing only numbers 0 and 1. Find the transition point efficiently.
 *  The transition point is a point where "0" ends and "1" begins (0 based indexing).
Note that, if there is no "1" exists, print -1.
Note that, in case of all 1s print 0.

Input:
The first line of the input contains T denoting the number of testcases. 
The first line of the test case will be the size of array and second line will be the elements of the array.
 * Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(1).
 * 
 * Input

0 0 0 1 1

0 0 0 0

Output
3
-1

Testcase 1: position 3 is 0 and next one is 1, so answer is 3.
Testcase 2: Since, there is no "1", so the answer is -1.
 * 
 */
	public static void main(String[] args) {
		int[] arr={0,0,0,0,1,1};
		System.out.println(transitionPoint(arr,arr.length));
	}
	 static int transitionPoint(int arr[], int n) {
	        int l=0;
	        int h=arr.length-1;
	        if(arr[0]==0 && arr[arr.length-1]==0){
	            return -1;
	        }
	        while(l<h){
	            int mid=l+((h-l)/2);
	            if(arr[mid] ==0 && arr[mid+1]==1){
	                return mid+1;
	            }
	            if(arr[mid]==1 && arr[mid-1]==0){
	                return mid;
	            }
	            if(arr[mid] == 0){
	                l=mid+1;
	                h=arr.length-1;
	            }
	            else if(arr[mid] == 1){
	                h=mid-1;
	                l=0;
	            }
	        }
	        return 0;
	    }
}

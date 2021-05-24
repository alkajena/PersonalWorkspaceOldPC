package miscellaneous;
/*Given an array of size N consisting of only 0's and 1's ,which is sorted in such a manner that all the 1's are placed first and then they are followed by all the 0's. You have to find  the count of all the 0's.
 

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
The first line of each test case contains an integer N, where N is the size of the array A[ ].
The second line of each test case contains N space separated integers of all 1's follwed by all the 0's, denoting elements of the array A[ ].


Output:
Print out the number of 0's in the array. 
 

Constraints:
1 <= T <= 100
1 <= N <= 30
0 <= A[i] <= 1
 

Example :

Input:
3
12
1 1 1 1 1 1 1 1 1 0 0 0 
5
0 0 0 0 0
6
1 1 1 1 1 1


Output:
3
5
0
 

Expected Complexity:

O(logN)
 */
public class CountOfZeros {

	public static void main(String[] args) {
		int[] arr={1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0};
	    int l=0;int h=arr.length-1;
	    int count=0;
	    while(l<h){
	        if(arr[0]==0  && arr[arr.length-1]==0){
	            count=arr.length;
	            break;
	        }
	        int mid=l+((h-l)/2);
	        if(arr[mid]==0 && arr[mid-1]==1){
	            count=arr.length-mid;
	            break;
	        }
	        if(arr[mid]==1 && arr[mid+1]==0){
	             count=arr.length-(mid+1);
	            break;
	        }
	        if(arr[mid]==1){
	            l=mid+1;
	        }
	        else if(arr[mid]==0){
	            h=mid-1;
	        }
	       
	    }
	    System.out.println("count of zero is :"+count);
	}

	

}

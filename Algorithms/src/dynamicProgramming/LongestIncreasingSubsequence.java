package dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
	static int max=1;
	/*Iterative way(longest)*/
	public static int longestSubsequenceIterative(Integer[] arr,int n){
		if(n==1)
			return 1;
		int res=1;
		int maxEndingHere=1;
		for(int i=1;i<n;i++){
			res=longestSubsequenceIterative(arr,i);
			if((arr[n-1] > arr[i-1]) && ((res+1) > maxEndingHere)){
				maxEndingHere=res+1;
			}
		}
		if(maxEndingHere > max){
			max=maxEndingHere;
		}
		return max;
	}
	
	/*Dynamic Programming way(longest) Tc:-O(n2)*/
	public static int longestSubsequenceDP(Integer[] arr,int n){
		Integer[] result=new Integer[n];
		for(int i=0;i<n;i++){
			result[i]=1;
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if((arr[i] > arr[j]) && (result[i] < (result[j]+1))){
					result[i]=1+result[j];
				}
			}
		}
		int max=Collections.max(Arrays.asList(result));
		return max;
	}
	
	/*Dynamic Programming way(longest) TC:-O(nlog(n))*/
	public static int longestSubsequenceDPWithdiffTC(Integer[] arr,int n){
		Integer[] result=new Integer[n];
		int len=1;
		result[0]=arr[0];
		for(int i=1;i<n-1;i++){
			if(arr[i] < result[0]){
				result[0]=arr[i];
			}
			else if(arr[i] > result[len-1]){
				result[len++]=arr[i];
			}
			else{
				int pos=searchPos(result,-1,len-1,arr[i]);
				result[pos]=arr[i];
			}
		}
		for(int i:result){
			System.out.println(i);
		}
		return len;
	}
	
	public static int searchPos(Integer[]  result,int l,int r,int k){
		while((r-l) > 1){
			int mid=l+((r-l)/2);
			if(k < mid)
				r=mid;
			else
				l=mid;
		}
		return r;
	}
	public static void main(String[] args) {
		Integer A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 }; 
        int n = A.length; 
       // System.out.println("Length of Longest Increasing Subsequence is " + longestSubsequenceIterative(A, n)); 
        System.out.println("Length of Longest Increasing Subsequence is " + longestSubsequenceDP(A, n)); 
        System.out.println("Length of Longest Increasing Subsequence is " + longestSubsequenceDPWithdiffTC(A, n)); 
	}

}

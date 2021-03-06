package dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		Integer A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 }; 
        int n = A.length;
        MaximumSumDP(A,n);
	}

	public static void MaximumSumDP(Integer[] arr,int n){
		
		Integer[] sum=new Integer[n];
		for(int i=0;i<n;i++){
			sum[i]=arr[i];
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if((arr[i] > arr[j]) && (sum[i] < (sum[j]+arr[i]))){
					sum[i]=sum[j]+arr[i];
				}
			}
		}
		System.out.println(Collections.max(Arrays.asList(sum)));
	}
	
}

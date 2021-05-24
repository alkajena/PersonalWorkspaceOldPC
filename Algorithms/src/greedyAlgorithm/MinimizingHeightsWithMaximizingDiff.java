package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * Given an array A[ ] denoting heights of N towers and a positive integer K,
 *  modify the heights of each tower either by increasing or decreasing them by K only once and then
 *   find out the minimum difference of the heights of shortest and longest towers.
 * 
 */
public class MinimizingHeightsWithMaximizingDiff {

	public static void main(String[] args) {
		int[] arr={1,5,8,10};
		int k=2;
		minimizeHeight(arr,k);
	}
	public static void minimizeHeight(int[] arr,int k){
		Arrays.sort(arr);
		
	
	int l=0;
	int h=arr.length-1;
			int mid=l+((h-l)/2);
			int[] subArr1=Arrays.copyOfRange(arr, 0, mid);
			int[] subArr2=Arrays.copyOfRange(arr, mid, arr.length);
			for(int i=0;i<subArr1.length;i++){
				subArr1[i] = subArr1[i]+k;
			}
		
			for(int i=0;i<subArr2.length;i++){
				subArr2[i] = subArr2[i]-k;
			}
			List<Integer> list=new ArrayList<>();
			for(Integer i:subArr1){
				list.add(i);
			}
			for(Integer i:subArr2){
				list.add(i);
			}
			
			
		
		int min=(int) Collections.min(list);
		int max=(int) Collections.max(list);
		int diff=max-min;
		System.out.println("Maximum difference is : "+diff);
	}
}

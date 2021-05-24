package greedyAlgorithm;

import java.util.Arrays;
/*Given arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop.
 * 
 * 
 */
public class MinimumNoOfPlatformRequired {

	public static void main(String[] args) {
		 int arr[] = { 900, 940, 950, 1100, 1500, 1800 }; 
	        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 }; 
	        int n = arr.length; 
	        System.out.println("Minimum Number of Platforms Required = "
	                           + findPlatform(arr, dep, n)); 
	}
	
	public static int  findPlatform(int[] arr,int[] dep,int n){
		Arrays.sort(arr);;
		Arrays.sort(dep);
		int max=Integer.MIN_VALUE;
		int plat=0;
		int a=0;
		int d=0;
		for(int i=0;i<n;i++){
			if(arr[a] < dep[d]){
				plat++;
				a++;
			}
			else{
				plat--;
				d++;
			}
			if(plat > max){
				max=plat;
			}
		}
		return max;
	}

}

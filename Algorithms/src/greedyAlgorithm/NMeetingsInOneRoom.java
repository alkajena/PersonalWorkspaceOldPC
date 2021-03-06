package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*This is same as activity selection problem
 * 
 * 
 */
public class NMeetingsInOneRoom {

	public static void main(String[] args) {
		int[] strtTime={1,3,0,5,8,5};
		int[] finishTime={2,4,6,7,9,9};
		Arrays.sort(finishTime);
		findMaximumMeetings(strtTime,finishTime,6);
		
	}
	
	public static void findMaximumMeetings(int[] strtTime,int[] finishTime,int x){
		int j=0;
		List<Integer> result=new ArrayList<>();
		result.add(j+1);
		for(int i=1;i<x;i++){
			if(finishTime[j] <= strtTime[i]){
				result.add(i+1);
				j=i;
			}
		}
		for(int i:result){
			System.out.println(i);
		}
	}

}

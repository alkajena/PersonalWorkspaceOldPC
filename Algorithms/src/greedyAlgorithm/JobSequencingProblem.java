package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSequencingProblem {

	static class Job{
		char jobId;
		Integer deadLine;
		int profit;
		
		public Job(char j,int d,int p){
			this.jobId=j;
			this.deadLine=d;
			this.profit=p;
		}
		
	}
	
	static class MyComparator implements Comparator<Job>{

		@Override
		public int compare(Job o1, Job o2) {
			Job j1=(Job)o1;
			Job j2=(Job)o2;
			return j2.deadLine.compareTo(j1.deadLine);
		}
		
	}
	public static void jobSequence(List<Job> jobs,int k){
		char[] job=new char[k];
		boolean[] result=new boolean[k];
		int[] timeslot=new int[k];
		
		for(int i=0;i<jobs.size();i++){
			for(int j=Math.min(k-1, jobs.get(i).deadLine-1);j>=0;j--)
			{
				if(!result[j]){
					result[j]=true;
					job[j]=jobs.get(i).jobId;
					break;
				}
			}
		}
		System.out.println("Following is maximum " + 
                "profit sequence of jobs");
		for(char ch:job){
			System.out.println(ch);
		}
		
	}
	public static void main(String[] args) {
		List<Job> arr = new ArrayList<Job>();  
	      
	    arr.add(new Job('a', 2, 100));  
	    arr.add(new Job('b', 1, 19));  
	    arr.add(new Job('c', 2, 27));  
	    arr.add(new Job('d', 1, 25));  
	    arr.add(new Job('e', 3, 15)); 
	    
	    Collections.sort(arr,new MyComparator());
	    jobSequence(arr,3);

	}

}

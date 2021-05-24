package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. 
 * A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. 
 * Your task is to complete the function maxChainLen which returns an integer denoting the longest chain which can be formed from a given set of pairs. 
 */
public class MaxLengthChain {
	static class Pair implements Comparable<Pair>{

		int strt;
		int end;
		@Override
		public int compareTo(Pair arg0) {
			return this.end-arg0.end;
		}
		
	}
	public static void main(String[] args) {
		int[][] graph={{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
		//int[][] graph={{5, 10}, {1, 11}};
		List<Pair> list=new ArrayList<>();
		List<Pair> result=new ArrayList<>();
		for(int i=0;i < graph.length;i++){
			Pair p=new Pair();
			p.strt=graph[i][0];
			p.end=graph[i][1];
			list.add(p);
		}
		Collections.sort(list);
		int j=0;
		result.add(list.get(0));
		for(int i=0;i<list.size();i++){
			if(list.get(j).end < list.get(i).strt){
				result.add(list.get(i));
				j=i;
			}
		}
		System.out.println("The maximum length of chain is : "+result.size());
	}

}

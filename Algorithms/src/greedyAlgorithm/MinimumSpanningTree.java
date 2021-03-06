package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Given a weighted, undirected and connected graph. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
 * 
 * 
 */
public class MinimumSpanningTree {
	static class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int weight;
		@Override
		public int compareTo(Edge arg0) {
			return this.weight-arg0.weight;
		}
	}
	public static int find(Integer[] parent,int i){
		if(parent[i]==-1)
			return i;
		return find(parent,parent[i]);
	}
	public static void union(Integer[] parent,int x,int y){
		int xset=find(parent,x);
		int yset=find(parent,y);
		parent[xset]=yset;
	}
	public static void findMinimumweightspanningtree(List<Edge> list){
		Collections.sort(list);
		Integer[] parent=new Integer[4];
		List<Edge> result=new ArrayList<>();
		for(int i=0;i<parent.length;i++){
			parent[i]=-1;
		}
		
		int c=0;
		int min=Integer.MAX_VALUE;
		while(c <= list.size()-1){
			
			int xset=find(parent,list.get(c).src);
			int yset=find(parent,list.get(c).dest);
			
			if(xset!=yset){
				result.add(list.get(c));
				union(parent,xset,yset);
			}
			c++;
		}
		int sum=0;
		for(Edge ed:result){
			sum=sum+ed.weight;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		int v=3;
		int e=3;
		int arr[]={1,2,5,2,3,3,1,3,1};
		List<Edge> list=new ArrayList<>();
		int j=0;
		int count=0;
		for(int i=0;i<e;i++){
		
			
				Edge edge=new Edge();
				edge.src=arr[count];
				edge.dest=arr[++count];
				edge.weight=arr[++count];
				count++;
				list.add(edge);
			
		}
		findMinimumweightspanningtree(list);
	}

}

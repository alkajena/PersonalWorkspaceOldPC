package greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalsAlgo{
	static int E;
	static int V;
	static Edge[] edge;
	static class Edge implements Comparator<Edge>{
		int src;
		int dest;
		int weight;
		
		public Edge(int src,int dest,int weight){
			this.src=src;
			this.dest=dest;
			this.weight=weight;
		}
		
		public Edge(){
			
		}

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight-o2.weight;
		}
	}
	class MyComparator implements Comparator<Edge>{

		@Override
		public int compare(Edge arg0, Edge arg1) {
			
			return arg0.weight-arg1.weight;
		}

		
	}
	public KruskalsAlgo(int V,int E){
		this.E=E;
		this.V=V;
		this.edge =  new Edge[E];
		for(int i=0;i<E;i++){
			edge[i]=new Edge();
		}
	}
	public static int find(int[] parent,int i){
		if(parent[i]==-1)
			return i;
		return find(parent,parent[i]);
	}
	
	public static void union(int[] parent,int x,int y){
		int xset=find(parent,x);
		int yset=find(parent,y);
		parent[xset]=yset;
	}
	public static void printKruskal(){
		int[] parent=new int[V];
		Edge[] output=new Edge[E];
		for(int i=0;i<V;i++){
			parent[i]=-1;
		}
		
		for(int i=0;i<E;i++){
			output[i]=new Edge();
		}
		int e=0;
		while(e<V){
			int x=find(parent,edge[e].src);
			int y=find(parent,edge[e].dest);
			//output[e]=new Edge();
			if(x!=y){
				output[e]=edge[e];
				union(parent,x,y);
			}
			e++;
		}
		
		for(Edge ed:output){
			System.out.println(ed.src+"--"+ed.dest+" weight : "+ed.weight);
		}
	}
	public static void main(String[] args) {
		KruskalsAlgo k=new KruskalsAlgo(4,5);
		k.edge[0]=new Edge(0,1,10);
		k.edge[1]=new Edge(0,2,6);
		k.edge[2]=new Edge(0,3,5);
		k.edge[3]=new Edge(1,3,15);
		k.edge[4]=new Edge(2,3,4);
		Arrays.sort(edge,k.new MyComparator());
		k.printKruskal();
		

	}

}

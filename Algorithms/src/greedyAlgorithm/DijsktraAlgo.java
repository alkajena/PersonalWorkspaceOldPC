package greedyAlgorithm;

public class DijsktraAlgo {
static int V=9;
	public static void main(String[] args) {
		int[][] graph=new int[][]{ { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
            
            DijkstraPrint(graph);

	}
	public static int findMinimum(boolean[] mst,int[] dist){
		int minIndex=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<V;i++){
			if(!mst[i] && dist[i]<min){
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	public static void DijkstraPrint(int[][] graph){
		int[] dist=new int[V];
		boolean[] mst=new boolean[V];
		
		for(int i=0;i<V;i++){
			dist[i]=Integer.MAX_VALUE;
			mst[i]=false;
		}
		dist[0]=0;
		for(int count=0;count<V;count++){
			int u=findMinimum(mst,dist);
			mst[u]=true;
			for(int v=0;v<V;v++){
				if(!mst[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && (dist[u]+graph[u][v])<dist[v]){
					dist[v]=dist[u]+graph[u][v];
				}
			}
		}
		
		for(int i=0;i<V;i++){
			System.out.println("point : "+i+" distance : "+dist[i]);
		}
	}
}

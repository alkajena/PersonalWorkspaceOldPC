package greedyAlgorithm;

public class DijkstraPractice {

	public static void main(String[] args) {
		int[][] graph={{0,1,43},{1,0,6},{43,6,0}};
		int sourceVertex=0;
		int vertex=3;
		Dijkstra(graph,sourceVertex,vertex);

	}
	public static int findMinimum(int[] dist,boolean[] mst,int v){
		int minIndex=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<v;i++){
			if(!mst[i] && dist[i] < min){
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	public static void Dijkstra(int[][] graph,int s,int V){
		int[] dist=new int[V];
		boolean[] mst=new boolean[V];
		for(int i=0;i<V;i++){
			dist[i]=Integer.MAX_VALUE;
			mst[i]=false;
		}
		dist[2]=0;
		for(int count=0;count<V;count++){
			int u=findMinimum(dist,mst,V);
			
			mst[u]=true;
			
			for(int v=0;v<V;v++){
				if(!mst[v] && dist[u]!=Integer.MAX_VALUE && graph[u][v]!=0 && (dist[u]+graph[u][v]) < dist[v]){
					dist[v]=dist[u]+graph[u][v];
				}
			}
		}
		
		for(int i:dist){
			System.out.println(i);
		}
	}
}

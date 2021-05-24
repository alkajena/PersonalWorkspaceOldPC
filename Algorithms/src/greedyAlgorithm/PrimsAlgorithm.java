package greedyAlgorithm;
/*Tc=o(v2) if we use adjancency list then it will reduce to o(ELogV)
 * 
 * 
 * 
 */
public class PrimsAlgorithm {
static int vertex=5;
	public static void main(String[] args) {
		
		int[][] graph=new int[][]{{ 0, 2, 0, 6, 0 }, 
            { 2, 0, 3, 8, 5 }, 
            { 0, 3, 0, 0, 7 }, 
            { 6, 8, 0, 0, 9 }, 
            { 0, 5, 7, 9, 0 } };
            
            primsMst(graph);

	}
	static int minimumDistance(boolean[] mst,int[] dist){
		int minIndex=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<vertex;i++){
			if(!mst[i] && dist[i]<min){
				minIndex=i;
				min=dist[i];
			}
		}
		return minIndex;
	}
	static void primsMst(int[][] graph){
		int[] parent=new int[vertex];
		int[] dist=new int[vertex];
		boolean[] mst=new boolean[vertex];
		
		for(int i=0;i<vertex;i++){
			dist[i]=Integer.MAX_VALUE;
			mst[i]=false;
		}
		dist[0]=0;
		parent[0]=-1;
		for(int count=0;count<vertex;count++){
			int u=minimumDistance(mst,dist);
			
			mst[u]=true;
			
			for(int v=0;v<vertex;v++){
				if(!mst[v] && graph[u][v]!=0 && (graph[u][v]) < dist[v]){
					parent[v]=u;
					dist[v]=graph[u][v];
				}
			}
		}
		for(int i=1;i<vertex;i++){
			System.out.println("path is : "+parent[i]+"--"+i+" dist is : "+dist[i]);
		}
	}
}

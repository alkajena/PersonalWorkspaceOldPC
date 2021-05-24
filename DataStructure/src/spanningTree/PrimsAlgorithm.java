package spanningTree;

public class PrimsAlgorithm {
	static int V=5;
	
	static int minIndext(boolean[] mstArr,int[] key){
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<V-1;i++){
			if(mstArr[i]==false && key[i]<min){
				min=key[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	static void PrimeMST(int[][] graph){
		//parent array to store result
		int[] parent=new int[V];
		//key array to store weight of edges
		int[] key=new int[V];
		//Mst array to store the nodes which are visited once
		boolean[] mstArr=new boolean[V];
		
		for(int i=0;i<V;i++){
			key[i]=Integer.MAX_VALUE;
			mstArr[i]=false;
		}
		
		key[0]=0;
		parent[0]=-1;
		
		for(int count=0;count<V-1;count++){
			int i=minIndext(mstArr, key);
			mstArr[i]=true;
			for(int j=0;j<V;j++){
				if(mstArr[j]==false && graph[i][j]!=0 && graph[i][j]<key[j]){
					parent[j]=i;
					key[j]=graph[i][j];
				}
			}
		}
		
		print(graph,parent,key);
	}
	static void print(int[][] graph,int[] parent,int[] key){
		for(int i=1;i<key.length;i++){
			System.out.println(parent[i]+"---"+i+" weight "+key[i]);
		}
	}
	public static void main(String[] args) {
		 int graph[][] = {{ 0, 2, 0, 6, 0 },{ 2, 0, 3, 8, 5 },{ 0, 3, 0, 0, 7 },{ 6, 8, 0, 0, 9 },{ 0, 5, 7, 9, 0 }};  
		 PrimeMST(graph);
	}

}

package spanningTree;

import java.util.Arrays;

public class KruskalAlgorithm {
	
	static class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int weight;
		
		public int compareTo(Edge comparededge) {
			return this.weight-comparededge.weight;
		}
		
	}

	static class Graph{
		int V;
		int E;
		Edge[] edge;
		
		
		public Graph(int V,int E){
			this.V=V;
			this.E=E;
			edge=new Edge[E];
			for(int i=0;i<E;i++){
				edge[i]=new Edge();
			}
		}
		
		static int find(int[] parent,int i){
			int x=parent[i];
			if(x==-1)
				return i;
			else 
				return find(parent,parent[i]);
		}
		
		static void union(int[] parent,int src,int dest){
			parent[src]=dest;
		}
		
		static void MST(Graph graph){
			int[] parent=new int[graph.V];
			
			for(int i=0;i<graph.V;i++)
				parent[i]=-1;
			
			Arrays.sort(graph.edge);
			
			Edge[] result=new Edge[graph.E];
			
			for(int i=0;i<graph.E;i++)
				result[i]=new Edge();
			
			int r=0;
			int e=0;
			
			while(e<graph.E-1){
				Edge edge=graph.edge[e];
				
				int edgeSrc=find(parent,edge.src);
				int edgeDest=find(parent,edge.dest);
				
				if(edgeSrc!=edgeDest){
					union(parent,edgeSrc,edgeDest);
					result[r]=edge;
					r++;
				}
				e++;
			}
		}
		
	}
	public static void main(String[] args) {
		int V=4;
		int E=5;
		Graph graph=new Graph(V,E);
		// add edge 0-1 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = 10; 
  
        // add edge 0-2 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 6; 
  
        // add edge 0-3 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 3; 
        graph.edge[2].weight = 5; 
  
        // add edge 1-3 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 15; 
  
        // add edge 2-3 
        graph.edge[4].src = 2; 
        graph.edge[4].dest = 3; 
        graph.edge[4].weight = 4; 
  
        graph.MST(graph);
        //Arrays.sort(graph.edge);
        
        
	}

}

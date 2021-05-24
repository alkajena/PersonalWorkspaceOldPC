package spanningTree;
//This class is for Disjoint set(Union and find algorithm) to check whether a graph contains cycle or not
public class UnionAndFind {
	
	static class Edge{
		int src,dest;
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
	
		//to find the parent of a vertex
		static int find(int[] parent,int i){
			int x=parent[i];
			if(x==-1)
				return i;
			else
				return find(parent,x);
		}
		
		static void union(int[] parent,int src,int dest){
			parent[src]=dest;
		}
		
		static int cycle(Graph graph){
			//create a parent array
			int[] parent=new int[graph.V];
			//assign each slot as -1 that means all node itself a parent node
			for(int i=0;i<graph.V;i++)
				parent[i]=-1;
			
		for(Edge edge:graph.edge){
			int src=edge.src;
			int dest=edge.dest;
			
			int srcParent=find(parent,src);
			int destParent=find(parent,dest);
			
			if(srcParent==destParent)
				return 1;
			
			union(parent,src,dest);
		}
		return 0;
		}
	}
	
	
	
	public static void main(String[] args) {
		int V=3;
		int E=2;
		Graph graph=new Graph(V,E);
		graph.edge[0].src=0;
		graph.edge[0].dest=1;
		graph.edge[1].src=1;
		graph.edge[1].dest=2;
		/*graph.edge[2].src=0;
		graph.edge[2].dest=2;*/
		
		int cycle=graph.cycle(graph);
		if(cycle==1)
			System.out.println("cycle is found");
		else
			System.out.println("No cycle is found");
		
		
	}

}

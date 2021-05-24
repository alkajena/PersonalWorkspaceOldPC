package graphDS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import queueDSA.QueueOperations;
import stackDSA.StackOperation;

public class DepthFirstSearch {


	@SuppressWarnings("unchecked")
	public static void DFS(int v,List chckList,AdjacentListPresentation graph){
			if(!chckList.contains(v)){
				chckList.add(v);
			}
		List<Integer> list=graph.vertexArr[v];
		Iterator<Integer> i = list.listIterator();
		for(Integer x:list){
			if(!chckList.contains(x))
				DFS(x,chckList,graph);
			}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void DFS(int v,List chckList,AdjacentListPresentation graph,StackOperation stack){
		stack.push(v);
		while(!stack.isEmpty()){
			v=stack.pop();
			if(chckList.contains(v)){
				continue;
			}
			chckList.add(v);
			List<Integer> list=graph.vertexArr[v];
			for(Integer i:list){
				if(!chckList.contains(i))
					stack.push(i);
				}
		}
			if(!chckList.contains(v)){
				chckList.add(v);
			}
	}

	
	
	@SuppressWarnings("unchecked")
	public static void BFS(int v,List chckList,AdjacentListPresentation graph,QueueOperations queue){
		//queue.enQueue(v);
		List<Integer> li=new ArrayList<>();
		li.add(v);
		while(li.size()!=0){
		//	v=queue.deQueue();
			v=li.remove(li.size()-1);
			if(chckList.contains(v)){
				continue;
			}
			chckList.add(v);
			List<Integer> list=graph.vertexArr[v];
			for(Integer i:list){
				if(!chckList.contains(i)){
					//queue.enQueue(i);
					li.add(i);
				}
				}
		}
		for(int x:li){
			System.out.println(x);
		}
	}

	
	public static  void DFSUtil(int v,boolean visited[],AdjacentListPresentation graph) 
	    { 
	        // Mark the current node as visited and print it 
	        visited[v] = true; 
	        System.out.print(v+" "); 
	  
	        // Recur for all the vertices adjacent to this vertex 
	        Iterator<Integer> i = graph.vertexArr[v].listIterator(); 
	        while (i.hasNext()) 
	        { 
	            int n = i.next(); 
	            if (!visited[n]) 
	                DFSUtil(n, visited,graph); 
	        } 
	    } 
	  
	    // The function to do DFS traversal. It uses recursive DFSUtil() 
	    static void DFS1(int v,AdjacentListPresentation graph) 
	    { 
	        // Mark all the vertices as not visited(set as 
	        // false by default in java) 
	        boolean visited[] = new boolean[graph.v]; 
	  
	        // Call the recursive helper function to print DFS traversal 
	        DFSUtil(v, visited,graph); 
	    } 
	  

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		//here we have given size as 5 becoz as it is a non directed graph so we are creating edgde from src to desct and dest to src
		
		AdjacentListPresentation g=new AdjacentListPresentation(5);
		/* 	g.addEdge(0, 1); 
	        g.addEdge(0, 2); 
	        g.addEdge(1, 2); 
	        g.addEdge(2, 0); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 3);*/
		
		g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(1, 4); 
		
		List<Integer> chckList1=new ArrayList<>();
		List<Integer> chckList2=new ArrayList<>();
		List<Integer> chckList3=new ArrayList<>();
		StackOperation stack=new StackOperation();
		QueueOperations queue=new QueueOperations();
		//DFS(2,g);
		//DFS(2,chckList1,g);
		//DFS(2,chckList2,g,stack);
		for(int i=0;i<g.array.size();i++){
			BFS(g.array.get(i),chckList3,g,queue);
		}
		
		for(List<Integer> list:g.vertexArr){
			System.out.println(list);
		}
		
		for(Integer i:chckList1){
			System.out.println(i);
		}
		System.out.println("\n");
		
		for(Integer i:chckList2){
			System.out.println(i);
		}
		
		System.out.println("\n");
		
		for(Integer i:chckList3){
			System.out.println(i);
		}

	}
}

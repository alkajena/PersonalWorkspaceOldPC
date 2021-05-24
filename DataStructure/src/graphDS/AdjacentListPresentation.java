package graphDS;

import java.util.ArrayList;
import java.util.List;

public class AdjacentListPresentation {
	int v;
	static List<Integer>[] vertexArr;
	static List<Integer> array= new ArrayList<>();
	
	AdjacentListPresentation(int v){
		this.v=v;
		vertexArr=new ArrayList[this.v];
		for(int i=0;i<vertexArr.length;i++){
			vertexArr[i]=new ArrayList<>();
		}
	}
	public static void addEdge(int src,int dest){
		array.add(src);
		vertexArr[src].add(dest);
		
	}
	
	public static void main(String[] args) {
		//here we have given size as 5 becoz as it is a non directed graph so we are creating edgde from src to desct and dest to src
		
		AdjacentListPresentation g=new AdjacentListPresentation(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
	
		
		for(List<Integer> list:vertexArr){
			System.out.println(list);
		}

	}

}

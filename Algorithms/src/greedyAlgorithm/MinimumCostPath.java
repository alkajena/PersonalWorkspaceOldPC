package greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;
/*Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left cell to bottom right cell by which total cost incurred is minimum. You can move in 4 directions : up, down, left an right.
Note : It is assumed that negative cost cycles do not exist in input matrix. 
 */
public class MinimumCostPath {

	public static void main(String[] args) {
		int[][] graph={{31, 100, 65, 12, 18},{10, 13, 47, 157, 6},{100, 113, 174, 11, 33},{88, 124, 41, 20, 140},{99, 32, 111, 41, 20}};
		int[][] graph1={{42,93},{7,14}};
		findMinimumCost(graph,5);
		
	}
	public static void findMinimumCost(int[][] graph,int v){
		List<String> posList=new ArrayList<>();
		List<Integer> values=new ArrayList<>();
		String resPos=(v-1)+""+(v-1);
		posList.add("00");
		values.add(graph[0][0]);
		int i=0;
		int j=0;
		int k=i-1;
		int l=i+1;
		int m=j-1;
		int n=j+1;
		int min=Integer.MAX_VALUE;
		String str="";
		while(!posList.contains(resPos)){
			 k=i-1;
			 l=i+1;
			 m=j-1;
			 n=j+1;
			 min=Integer.MAX_VALUE;

			if(l!=-1 && l!=v && graph[l][j] < min && !posList.contains(l+""+j)){
				min=graph[l][j];
				str=l+""+j;
			}
			if(n!=-1 && n!=v && graph[i][n] < min && !posList.contains(i+""+n)){
				min=graph[i][n];
				str=i+""+n;
			}
			if(m!=-1 && m!=v && graph[i][m] < min && !posList.contains(i+""+m)){
				min=graph[i][m];
				str=i+""+m;
			}
			if(k!=-1 && k!=v && graph[k][j] < min && !posList.contains(k+""+j)){
				min=graph[k][j];
				str=k+""+j;
			}
			String[] strArr=str.split("");
			i=Integer.valueOf(strArr[0]);
			j=Integer.valueOf(strArr[1]);
			if(!posList.contains(str)){
				posList.add(str);
				values.add(min);
			}
		}
		int sum=0;
		for(int x:values){
			System.out.println(x);
			sum=sum+x;
		}
	System.out.println("the minimum cost is : "+sum);
	}
}

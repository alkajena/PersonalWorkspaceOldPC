package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KCenterProblems {

	public static void main(String[] args) {
		int[][] graph=new int[][]{{0,10,7,6},
			{10,0,8,5},
			{7,8,0,12},
			{6,5,12,0}};
		int k=3;
		//System.out.println(graph[0][6]);
		findToPlaceATM(graph,k);
	}
	public static void findToPlaceATM(int[][] graph,int k){
		int n=3;
		int centers=1;
		int c2=0;
		List<Integer> chosenCenter=new ArrayList<>();
		chosenCenter.add(0);
		List<Integer> otherCenters=new ArrayList<>();
		for(int i=0;i<=n;i++){
			if(!chosenCenter.contains(i)){
				otherCenters.add(i);
			}
		}
		int count=1;
		for(int j=0;j<otherCenters.size();j++){
			if(count<k){
				if(!chosenCenter.contains(otherCenters.get(j))){
						int min=Integer.MAX_VALUE;
						int max=Integer.MIN_VALUE;
						Iterator<Integer> itr=chosenCenter.iterator();
						while(itr.hasNext()){
							int x=(Integer)itr.next();
							if(graph[x][otherCenters.get(j)] < min){
								min=graph[x][otherCenters.get(j)];
							}
						}
						if(min > max){
							max=min;
							c2=otherCenters.get(j);
							chosenCenter.add(c2);
							count++;
						}
					}		
			}
			else{
				break;
			}
		
		}
		System.out.println(chosenCenter);
	}
	
}

package treeGeeksForGeeksQuestions;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PostOrderFromGivenInOrderAndPreOrder {
	static int search(List<Integer> in,int root){
		for(int i=0;i<in.size();i++){
			if(in.get(i)==root){
				return i;
			}
		}
		return -1;
	}
	static void postOrder(List<Integer> in,List<Integer> pre, int size){
		Integer root=pre.get(0);
		int rootIndex=search(in,root);
		
		if(rootIndex!=0){
			postOrder(in.subList(0, rootIndex),pre.subList(1, rootIndex+1),rootIndex);
		}
		
		if(rootIndex!=size-1){
			postOrder(in.subList(rootIndex+1, size),pre.subList(rootIndex+1, size),size-rootIndex-1);
		}
		
		System.out.print(pre.get(0)+" ");
	}
	public static void main(String[] args) {
		//Left root right
		List<Integer> inOrder=new ArrayList<>();
		inOrder.add(4);
		inOrder.add(2);
		inOrder.add(5);
		inOrder.add(1);
		inOrder.add(3);
		inOrder.add(6);
		
		
		//root left right
		List<Integer> preOrder=new ArrayList<>();
		preOrder.add(1);
		preOrder.add(2);
		preOrder.add(4);
		preOrder.add(5);
		preOrder.add(3);
		preOrder.add(6);
		
		

		postOrder(inOrder,preOrder,inOrder.size());

	}

}

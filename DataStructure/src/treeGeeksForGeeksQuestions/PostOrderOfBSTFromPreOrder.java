package treeGeeksForGeeksQuestions;

import java.util.ArrayList;
import java.util.List;

public class PostOrderOfBSTFromPreOrder {

	static void postOrder(List<Integer> pre,int size){
		int root=pre.get(0);
		
		
		List<Integer> leftSubTree = new ArrayList<>();
		List<Integer> rightSubTree= new ArrayList<>();
		
		for(Integer i:pre){
			if(i<root){
				leftSubTree.add(i);
			}
			else if(i>root){
				rightSubTree.add(i);
			}
		}
		
		if(leftSubTree.size()!=0){
			postOrder(leftSubTree,leftSubTree.size());
		}
		
		if(rightSubTree.size()!=0){
			postOrder(rightSubTree,rightSubTree.size());
		}
		
		System.out.print(pre.get(0)+" ");
	}
	public static void main(String[] args) {
		List<Integer> pre=new ArrayList<>();
		pre.add(40);
		pre.add(30);
		pre.add(32);
		pre.add(35);
		pre.add(80);
		pre.add(90);
		pre.add(100);
		pre.add(120);
		postOrder(pre,pre.size());

	}

}

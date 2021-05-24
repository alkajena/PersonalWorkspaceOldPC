package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearSearch {

	/*Linear Search is rarely used in practical scenario as time complexity of this search is O(N) which is worst.
	 *  Binary Search and Hash table are better option than linear search 
	 */
	public static void main(String[] args) {
		Integer[] searchArr={60,50,80,100,65,89,1,3,4,5,6,9,87,64,23};
		int x=23;
		
		long start1 = System.currentTimeMillis(); 
		int y=searchInRegularWay(searchArr,x);
		 long end1 = System.currentTimeMillis(); 
		 System.out.println("searchInRegularWay method takes " + 
                 (end1 - start1) + "ms"); 
		 System.out.println("Serahced element searchInRegularWay() "+x+"'s index is : "+y);
		 long start2 = System.currentTimeMillis(); 
		int z=searchInBuiltMethod(searchArr,x);
		long end2 = System.currentTimeMillis(); 
		 System.out.println("searchInBuiltMethod method takes " + 
                 (end2 - start2) + "ms"); 
		 System.out.println("Serahced element searchInBuiltMethod() "+x+"'s index is : "+z);
		
	}

	
	public static int searchInRegularWay(Integer[] searchArr,int x){
		for(int i=0;i<searchArr.length;i++){
			if(searchArr[i]==x){
				return i;
			}
		}
		return -1;
	}
	
	
	public static int searchInBuiltMethod(Integer[] searchArr,int x){
		List<Integer> list=new ArrayList<>();//All Collections object can not operate on primitive data types..
												//it only works Reference data types..Thats why changed the serachArr type from int to Integer
		list=Arrays.asList(searchArr);
		if(list.contains(x)){
			return list.indexOf(x);
		}
		return -1;
	}
}

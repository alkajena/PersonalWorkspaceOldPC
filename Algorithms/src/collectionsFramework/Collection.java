package collectionsFramework;

import java.util.ArrayList;
import java.util.List;

public class Collection {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		Integer[] arr=new Integer[2];
		arr=list.toArray(arr);

		String s1="alka";
		String s2="alka";
		
		String s3=s2;
		String s4=new String("alka");
		String s5=new String("alka");
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(s2==s3);
		System.out.println(s4==s5);
		
	}

}

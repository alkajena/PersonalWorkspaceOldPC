package sorting;

import java.util.Arrays;
import java.util.Collections;

public class Countingsort {

	public static void main(String[] args) {
		Character[] chararr={'g', 'e', 'e', 'k', 's', 'f', 'o', 
                'r', 'g', 'e', 'e', 'k', 's'};
		countingsort(chararr);
		
		Integer[] intarr={1, 4, 1, 2, 7, 5, 2};
		int max=Collections.max(Arrays.asList(intarr));
		countingsortInteger(intarr,max);

	}
	/*Mainly this sort is inefficient if the input data is out of range provided i.e. if data are 1,2,5k,10k but range is in between 1 to 6k
	 * it is mainly used as sub routine in radix sort
	 * it can be expanded to sort negative values as well
	 * it does not sort based on comparison of datas
	 * it use partial hashing to get the count of data
	 * Time complexity is o(n+k) where n=number of input data,k=data span/range
	 */
	public static void countingsort(Character[] arr){
		//output sorted array
		Character[] output=new Character[arr.length];
		
		//create count array and insert all values as 0
		Integer[] count=new Integer[256];
		for(int i=0; i<256; i++){
			count[i]=0;
		}
		
		//store occurance of input data in count array(ascii value means 'g' will be stored in count[104]..In count[arr[i]], arr[i] which is a 
		//character is internally converted to its ascii value which is 104..
		for(int i=0;i<arr.length;i++){
			//System.out.println(arr[i]+" ascii value : "+count[arr[i]]);
			++count[arr[i]];
			System.out.println(arr[i]+" occurance is : "+count[arr[i]]);
		}
		
		//store calculated(sorted) index of given input in count array
		for(int i=1;i<256;i++){
			count[i]=count[i]+count[i-1];
		}
		
		for(int i=0;i<arr.length;i++){
			output[count[arr[i]]-1]=arr[i];
			--count[arr[i]];
		}
		
		for(int i=0;i<arr.length;i++){
			arr[i]=output[i];
			System.out.println(output[i]);
		}
	}
	
	
	public static void countingsortInteger(Integer[] intarr,int max){
		//output sorted array
		Integer[] output=new Integer[intarr.length];
		max=max+1;
		//create count array and insert all values as 0
		Integer[] count=new Integer[max];
		for(int i=0; i<max; i++){
			count[i]=0;
		}
		
		//store occurance of input data in count array(ascii value means 'g' will be stored in count[104]..In count[arr[i]], arr[i] which is a 
		//character is internally converted to its ascii value which is 104..
		for(int i=0;i<intarr.length;i++){
			//System.out.println(arr[i]+" ascii value : "+count[arr[i]]);
			++count[intarr[i]];
			System.out.println(intarr[i]+" occurance is : "+count[intarr[i]]);
		}
		
		//store calculated(sorted) index of given input in count array
		for(int i=1;i<max;i++){
			count[i]=count[i]+count[i-1];
		}
		
		for(int i=0;i<intarr.length;i++){
			output[count[intarr[i]]-1]=intarr[i];
			--count[intarr[i]];
		}
		
		for(int i=0;i<intarr.length;i++){
			intarr[i]=output[i];
			System.out.println(output[i]);
		}
	}
}

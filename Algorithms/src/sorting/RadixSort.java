package sorting;

import java.util.Arrays;
import java.util.Collections;

public class RadixSort {

	public static void main(String[] args) {
		 Integer arr[] = {170, 45, 75, 90, 802, 24, 2, 66}; 
	        int n = arr.length; 
	        int max=Collections.max(Arrays.asList(arr));
	        for(int i=1;(max/i)>0;i*=10){
	        	 radixSort(arr,i, n); 
	        }
	        
	        for(int i:arr){
				System.out.println(i);
			}
	      
	}
	/*Time complexity is o(d*(n+b)) where b:-base of number,n:-number of inputs,d=log(k)
	 * TC=O(nlog(n)) base is b so when base of input is same as n then tc=O(n) which is linear
	 * it is stable as we are going in reverse order of array
	 * it uses count sort as subroutine...
	 * non comparison sorting
	 */
	public static void radixSort(Integer[] arr,int exp,int n){
		//create output array
		Integer[] output=new Integer[n];
		
		//create count array and initialize as 0
		Integer[] count=new Integer[10];
		for(int i=0;i<10;i++){
			count[i]=0;
		}
		
		//store occuracnce of each digit in count array
		for(int i=0;i<n;i++){
			count[(arr[i]/exp)%10]++;
		}
		
		//calculate the indices and store in count array
		for(int i=1;i<10;i++){
			count[i]=count[i]+count[i-1];
		}
		
		for(int i=n-1;i>=0;i--){
			output[count[(arr[i]/exp)%10]-1]=arr[i];
			--count[(arr[i]/exp)%10];
		}
		
		for(int i=0;i<n;i++){
			arr[i] = output[i];
		}
		
		
	}
}

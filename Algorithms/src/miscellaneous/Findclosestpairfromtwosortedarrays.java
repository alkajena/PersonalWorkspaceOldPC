package miscellaneous;
/*
 * Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
We are given two arrays ar1[0?m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] 
such that absolute value of (ar1[i] + ar2[j] ? x) is minimum.Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32      
Output:  1 and 30

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 50      
Output:  7 and 40
 */
public class Findclosestpairfromtwosortedarrays {

	public static void main(String[] args) {
		int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int x=38;
        int n1=ar1.length-1;
        int n2=ar2.length-1;
        Findclosestpairfromtwosortedarrays(ar1,ar2,n1,n2,x);
        

	}
public static void Findclosestpairfromtwosortedarrays(int[] ar1,int[] ar2,int n1,int n2,int x){
	int resl=0;
	int resr=0;
	int diff=Integer.MAX_VALUE;
	
	int l=0;
	int r=n2;
	while(l <= n1 && r>=0){
		if(Math.abs((ar1[l]+ar2[r])-x) < diff){
			resl=l;
			resr=r;
			diff=Math.abs((ar1[l]+ar2[r])-x);
		}
		
		if((ar1[l]+ar2[r]) > x){
			r--;
		}
		else{
			l++;
		}
	}
	System.out.println("sum is :"+(ar1[resl]+ar2[resr]));
}
}

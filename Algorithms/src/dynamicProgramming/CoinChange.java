package dynamicProgramming;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int[] arr={1,2,3};
		int m=arr.length;
		int k=4;
		System.out.println(coinChangeDP(arr,m,k));
	}
	//Recusrive way..TC:-exponential, spcae complexity:-1
	public static int coinChange(int[] arr,int m,int k){
		if(k==0){
			return 1;
		}
		if(k<0){
			return 0;
		}
		if(m<=0){
			return 0;
		}
		return coinChange(arr,m-1,k)+coinChange(arr,m,k-arr[m-1]); 
	}
	
	//Dynamic programming ...TC:-o(m*k),space complexity:-o(m*k)
	public static int coinChangeDP(int[] arr,int m,int k){
		int[] table=new int[k+1];
		Arrays.fill(table, 0);
		table[0]=1;
		
		for(int i=0;i<m;i++){
			for(int j=arr[i];j<=k;j++){
				table[j]=table[j]+table[j-arr[i]];
			}
		}
		return table[k];
	}
}

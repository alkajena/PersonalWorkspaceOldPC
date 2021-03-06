package dynamicProgramming;

public class MinimumCostPath {

	public static void main(String[] args) {
		int cost[][]= {{1, 2, 3}, 
                {4, 8, 2}, 
                {1, 5, 3}}; 
 System.out.println(minCost(cost,2,2)); 
	}
//Tc:-o(m*n)
public static int minCost(int[][] cost,int m,int n){
	int[][] dp=new int[m+1][n+1];
	dp[0][0]=cost[0][0];
	for(int i=1;i<=m;i++)
		dp[i][0]=cost[i][0]+dp[i-1][0];
	for(int j=1;j<=n;j++)
		dp[0][j]=cost[0][j]+dp[0][j-1];
	for(int i=1;i<=m;i++){
		for(int j=1;j<=n;j++){
			dp[i][j]=cost[i][j]+(min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]));
		}
	}
	return dp[m][n];
}
public static int mincostRecursive(int[][] cost,int m,int n){
	if(m<1 || n<1)
		return Integer.MAX_VALUE;
	else if(m==0 && n==0)
		return cost[m][n];
	else {
		return cost[m][n]+min(mincostRecursive(cost,m-1,n-1),mincostRecursive(cost,m,n-1),mincostRecursive(cost,m-1,n));
	}
}
public static int min(int a,int b,int c){
	int min1= a<b?a:b;
	int min2=c<min1?c:min1;
	return min2;
}
}

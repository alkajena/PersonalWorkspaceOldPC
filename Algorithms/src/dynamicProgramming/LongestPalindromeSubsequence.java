package dynamicProgramming;

public class LongestPalindromeSubsequence {

	public static void main(String[] args) {
		String str="GEEKSFORGEEKS";
		int i=0;
		int length=str.length()-1;
		System.out.println(palindromeDP(str,i,length));
		printPalindromeDP(str);

	}
	public static int max(int a,int b){
		return a>b?a:b;
	}
	public static int palindrome(String str,int i,int j){
		
		if(i==j)
			return 1;
		if((j==(i+1)) && str.charAt(i)==str.charAt(j)){
			return 2;
		}
		else if(str.charAt(i)==str.charAt(j)){
			return 2+palindrome(str,i+1,j-1);
		}
		else{
			return max(palindrome(str,i+1,j),palindrome(str,i,j-1));
		}
	}
	
	public static int palindromeDP(String str,int i,int j){
		int n=str.length();
		int[][] res=new int[n][n];
		
		for(int k=0;k<str.length();k++){
			res[k][k]=1;
		}
		
		for(int cl=2;cl<=n;cl++){
			for(int x=0;x<(n-cl+1);x++){
				int y=x+cl-1;
				
				if((y==(x+1)) && str.charAt(x)==str.charAt(y)){
					res[x][y]= 2;
				}
				else if(str.charAt(x)==str.charAt(y)){
					res[x][y]= 2+res[x+1][y-1];
				}
				else{
					res[x][y]= max(res[x+1][y],res[x][y-1]);
				}
			}
		}
		return res[0][n-1];
	}
	public static void printPalindromeDP(String str){
		StringBuffer buf=new StringBuffer(str);
		buf.reverse();
		String rev=buf.toString();
		
		char[] arr1=str.toCharArray();
		char[] arr2=rev.toCharArray();
		
		int m=arr1.length;
		int n=arr2.length;
		
		int[][] res=new int[m+1][n+1];
		
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					res[i][j]=0;
				}
				else if(arr1[i-1]==arr2[j-1]){
					res[i][j]=1+res[i-1][j-1];
				}
				else{
					res[i][j]=max(res[i][j-1],res[i-1][j]);
				}
			}
		}
		
		int index=res[m][n];
		int i=m;int j=n;
		char[] arr=new char[index+1];
		while(i>0 && j>0){
			
			if(arr1[i-1]==arr2[j-1]){
				arr[index-1]=arr1[i-1];
				i--;
				j--;
				index--;
			}
			else if(res[i-1][j] > res[i][j-1]){
				i--;
			}
			else{
				j--;
			}
		}
		
		for(char c:arr){
			System.out.print(c);
		}
	}
}

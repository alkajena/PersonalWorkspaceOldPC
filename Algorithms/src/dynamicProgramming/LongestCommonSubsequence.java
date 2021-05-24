package dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {
static String str="";
static Set<Character> set=new HashSet<>();
	public static void main(String[] args) {
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	    
	    char[] s1Arr=s1.toCharArray();
	    char[] s2Arr=s2.toCharArray();
	    
	    int s1Len=s1Arr.length;
	    int s2Len=s2Arr.length;
	    
	   //longestommonSubsequenceDP(s1Arr,s2Arr,s1Len,s2Len);
	   longestCommonSubSequencePrintWithDP(s1Arr,s2Arr,s1Len,s2Len);
	    
	}

	public static int longestommonSubsequenceRecursive(char[] arr1,char[] arr2,int len1,int len2){
		if(len1==0 || len2==0)
			return 0;
		else if(arr1[len1-1] == arr2[len2-1]){
			set.add(arr1[len1-1]);
			str=str+arr1[len1-1];
			return 1+longestommonSubsequenceRecursive(arr1,arr2,len1-1,len2-1);
		}
		else
			return max(longestommonSubsequenceRecursive(arr1,arr2,len1-1,len2),longestommonSubsequenceRecursive(arr1,arr2,len1,len2-1));
	}
	
	public static int max(int a,int b){
		return a>b?a:b;
	}
	
	public static void longestommonSubsequenceDP(char[] arr1,char[] arr2,int len1,int len2){
		Integer[][] result=new Integer[len1+1][len2+1];
		
		for(int i=0;i<=len1;i++){
			for(int j=0;j<=len2;j++){
				if(i==0 || j==0){
					result[i][j]=0;
				}
				else if(arr1[i-1]==arr2[j-1]){
					result[i][j]=1+result[i-1][j-1];
				}
				else{
					result[i][j]=max(result[i-1][j],result[i][j-1]);
				}
			}
		}
		for(int i=0;i<result.length;i++){
			for(int j=0;j<=result.length;j++){
				System.out.println(result[i][j]);
			}
		}
		System.out.println("    "+result[len1][len2]);
	}
	
	public static void longestCommonSubSequencePrintWithDP(char[] arr1,char[] arr2,int m,int n){
		Integer[][] res=new Integer[m+1][n+1];
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
		int i=m;
		int j=n;
		char[] resStr=new char[index+1];
		//resStr[index]='\u0000';
		
		while(i>0 && j>0){
			if(arr1[i-1]==arr2[j-1]){
				resStr[index-1]=arr1[i-1];
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
		System.out.println(resStr);
		for(char c:resStr){
			System.out.println(c);
		}
	}
}

package dynamicProgramming;

public class EditDistnace {

	public static void main(String[] args) {
		String str1="sunday";
		String str2="saturday";
		int m=str1.length();
		int n=str2.length();
		//System.out.println(editDistnace(str1,str2,m,m));
		editdistanceDP(str1,str2,m,n);
		System.out.println(editDist(str1,str2,m,n));
	}
	static int min1(int x, int y, int z) 
    { 
        if (x <= y && x <= z) 
            return x; 
        if (y <= x && y <= z) 
            return y; 
        else
            return z; 
    } 
	static int editDist(String str1, String str2, int m, int n) 
    { 
        // If first string is empty, the only option is to 
        // insert all characters of second string into first 
        if (m == 0) 
            return n; 
  
        // If second string is empty, the only option is to 
        // remove all characters of first string 
        if (n == 0) 
            return m; 
  
        // If last characters of two strings are same, nothing 
        // much to do. Ignore last characters and get count for 
        // remaining strings. 
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) 
            return editDist(str1, str2, m - 1, n - 1); 
  
        // If last characters are not same, consider all three 
        // operations on last character of first string, recursively 
        // compute minimum cost for all three operations and take 
        // minimum of three values. 
        return 1 + min1(editDist(str1, str2, m, n - 1), // Insert 
                       editDist(str1, str2, m - 1, n), // Remove 
                       editDist(str1, str2, m - 1, n - 1) // Replace 
                       ); 
    } 
  //Tc:-o(3^m) which is more than DP
	public static int editDistnace(String str1,String str2,int m,int n){
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(str1.charAt(m-1)==str2.charAt(n-1))
			return editDistnace(str1,str2,m-1,n-1);
		else
			return 1+(min(editDistnace(str1,str2,m,n-1),editDistnace(str1,str2,m-1,n),editDistnace(str1,str2,m-1,n-1)));
	}
	
	public static int min(int a,int b,int c){
		int min1= a<b?a:b;
		int min2=c<min1?c:min1;
		return min2;
	}
	//Tc:-O(m*n) and space complexity=O(m*n) inorder to reduce space compalexity use i%2 instead of i
	public static void editdistanceDP(String str1,String str2,int m,int n){
		Integer[][] res=new Integer[m+1][n+1];
		for(int j=0;j<=n;j++){
			res[0][j]=j;
		}
		for(int i=1;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(j==0){
						res[i][j]=i;
				}
				else if(str1.charAt(i-1)==str2.charAt(j-1)){
					res[i][j]=res[i-1][j-1];
				}
				else{
					res[i][j]=1+(min(res[i-1][j],res[i][j-1],res[i-1][j-1]));
				}
					
			}
		}
		
		System.out.println(res[m][n]);
	}
}

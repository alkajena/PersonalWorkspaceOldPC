package dynamicProgramming;

public class EggDroppingPuzzle {

	public static void main(String[] args) {
		int egg=2;
		int floor=10;
		System.out.println(EggDropDP(egg,floor));
	}
	public static int EggDrop(int eg,int fl){
		if(fl==0 || fl==1)
			return fl;
		if(eg==1)
			return fl;
		int res;
		int min=Integer.MAX_VALUE;
		for(int x=1;x<=fl;x++){
			res=max(EggDrop(eg-1,x-1),EggDrop(eg,fl-x));
			
			if(res < min)
				min=res;
		}
		return min+1;
	}
	
	public static int max(int a,int b){
		return a>b?a:b;
	}
	
	public static int EggDropDP(int eg,int fl){
		int[][] res=new int[eg+1][fl+1];
		
		for(int i=0;i<=eg;i++){
			res[eg][0]=0;
			res[eg][1]=1;
		}
		
		for(int i=0;i<=fl;i++){
			res[1][i]=i;
		}
	int min;
		for(int i=2;i<=eg;i++){
			for(int j=2;j<=fl;j++){
				res[i][j]=Integer.MAX_VALUE;
				for(int k=1;k<j;k++){
					min=1+max(res[i][k-1],res[i-1][j-k]);
					
					if(min < res[i][j])
						res[i][j]=min;
				}
			}
		}
		return res[eg][fl];
	}
}

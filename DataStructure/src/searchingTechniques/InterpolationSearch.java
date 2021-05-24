package searchingTechniques;

public class InterpolationSearch {

	public static int interpolationSearch(int[] arr,int l,int h,int data){
		while(l<=h){
			int pos=l+(((data-arr[l])*(h-l))/(arr[h]-arr[l]));
			if(arr[pos]==data){
				return pos;
			}
			else if(data>arr[pos]){
				l=pos+1;
			}
			else if(data<arr[pos]){
				h=pos-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4,5,6,7,8};
		int l=0;
		int h=arr.length-1;
		int data=8;
		System.out.println("the index of earched element in recusrion method is :"+interpolationSearch(arr,l,h,data));

	}

}

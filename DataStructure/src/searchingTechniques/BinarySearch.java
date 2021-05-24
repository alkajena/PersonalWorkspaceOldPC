package searchingTechniques;

public class BinarySearch {
	
	public static int binarySearchRecursion(int[] arr,int l,int h,int data){
		int mid=l+(h-l)/2;
		
		if(data==arr[mid])
			return mid;
		else if(data > arr[mid]){
			l=mid+1;
			return binarySearchRecursion(arr,l,h,data);
		}
		else if(data < arr[mid]){
			h=mid-1;
			return binarySearchRecursion(arr,l,h,data);
		}
		return -1;
	}
	
	public static int binarySearchIteration(int[] arr,int l,int h,int data){
		
		while(l<=h){
			int mid=l+(h-l)/2;
			if(data==arr[mid]){
				return mid;
			}
			else if(data > arr[mid]){
				l=mid+1;
			}
			else if(data < arr[mid]){
				h=mid-1;
		}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4,5,6,7,8};
		int l=0;
		int h=arr.length-1;
		int data=8;
		System.out.println("the index of earched element in recusrion method is :"+binarySearchRecursion(arr,l,h,data));
		System.out.println("the index of earched element in iteration method is :"+binarySearchIteration(arr,l,h,data));
	}

}

package arrayDSA;

public class ArrayInsertion {

	public static void main(String[] args) {
		
	//from begining	
	int arr[]=new int[]{10,20,30,40,50};
	int item=80;
	int k=3;
	for(int i=0;i<arr.length;i++){
		if(i>=k){
			int j=arr[i];
			arr[i]=item;
			item=j;
		}
	}
	int[] arr1=new int[arr.length+1];
	for(int i=0;i<arr.length;i++){
		arr1[i]=arr[i];
	}
	arr1[arr1.length-1]=item;
	for(int i=0;i<arr1.length;i++){
		System.out.println(arr1[i]);
	}
	
	//from ending 
	int newArr[]=new int[]{10,20,30,40,50};
	int item1=80;
	int k1=3;
	
	int[] newArr1=new int[newArr.length+1];
	for(int i=0;i<newArr.length;i++){
		newArr1[i]=newArr[i];
	}
	int i=0;
	for( i=newArr1.length-1;i>=k1;i--){
		if(i>=k1){
			newArr1[i]=newArr1[i-1];
		}
	}
	newArr1[i+1]=item1;
	System.out.println("\n");
	for(int j=0;j<newArr1.length;j++){
		System.out.println(newArr1[j]);
	}
	
	}
}

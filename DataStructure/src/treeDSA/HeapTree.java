package treeDSA;

public class HeapTree {
	static int size=0;
	static int[] heap;
	
	
	public HeapTree(int size){
		heap=new int[size];
		heap[0]=Integer.MAX_VALUE;
	}
	static int parent(int pos){
		return pos/2;
	}
	
	static int leftchild(int pos){
		return 2*pos;
	}
	
	static int rightchild(int pos){
		return (2*pos)+1;
	}
	static void swap(int x,int y){
		int temp=heap[x];
		heap[x]=heap[y];
		heap[y]=temp;
	}
	static void insert(int data){
		heap[++size]=data;
		int current=size;
		while(heap[current]>heap[parent(current)]){
			swap(current,parent(current));
			current=parent(current);
		}
	}
	static int deleteRoot(int root){
		heap[1]=heap[size--];
		hepify(heap,size,1);
		return size;
	}
	static void deleteNodeOtherThanRoot(int key){
		int i;
		for(i=1;i<size;i++){
			if(heap[i]==key){
				int temp=heap[i];
				heap[i]=heap[size];
				heap[size]=temp;
				break;
			}
		}
		hepify(heap,size--,i);
		print();
	}
	
	static void hepify(int[] heap,int size,int i){
		int largest=i;
		int l=2*i;
		int r=2*i+1;
		
		if(l<size && heap[l]>heap[largest])
			largest=l;
		if(r<size && heap[r]>heap[largest])
			largest=r;
		
		if(largest!=i){
			int temp=heap[largest];
			heap[largest]=heap[i];
			heap[i]=temp;
			
			hepify(heap,size,largest);
		}
	}
	static void print(){
		for(int i=1;i<=size/2;i++){
			System.out.println("root "+heap[i]+" left "+heap[2*i]+" right "+heap[2*i+1]);
		}
		System.out.println(heap[size]);
	}
	public static void main(String[] args) {
		System.out.println("The Max Heap is "); 
        HeapTree maxHeap = new HeapTree(15); 
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
        print();
        deleteNodeOtherThanRoot(22);
	}

}

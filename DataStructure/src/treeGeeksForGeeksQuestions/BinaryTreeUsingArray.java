package treeGeeksForGeeksQuestions;

public class BinaryTreeUsingArray {
	static int[] bTree;
	static int size;
	public BinaryTreeUsingArray(int size){
		this.size=size;
		bTree=new int[size];
		bTree[0]=Integer.MAX_VALUE;
	}
	static int setParent(int data,int pos){
		bTree[pos]=data;
		return pos;
	}

	static int setLeftChild(int data,int parentPos){
		int childPos=2*parentPos;
		if(childPos<size)
			bTree[childPos]=data;
		return childPos;
	}
	
static int setRightChild(int data,int parentPos){
	int childPos=2*parentPos+1;
	if(childPos<size)
		bTree[childPos]=data;
	return childPos;
	}
	public static void main(String[] args) {
		int parentPos=0;
		int leftChildPos=0;
		int rightchildPos=0;
		BinaryTreeUsingArray tree= new BinaryTreeUsingArray(8);
		parentPos=tree.setParent(1, 1);
		leftChildPos=tree.setLeftChild(2, parentPos);
		rightchildPos=tree.setRightChild(3, parentPos);
		tree.setLeftChild(5, leftChildPos);
		tree.setRightChild(6, leftChildPos);
		tree.setLeftChild(7, rightchildPos);
		tree.setRightChild(8, rightchildPos);
		
		for(int i=0;i<size;i++){
			System.out.println(bTree[i]);
		}

	}

}

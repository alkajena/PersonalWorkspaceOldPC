package sorting;
/*As data in linkedlist is not stored in contiguous memory location so random access to data is very
 * difficult. so merge action of merge sort will be useful for merging two nodes in linkedlist.
 *  That's why mostly sorting of linkedlist, mergesort is preferred over quick sort and heap sort
 */
public class MergeSortWithLinedList {

	static Node head;
	
	static class Node{
		int value;
		Node next;
		
		public Node(int data){
			this.value=data;
			this.next=null;
		}
	}
	
	public void push(int data){
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;
		
	}
	public Node merge(Node l,Node r){
		Node result = null;
		if(l==null)
			return r;
		if(r==null)
			return l;
		if(l.value < r.value){
			result=l;
			result.next=merge(l.next,r);
		}
		
		if(l.value > r.value){
			result=r;
			result.next=merge(l,r.next);
		}
		
		return result;
			
	}
	public Node mergeSort(Node head){
		if(head==null || head.next==null)
			return head;
		Node middle=getMiddle(head);
		Node middleNext=middle.next;
		
		middle.next=null;
		
		Node left=mergeSort(head);
		Node right=mergeSort(middleNext);
		
		Node merge=merge(left,right);
		return merge;
	}
	
	public Node getMiddle(Node head){
		if(head==null || head.next==null)
			return head;
		Node slow=head;
		Node fast=head;
		
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		
		return slow;
	}
	public static void main(String[] args) {
		MergeSortWithLinedList li=new MergeSortWithLinedList();
		li.push(15); 
        li.push(10); 
        li.push(5); 
        li.push(20); 
        li.push(3); 
        li.push(2); 
        
        Node merge=li.mergeSort(head);
        
        Node temp=merge;
        while(temp.next!=null){
        	System.out.println(temp.value);
        	temp=temp.next;
        }
        System.out.println(temp.value);
	}

}

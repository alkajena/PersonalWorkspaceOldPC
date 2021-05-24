package searchingTechniques;

import java.util.ArrayList;
import java.util.List;
//It implememnts separate chaining method
public class HashTable {
	static List<Node> nodesArr=new ArrayList<>();
	int bucketsize=10;
	int size=0;
	static class Node{
		Integer key;
		int value;
		Node next;
		
		Node(int key,int value){
			this.key=key;
			this.value=value;
			next=null;
		}
	}
	
	HashTable(){
		for(int i=0;i<bucketsize;i++){
			nodesArr.add(null);
		}
	}
	public int getIndex(int key){
		return key%bucketsize;
	}
	@SuppressWarnings("unused")
	public void add(int key,int value){
		int index=getIndex(key);
		Node node=nodesArr.get(index);
		//when whole array contains only null value
		if(node==null){
			Node newNode=new Node(key,value);
			nodesArr.set(index, newNode);
			size++;
			return;
		}
		
		//if key is present then override wit new value
		Node temp=node;
		while(temp!=null){
			if(temp.key.equals(key)){
				temp.value=value;
				return;
			}
			temp=temp.next;
		}
		//insert a new key value pair
			Node newNode=new Node(key,value);
			newNode.next=node;
			nodesArr.set(index, newNode);
			size++;
		
		
	}
	
	public void delete(int key){
		int index=getIndex(key);
		Node node=nodesArr.get(index);
		
		//if node at given index is null
		while(node==null){
			return;
		}
		if(node.key.equals(key)){
			nodesArr.set(index, node.next);
			size--;
		}
		else{
				Node temp=node;
				Node prev=null;
				while(temp!=null){
					if(temp.key.equals(key)){
						prev.next=temp.next;
						size--;
						return;
					}
					prev=temp;
					temp=temp.next;
				}
				
		}
				
	}
	
	public int getNode(int key){
		int index=getIndex(key);
		Node node=nodesArr.get(index);
		
		while(node!=null){
			if(node.key.equals(key)){
				return node.value;
			}
			node=node.next;
		}
		return 0;
	}
	public static void main(String[] args) {
		HashTable hashTable = new HashTable(); 
		hashTable.add(1,1); 
		hashTable.add(2,2); 
		hashTable.add(11,11);
		hashTable.add(21,21);
		hashTable.add(31,31);
		hashTable.add(1,2); 
		hashTable.delete(8); 
		System.out.println("getNode is :"+hashTable.getNode(1)); 
		 System.out.println(hashTable.size); 
		 System.out.println(nodesArr); 
	        for(Node node:nodesArr){
	        	if(node!=null){
	        		while(node.next!=null){
	        			System.out.println(node.key+" "+node.value);
	        			node=node.next;
	        		}
	        		System.out.println(node.key+" "+node.value);
	        	}
	        }

	}

}

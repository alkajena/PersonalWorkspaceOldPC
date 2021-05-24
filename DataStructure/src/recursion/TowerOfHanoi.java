package recursion;

public class TowerOfHanoi {

	static void Hanoi(int n,char from,char to,char aux){
		if(n==1){
			System.out.println(n +"disk is moved from "+from+" to "+to);
			return;
		}
		Hanoi(n-1,from,aux,to);
		System.out.println(n +"disk is moved from "+from+" to "+to);
		Hanoi(n-1,aux,to,from);
	}
	public static void main(String[] args) {
		Hanoi(3,'A','B','C');

	}

}

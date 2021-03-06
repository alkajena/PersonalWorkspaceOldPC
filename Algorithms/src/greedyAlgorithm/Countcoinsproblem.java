package greedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*minimumDenominations method does not work for {9,6,5,1} array ..it will give 9,1,1 but we can get 11 from only 2 denominations that is 5,6
 * Timecomplexity is NLogN 
 */
public class Countcoinsproblem {

	public static void main(String[] args) {
		//Denomination array
		Integer[] arr={9,6,5,1};
		Integer[] arr1={1000,500,100,50,20,10,5,2,1};
		//Amount to be converted to denomination
		int V=11;
		int V1=121;
		minimumDenominations(arr1,V1);
		Map<String,String> map=countMinimumCoins(arr,V);
		System.out.println("Number of minimum coins are : "+map.get("count")+" coins are : "+map.get("coin").split(":")+map);

	}
	public static Map<String,String> countMinimumCoins(Integer[] arr,int V){
		if(V==0){
			Map<String,String> map=new HashMap<>();
			map.put("count", "0");
			map.put("coin", "");
			return map;
		}
		Integer res=Integer.MAX_VALUE;
		Map<String,String> map1=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			
			if(V>=arr[i]){
				Map<String,String> map=new HashMap<>();
				map=countMinimumCoins(arr,V-arr[i]);
				int subRes=Integer.valueOf(map.get("count"));
				 String coins=map.get("coin");
				if(subRes!=Integer.MAX_VALUE && subRes+1<res){
					res=subRes+1;
					coins=coins+arr[i]+":";
					map1.put("count", res.toString());
					map1.put("coin", coins);
					
				}
			}
		}
		return map1;
		
	}
	
	public static void minimumDenominations(Integer[] coin,int V){
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<coin.length;i++){
			if(V>=coin[i]){
				V=V-coin[i];
				list.add(coin[i]);
			}
		}
		System.out.println(list);
	}
}

//The Game is that Computer gives a Result RGBY and you give a guess like GGRR
//Count the number of hits and pseudo-hits
import java.util.*;
public class Solution {
	public static void main(String[] args){
		result("RGRG","GGRR");
	}
	public static void result(String solution, String guess){
		HashMap<Character, Integer> filter = new HashMap<Character, Integer>();
		int hits= 0;
		int pseudohits = 0;
		for(int i = 0; i<4; i++){
			char s = solution.charAt(i);
			char g =guess.charAt(i);
			if(s==g){
				hits++;
			}
			else{
				if(filter.containsKey(s)){
					int num = filter.get(s);
					if(num%2==0){
						pseudohits++;
						num -= 2;
						if(num<0){
							filter.remove(s);
						}
						else{
							filter.put(s, num);
						}
					}
					else{
						filter.put(s, num+2);
					}
				}
				else{
					filter.put(s, 1);
				}
				if(filter.containsKey(g)){
					int num = filter.get(g);
					if(num%2==1){
						pseudohits++;
						num -= 2;
						if(num<0){
							filter.remove(g);
						}
						else{
							filter.put(g, num);
						}
					}
					else{
						filter.put(g, num+2);
					}
				}
				else{
					filter.put(g, 0);
				}
			}
		}
		System.out.printf("Hits: %d %nPseudoHits:%d", hits, pseudohits);
	}
}

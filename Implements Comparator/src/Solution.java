import java.util.Arrays;
import java.util.Comparator;
public class Solution {
	public static class Comp implements Comparator<Integer>{
		@Override
		public int compare(Integer a, Integer b){
			return a>b?-1:a==b?0:1;
		}
	}
	public static void main(String[] args){
		Integer[] a = {1,2,3,4,5};
//		Arrays.sort(a,new Comparator<Integer>(){
//			@Override
//			public int compare(Integer a, Integer b){
//				return a>b?-1:a==b?0:1;
//			}
//		});
		Comp b = new Comp();
		Arrays.sort(a,b);
		System.out.println(Arrays.toString(a));
	}
}

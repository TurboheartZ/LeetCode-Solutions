import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = new int[2][2];
		Integer[] a = {1,-1};
		Arrays.sort(a,new Comparator<Integer>(){
			@Override
			public int compare(Integer a,Integer b){
				return a>b?-1:a<b?1:0;
			}
		});
		System.out.println(a[0]);
		List<Integer> data = new ArrayList<Integer>();
		data.add(1);
		data.set(0, 2);
		System.out.println(data);
	}
	
}

import java.util.*;

class arch {
	int val;
	int val2;
	public arch(int x){
		this.val = x;
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("This is a test");
//		HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
//		
//		int[] a = {1,2,3};
//		int[] b = a;
//		System.out.println(a.equals(b));
//		String c = "ava";
//		
//		char[] aa = c.toCharArray();
//		
//		System.out.println(~0);
//		
//		List<Integer> test = new LinkedList<Integer>();
//		int[] k = {1,2,3};
//		System.out.println(String.valueOf(k));
//		System.out.println(Arrays.toString(k));
//		int b = 0;
//		try{
//			int a = 10/0;
//			System.out.println("this is 10/0");
//			System.out.println(b);
//		}catch(Exception e){
//			System.out.println("Exception occurred!");
//		}finally{
//			System.out.println("This is the finally code!");
//			b++;
//		}
//		System.out.println(Integer.MIN_VALUE);
//		StringBuilder sb = new StringBuilder();
//		TreeSet<String> a = new TreeSet<String>();
		
		HashMap<Integer, arch> mp = new HashMap<Integer, arch>();
		arch d = new arch(0);
		d.val2 = 1;
		mp.put(1,d);
		System.out.println(mp.get(1).val2);
		d.val2 = 2;
		System.out.println(mp.get(1).val2);
		
	}

}

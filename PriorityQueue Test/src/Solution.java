import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 10;
		System.out.println(nthUglyNumber(input));
		HashSet<Integer> data = new HashSet<Integer>();
		data.add(1);
		for(int x:data){
			System.out.println(x);
		}

	}
    public static int nthUglyNumber(int n) {
        PriorityQueue<Integer> ugly = new PriorityQueue<Integer>();
        ugly.add(1);
        for(int i = 2; i<=n ;i++){
            int p = ugly.poll();
            if(ugly.contains(2*p)==false) ugly.add(2*p);
            if(ugly.contains(3*p)==false) ugly.add(3*p);
            if(ugly.contains(5*p)==false) ugly.add(5*p);
        }
        return ugly.poll();
    }
}

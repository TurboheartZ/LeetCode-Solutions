
public class Solution {
	public static void main(String[] args){
		int input = 20;
		System.out.println(zeroes(input));
		long p = 1l;
		for(int i= 1; i<=input; i++){
			p *= i;
		}
		System.out.println(p);
	}
	public static int zeroes(int n){
		int count = 0;
		if(n<0){
			return 0;
		}
		else if(n==0){
			return 1;
		}
		else{
			int num = n/5;
			count = num;
			return count;
		}
		//Since the number of 5 is always less than the number of 2, we only need to concern the number of5	
	}
}

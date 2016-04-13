
public class Solution {
	public static void main(String[] args){
		System.out.print(add(11,19));
	}
	public static int add(int a, int b){
		if(b==0){
			return a;
		}
		else if(a==0){
			return b;
		}
		else{
			int sum = a^b;//This is the sum without carry
			int carry = (a&b)<<1;//This is the carry, do not forget to shift leftward for 1 bit
			return add(sum,carry);
		}
	}
}

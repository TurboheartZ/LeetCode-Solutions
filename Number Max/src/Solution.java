
public class Solution {
	public static void main(String[] args){
		//Compare two integers without using if-else or comparison operators
		System.out.println(max(7,6));
		System.out.println(~-1);
	}
	public static int max(int a, int b){
		int sub = a-b;
		int sign = sub>>31;
		return -a*(~sign)-b*sign;
	}
}

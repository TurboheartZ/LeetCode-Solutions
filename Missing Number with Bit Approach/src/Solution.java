import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17};
		System.out.println(missingNumber(input,17));
	}
	public static int missingNumber(int[] nums, int n){
		int[] bits = new int[32];
		Arrays.fill(bits, 0);
		partition(bits,n);
		System.out.println(Arrays.toString(bits));
		for(int x : nums){
			for(int i = 0; i<32; i++){
				if(getBit(x,i)==1){
					bits[i]--;
				}
			}
		}
		int sum = 0;
		for(int i = 0; i<bits.length; i++){
			if(bits[i]==1){
				sum += (int)Math.pow(2,i);
			}
		}
		return sum;
	}
	private static void partition(int[] bits, int n){
		if(n>=1){
			int r = (int)Math.floor((Math.log(n+1)/Math.log(2)));
			for(int i = 0; i<r ; i++){
				bits[i] += (int)Math.pow(2, r-1);
			}
			int diff = n + 1 - (int)Math.pow(2, r);
			bits[r] += diff;
			partition(bits, diff-1);
		}
		else return;
	}
	private static int getBit(int num, int index){
		return (num>>(index))&1;
	}
}

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2,3,5,7,13,17,19,37,43,53,61,71,79,89,97,103,107,109,131,137};
		int n = 17;
		System.out.println(nthSuperUglyNumber(n,input));
	}
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int length = primes.length;
        int[] index = new int[length];
        int[] num = primes.clone();
        Arrays.fill(index,1);
        int[] ugly = new int[n];
        ugly[0] = 1;
        for(int i = 1; i<n; i++){
            int min = findMin(num);
            ugly[i] = min;
            for(int j = 0; j<num.length; j++){
                if(num[j]==min){
                    num[j] = primes[j]*ugly[index[j]++];
                }
            }
        }
        return ugly[n-1];
    }
    private static int findMin(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }
}

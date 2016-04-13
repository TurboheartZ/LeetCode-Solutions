
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] singleNumber(int[] nums) {
	        if(nums.length<2){
	            return new int[2];
	        }
	        else{
	            int xor = 0;
	            for(int x : nums){
	                xor ^= x;
	            }
	            int diff = xor&(-xor);
	            //This is the rightmost same bit between X and Y
	            //Divide the nums into two part
	            //Each part is formed with 2a,2b,2c,X and 2d,2e,2f,Y
	            //Do xor respectively and get X and Y
	            int[] result = new int[2];
	            for(int x : nums){
	                if((x&diff)==0){
	                    result[0] ^= x;
	                }
	                else{
	                    result[1] ^= x;
	                }
	            }
	            return result;
	        }
	    }
}

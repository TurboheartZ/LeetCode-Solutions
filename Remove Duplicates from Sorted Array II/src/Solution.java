
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = {'a','b','c','d'};
	}
    public static int removeDuplicates(int[] nums) {
        //Use two pointers, one for write one for check duplicate
        if(nums==null||nums.length==0){
            return 0;
        }
        else{
            int write = 1;
            int read = 1;
            int repeat = 1;
            while(read<nums.length){
                if(nums[read]==nums[write-1]){
                    if(repeat==1){
                        nums[write++] = nums[read];
                        repeat = 2;                        
                    }
                }
                else{
                    nums[write++] = nums[read];
                    repeat = 1;
                }
                read++;
            }
            return write;
        }
    }
}

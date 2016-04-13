
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int findPeakElement(int[] nums) {
        //Try to use 2-pointers to minimize calculation
        if(nums.length==1){
            return 0;
        }
        else{
            if(nums[0]>nums[1]){
                return 0;
            }
            else if(nums[nums.length-2]<nums[nums.length-1]){
                return nums.length-1;
            }
            else{
                int first = 1;
                int last = nums.length-2;
                int index = -1;
                while(last-first>=0){
                    if(nums[first+1]<nums[first]){
                        index=first;
                        break;
                    }
                    else{
                        first++;
                    }
                    if(nums[last-1]<nums[last]){
                        index=last;
                        break;
                    }
                    else{
                        last--;
                    }
                }
                return index;
            }
        }
    }
}

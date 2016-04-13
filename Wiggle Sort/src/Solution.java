
public class Solution {
	public static void main(String[] args){
		
	}
    public void wiggleSort(int[] nums) {
        if(nums.length<=1){
            return; 
        }
        else{
            if(nums[0]>nums[1]){
                swap(nums,0,1);//As long as we have defined the relation between first pairs, we define the whole style
            }
            int dir = 1;
            for(int i = 1; i<nums.length-1; i++){
                if(nums[i]>nums[i-1]){
                    if(nums[i]<nums[i+1]){
                        swap(nums, i, i+1);
                    }
                    dir = -1;//We need this to indicate the direction when we met with adjacent equal numbers
                }
                else if(nums[i]<nums[i-1]){
                    if(nums[i]>nums[i+1]){
                        swap(nums, i, i+1);
                    }
                    dir = 1;
                }
                else{
                    if(dir==-1){
                        if(nums[i]>nums[i+1]){
                            swap(nums, i, i+1);
                        }
                        dir = 1;
                    }
                    else{
                        if(nums[i]<nums[i+1]){
                            swap(nums, i, i+1);
                        }
                        dir = -1;                        
                    }
                }
            }
        }
    }
    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

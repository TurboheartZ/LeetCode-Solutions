import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//This is a very illustrative problem!
    //Use Boyer-Moore Voting Algorithm to solve this problem
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer> ();
        if(nums.length==0){
            return result;
        }
        else if(nums.length==1){
            result.add(nums[0]);
            return result;
        }
        else{
            int can1 = nums[0], can2 = nums[1], counter1 = 0, counter2 = 0;
            for(int x:nums){
                if(x==can1){
                    counter1++;
                }
                else if(x==can2){//Here I use else if, this is because we dont want can1 and can2 to hold the same value
                    counter2++;
                }
                else if(counter1==0){
                    can1 = x;
                    counter1 = 1;
                }
                else if(counter2==0){
                    can2 = x;
                    counter2 = 1;
                }
                else{
                    counter1--;
                    counter2--;
                }
            }
            counter1 = 0;
            counter2 = 0;
            for(int x:nums){
                if(x==can1){
                    counter1++;
                }
                if(x==can2){
                    counter2++;
                }
            }
            if(counter1>(nums.length/3)){
                result.add(can1);
            }
            if(counter2>(nums.length/3)&&can2!=can1){//Here we make sure can1!=can2
                result.add(can2);
            }
            return result;
        }
    }
}

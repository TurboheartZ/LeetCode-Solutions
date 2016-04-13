
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //If the number of Zero is larger or equals to 2, then all the result should be Zero
    //If only one Zero, except the result of the zero element, other results should be Zero
    //Else, we can firstly calculate the product of all the elements and then divide it with each element
    public static int[] productExceptSelf(int[] nums) {
        int product=1;
        int zero=0;
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
            else{
                product*=nums[i];
            }
        }
        if(zero>=2){
            return result;
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    result[i]=product;
                }
                else{
                    result[i]=zero==1?0:product/nums[i];
                }
            }
            return result;
        }
    }
}

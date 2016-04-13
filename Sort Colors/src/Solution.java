
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0,0};
		sortColors(input);
		int[] input2 = {1,1};
		input = input2;
		System.out.println(input[1]);
		//System.out.println("Done");
	}
    public static void sortColors(int[] nums) {
        int first=0;
        int last=nums.length-1;
        int[] data = nums.clone();
        if(nums.length>1){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    data[first++]=0;
                }
                else if(nums[i]==2){
                    data[last--]=2;
                }
            }
            for(int i=first;i<=last;i++){
                data[i]=1;
            }
            for(int i=0;i<nums.length;i++){
                nums[i]=data[i];
            }
        }
    }
}

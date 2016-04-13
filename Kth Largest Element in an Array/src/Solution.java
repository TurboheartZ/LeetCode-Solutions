import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		int[] b = {0,0,0,0};
		int[] data;
		data = a;
		System.out.println(data[2]);
	}
    //Although this problem can be solved using Arrays.sort(), but actually we do not need to sort all the array to get the answer
    //We can use quick sort, since after every round of sort, the number will appear at its defined position
    static int[] data;
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if(len==1){
            return nums[0];
        }
        else{
            data = nums;
            int lo = 0;
            int hi = len-1;
            int index = -1;
            int result = -1;
            do{
               index = partition(data,lo,hi);
               if(index==len-k){
                   result = data[index];
                   break;
               }
               else if(index<len-k){
                   lo = index+1;
               }
               else{
                   hi = index-1;
               }
            }while(true);
            return result; 
        }
    }
    //Actually, this part can be involved into the main function, which can reduce the time used for globlization nums
    private static int partition(int[] nums, int lo, int hi){
        int key = nums[lo];
        while(lo<hi){
            while(lo<hi&&nums[hi]>key) hi--;
            if(hi>lo){
                int temp = nums[hi];
                nums[hi] = nums[lo];
                nums[lo++] = temp;
            }
            while(lo<hi&&nums[lo]<key) lo++;
            if(lo<hi){
                int temp = nums[hi];
                nums[hi--] = nums[lo];
                nums[lo] = temp;
            }           
        }
        //return nums[lo]==key?lo:hi;
        return lo;
    }
}

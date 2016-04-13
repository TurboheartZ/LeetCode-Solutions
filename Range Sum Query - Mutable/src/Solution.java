	class NumArray {
	    //Use Binary Indexed Tree to solve this problem
	    
	    public int[] Bit;
	    public int[] store;
	    
	    public NumArray(int[] nums) {
	        Bit = new int[nums.length];
	        store = nums;
	        //Build the Bit array
	        for(int i = 0; i<nums.length; i++){
	            Bit[i] = nums[i];
	            int lowbits = (i+1)&(-(i+1));
	            for(int j = 1; j<lowbits; j<<=1){
	                Bit[i] += Bit[i-j];
	            }
	        }
	    }

	    void update(int i, int val) {
	        int change = val-store[i];
	        store[i] = val;
	        int fakeIndex = i+1;
	        while(fakeIndex<=Bit.length){
	            Bit[fakeIndex-1] += change;
	            fakeIndex += fakeIndex&(-fakeIndex); 
	        }
	    }

	    public int sumRange(int i, int j) {
	        return findBit(j)-findBit(i-1);
	    }
	    
	    private int findBit(int i){
	        int fakeIndex = i+1;
	        int result = 0;
	        while(fakeIndex>0){
	            result += Bit[fakeIndex-1];
	            fakeIndex -= fakeIndex&(-fakeIndex);
	        }
	        return result;
	    }
	}
public class Solution {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {5,18,13};
		NumArray test = new NumArray(input);
		System.out.println(test.sumRange(0,2));
		test.update(1, -1);
		test.update(2, 3);
		test.update(0, 5);
		test.update(0, -4);
		System.out.println(test.sumRange(0,2));
	}

}

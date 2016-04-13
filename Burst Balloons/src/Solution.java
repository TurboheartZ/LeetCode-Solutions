
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,9,8,0,7,1,3,5,5,2,3,3};
		System.out.println(maxCoins(nums));
	}
	//****This is a DP solution with time complexity of O(N^3)
    //After divide and conquer solution, now try to solve it in DP ways
    //Use memory to utilize the previous calculations
    public int maxCoinsOptimal(int[] nums) {
        int[] newNums = new int[nums.length+2];
        int i = 1;
        for(int x:nums){
            if(x>0){
                newNums[i++] = x;
            }
        }
        newNums[0] = newNums[i] = 1;
        int[][] memory = new int[i+1][i+1];
        for(int dist = 2; dist<i+1; dist++){
            //Start from the smallest range and expand later while using the previous results of small ranges
            for(int left = 0; left<i+1-dist; left++){
                int right = left+dist;
                for(int j = left+1; j<right; j++){
                    //i is the last to burst in the range of (left,right)
                    int res = newNums[left]*newNums[j]*newNums[right]+memory[left][j]+memory[j][right];
                    memory[left][right] = Math.max(memory[left][right],res);
                }
            }
        }
        return memory[0][i];
    }
	
	
    //****This is a Divide and conquer method with time complexity of O(Nlog(N))
    //Divide and conquer method
    //Using the last to burst in a range to divide
    public int maxCoinsOptimized(int[] nums) {
        int[] newNums = new int[nums.length+2];
        int j = 1;
        for(int x : nums){
            if(x>0){
                newNums[j++] = x;
            }
        }
        newNums[0] = 1;
        newNums[j] = 1;
        int[][] memory = new int[j+1][j+1];
        return burst(newNums,memory,0,j);
    }
    private int burst(int[] nums, int[][] memory, int begin, int end){
        if(begin+1==end){
            return 0;
        }
        else{
            if(memory[begin][end]>0){
                return memory[begin][end];
            }
            else{
                int max = 0;
                for(int i = begin+1; i<end; i++){
                    int res = nums[i]*nums[begin]*nums[end]+burst(nums,memory,begin,i)+burst(nums,memory,i,end);
                    max = Math.max(max,res);
                }
                memory[begin][end] = max;
                return max;
            }
        }
    }	
	//****This is a backtracking method with time complexity of O(n!)****
    private static int max = 0;
    
    public static int maxCoins(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        else{
            boolean[] visited = new boolean[nums.length];
            DFS(visited,nums,0);
            return max;
        }
    }
    
    private static void DFS(boolean[] visited, int[] nums, int sum){
        int left = 1;
        int right = -1;
        int i = 0;
        int leftIndex = -1;
        int midIndex = 0;
        //int rightIndex = nums.length-1;
        while(i<nums.length){
            for(; i<nums.length&&right==-1; i++){
                if(visited[i]==false){
                    break;
                }
            }
            if(right==-1&&i==nums.length){
                max = Math.max(max,sum);
                return;
            }
            else{
                midIndex = i;
                int mid = nums[i];
                for(i = i+1; i<nums.length; i++){
                    if(visited[i]==false){
                        break;
                    }
                }
                if(i==nums.length){
                    sum += left*mid;
                    if(leftIndex!=-1){
                    	sum += Math.max(left, mid);
                    }
                    max = Math.max(max,sum);
                    return;
                }
                else{
                    //rightIndex = i;
                    right = nums[i];
                    int newSum = sum+mid*left*right;
                    visited[midIndex] = true;
                    DFS(visited,nums,newSum);
                    visited[midIndex] = false;
                    left = mid;
                    leftIndex = midIndex;
                }
            }            
        }
    }
}

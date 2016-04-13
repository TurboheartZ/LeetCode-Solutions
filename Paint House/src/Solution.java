
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //DP with memorization
    public int minCost(int[][] costs) {
        if(costs.length==0||costs[0].length==0){
            return 0;
        }
        else{
            if(costs.length==1){
                return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
            }
            else{
                int[][] mem = new int[3][costs.length];
                mem[0][0] = costs[0][0];
                mem[1][0] = costs[0][1];
                mem[2][0] = costs[0][2];
                return DP(costs,mem,1);
            }
        }
    }
    private int DP(int[][] costs, int[][] mem, int index){
    	//int r means the min costs when the No.index house is painted to red, which is the comparsion result of previous Paint Blue and Paint Green
        int r = Math.min((mem[1][index-1]+costs[index][0]),(mem[2][index-1]+costs[index][0]));
        int b = Math.min((mem[0][index-1]+costs[index][1]),(mem[2][index-1]+costs[index][1]));
        int g = Math.min((mem[0][index-1]+costs[index][2]),(mem[1][index-1]+costs[index][2]));        
        if(index==costs.length-1){
            return Math.min(r,Math.min(b,g));
        }
        else{
            mem[0][index] = r;
            mem[1][index] = b;
            mem[2][index] = g;
            return DP(costs,mem,index+1);
        }
    }
}

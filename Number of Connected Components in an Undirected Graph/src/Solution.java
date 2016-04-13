import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Use union-find method to solve this problem
    public int countComponents(int n, int[][] edges) {
        //Error check first
        if(edges.length==0){
            return n;
        }
        else{
            int[] root = new int[n];
            Arrays.fill(root,-1);
            int num = 0;
            for(int i = 0; i<edges.length; i++){
                int x = edges[i][0];
                int y = edges[i][1];
                if(root[x]==-1&&root[y]==-1){
                    root[x] = x;
                    root[y] = x;
                    num++;
                }
                else if(root[x]==-1){
                    root[x] = findRoot(root,root[y]);
                }
                else if(root[y]==-1){
                    root[y] = findRoot(root,root[x]);
                }
                else{
                    if(findRoot(root,root[x])!=findRoot(root,root[y])){
                        num--;
                        root[findRoot(root,root[x])] = findRoot(root,root[y]);//Connect one's root to anothers root
                    }
                }
            }
            int count = 0;
            for(int i = 0; i<n; i++){//Check those not linked ones
                if(root[i]==-1){
                    count++;
                }
            }
            return num+count;
        }
    }
    private int findRoot(int[] root, int i){
        if(root[i]==-1){
            return -1;
        }
        while(i!=root[i]){
            root[i] = root[root[i]];
            i = root[i];
        }
        return root[i];
    }
}

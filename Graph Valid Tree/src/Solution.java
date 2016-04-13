import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //First: No cycles
    //Second: No isolated edges
	//Third: No isolated vertices
    public boolean validTree(int n, int[][] edges) {
        if(n<=0||edges.length==0){
            return n==1;
        }
        else{
            int[] root = new int[n];
            Arrays.fill(root,-1);
            for(int i = 0; i<edges.length; i++){
                int x = edges[i][0];
                int y = edges[i][1];
                if(root[x]==-1&&root[y]==-1){
                    root[x] = x;
                    root[y] = x;
                }
                else if(root[x]==-1){
                    root[x] = findRoot(root,y);
                }
                else if(root[y]==-1){
                    root[y] = findRoot(root,x);
                }
                else{
                    int rx = findRoot(root,x);
                    int ry = findRoot(root,y);
                    if(rx!=ry){
                        root[rx] = ry;
                    }
                    else{//****Check for cycles****
                        return false;
                    }
                }
            }
            int r = findRoot(root,0);
            for(int i = 1; i<n; i++){
                if(root[i]==-1){//****Check isolated vertices****
                    return false;
                }
                else if(findRoot(root,i)!=r){//****Check isolated edges****
                    return false;
                }
            }
            return true;
        }
    }
    private int findRoot(int[] root, int i){
        while(root[i]!=i){
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}

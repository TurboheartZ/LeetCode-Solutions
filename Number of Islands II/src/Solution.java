import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Union-Find Method to solve this problem
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();
        if(positions.length==0||m<=0||n<=0){
            return result;
        }
        else{
            int count = 0;
            int[] id = new int[m*n];
            Arrays.fill(id,-1);//Initiate the root array
            for(int i = 0; i<positions.length; i++){
                int x = positions[i][0];
                int y = positions[i][1];
                if(x<0||x>=m||y<0||y>=n){
                    continue;
                }
                else{
                    int pos = x*n+y;
                    if(id[pos]==-1){
                        //int sets = 0;
                        int root = -1;
                        if(x-1>=0&&findRoot(id,pos-n)!=-1){
                            if(root==-1){
                                root = findRoot(id,pos-n);
                            }
                            else{
                                if(root!=findRoot(id,pos-n)){
                                    count--;
                                    id[findRoot(id,pos-n)] = root;
                                }
                            }
                        }
                        if(y-1>=0&&findRoot(id,pos-1)!=-1){
                            if(root==-1){
                                root = findRoot(id,pos-1);
                            }
                            else{
                                if(root!=findRoot(id,pos-1)){
                                    count--;
                                    id[findRoot(id,pos-1)] = root;
                                }
                            }
                        }
                        if(y+1<n&&findRoot(id,pos+1)!=-1){
                            if(root==-1){
                                root = findRoot(id,pos+1);
                            }
                            else{
                                if(root!=findRoot(id,pos+1)){
                                    count--;
                                    id[findRoot(id,pos+1)] = root;
                                }
                            }
                        }
                        if(x+1<m&&findRoot(id,pos+n)!=-1){
                            if(root==-1){
                                root = findRoot(id,pos+n);
                            }
                            else{
                                if(root!=findRoot(id,pos+n)){
                                    count--;
                                    id[findRoot(id,pos+n)] = root;
                                }
                            }
                        }
                        if(root==-1){
                            count++;
                            id[pos] = pos;
                        }
                        else{
                            id[pos] = root;
                        }
                        result.add(count);
                    }
                }
            }
            return result;
        }
    }
    private static int findRoot(int[] id, int i){
        if(i<0||i>id.length-1){
            return -1;
        }
        while(i!=id[i]&&id[i]!=-1){
            id[i] = id[id[i]];
            i = id[i];
        }
        return id[i];
    }
}

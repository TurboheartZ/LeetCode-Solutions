import java.util.*;
class Node{
    public int x;
    public int y;
    public int distance;
    public Node(int a, int b, int c){
        this.x = a;
        this.y = b;
        this.distance = c;
    }
}
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		int[][] input2 = {{0,0,0,2,0,2,0,0,2,0,0,0,2},{2,0,0,0,2,0,2,0,2,2,1,0,0},{0,0,0,0,2,1,2,0,0,0,0,0,0},{0,0,0,1,0,2,0,2,1,0,2,0,2},{2,2,0,0,2,0,0,2,2,0,0,2,0},{2,0,1,0,2,0,0,0,0,0,0,0,0},{0,2,2,2,1,2,1,0,2,0,0,0,0},{0,2,0,1,2,0,0,2,2,2,0,0,0},{0,0,2,1,0,0,2,0,0,0,2,2,0},{1,0,0,2,2,2,0,0,2,2,0,0,0},{2,0,2,0,2,2,2,2,2,2,0,0,0},{2,2,2,0,2,0,2,0,2,2,2,0,0},{0,0,0,0,0,0,0,1,0,0,1,0,0},{0,0,0,0,2,0,0,0,2,2,0,0,0},{0,0,0,0,0,2,1,1,0,0,0,2,0},{2,0,0,0,2,2,2,0,0,2,0,0,2},{0,1,0,2,2,0,2,2,2,0,0,2,0},{2,0,2,0,0,2,2,0,2,0,0,0,0},{0,2,0,1,0,2,0,2,0,2,0,0,2},{2,0,0,0,0,0,0,0,0,2,0,2,2},{0,0,0,2,0,2,0,0,2,0,0,0,0},{2,0,2,0,0,0,0,0,0,0,0,2,0},{0,0,2,2,0,2,0,0,1,2,1,0,0},{0,2,2,0,0,0,0,0,0,2,0,0,0},{2,0,0,0,0,0,0,0,2,2,0,1,0},{0,0,0,0,0,2,0,0,0,2,1,0,0}};
		System.out.println(shortestDistance(input2));
	}

    //Use BFS to solve this problem
    //Firstly we do BFS from each building to find the distance from each blank space to this building
    public static int shortestDistance(int[][] grid) {
        if(grid.length==0||grid[0].length==0){
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        List<Node> building = new ArrayList<Node>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    building.add(new Node(i,j,0));
                    grid[i][j]=-1;//So that this building value will not affect our calculation next
                }
                else if(grid[i][j]==2){
                    grid[i][j]=-2;//So that this building value will not affect our calculation next
                }
            }
        }
        if(building.size()==0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int[] shift = {1,0,-1,0,1};
        HashMap<String,int[]> record = new HashMap<String,int[]>();
        int numOfBuilding = building.size();
        for(int i = 0; i<numOfBuilding; i++){
            Node n = building.get(i);
            boolean[][] isVisited = new boolean[row][col];
            isVisited[n.x][n.y] = true;
            Queue<Node> adjNodes = new LinkedList<Node>();
            adjNodes.offer(n);
            while(adjNodes.size()>0){
                Node adjnode = adjNodes.poll();
                int x = adjnode.x;
                int y = adjnode.y;
                for(int s = 0; s<4; s++){
                    int r = x-shift[s];
                    int c = y-shift[s+1];
                    if(r>=0&&r<row&&c>=0&&c<col&&grid[r][c]==0&&isVisited[r][c]==false){
                        isVisited[r][c] = true;
                        adjNodes.offer(new Node(r,c,adjnode.distance+1));
                        String re = String.valueOf(r)+"+"+String.valueOf(c);
                        if(record.containsKey(re)){
                            int[] v = record.get(re);
                            v[0]++;
                            v[1] += adjnode.distance+1;
                            record.replace(re,v);
                        }
                        else{
                            int[] v = new int[2];
                            v[0] = 1;
                            v[1] = adjnode.distance+1;
                            record.put(re,v);
                        }
                    }
                }
            }
        }
        for(int[] v : record.values()){
            if(v[0]==numOfBuilding){
                min = Math.min(min,v[1]);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}

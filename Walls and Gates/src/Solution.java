
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //BFS search
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length==0||rooms[0].length==0){
            return;
        }
        else{
            for(int i = 0; i<rooms.length; i++){
                for(int j = 0; j<rooms[0].length; j++){
                    if(rooms[i][j]==0){
                        fill(rooms,i,j,0,0);
                        //Use dir to avoid reverse visit
                        //from dir: 1:up 2:down 3:left 4:right
                    }
                }
            }
        }
    }
    public void fill(int[][] rooms, int x, int y, int dis, int dir){
        if(x<0||x>=rooms.length||y<0||y>=rooms[0].length){
            return;
        }
        if(rooms[x][y]!=-1){
            if(rooms[x][y]<dis){
                //If we find we already have a smaller distance, this path can be ended
                return;
            }
            else{
                rooms[x][y] = dis;
                if(dir!=1) fill(rooms,x-1,y,dis+1,2);
                if(dir!=2) fill(rooms,x+1,y,dis+1,1);
                if(dir!=3) fill(rooms,x,y-1,dis+1,4);
                if(dir!=4) fill(rooms,x,y+1,dis+1,3);
            }
        }
    }
}

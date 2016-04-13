
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Two kinds of pattern
    //#1 Squeezing 
    //#2 Expanding
    public boolean isSelfCrossing(int[] x) {
        if(x.length<4){
            return false;
        }
        else{
            int up = x[0];
            int left = x[1];
            int down = x[0]-x[2];
            int right = x[1]-x[3];
            if(right<=0&&down>=0){
                return true;
            }
            if(right>0){
                //Squeezing pattern, then the rest should less than the pattern
                return squeeze(x, 4, up, left, down, right);
            }
            else if(right==0){//Notice this corner case
                return squeeze(x, 4, 0, left, down, right);
            }
            else{
                //Expanding pattern
                return expand(x, 4, up, left, down, right);
            }
        }
    }
    
    private boolean squeeze(int[] x, int index, int up, int left, int down, int right){
        for(int i = index; i<x.length; i++){
            int dir = i%4;
            if(dir==0){
                int p = down+x[i];
                if(p>=up){
                    return true;
                }
                else{
                    up = p;
                }
            }
            else if(dir==1){
                int p = right+x[i];
                if(p>=left){
                    return true;
                }
                else{
                    left = p;
                }
            }
            else if(dir==2){
                int p = up-x[i];
                if(p<=down){
                    //Notice the signal
                    return true;
                }
                else{
                    down = p;
                }
            }
            else{
                int p = left-x[i];
                if(p<=right){
                    return true;
                }
                else{
                    right = p;
                }
            }
        }
        return false;        
    }
    
    private boolean expand(int[] x, int index, int up, int left, int down, int right){
        int prevUp = up;
        int prevLeft = left;
        int prevDown = down;
        int prevRight = right;
        for(int i = index; i<x.length; i++){
            int dir = i%4;
            if(dir==0){
                int p = down+x[i];
                if(p<=up){
                    if(i>=8){
                        return squeeze(x, i+1, p, prevRight, down, right);
                    }
                    else{
                        if(p>=0){
                            return squeeze(x, i+1, p, 0, down, right);
                        }
                        else{
                            return squeeze(x, i+1, p, left, down, right);
                        }
                    }
                }
                else{
                    prevUp = up;
                    up = p;
                }
            }
            else if(dir==1){
                int p = right+x[i];
                if(p<=left){
                    return squeeze(x, i+1, up, p, prevUp, right);
                }
                else{
                    prevLeft = left;
                    left = p;
                }
            }
            else if(dir==2){
                int p = up-x[i];
                if(p>=down){
                    //Notice the signal
                    return squeeze(x, i+1, up, left, p, prevLeft);
                }
                else{
                    prevDown = down;
                    down = p;
                }
            }
            else{
                int p = left-x[i];
                if(p>=right){
                    return squeeze(x, i+1, prevDown, left, down, p);
                }
                else{
                    prevRight = right;
                    right = p;
                }            
            }
        }
        return false;
    }
}

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public int findCelebrity(int n) {
        if(n<=0){
            return -1;
        }    
        else if(n==1){
            return 0;
        }
        else{
            int candidate = 0;
            //First round, find candidate
            for(int i = 1; i<n; i++){
                if(knows(candidate,i)){
                    candidate = i;
                }
            }
            //Second round, check candidate
            for(int i = 0; i<n; i++){
                if(((!knows(candidate,i))&knows(i,candidate))==false&&i!=candidate){
                    return -1;
                }
            }
            return candidate;
        }
    }
    private static boolean knows(int a, int b){
    	return true;
    }
}

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		
	}
	//****This method uses game theory to solve the problem, which greatly saves the time
	//****Link:https://leetcode.com/discuss/64344/theory-matters-from-backtracking-128ms-to-dp-0ms
    public boolean canWinOptimized(String s) {
        s = s.replace('-', ' ');
        int G = 0;
        List<Integer> g = new ArrayList<>();
        for (String t : s.split("[ ]+")) {
            int p = t.length();
            if (p == 0) continue;
            while (g.size() <= p) {
                char[] x = t.toCharArray();
                int i = 0, j = g.size() - 2;
                while (i <= j)
                    x[g.get(i++) ^ g.get(j--)] = '-';
                g.add(new String(x).indexOf('+'));
            }
            G ^= g.get(p);
        }
        return G != 0;
    }
	
	//****This is a backtracking solution which consumes 2^N time complexity 
    public boolean canWin(String s) {
        if(s.length()==0){
            return false;
        }
        else{
            for(int i = 0; i<s.length()-1; i++){
                if(s.startsWith("++", i)){
                    String next = s.substring(0,i)+"--"+s.substring(i+2,s.length());
                    //Backtracking method
                    if(canWin(next)==false){
                        return true;    
                    }
                }
            }
            return false;
        }
    }
}

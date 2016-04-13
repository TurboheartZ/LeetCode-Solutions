
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words.length<2){
            return 0;
        }
        else{
            if(word1.equals(word2)){
                int min = Integer.MAX_VALUE;
                int low = -1;
                for(int i = 0; i<words.length; i++){
                    if(words[i].equals(word1)){
                        if(low!=-1){
                             min = Math.min(min,i-low);
                        }
                        low = i;
                    }
                }
                return min;
            }
            else{
                int minDist = Integer.MAX_VALUE;
                int index1 = -1;
                int index2 = -1;
                for(int i = 0; i<words.length; i++){
                    if(words[i].equals(word1)){
                        index1 = i;
                        if(index2!=-1)
                        minDist = Math.min(minDist,Math.abs(i-index2));
                    }
                    else if(words[i].equals(word2)){
                        index2 = i;
                        if(index1!=-1)
                        minDist = Math.min(minDist,Math.abs(i-index1));
                    }
                }
                return minDist;                
            }
        }
    }
}

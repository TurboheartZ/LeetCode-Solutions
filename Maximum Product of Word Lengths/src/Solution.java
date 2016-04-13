import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //****Use bitmap to denote each word, if(word[a]&word[b]==0), means two words share no common character
    //****Time complexity-->O(N^2)
    public int maxProductOptimized(String[] words) {
        if(words.length<2){
            return 0;
        }
        else{
            int[] bm = new int[words.length];
            //Construct the pseudo-bitmap
            for(int i = 0; i<words.length; i++){
                for(int j = 0; j<words[i].length(); j++){
                    bm[i] |= 1<<(words[i].charAt(j)-'a');
                }
            }
            
            //Do the calculation
            int pmax = 0;
            for(int i = 0; i<words.length-1; i++){
                for(int j = i+1; j<words.length; j++){
                    if(words[i].length()*words[j].length()>pmax){
                        //If bm[i]&bm[j]==0 means no common bits-->no common characters
                        pmax = (bm[i]&bm[j])==0?words[i].length()*words[j].length():pmax;
                    }
                }
            }
            return pmax;
        }
    }
	
	

	//****This method fails to find the way to quickly check if two words share same characters
	//****Time complexity N^3
    public int maxProduct(String[] words) {
        if(words.length<=1){
            return 0;
        }
        else{
            int pmax = 0;
            for(int i = 0; i<words.length; i++){
                int l1 = words[i].length();
                HashSet<Character> w1 = new HashSet<Character>();
                for(int k = 0; k<l1; k++){
                    w1.add(words[i].charAt(k));
                }
                for(int j = i+1; j<words.length; j++){
                    if(words[j].length()*l1>pmax){
                        boolean isUnique = true;
                        for(int m = 0; m<words[j].length(); m++){
                            if(w1.contains(words[j].charAt(m))){
                                isUnique = false;
                                break;
                            }
                        }
                        pmax = isUnique?words[j].length()*l1:pmax;
                    }
                }
            }
            return pmax;
        }
    }
}


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "the sky is blue";
		char[] input = a.toCharArray();
		reverseWords(input);
	}
    public static void reverseWords(char[] s) {
        if(s.length<=1){
            return;
        }
        else{
            //Firstly mirror the string from the middle: sky is blue-->eulb si yks
            //Use the function is faster than do this in this block
            reverseWord(s, 0, s.length-1);
            // for(int i = 0; i<s.length/2; i++){
            //     char temp =s[i];
            //     s[i] = s[s.length-1-i]; 
            //     s[s.length-1-i] = temp;
            // }
            int start = 0;
            //Secondly reverse each word:eulb-->blue
            for(int i = 0; i<s.length; i++){
                if(s[i] == ' '){
                    reverseWord(s, start, i-1);
                    start = i+1;
                }
            }
            reverseWord(s, start, s.length-1);
        }
    }
    private static void reverseWord(char[] s, int start, int end){
        if(start >= end){
            return;
        }
        else{
            for(int i = start; i<=(start+end)/2; i++){
                char temp = s[i];
                s[i] = s[end+start-i];
                s[end+start-i] = temp;
            }
            return;
        }
    }
}

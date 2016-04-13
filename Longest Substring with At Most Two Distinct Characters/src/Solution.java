import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()==0){
            return 0;
        }
        else{
            Queue<Character> c = new LinkedList<Character>();
            //Queue<Integer> index = new LinkedList<Integer>();
            char last = ' ';
            int lastIndex = 0;
            int firstIndex = 0;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(c.size()==0){
                    c.offer(ch);
                    firstIndex = i;
                    //index.offer(i);
                    max =  Math.max(max,i+1);
                }
                else if(c.size()==1){
                    if(c.peek()!=ch){
                        c.offer(ch);
                        //index.offer(i);
                        last = ch;
                        lastIndex = i;
                    }
                    //max = Math.max(max,i-index.peek()+1);
                    max = Math.max(max,i-firstIndex+1);
                }
                else if(c.size()==2){
                    if(c.contains(ch)){
                        //If so, we need change the position of the index
                        max = Math.max(max,i-firstIndex+1);
                        //max = Math.max(max,i-index.poll()+1);
                        if(ch!=last){
                            last = ch;
                            lastIndex = i;
                        }
                    }
                    else{
                        if(c.peek()==last){
                            c.clear();
                            c.offer(last);
                        }
                        else{
                            c.poll();
                        }
                        c.offer(ch);
                        last = ch;
                        firstIndex =  lastIndex;
                        lastIndex = i;
                        max = Math.max(max,i-firstIndex+1);
                    }
                }
            }
            return max;
        }
    }
}

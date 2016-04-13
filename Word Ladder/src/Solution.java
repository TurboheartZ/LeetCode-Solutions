import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String end = "cog";
		Set<String> data = new HashSet<String>();
		data.add("hot");
		data.add("dog");
		data.add("lot");
		data.add("log");
		data.add("dot");
		System.out.println(ladderLength(begin,end,data));
	}
    //Two-end BFS
    //Works like "Contains Duplicate III" which select t or k as the variable
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> begin = new HashSet<String>();
        HashSet<String> end = new HashSet<String>();
        begin.add(beginWord);
        end.add(endWord);
        int len = beginWord.length();
        int step = 0;
        while(!begin.isEmpty()&&!end.isEmpty()){
            if(begin.size()>end.size()){
                //Always make the smaller set as the begin set to reduce calculation volume
                HashSet<String> mid = begin;
                begin = end;
                end = mid;
            }
            HashSet<String> newBegin = new HashSet<String>();
            for(String x : begin){
                for(int i = 0; i<len; i++){
                    char[] chs = x.toCharArray();
                    for(char c = 'a'; c<='z'; c++){
                        //Change chs[i] from 'a' to 'z'
                        chs[i] = c;
                        String s = String.valueOf(chs);
                        if(end.contains(s)){
                            return step+1;
                        }
                        else{
                            if(wordList.contains(s)){
                                newBegin.add(s);
                                wordList.remove(s);
                            }
                        }
                    }
                }
            }
            begin = newBegin;
            step++;
        }
        return 0;
    }
}

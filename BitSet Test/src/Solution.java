import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateAbbreviations("word"));
		
	}
    private static List<String> result = new ArrayList<String>();
    public static List<String> generateAbbreviations(String word) {
        if(word.length()==0){
            return result;
        }
        else{
            backTracking(word,new StringBuilder(),0,0);
        }
        return result;
    }
    private static void backTracking(String word, StringBuilder s, int pos, int count){
        if(pos==word.length()){
            if(count!=0){
                result.add(s.append(count).toString());
            }
            else{
                result.add(s.toString());
            }
            return;
        }
        else{
            if(count==0){
            	
                backTracking(word,new StringBuilder(s.append(word.charAt(pos))),pos+1,0);
                backTracking(word,new StringBuilder(s),pos+1,1);
            }
            else{
                backTracking(word,new StringBuilder(s.append(count).append(word.charAt(pos))),pos+1,0);
                backTracking(word,new StringBuilder(s),pos+1,count+1);
            }
        }
    }
}

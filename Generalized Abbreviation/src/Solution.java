import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//****This method uses variable "count" to record the count, so that we do not need to recount.
    private List<String> result = new ArrayList<String>();
    public List<String> generateAbbreviationsOptimized(String word) {
        if(word.length()==0){
            result.add("");
            return result;
        }
        else{
            backTracking(word,"",0,0);
        }
        return result;
    }
    //****Use variable "count" to record the count, so that we do not need to recount.
    private void backTracking(String word, String s, int pos, int count){
        if(pos==word.length()){
            if(count!=0){
                result.add(s+count);
                //Do not forget to check if count>0, if count>0, we need to append that to the string
            }
            else{
                result.add(s);
            }
            return;
        }
        else{
            if(count==0){
                backTracking(word,s+word.charAt(pos),pos+1,0);
            }
            else{
                backTracking(word,s+count+word.charAt(pos),pos+1,0);
            }
            backTracking(word,s,pos+1,count+1);
        }
    }
	
	
	
	//****This method we need to recalculate the number of abbreviated characters which consumes time
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        if(word.length()==0){
            result.add(word);
            return result;
        }
        else{
            result.add("1");
            result.add(word.substring(0,1));
            for(int i = 1; i<word.length(); i++){
                List<String> c =  new ArrayList<String>();
                List<String> n = new ArrayList<String>();
                for(String x : result){
                    c.add(x+word.charAt(i));
                    n.add(numString(x));
                }
                result.clear();
                result.addAll(c);
                result.addAll(n);
            }
            return result;
        }
    }
    private String numString(String s){
        if(s.length()==0){
            return s+"1";
        }
        String x = "";
        int i;
        for(i = s.length()-1; i>=0; i--){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){//Check if we need carry-in
                x = s.charAt(i)+x;
            }
            else{
                break;
            }
        }
        if(i==s.length()-1){
            return s+"1";
        }
        return s.substring(0,i+1)+String.valueOf(Integer.valueOf(x)+1);
    }
}

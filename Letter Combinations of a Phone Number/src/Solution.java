import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = (char)('a'+1);
	}
    //If there is 0 or 1 during the searching process, we need back track and remove the prev results
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        int length = digits.length();
        if(length<1){
            return result;
        }
        else{
            return toCombination(digits,"",0);
        }
    }
    private static List<String> toCombination(String s, String prev, int index){
        List<String> result = new ArrayList<String>();
        char c = s.charAt(index);
        int ci = isValid(c);
        if(ci==-1){
            return result;
        }
        else{
            int limit = ci==7||ci==9?4:3;
            for(int i=0; i<limit; i++){
                char cc;
                {
                    if(ci<7){
                        cc = (char)('a'+(ci-2)*3+i);
                    }
                    else if(ci==7){
                        cc = (char)('p'+i);
                    }
                    else if(ci==8){
                        cc = (char)('t'+i);
                    }
                    else{
                        cc = (char)('w'+i);
                    }
                }
                String cur = prev.concat(String.valueOf(cc));
                if(index+1<s.length()){
                    List<String> lst = toCombination(s,cur,index+1);
                    if(lst.size()==0){
                        break;
                    }
                    else{
                        result.addAll(lst);
                    }
                }
                else{
                    result.add(cur);
                }
            }
            return result;
        }
        
    }
    private static int isValid(char c){
        int result = -1;
        int r = c-'0';
        if(r>=2&&r<=9){
            result = r;
        }
        return result;
    }
}

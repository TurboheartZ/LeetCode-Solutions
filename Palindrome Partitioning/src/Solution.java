import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		System.out.println(partition(s));
	}
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        int length = s.length();
        if(length==0){
            return result;
        }
        else{
            for(int i = 1; i<=length; i++){
                String m = s.substring(0,i);
                if(isPalindrome(m)==true){
                    List<List<String>> lst = partition(s.substring(i,length));
                    if(lst.size()<1){
                        List<String> newlst = new ArrayList<String>();
                        newlst.add(m);
                        result.add(newlst);
                    }
                    else{
                        for(int j = 0; j<lst.size(); j++){
                            List<String> newlst = new ArrayList<String>();
                            newlst.add(m);
                            newlst.addAll(lst.get(j));
                            result.add(newlst);
                        }                        
                    }
                }
            }
            return result;
        }        
    }
    private static boolean isPalindrome(String input){
        int length = input.length();
        if(length<=1){
            return true;
        }
        else{
            boolean result = true;
            for(int i = 0; i<=length/2; i++){
                if(input.charAt(i)!=input.charAt(length-1-i)){
                    result = false;
                    break;
                }
            }
            return result;
        }
    }
}

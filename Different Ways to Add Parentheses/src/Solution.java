import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "1+2*3-4*6*4";
		System.out.println(diffWaysToCompute(input));
	}
    //Use recursive Divide&Conquer to solve this problem
    public static List<Integer> diffWaysToCompute(String input) {
        return partition(input); 
    }
    private static List<Integer> partition(String input){
        List<Integer> result = new ArrayList<Integer>();
        int length = input.length();
        if(length<1){
            return result;
        }
        else{
            if((!input.contains("+"))&&(!input.contains("-"))&&(!input.contains("*"))){
                result.add(Integer.valueOf(input));
                return result;
            }
            else{
                for(int i = 0; i<length; i++){
                    if(input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'){
                        List<Integer> left = partition(input.substring(0,i));
                        List<Integer> right = partition(input.substring(i+1,length));
                        for(int leftvalue : left){
                            for(int rightvalue : right){
                                 int value = input.charAt(i)=='+'?leftvalue+rightvalue:input.charAt(i)=='-'?leftvalue-rightvalue:leftvalue*rightvalue;
                                result.add(value);
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}

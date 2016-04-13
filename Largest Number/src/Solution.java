import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {"5","54","52","67","68","5","52","17","93","53"};
		int[] input = {1,5,5,52,52,53,53,54,6,8};
		System.out.println(largestNumber(input));		
	}
    public static String largestNumber(int[] nums) {
        if(nums.length<1){
        	return "";
        }
        else{
        	Comparator<String> comp = new Comparator<String>(){//Use customized comparator 
            	//@Override
            	public int compare(String a, String b){
            		return (a+b).compareTo((b+a));
            	}
            };
            String[] data = new String[nums.length];
            for(int i = 0; i<nums.length; i++){
            	data[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(data,comp);
            String res ="";
            if(data[nums.length-1].equals("0")) return "0";
            else{
            	for(int i = data.length-1; i>=0; i--){
            		res+=data[i];
            	}
            	return res;
            }
        }
    }
}

import java.math.BigInteger;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("4","5"));
	}
	//*****This is a tricky solution
//    public static String multiply(String num1, String num2) {
//        BigInteger a = new BigInteger(num1);
//        BigInteger b = new BigInteger(num2);
//        BigInteger c = a.multiply(b);
//        return c.toString();
//    }
	
	
	//I would like to use string manipulation to solve this problem
    public static String multiply(String num1, String num2) {
        int[] data1 = new int[num1.length()];
        int[] data2 = new int[num2.length()];
        int[] result = new int[num1.length()+num2.length()];
        //First get the integer value of the  number
        for(int i = 0; i<num1.length(); i++){
            data1[i] = num1.charAt(i)-'0';
        }
        for(int i = 0; i<num2.length(); i++){
            data2[i] = num2.charAt(i)-'0';
        }
        //Start to multiply
        for(int i = num2.length()-1; i>=0; i--){
            for(int j = num1.length()-1; j>=0; j--){
                result[i+j+1] = data1[j]*data2[i]+result[i+j+1];
            }
        }
        for(int i = result.length-1;i>0;i--){
            if(result[i]>=10){
                result[i-1] += result[i]/10;
                result[i] = result[i]%10;
            }
        }
        int begin = -1;
        for(int i = 0; i<result.length; i++){
            if(result[i]>0){
                begin = i;
                break;
            }
        }
        if(begin==-1){
            return "0";
        }
        else{
            StringBuffer mul = new StringBuffer();
            for(int i = begin; i<result.length; i++){
                mul.append((char)(result[i]+48));
            }
            return mul.toString();            
        }
    }	
}

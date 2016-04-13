import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("DCXXI"));
	}
	/*罗马数字是阿拉伯数字传入之前使用的一种数码。罗马数字采用七个罗马字母作数字、即Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）。记数的方法：
	    相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
	    小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
	    小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
	    在一个数的上面画一条横线，表示这个数增值 1,000 倍*/
	
    public static int romanToInt(String s) {
        HashMap<Character,Integer> mp = new HashMap<Character,Integer>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('C',100);
        mp.put('X',10);
        mp.put('M',1000);
        mp.put('L',50);
        mp.put('D',500);
        int len = s.length();
        if(len==0){
            return 0;
        }
        else{
            char[] num = s.toCharArray();
            int result = 0;
            int large = 0;
            for(int i = len-1; i>=0; i--){
                int n = mp.get(num[i]);
                if(n>=large){
                    result += n;
                    large = n;
                }
                else{
                    result -= n;
                }
            }
            return result;
        }
    }
}


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Numbers like 40(XL), 4(IV) only the first left number can be regarded as reduction
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        if(num<=0){
            return "";
        }
        else{
            int t = num/1000;
            for(int i =0; i<t; i++){
                result.append("M");
            }
            num -= t*1000;
            int h = num/100;
            num -= h*100;
            if(h==9){
                result.append("C");
                result.append("M");
            }
            else if(h>=5){
                result.append("D");
                for(int i = 0; i<h-5; i++){
                    result.append("C");
                }
            }
            else if(h==4){
                result.append("C");
                result.append("D");
            }
            else{
                for(int i = 0; i<h; i++){
                    result.append("C");
                }
            }
            int ten = num/10;
            num -= ten*10;
            if(ten==9){
                result.append("X");
                result.append("C");
            }
            else if(ten>=5){
                result.append("L");
                for(int i = 0; i<ten-5; i++){
                    result.append("X");
                }
            }
            else if(ten==4){
                result.append("X");
                result.append("L");
            }
            else{
                for(int i = 0; i<ten; i++){
                    result.append("X");
                }
            }
            int one = num;
            if(one==9){
                result.append("I");
                result.append("X");
            }
            else if(one>=5){
                result.append("V");
                for(int i = 0; i<one-5; i++){
                    result.append("I");
                }
            }
            else if(one==4){
                result.append("I");
                result.append("V");
            }
            else{
                for(int i = 0; i<one; i++){
                    result.append("I");
                }
            }
            return result.toString();
        }
    }
}

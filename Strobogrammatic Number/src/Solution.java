
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isStrobogrammatic(String num) {
        if(num.length()==0){
            return true;
            //Error input check
        }
        //Only 0,1,6,8,9 can satisfy the requirements but we need to know that 6 and 9 appear in pairs
        else{
            int len = num.length();
            int mid = len/2;
            boolean result = true;
            for(int i = 0; i<=mid; i++){
                if(num.charAt(i)=='0'||num.charAt(i)=='1'||num.charAt(i)=='8'){
                    if(num.charAt(len-1-i)==num.charAt(i)){
                        continue;
                    }
                    else{
                        result = false;
                        break;
                    }
                }
                else if(num.charAt(i)=='6'){
                    if(num.charAt(len-1-i)=='9'){
                        continue;
                    }
                    else{
                        result = false;
                        break;
                    }
                }
                else if(num.charAt(i)=='9'){
                    if(num.charAt(len-1-i)=='6'){
                        continue;
                    }
                    else{
                        result = false;
                        break;
                    }
                }
                else{
                    result = false;
                    break;
                }
            }
            return result;
        }
    }
}


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //One edit distance: change a into b with one operation only, the operation can be either delete or insert or replace
    public boolean isOneEditDistance(String s, String t) {
        int sLen =  s.length();
        int tLen = t.length();
        if(Math.abs(sLen-tLen)>1){
            return false;
        }
        else{
            boolean changed = false;
            int sIndex = 0;
            int tIndex = 0;
            while(sIndex<sLen&&tIndex<tLen){
                if(s.charAt(sIndex)!=t.charAt(tIndex)){
                    if(changed){
                        return false;
                    }
                    else{
                        changed = true;
                        if(sLen==tLen){
                            sIndex++;
                            tIndex++;
                        }
                        else if(sLen>tLen){
                        //If sLen>tLen, it must be String t that inserts an element, so that we simulate the insertion by increase sIndex
                            sIndex++;
                        }
                        else{
                        //Same as above    
                            tIndex++;
                        }
                    }
                }
                else{
                    sIndex++;
                    tIndex++;
                }
            }
            //Remeber to include the situation that the edit happens at the very last position of the Strings
            if(changed==false&&Math.abs(sLen-tLen)==1||changed==true){
                return true;
            }
            else{
                return false;
            }
        }
    }
}

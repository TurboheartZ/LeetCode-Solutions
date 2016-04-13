
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Solve this problem in iterative ways
    //When we reach the index, the combinations can be formed by two part
    //Part#1: The combinations of the previous index-1 chars tailed with char[index]
    //Part#2: The combinations of the previous index-2 chars tailed with the combination of char(s[index-1]*10+s[index])
    public static int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        else{
            char[] st = s.toCharArray();
            if(st[0]=='0'){
                return 0;
            }
            int[] count = new int[st.length];
            count[0] = 1;
            for(int i= 1; i<st.length; i++){
                if(st[i]!='0')//Corner case#1: "0"
                count[i] = count[i-1];
                if(i-2>=-1){
                    int sum = (st[i-1]-'0')*10+st[i]-'0';
                    if(sum<=26&&st[i-1]!='0'){//Corner case#2 : "100" or "101"
                        if(i-2>=0)
                        count[i] += count[i-2];
                        else
                        count[i] += 1;
                    }
                }
                if(count[i]==0){
                    return 0;
                }
            }
            return count[st.length-1];
        }
    }
}

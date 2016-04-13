
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("ccc"));
	}
	
	//Optimal Solution using Manacher Algorithm****
    //Try to use Manacher Algorithm to solve this problem
    //Manacher Algorithm take the advantages of palindrome
    //There are two situations:
    //#1: mx>i ---> p[i] = (i+p[2*id-i]<mx)? p[2*id-i] : (mx-i+additional calculations)
    //#2: mx<=i --> 1+additional calculations
    public String longestPalindromeOptimized(String s) {
        int len = s.length();
        if(len==0){
            return s;
        }
        else{
            int lt = 2*(len+1);
            char[] str = s.toCharArray();
            char[] arr = new char[lt];
            int[] p = new int[lt];
            int id = 0;
            int mx = 0;
            int max = 0;
            int location = 0;
            //First build the char array
            arr[0] = '$';//Use this to avoid pointer exception
            arr[1] = '#';
            for(int i = 0; i<len; i++){
                int index = (i+1)*2;
                arr[index] = str[i];
                arr[index+1] = '#';
            }
            //Start to fill p array;
            for(int i = 1; i<lt; i++){
                if(mx>i){
                    p[i] = (i+p[2*id-i])<mx? p[2*id-i] : mx-i;
                }
                else{
                    p[i] = 1;
                }
                while(i-p[i]>=0&&i+p[i]<lt&&arr[i-p[i]]==arr[i+p[i]]){
                    p[i]++;
                }
                if(i+p[i]>mx){
                    id = i;
                    mx = i+p[i];
                }
                if(p[i]>max){
                    max = p[i];
                    location = i;
                }
            }
            StringBuilder result = new StringBuilder();
            for(int i = location-max+1; i<location+max; i++){
                if(arr[i]!='#'&&arr[i]!='$'){
                    result.append(arr[i]);
                }
            }
            return result.toString();
        }
    }	
	
	
	
	
	
	//****This method takes O(N^2) time complexity
    //The center-aligned substring of the a palindromic string is also a palindromic one
    public static String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        else{
            String max = "";
            for(int i = 0; i<s.length(); i++){
            	if(max.length()>(s.length()-i-1)*2) break; //Saves time
                if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)){
                    int flag = 0;
                    int j;
                    for(j = 1;i-j>=0&&i+1+j<s.length(); j++){
                        if(s.charAt(i-j)==s.charAt(i+1+j)){
                            flag = 1;
                        }
                        else{
                            break;
                        }
                    }
                    int len = flag==0?2:j*2;
                    if(len>max.length()){
                        max = s.substring(i-j+1,i+j+1);
                    }
                }
                if(i+2<s.length()&&s.charAt(i)==s.charAt(i+2)){
                    int flag = 0;
                    int j;
                    for(j = 1;i-j>=0&&i+2+j<s.length(); j++){
                        if(s.charAt(i-j)==s.charAt(i+2+j)){
                            flag = 1;
                        }
                        else{
                            break;
                        }
                    }
                    int len = flag==0?3:j*2+1;
                    if(len>max.length()){
                        max = s.substring(i-j+1,i+j+2);
                    }
                }                
            }
            return max;
        }
    }
}

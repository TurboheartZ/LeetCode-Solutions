import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		char[] input= {'a','1','4','b','2','c','d','e','3','4','5'};//Successive ints and chars
		System.out.println(longestSub(input));
	}
	public static String longestSub(char[] s){
		if(s.length==0){
			return "";
		}
		else{
			int[] c = new int[2];//Record the start and end of character string
			Arrays.fill(c, -1);
			int[] d = new int[2];//Record the start and end of integer string
			Arrays.fill(d, -1);
			int flag = 0;//Indicate character(1) of integer(-1)
			String max = "";
			for(int i  = 0; i<s.length; i++){
				if(isChar(s[i])==true){
					if(flag==1){
						c[1] = i;
					}
					else if(flag==0){
						c[0] = i;
						flag = 1;
					}
					else{
						//Check if we have char string before this integer substring
						//If we have, update 
						if(c[0]!=-1){
							int subLen = Math.min(c[1]-c[0], d[1]-d[0])+1;
							max = 2*subLen>max.length()?String.valueOf(s, c[1]-subLen+1, 2*subLen):max;
							c[0] = i;
							c[1] = i;
							flag = 1;
						}
						else{
							c[0] = i;
							c[1] = i;
							flag = 1;
						}
					}
				}
				else{
					//This is a char
					if(flag==-1){
						d[1] = i;
					}
					else if(flag==0){
						d[0] = i;
						flag = -1;
					}
					else{
						//Check if we have char integer before this char substring
						//If we have, update 
						if(d[0]!=-1){
							int subLen = Math.min(c[1]-c[0], d[1]-d[0])+1;
							max = 2*subLen>max.length()?String.valueOf(s, d[1]-subLen+1, 2*subLen):max;
							d[0] = i;
							d[1] = i;
							flag = -1;
						}
						else{
							d[0] = i;
							d[1] = i;
							flag = -1;
						}
					}
				}
			}
			//Final update
			int subLen = Math.min(c[1]-c[0], d[1]-d[0])+1;
			int mid = Math.max(c[0], d[0])-1;
			max = 2*subLen>max.length()?String.valueOf(s, mid-subLen+1, 2*subLen):max;
			return max;
		}
	}
	private static boolean isChar(char input){
		return ((input-'a'>=0&&input-'a'<26)||(input-'A'>=0&&input-'A'<26))?true:false;
	}
}

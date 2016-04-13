import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "25525511135";
		System.out.println(restoreIpAddresses(s));
	}
    //DFS and avoid non-necessary DFS
    private static List<String> result = new ArrayList<String>();
    
    public static List<String> restoreIpAddresses(String s) {
        if(s.length()==0||s.length()>12){
            return result;
        }
        char[] data = s.toCharArray();
        DFS(data, 0, 1, 0, new StringBuilder());
        return result;
    }
    
    private static void DFS(char[] data, int index, int bit, int dot, StringBuilder ip){
        if(index==data.length){
            result.add(ip.toString());
            return;
        }
        else{
            int len = data.length;
            int rem = len-index-1;
            if(dot<=2){
                int min = 3-dot;
                int max = (3-dot)*3;
                if(bit==1){
                    if(rem>=min&rem<=max+2){
                        ip.append(data[index]);
                        DFS(data, index+1, 2, dot, ip);
                        ip.deleteCharAt(ip.length()-1);
                    }
                    return;
                }
                else if(bit==2){
                    if(rem+1>=min&&rem+1<=max){
                        ip.append(".");//Option#1, add a dot;
                        DFS(data, index, 1, dot+1, ip);
                        ip.deleteCharAt(ip.length()-1);
                    }
                    if(rem>=min&&rem<=max+1){
                        if(data[index-1]=='0'){
                            return;
                        }
                        ip.append(data[index]);
                        DFS(data, index+1, 3, dot, ip);
                        ip.deleteCharAt(ip.length()-1);
                    }
                    return;
                }
                else{
                    if(rem+1>=min&&rem+1<=max){
                        ip.append(".");//Option#1, add a dot;
                        DFS(data, index, 1, dot+1, ip);
                        ip.deleteCharAt(ip.length()-1);
                    }
                    if(rem>=min&&rem<=max){
                        int prev = Integer.valueOf(ip.substring(ip.length()-2,ip.length()));
                        if(prev<=24||(prev==25&&(data[index]-'0'<=5))){
                            ip.append(data[index]);
                            ip.append(".");
                            DFS(data, index+1, 1, dot+1, ip);
                            ip.deleteCharAt(ip.length()-1);
                            ip.deleteCharAt(ip.length()-1);
                        }
                    }
                    return;                    
                }
            }
            else if(dot==3){
                if(bit==1){
                    ip.append(data[index]);
                    DFS(data, index+1, 2, dot, ip);
                    ip.deleteCharAt(ip.length()-1); 
                    return;
                }
                else if(bit==2){
                    if(data[index-1]=='0'){//Avoid the situation of "XXX.01" or "XXX.00"
                        return;
                    }                    
                    ip.append(data[index]);
                    DFS(data, index+1, 3, dot, ip);
                    ip.deleteCharAt(ip.length()-1); 
                    return;                    
                }
                else{
                    int prev = Integer.valueOf(ip.substring(ip.length()-2,ip.length()));
                    if(prev<=24||(prev==25&&(data[index]-'0'<=5))){
                        ip.append(data[index]);
                        DFS(data, index+1, 1, dot+1, ip);
                        ip.deleteCharAt(ip.length()-1);
                    }                    
                    return;
                }
            }
        }
    }
}

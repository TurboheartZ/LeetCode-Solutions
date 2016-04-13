import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generatePalindromes("abba"));
//		List<Character> data = new ArrayList<Character>();
//		data.add('b');
//		data.add('a');
//		data.sort(new Comparator<Character>(){
//			@Override
//			public int compare(Character a, Character b){
//				return a>b?1:a==b?0:-1;
//			}
//		});
//		
//		System.out.println(r.length());
		
	}
    //First we check if it can form a palindrome permutation
    //Then we divide it into a half and do the permutation
    public static List<String> generatePalindromes(String s) {
        if(s.length()==0){
            return new ArrayList<String>();
        }
        HashSet<Character> filter = new HashSet<Character>();
        List<Character> container = new ArrayList<Character>();
        List<String> res = new ArrayList<String>();
        for(int i = 0; i<s.length(); i++){
            char x = s.charAt(i);
            if(filter.contains(x)){
                container.add(x);
                filter.remove(x);
            }
            else{
                filter.add(x);
            }
        }
        //Sort the list
		container.sort(new Comparator<Character>(){
			@Override
			public int compare(Character a, Character b){
				return a>b?1:a==b?0:-1;
			}
		});
        if(filter.size()>1){
            return res;
        }
        else{
            String last = "";
            if(filter.size()==1){
                for(char x : filter){
                    last += x;
                }
            }
            boolean[] visited = new boolean[container.size()];
            StringBuffer bufft = new StringBuffer();
            DFS(container,res,new StringBuffer(),visited,last);
            return res;
        }
    }
    private static void DFS(List<Character> container,List<String> res, StringBuffer buff, boolean[] visited, String last){
        if(buff.length()==container.size()){
        	res.add(buff.toString()+last+buff.reverse().toString());
        	buff.reverse();
        	return;
        }
        else{
            for(int i = 0; i<container.size(); i++){
                if(visited[i]==true) continue;
                else if(i>=1&&container.get(i)==container.get(i-1)&&visited[i-1]==false) continue;
                else{
                    //StringBuffer newbuff = new StringBuffer(buff);
                    char x = container.get(i);
                    visited[i] = true;
                    buff.append(x);
                    //newbuff.append(x);
                    DFS(container,res,buff,visited,last);
                    visited[i] = false;
                    buff.deleteCharAt(buff.length()-1);
                }
            }
        }
    }
}

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"wrt","wrf","er","ett","rftt"};
		String[] input2 = {"a","b","a"};
		String[] input3 = {"za","zb","ca","cb"};
		System.out.println(alienOrder(input3));
	}
    //Use HashMap<Character,List<Character>> graph to denote the graph, the list only contains the outward nodes
    public static String alienOrder(String[] words) {
        if(words.length==0){
            return "";
        }
        else if(words.length==1){
            return words[0];
        }
        else{
            HashMap<Character,HashSet<Character>> graph = new HashMap<Character,HashSet<Character>>();
            //Use this array to denote each node's indegree
            int[] indegree = new int[26];
            Arrays.fill(indegree,-1);
            //****Initialize indegree array, '0' means exits****
            for(String x : words){
                for(char c : x.toCharArray()){
                    indegree[c-'a'] = 0;
                }
            }
            int first = 0;
            int second = 1;
            //****Build the graph****
            while(second<words.length){
                int minLen = Math.min(words[first].length(),words[second].length());
                for(int i = 0; i<minLen; i++){
                    char f = words[first].charAt(i);
                    char s = words[second].charAt(i);
                    if(f!=s){
                        if(graph.containsKey(s)==true){
                            HashSet<Character> hs = graph.get(s);
                            if(hs.contains(f)==false){
                                indegree[f-'a']++;
                                hs.add(f);
                                graph.replace(s,hs);
                            }
                        }
                        else{
                            HashSet<Character> hs = new HashSet<Character>();
                            hs.add(f);
                            graph.put(s,hs);
                            indegree[f-'a']++;
                        }
                        break;
                    }
                }
                first++;
                second++;
            }
            StringBuilder result = new StringBuilder();
            Queue<Character> topo = new LinkedList<Character>();
            int numOfChar = 0;
            for(int i = 0; i<26; i++){
                if(indegree[i]>=0){
                    numOfChar++;
                    if(indegree[i]==0){
                        topo.offer((char)('a'+i));
                    }                    
                }
            }
            if(topo.size()==0){
                return "";
                //Means circle exits
            }
            while(topo.size()>0){
                char c = topo.poll();
                result.append(c);
                if(graph.containsKey(c)==false){
                	continue;
                }
                HashSet<Character> hs = graph.get(c);
                for(char x : hs){
                    indegree[x-'a']--;
                    if(indegree[x-'a']<0){
                        return "";
                    }
                    else if(indegree[x-'a']==0){
                        topo.offer(x);
                    }
                }
            }
            return result.reverse().toString();
            //return result.length()==numOfChar?result.reverse().toString():"HAHA";
        }
    }
}

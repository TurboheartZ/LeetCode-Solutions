import java.util.*;
class graphNode{
    public char val;
    public int indgree = 0;
    public List<Character> output = new ArrayList<Character>();
    public graphNode(char c){
        this.val = c;
    }
    public void outNode(char c){
        output.add(c);
    }
}
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"wrt","wrf","er","ett","rftt"};
		String[] input2 = {"ac","ab","ac"};
		System.out.println(alienOrder(input));
		HashSet<Integer> a = new HashSet<Integer>();
		StringBuilder cc = new StringBuilder();
		
		
	}
    private static List<String> order =  new ArrayList<String>();
    //****Do topology sort
    public static String alienOrder(String[] words) {
        if(words.length==0){
            return "";
        }
        else{
            String ord = constructOrder(Arrays.asList(words));
            if(ord.length()>0){
                order.add(ord);
            }  
        }
        if(order.size()==0){
            return "";
        }
        String result = "";
        HashMap<Character,graphNode> record = new HashMap<Character,graphNode>();        
        for(String x:order){
        	if(x.length()>1){
            	char large = x.charAt(0);
            	char small = ' ';
            	for(int i = 1; i<x.length(); i++){
            		 small = x.charAt(i);
            		 if(record.containsKey(large)){
            			 graphNode n = record.get(large);
            			 n.indgree++;
            			 record.replace(large, n);
            		 }
            		 else{
            			 graphNode n = new graphNode(large);
            			 n.indgree++;
            			 record.put(large, n);
            		 }
            		 if(record.containsKey(small)){
            			 graphNode n = record.get(small);
            			 n.output.add(large);
            			 record.replace(small, n);
            		 }
            		 else{
            			 graphNode n = new graphNode(small);
            			 n.output.add(large);
            			 record.put(small, n);
            		 }
            		 large = small;
            	}
        	}
        	else if(x.length()==1){
        	    if(x.equals("1")){
        	        return "";
        	    }
        		if(record.containsKey(x.charAt(0))==false){
        			graphNode n = new graphNode(x.charAt(0));
        			record.put(x.charAt(0), n);
        		}
        	}
        }
        Queue<graphNode> indegreeQueue = new LinkedList<graphNode>();
        for(graphNode x : record.values()){
        	if(x.indgree==0){
        		indegreeQueue.offer(x);
        	}
        }        
        while(indegreeQueue.size()>0){
        	graphNode n = indegreeQueue.poll();
        	record.remove(n.val);
        	result = n.val+result;
        	for(char x : n.output){
        		if(record.containsKey(x)==false){
        			return "";
        		}
        		else{
        			graphNode t = record.get(x);
        			t.indgree--;
        			if(t.indgree>0){
        				record.replace(x, t);
        			}
        			else{
        				indegreeQueue.offer(t);
        			}
        		}
        	}
        }
        return record.isEmpty()==true?result:"";
    }
    //****Build the order of characters
    private static String constructOrder(List<String> words){
        if(words.size()==0){
            return "";
        }
        char first = ' ';
        StringBuilder result = new StringBuilder();
        List<String> data =  new ArrayList();
        for(int i = 0; i<words.size(); i++){
            String s = words.get(i);
            if(s.length()!=0){
                if(s.charAt(0)==first){
                    String n = s.substring(1,s.length());
                    if(n.length()>0){
                        data.add(n);
                    }
                }
                else{
                    if(data.size()>0){
                        String ord = constructOrder(data);
                        if(ord.length()>0){
                            order.add(ord);
                        }
                        data = new ArrayList<String>();
                    }
                    String n = s.substring(1,s.length());
                    if(n.length()>0){
                        data.add(n);
                    }                        
                    first = s.charAt(0);
                    if(result.indexOf(String.valueOf(first))!=-1){
                        return "1";
                    }
                    result.append(first);
                }
            }
        }
        if(data.size()>0){
        	String ord = constructOrder(data);
            if(ord.length()>0){
                order.add(ord);
            }
        }
        return result.toString();
    }
}

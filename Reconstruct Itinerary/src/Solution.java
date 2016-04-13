import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] input = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		System.out.println(findItinerary(input));
	}
    public static List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        if(tickets.length==0||tickets[0].length==0){
            return result;
        }
        else{
            HashMap<String, PriorityQueue<String>> data = new HashMap<String, PriorityQueue<String>>();
            for(String[] x : tickets){
                if(data.containsKey(x[0])){
                    PriorityQueue<String> s = data.get(x[0]);
                    s.offer(x[1]);
                    data.replace(x[0],s);
                }
                else{
                    PriorityQueue<String> s = new PriorityQueue<String>();
                    s.offer(x[1]);
                    data.put(x[0],s);
                }
            }
            if(data.containsKey("JFK")){
                String cur = "JFK";
                Stack<String> prevS = new Stack<String>();
                for(int i = 0; i<tickets.length; i++){
                	while(!data.containsKey(cur)||data.get(cur).isEmpty()){
                		prevS.push(cur);
                		cur = result.remove(result.size()-1);
                	}
                	result.add(cur);
                	PriorityQueue<String> s = data.get(cur);
                	cur = s.poll();
                }
                result.add(cur);
                while(prevS.isEmpty()==false){
                	result.add(prevS.pop());
                }
            }
            return result;
        }
    }
}

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashMap<String, List<String>> fill = new HashMap<String, List<String>>();
	}
    public static List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> result = new LinkedList<List<String>>();
    	int len = strs.length;
    	if(len>0){
    		Arrays.sort(strs);
    		int i = 0;
    		HashMap<String,Integer> filter = new HashMap<String,Integer>();
    		for (String item:strs){
    			char[] data = item.toCharArray();
    			Arrays.sort(data);
    			String newData = String.valueOf(data);
    			if(filter.get(newData)==null){
    				LinkedList<String> newList = new LinkedList<String>();
    				newList.add(item);
    				result.add(newList);
    				filter.put(newData, i);
    				i++;    				
    			}
    			else{
    				int index = filter.get(newData);
    				result.get(index).add(item);
    			}
    		}
    	}
    	return result;         
    }
}

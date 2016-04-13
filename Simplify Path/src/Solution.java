import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String simplifyPath(String path) {
	    Stack<String> stack = new Stack<String>();
	    char[] chars = path.toCharArray(); // convert to char array, but it's not mandatory
	    String folder = "";
	    for(int i=-1, L=chars.length; i<=L; i++) {
	        if(i==-1 || i==L || chars[i]=='/') { // add an imaginary "/" at the beginning and end of the previous path
	            if(folder.equals("..")) {
	                if(!stack.isEmpty()) 
	                    stack.pop();
	            }
	            else if(!"".equals(folder) && !".".equals(folder)) 
	                stack.push(folder);
	            folder = "";
	        }
	        else {
	            folder += chars[i];
	        }
	    }

	    while(!stack.isEmpty())
	        folder = "/" + stack.pop() + folder;

	    return folder.equals("") ? "/" : folder;
	}
}

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "9,34,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(isValidSerialization(input));
	}
    public static boolean isValidSerialization(String preorder) {
        //We can use stack structure to do the DFS
        if(preorder==null){
            return false;
            //Since a blank tree is denoted as "#"
        }
        else{
            //Every time we meet # and #, we pop them out and pop its parent out and change it into # which means we have searched this tree
            Stack<String> container = new Stack<String>();
            int i = 0;
            for(i = 0; i<preorder.length(); i++){
                if(preorder.charAt(i)=='#'){
                    while(container.isEmpty()==false&&container.peek().equals("#")){
                        container.pop();
                        if(container.isEmpty()==true){
                            break;
                        }
                        else{
                            container.pop();
                        }
                    }
                    container.push("#");
                }
                else if(preorder.charAt(i)!=','){
                    int count = 0;
                    while(preorder.charAt(i)!=','){//Consider multi-digits number
                        count = count*10 + preorder.charAt(i)-'0';
                        i++;
                        if(i>=preorder.length()){
                            break;
                        }
                    }
                    container.push(String.valueOf(count));
                    //i--;
                }
                if(container.size()==1&&container.peek().equals("#")){
                    break;
                }
            }
            return (container.size()==1&&container.pop().equals("#")&&i>=preorder.length()-1);
        }
    }
}

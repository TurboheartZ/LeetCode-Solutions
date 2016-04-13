import java.util.*;

class TrieNode{
    char content;
    boolean isEnd;
    TrieNode[] childNodes = new TrieNode[26];
    public TrieNode(char c){
        this.content = c;
    }
    public TrieNode findChild(char c){
        return childNodes[c-'a'];
    }
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    //We can use build a Prefix Tree according to the given words
    //So that we can eliminate duplicated searching for those words with same prefix
    private HashSet<String> result = new HashSet<String>();
    private int maxLen = Integer.MIN_VALUE;
    
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length==0||board[0].length==0||words.length==0){
            return new ArrayList<String>(result);
        }
        else{
            TrieNode root = buildTrie(words);
            boolean[][] visited = new boolean[board.length][board[0].length];
            for(int i = 0; i<board.length; i++){
                for(int j = 0; j<board[0].length; j++){
                    searchWords(board, visited, root, i, j, "");
                }
            }
            return new ArrayList<String>(result);
        }
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode(' ');
        for(String x : words){
            TrieNode current = root;
            int len = x.length();
            maxLen = Math.max(len,maxLen);
            for(int i = 0; i<len; i++){
                char c = x.charAt(i);
                TrieNode next = current.findChild(c);
                if(next==null){
                    next = new TrieNode(c);
                    current.childNodes[c-'a'] = next;
                }
                current = next;
            }
            current.isEnd = true;
        }
        return root;
    }
    
    private void searchWords(char[][] board, boolean[][] visited, TrieNode root, int x, int y, String s){
        int row = board.length;
        int col = board[0].length;
        char c = board[x][y];
        TrieNode next = root.findChild(c);
        if(next==null){
            return;
        }
        else{
            //If we use StringBuilder, it will be static among differend level of executions
            String ss = s+c;
            visited[x][y] = true;
            if(next.isEnd){
                result.add(ss);
            }
            //Do further BFS
            if(s.length()<maxLen){
                if(x-1>=0&&!visited[x-1][y]){
                    searchWords(board, visited, next, x-1, y, ss);
                }
                if(x+1<row&&!visited[x+1][y]){
                    searchWords(board, visited, next, x+1, y, ss);
                }
                if(y-1>=0&&!visited[x][y-1]){
                    searchWords(board, visited, next, x, y-1, ss);
                }
                if(y+1<col&&!visited[x][y+1]){
                    searchWords(board, visited, next, x, y+1, ss);
                }                
            }
            visited[x][y] = false;
            return;
        }
    }
}

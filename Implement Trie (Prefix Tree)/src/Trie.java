import java.util.*;
class TrieNode {
    // Initialize your data structure here.
    char content;
    boolean isEnd;
    List<TrieNode> childNodes;
    public TrieNode(char c) {
        this.content = c;
        this.childNodes = new ArrayList<TrieNode>();
    }
    public TrieNode findNode(char c){
        if(childNodes.size()==0){
            return null;
        }
        for(TrieNode x : childNodes){
            if(x.content==c){
                return x;
            }
        }
        return null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(search(word)){
            return;
        }
        int len = word.length();
        TrieNode current = root;
        for(int i = 0; i<len; i++){
            char c = word.charAt(i);
            TrieNode next = current.findNode(c);
            if(next==null){
                TrieNode newNode = new TrieNode(c);
                current.childNodes.add(newNode);
                current = current.findNode(c);
                
            }
            else{
                current = next;
            }
        }
        current.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode next = current.findNode(c);
            if(next==null){
                return false;
            }
            else{
                current = next;
            }
        }
        return current.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        //Works like search, but do not need current.isEnd to be true
        TrieNode current = root;
        for(int i = 0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            TrieNode next = current.findNode(c);
            if(next==null){
                return false;
            }
            else{
                current = next;
            }
        }
        return true;        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
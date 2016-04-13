//Use Prefix Tree to solve this problem
class TrieNode{
    char content;
    boolean isEnd = false;
    int childNum = 0;//Use this variable to indicate if the TrieNode has successor, so that we can handle the situation with '.'
    TrieNode[] childNodes = new TrieNode[26];
    public TrieNode(char c){
        this.content = c;
    }
    public TrieNode findNode(char c){
        return childNodes[c-'a'];
    }
}


public class WordDictionary {
    
    public TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode(' ');
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(search(word)){
            return;
        }
        TrieNode current = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode next = current.findNode(c);
            if(next==null){
                current.childNum++;
                TrieNode newNode = new TrieNode(c);
                current.childNodes[c-'a'] = newNode;
                current = current.findNode(c);
            }
            else{
                current = next;
            }
        }
        current.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return deapSearch(root,word);
    }
    
    public boolean deapSearch(TrieNode root, String word){
        int len = word.length();
        if(len==0){
            return root.isEnd;
        }
        else if(word.equals(".")){
            if(root.childNum==0){
                return false;
            }
            else{
                for(TrieNode x : root.childNodes){
                    if(x!=null&&x.isEnd){
                        return true;
                    }
                }
                return false;
            }
        }
        else{
            TrieNode current = root;
            for(int i = 0; i<len; i++){
                char c = word.charAt(i);
                if(c!='.'){
                    TrieNode next = current.findNode(c);
                    if(next==null){
                        return false;
                    }
                    else{
                        current = next;
                    }
                }
                else{
                    if(current.childNum==0){
                        return false;
                    }
                    else{
                        String nextString = word.substring(i+1,len);
                        for(TrieNode x : current.childNodes){
                            if(x!=null){
                                boolean result = deapSearch(x,nextString);
                                if(result){
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }
            }
            return current.isEnd;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

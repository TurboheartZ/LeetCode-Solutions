

import java.util.*;
public class ValidWordAbbr {
    private HashMap<String,String> filter = new HashMap<String, String>();
    public ValidWordAbbr(String[] dictionary) {
        for(String x : dictionary){
            if(x.length()<=2){
                if(this.filter.containsKey(x)){
                    String s = this.filter.get(x);
                    if(s.equals(x)==false){
                        s = "#";//Means appear multiple times
                        this.filter.put(x,s);
                    }
                }
                else{
                    this.filter.put(x,x);
                }
            }
            else{
                String n = x.charAt(0)+String.valueOf(x.length()-2)+x.charAt(x.length()-1);
                if(this.filter.containsKey(n)){
                    String s = this.filter.get(n);
                    if(s.equals(x)==false){
                        s = "#";
                        this.filter.put(n,s);
                    }
                }
                else{
                    this.filter.put(n,x);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String n;
        if(word.length()<=2){
            n = word;
        }
        else{
            n = word.charAt(0)+String.valueOf(word.length()-2)+word.charAt(word.length()-1);
        }
        return this.filter.containsKey(n)==false||this.filter.get(n).equals(word);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
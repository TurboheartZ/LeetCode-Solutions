import java.util.*;
public class WordDistance {
    //I tried to use HashMap to record previous searching results to avoid duplicate searching, but this turns out to be slower
    public HashMap<String[], Integer> record = new HashMap<String[],Integer>();
    //Use list to record the index of each word so that we do not need to search the array again
    public HashMap<String,List<Integer>> index = new HashMap<String,List<Integer>>();
    
    public WordDistance(String[] words) {
        for(int i = 0; i<words.length; i++){
            if(index.containsKey(words[i])){
                List<Integer> in = index.get(words[i]);
                in.add(i);
                index.replace(words[i],in);
            }
            else{
                List<Integer> in = new ArrayList<Integer>();
                in.add(i);
                index.put(words[i],in);
            }
        }
    }

    public int shortest(String word1, String word2) {
        // String[] k = {word1,word2};
        // if(record.containsKey(k)==true){
        //     return record.get(k);
        // }
        // else{
        //     String[]kr = {word2,word1};
        //     if(record.containsKey(kr)==true){
        //         return record.get(kr);
        //     }
        //     else{
        //         List<Integer> w1 = index.get(word1);
        //         List<Integer> w2 = index.get(word2);
        //         int index1 = 0;
        //         int index2 = 0;
        //         int min = Integer.MAX_VALUE;
        //         while(index1<w1.size()&&index2<w2.size()){
        //             int i1 = w1.get(index1);
        //             int i2 = w2.get(index2);
        //             if(i1>i2){
        //                 min = Math.min(min,i1-i2);
        //                 index2++;
        //             }
        //             else{
        //                 min = Math.min(min,i2-i1);
        //                 index1++;
        //             }
        //         }               
        //         record.put(kr,min);
        //         return min;
        //     }
        // }
        List<Integer> w1 = index.get(word1);
        List<Integer> w2 = index.get(word2);
        int index1 = 0;
        int index2 = 0;
        int min = Integer.MAX_VALUE;
        while(index1<w1.size()&&index2<w2.size()){
            int i1 = w1.get(index1);
            int i2 = w2.get(index2);
            if(i1>i2){
                //When i1>i2, moving i1 will only make the distance even larger, so we move i2
                min = Math.min(min,i1-i2);
                index2++;
            }
            else{
                min = Math.min(min,i2-i1);
                index1++;
            }
        }               
        //record.put(kr,min);
        return min;
    }
}

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Since the range of the array is included in [lower,upper], we donot need to consider if the largese number in array is larger than upper
    //Two pointers
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if(nums.length==0){
            if(lower==upper){
                result.add(String.valueOf(lower));
            }
            else{
                result.add(String.valueOf(lower)+"->"+String.valueOf(upper));
            }
            return result;
        }
        else{
            int begin = lower-1;//Since we use (begin+1,end-1) as the range, the first should be lower-1 so that we can include lower in range
            int end;
            for(int i = 0; i<nums.length; i++){
                end = nums[i];
                if(end-begin==1){
                    begin++;
                }
                else{
                    if(end-begin==2){
                        result.add(String.valueOf(begin+1));
                    }
                    else{
                        result.add(String.valueOf(begin+1)+"->"+String.valueOf(end-1));
                    }
                    begin = end;
                }
            }
            if(begin==upper-1){
                result.add(String.valueOf(begin+1));
            }
            else if(begin<upper-1){
                result.add(String.valueOf(begin+1)+"->"+String.valueOf(upper));
            }
            return result;
        }
    }
}

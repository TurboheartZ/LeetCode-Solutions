import java.util.Arrays;
import java.util.*;
public class Solution {
	public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    //This is also an O(Nlog(N)) solution 
    //We are sure about that there must be an end before a start
    public boolean canAttendMeetingsOptimal(Interval[] intervals) {
        if(intervals.length==0){
            return true;
        }
        else{
            int[] begin = new int[intervals.length];
            int[] end = new int[intervals.length];
            for(int i = 0; i<intervals.length; i++){
                begin[i] = intervals[i].start;
                end[i] =  intervals[i].end;
            }
            Arrays.sort(begin);
            Arrays.sort(end);
            for(int i = 1; i<intervals.length; i++){
                if(begin[i]<end[i-1]){
                    return false;
                }
            }
            return true;
        }
    }	
	
    //*****O(Nlog(N)) solution, we need to find a O(N) solution instead*******
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length==0){
            return true;
        }
        else{
            Arrays.sort(intervals,new Comparator<Interval>(){
                @Override
                public int compare(Interval a, Interval b){
                    return a.start>b.start?1:a.start==b.start?0:-1;
                }
            });
            for(int i = 1; i<intervals.length; i++){
                if(intervals[i].start<intervals[i-1].end){
                    return false;
                }
            }
            return true;
        }
    }
}

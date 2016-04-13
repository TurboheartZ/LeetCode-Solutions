import java.util.*;
public class Solution {
	
	class Interval {
		  int start;
		  int end;
		  Interval() { start = 0; end = 0; }
		  Interval(int s, int e) { start = s; end = e; }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//****A method with Nlog(N) time complexity
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length==0){
            return 0;
        }
        else{
            int[] start = new int[intervals.length];
            int[] end = new int[intervals.length];
            for(int i = 0; i<intervals.length; i++){
                start[i] = intervals[i].start;
                end[i] = intervals[i].end;
            }
            Arrays.sort(start);
            Arrays.sort(end);
            int endPointer = 0;
            int room = 0;
            for(int i = 0; i<start.length; i++){
                if(start[i]<end[endPointer]){
                    room++;
                }
                else{
                    endPointer++;//One start time is later than the end time, means this end time can be possessed, we go to next end time
                }
            }
            return room;
        }
    }
	
	
	//****This method has a time complexity of N^2
    public int minMeetingRooms2(Interval[] intervals) {
        if(intervals.length==0){
            return 0;
        }
        else{
        	//Sort first
            Arrays.sort(intervals,(x,y)->x.start==y.start?0:x.start<y.start?-1:1);
            List<Interval> data = new ArrayList<Interval>();
            for(int i = 0; i<intervals.length; i++){
                int index = findEnd(data);
                if(index==-1){
                    data.add(intervals[i]);
                }
                else{
                    if(data.get(index).end<=intervals[i].start){
                        Interval n = data.get(index);
                        n.end = intervals[i].end;
                        data.set(index,n);
                    }
                    else{
                        data.add(intervals[i]);
                    }
                }
            }
            return data.size();
        }
    }
    private int findEnd(List<Interval> data){
        if(data.size()==0){
            return -1;
        }
        else if(data.size()==1){
            return 0;
        }
        else{
            int min = data.get(0).end;
            int index = 0;
            for(int i = 1; i<data.size(); i++){
                if(data.get(i).end<min){
                    min = data.get(i).end;
                    index = i;
                }
            }
            return index;
        }
    }
}

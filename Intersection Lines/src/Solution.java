
public class Solution {
	public static void main(String[] args){
		//Initialize line 1 and line 2
		Point l1s = new Point(0,0);
		Point l1e = new Point(7,5);
		Line l1 = new Line(l1s,l1e);
		Point l2s = new Point(0,6.0);
		Point l2e = new Point(10.0,0);
		Line l2 = new Line(l2s,l2e);
		Point intersec = checkIntersection(l1,l2);
		System.out.printf("(%f,%f)",intersec.x,intersec.y);
	}
	public static Point checkIntersection(Line l1, Line l2){
		//Since the line is not infinite, we need to consider the start and end points
		Point intersection = new Point((double)Integer.MAX_VALUE,(double)Integer.MAX_VALUE);
		double l1rsx = Math.min(l1.start.x,l1.end.x);
		double l1rsy = Math.min(l1.start.y,l1.end.y);
		double l1rex = Math.max(l1.start.x,l1.end.x);
		double l1rey = Math.max(l1.start.y,l1.end.y);
		double l2rsx = Math.min(l2.start.x,l2.end.x);
		double l2rsy = Math.min(l2.start.y,l2.end.y);
		double l2rex = Math.max(l2.start.x,l2.end.x);
		double l2rey = Math.max(l2.start.y,l2.end.y);
		if(l1.slope==l2.slope){
			return intersection;
		}
		else if(Math.max(l1.start.x,l1.end.x)<Math.min(l2.start.x, l2.end.x)||Math.max(l2.start.x,l2.end.x)<Math.min(l1.start.x, l1.end.x)||Math.max(l1.start.y,l1.end.y)<Math.min(l2.start.y, l2.end.y)||Math.max(l2.start.y,l2.end.y)<Math.min(l1.start.y, l1.end.y)){
			return intersection;
		}
		else{
			if(intersection.x<l1rsx||intersection.x>l1rex||intersection.x<l2rsx||intersection.x>l2rex||intersection.y<l1rsy||intersection.y>l1rey||intersection.y<l2rsy||intersection.y>l2rey){
				//return intersection;
			}
			intersection.x = (l2.start.y-l1.start.y+l1.slope*l1.start.x-l2.slope*l2.start.x)/(l1.slope-l2.slope);
			intersection.y = (l1.slope*l2.slope*(l2.start.x-l1.start.x)+l2.slope*l1.start.y-l1.slope*l2.start.y)/(l2.slope-l1.slope);
			//Still need to check if this node are on the segment
			return intersection;
		}
	} 
}

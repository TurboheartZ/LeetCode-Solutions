
public class Line {
	public Point start,end;
	public double slope = 0;
	public Line(Point s, Point e){
		this.start = s;
		this.end = e;
		this.slope = s.y==e.y?(double)Integer.MAX_VALUE:(e.y-s.y)/(e.x-s.x);
	}
}

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		System.out.println(kthMultiple(20));
	}
	public static int kthMultiple(int k){
		if(k<1){
			return -1;
			//error input
		}
		else{
			ArrayList<Integer> container = new ArrayList<Integer>();
			container.add(1);
			HashSet<Integer> filter = new HashSet<Integer>();
			filter.add(1);
			int p3 = 0;
			int p5 = 0;
			int p7 = 0;
			while(container.size()<k){
				//Avoid duplicate values
				int n3 = container.get(p3)*3;
				while(filter.contains(n3)){
					p3++;
					n3 = container.get(p3)*3;
				}
				int n5 = container.get(p5)*5;
				while(filter.contains(n5)){
					p5++;
					n5 = container.get(p5)*5;
				}
				int n7 = container.get(p7)*7;
				while(filter.contains(n7)){
					p7++;
					n7 = container.get(p7)*7;
				}
				//Start comparing
				if(n3<=n5&&n3<=n7){
					container.add(n3);
					filter.add(n3);
					p3++;
				}
				else if(n5<=n3&&n5<=n7){
					container.add(n5);
					filter.add(n5);
					p5++;
				}
				else{
					container.add(n7);
					filter.add(n7);
					p7++;
				}
			}
			System.out.println(container);
			return container.get(k-1);
		}
	}
}

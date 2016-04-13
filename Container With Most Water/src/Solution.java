
public class Solution {
//This is quite a illustrative problem
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[3];
		System.out.println(input[0]);

	}
	public static int maxArea(int[] height) {
	    int maxarea=0;
	    int temparea=0;
	    int m=0,n=height.length-1;
	    while(m!=n){
	        if(height[m]<height[n]){
	            temparea=height[m]*(n-m);
	            m++;
	        }
	        else{
	            temparea=height[n]*(n-m);
	            n--;
	        }
	        if(maxarea<temparea) maxarea=temparea;
	    }
	    return maxarea;
	}
}

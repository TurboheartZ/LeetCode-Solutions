
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(quickSearch(3951));
		long startTime = System.nanoTime();
		quickSearch(1029887);//This is faster
		long endTime = System.nanoTime();
		System.out.println(endTime-startTime);

		long startTime2 = System.nanoTime();
		shiftSearch(1029887);
		long endTime2 = System.nanoTime();
		System.out.println(endTime2-startTime2);
		//System.out.println(shiftSearch(3895));
	}
	public static int quickSearch(int num){
		int count = 0;
		while(num!=0){
			count++;
			num = num&(num-1);
		}
		return count;
	}
	public static int shiftSearch(int num){
		int count = 0;
		while(num!=0){
			count += 1;
			num <<= 1;
		}
		return count;
	}
}

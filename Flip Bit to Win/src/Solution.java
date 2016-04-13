
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 8273871 ;
		System.out.println(longestOnes(input));
	}
	public static int longestOnes(int num){
		int max = 0;
		if(num==0){
			return 1;
		}
		else{
			int length = 0;
			int flag = 0;
			while(num>0){
				int rem = num%2;
				if(rem==1){
					length++;
				}
				else{
					if(((num-rem)/2%2==1)&&flag==0){
						length++;
						flag = 1;
					}
					else{
						length = length + 1-flag;
						max = Math.max(max,length);
						length = 0;
						flag = 0;
					}
				}
				num = (num-rem)/2;
			}
			return Math.max(max,length);
		}
	}

}

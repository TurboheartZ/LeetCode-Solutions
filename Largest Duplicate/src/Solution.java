
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(largest(12345498));
	}
	public static int largest(int x){
		if(x<1||x>100000000){
			return 0;
		}
		else{
			String input = String.valueOf(x);
			int indexOfDuplicate = 0;
			for(indexOfDuplicate  = 0; indexOfDuplicate<input.length()-1; indexOfDuplicate++){
				if(input.charAt(indexOfDuplicate+1)<input.charAt(indexOfDuplicate)){
					break;
				}
			}
			return Integer.valueOf(input.substring(0,indexOfDuplicate+1)+input.charAt(indexOfDuplicate)+input.substring(indexOfDuplicate+1,input.length()));
			//if beginIndex==endIndex==length, substring returns a empty string
		}
	}

}

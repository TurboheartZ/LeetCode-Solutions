
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time1 = System.nanoTime();
		System.out.println(countTwos(917289823));
		long time2 = System.nanoTime();
		System.out.println(test(917289823));
		long time3 = System.nanoTime();
		System.out.println("Time1 is:"+(time2-time1));
		System.out.println("Time1 is:"+(time3-time2));
	}
	//****This method firstly divide the number into 2 parts
	//****For example: 836->{000-099+100-199+...+700-799} And {00-36} and do recursive operate for each part
	//****if the LSB>2, we need to add more{9999..99} for extra 2s 
	public static int countTwos(int n){
		if(n<2){
			return 0;
		}
		else{
			if(n<=9){
				return 1;
			}
			else{
				String num = String.valueOf(n);
				if(num.charAt(0)-'2'>0){
					String nextNum = "";
					for(int i = 0; i<num.length()-1; i++){
						nextNum += "9";
					}
					return (num.charAt(0)-'0')*countTwos(Integer.valueOf(nextNum))+Integer.valueOf(nextNum)+1+countTwos(Integer.valueOf(num.substring(1,num.length())));
				}
				else if(num.charAt(0)-'2'==0){
					String nextNum = "";
					for(int i = 0; i<num.length()-1; i++){
						nextNum += "9";
					}
					return 2*countTwos(Integer.valueOf(nextNum))+Integer.valueOf(num.substring(1,num.length()))+1+countTwos(Integer.valueOf(num.substring(1,num.length())));
				}
				else{
					String nextNum = "";
					for(int i = 0; i<num.length()-1; i++){
						nextNum += "9";
					}
					return countTwos(Integer.valueOf(nextNum))+countTwos(Integer.valueOf(num.substring(1,num.length())));
				}
			}
		}
	}
	public static int test(int n){
		int count = 0;
		for(int i = 0; i<=n; i++){
			count += numof2(i);
		}
		return count;
	}
	private static int numof2(int n){
		String s = String.valueOf(n);
		int count = 0;
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i)=='2'){
				count++;
			}
		}
		return count;
	}
}

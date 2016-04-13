
public class Solution {
	public static void main(String[] args){
		
	}
	public static String englishInt(int number){
		String num  = String.valueOf(number);
		
		
		return "";
	}
	private static String scale(int x){
		String result = "";
		switch(x){
		case 2: result+="Hundred";
				break;
		case 3: result+="Thousand";
				break;
		case 6: result+="Million";
				break;
		case 9: result+="Billion";
				break;
		default: break;		
		}
		return result;
	}
}

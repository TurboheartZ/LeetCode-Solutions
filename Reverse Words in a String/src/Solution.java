
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = " a";
		String out[] = input.split(" ");
		System.out.println(out.length);
		System.out.println(reverseWords(input));
		System.out.println(reverseWords(input).length());
		
	}
    public static String reverseWords(String s) {
        String[] data = s.split(" ");
        StringBuffer result = new StringBuffer();//StringBuffer is much faster than string.concat(str)
        for(int i = data.length-1; i>=0; i--){
            if(data[i].equals(" ")==false&&data[i].equals("")==false){
                if(result.length()>0){
                    result.append(" ");
                }
                result.append(data[i]);
            }
        }
        return result.toString();
    }
}

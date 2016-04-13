import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findStrobogrammatic(4));
	}
	//****This method works properly but I think we can optimize it by using memory
	//****If we hava f(a) and f(b), we can easily know f(a+b)
    public static List<String> findStrobogrammatic(int n) {
        //We can build these numbers from 1 or 2 original strobogrammatic numbers
        List<String> data = new ArrayList<String>();
        if(n==0){
            return data;
        }
        else{
            if(n%2==1){
                String[] num = {"0","1","8"};
                data = Arrays.asList(num);
                n = n-1;
            }
            else{
                String[] num = {"11","69","88","96"};
                data = Arrays.asList(num);
                n = n-2;
                String[] numz = {"00","11","69","88","96"};
                if(n>0){
                	data = Arrays.asList(numz);
                }
            }
            for(int i = 0; i<n/2; i++){
                List<String> temp = new ArrayList<String>();
                for(String x : data){
                    if(i!=n/2-1){
                        temp.add("0"+x+"0");
                    }
                    temp.add("1"+x+"1");
                    temp.add("8"+x+"8");
                    temp.add("6"+x+"9");
                    temp.add("9"+x+"6");
                }
                data = temp;
            }
            return data;
        }
    }
}


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares(9999));
	}
    //Use memory to save the min numbers of suqare roots at each n
    static int[] data;
    public static int numSquares(int n) {
        if(n<=3){
            return n;
        }
        else{
            data = new int[n+1];            
            data[1] = 1;
            data[2] = 2;
            data[3] = 3;
            if(data[n]!=0){
                return data[n];
            }
            else{
                return partition(n);
            }
        }
    }
    private static int partition(int n){
        if(data[n]!=0){
            return data[n];
        }
        else{
            int root = (int)Math.sqrt(n);
            int mul = root*root;
            if(mul==n){
                data[n] = 1;
                return 1;
            }
            else{
                int min = n;
                for(int i = 2; i<=root; i++ ){
                    int num = 1+partition(n-i*i);//Notice this part! num = (partition(i*i)==i)+partition(n-i^2)
                    min = Math.min(min,num);
                    if(min==2){
                        break;
                    }
                }
                data[n] = min;
                return data[n];
            }
        }        
    }
}

import java.util.*;

class FizzBuzzThread implements Runnable{
	int current = 1;
	@Override
	public void run(){
		while(true){
			if(current>=100) return;
			synchronized(this){
				if(current%2==0&&current%3!=0){
					System.out.println("Count# "+current+"Fizz"+"From#"+Thread.currentThread().getName()+"#");
				}
				else if(current%2!=0&&current%3==0){
					System.out.println("Count# "+current+"Buzz"+"From#"+Thread.currentThread().getName()+"#");
				}
				else if(current%2==0&&current%3==0){
					System.out.println("Count# "+current+"FizzBuzz"+"From#"+Thread.currentThread().getName()+"#");
				}
				else{
					System.out.println("Count**"+current+"From#"+Thread.currentThread().getName()+"#");
				}
				current++;
			}
		}
	}
}

public class Solution{
	public static void main(String[] Args){
		FizzBuzzThread fbt = new FizzBuzzThread();
		new Thread(fbt,"a").start();
		new Thread(fbt,"b").start();
		new Thread(fbt,"c").start();
		new Thread(fbt,"d").start();
	}
}

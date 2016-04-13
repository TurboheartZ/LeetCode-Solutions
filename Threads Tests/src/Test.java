import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
class Testthread extends Thread{
	private String name;
	public int count = 10;
	public Testthread(String nm){
		this.name = nm;
	}
	@Override
	public void run(){
		for(int i = 0; i<5; i++){
			System.out.println("Run From"+Thread.currentThread().getName()+"At"+count--);
		}
		try{
			Thread.sleep((long)Math.random()*1);
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

class Rthread implements Runnable{
	private String name;
	public int count = 10;
	@Override
	public void run(){
		for(int i  = 0; i<5; i++){
			System.out.println("Thread"+Thread.currentThread().getName()+"Count:"+count--);
		}
		try{
			Thread.sleep((long)Math.random()*100);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

class Sthread implements Runnable{
	@Override
	public synchronized void run(){
		for(int i = 0; i<3; i++){
			System.out.println(Thread.currentThread().getName()+"Run#"+i);
		}
	}
}

class Sthread2 implements Runnable{
	@Override
	public void run(){
		synchronized(this){
			for(int i = 0; i<3; i++){
				System.out.println(Thread.currentThread().getName()+"Run#"+i);
			}
		}
		for(int j = 0; j<3; j++){//This part is not synchronized so that it can be approached randomly
			System.out.println("This is from"+Thread.currentThread().getName());
		}
	}
}

class Lthread implements Runnable{
	Lock lk = new ReentrantLock();
	@Override
	public void run(){

		lk.lock();
		try{
			for(int i =  0; i<3; i++){
				System.out.println(Thread.currentThread().getName()+"Run#"+i);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lk.unlock();
		}
	}
}

class semThread extends Thread{
	public Semaphore sem1 = new Semaphore(1);
	
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//*****This part is the threads extends from Thread****
//		Testthread a = new Testthread("threadA");
//		Testthread b = new Testthread("threadB");
////		a.start();
////		b.start();
////		new Thread(a,"MM").start();
////		new Thread(a,"NN").start();
//		new Testthread("a").start();
//		new Testthread("b").start();
		//Theads are unorderedly executed
		
		//****This part is the threads implements unnable****
//		Rthread rt = new Rthread();
//		Rthread rt2 = new Rthread();
//		new Thread(rt,"AA").start();
//		new Thread(rt,"BB").start();
		
		//****This is the tests for Synchronized mechanism****
//		Sthread2 st = new Sthread2();
//		new Thread(st,"AA").start();
//		new Thread(st,"BB").start();
//		new Thread(st,"CC").start();
		
		//****This is the tests for Lock mechanism****
		Lthread lt = new Lthread();
		new Thread(lt,"AA").start();
		new Thread(lt,"BB").start();
		new Thread(lt,"CC").start();
		//The threads are all from the Rthread rt, they share the same resources
	}

}

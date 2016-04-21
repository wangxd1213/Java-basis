package com.java.test;

public class ThreadAndRunnable {

	public static void main(String args[]) {
//		MyThread mt1=new MyThread();
//		MyThread mt2=new MyThread();
//		MyThread mt3=new MyThread();
//		mt1.start();//每个线程都各卖了10张，共卖了30张票
//		mt2.start();//但实际只有10张票，每个线程都卖自己的票
//		mt3.start();//没有达到资源共享
		
//		MyRunnable mt=new MyRunnable();
//		new Thread(mt).start();//同一个mt，但是在Thread中就不可以，如果用同一
//		new Thread(mt).start();//个实例化对象mt，就会出现异常
//		new Thread(mt).start();
		
		MyRunnable1 mt1=new MyRunnable1();
		new Thread(mt1).start();
		new Thread(mt1).start();
		new Thread(mt1).start();
	}

	static class MyThread extends Thread {
		private boolean running=true;
		private int ticket = 10;

		public void run(){
			while(running){
				if(this.ticket>0){
					try {
						Thread.sleep(500);
						System.out.println("卖票：ticket"+this.ticket--);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						running = false;
						e.printStackTrace();
					}
				}
				else{
					running = false;
				}
			}
		}
	}
	
	/**
	 * 虽然现在程序中有三个线程，但是一共卖了10张票，也就是说使用Runnable实现多线程可以达到资源共享目的。
	 * @author apple
	 *
	 */
	static class MyRunnable implements Runnable {
		private boolean running=true;
		private int ticket = 10;

		public void run() {
			while(running){
				if (this.ticket > 0) {
					try {
						Thread.sleep(500);
						System.out.println("卖票：ticket" + this.ticket--);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						running = false;
						e.printStackTrace();
					}
				}
				else{
					running = false;
				}
			}
		}
	}
	
	static class MyRunnable1 implements Runnable {
		private boolean running=true;
		private int ticket = 10;

		public synchronized void run() {
			while(running){
				if (this.ticket > 0) {
					try {
						Thread.sleep(500);
						System.out.println("卖票：ticket" + this.ticket--);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						running = false;
						e.printStackTrace();
					}
				}
				else{
					running = false;
				}
			}
		}
	}
}

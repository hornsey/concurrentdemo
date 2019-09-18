package com.hornsey.threadbasic;

import java.util.concurrent.TimeUnit;

/**
 * @Author hornsey
 * @create 2019/9/18 20:28
 */
public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			log("Start");
			log("thread.isInterrupted = " + Thread.interrupted());

			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				log("Oh, i am be interrupted.");
			}
			int i = 0;
			while (i++ < 10){
				log("thread.isInterrupted = " + Thread.interrupted());
			}

		});

//		thread.setDaemon(true);
		thread.start();

		TimeUnit.MILLISECONDS.sleep(1);
		log("thread.isInterrupted = " + thread.isInterrupted());
		thread.interrupt();
		log("thread.isInterrupted = " + thread.isInterrupted());
	}

	public static void log(String args) {
		String threadName = Thread.currentThread().getName();
		System.out.println(String.format("[%10s][%s] - %s", threadName, System.currentTimeMillis(), args));
	}
}

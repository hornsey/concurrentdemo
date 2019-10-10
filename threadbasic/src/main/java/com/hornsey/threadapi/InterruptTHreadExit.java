package com.hornsey.threadapi;

import java.util.concurrent.TimeUnit;

/**
 * @Author hornsey
 * @create 2019/9/18 21:49
 */
public class InterruptTHreadExit {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
				log("I'm working.");
				while (!isInterrupted()) {

				}
				log("I'll exit.");
			}
		};

		t.start();
		TimeUnit.SECONDS.sleep(10);
		log("System will shutdown.");
		t.interrupt();
	}

	public static void log(String args) {
		String threadName = Thread.currentThread().getName();
		System.out.println(String.format("[%10s][%s] - %s", threadName, System.currentTimeMillis(), args));
	}
}

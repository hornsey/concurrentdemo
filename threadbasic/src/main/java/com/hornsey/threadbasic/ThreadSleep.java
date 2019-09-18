package com.hornsey.threadbasic;

import java.util.concurrent.TimeUnit;

/**
 * @Author hornsey
 * @create 2019/9/18 19:25
 */
public class ThreadSleep {

	public static void main(String[] args) {
		new Thread(() -> {
			long startTime = System.currentTimeMillis();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			System.out.println(Thread.currentThread().getName() + " spend " + (endTime - startTime) + "ms" );
		}).start();

		long startTime = System.currentTimeMillis();
		try {
			TimeUnit.SECONDS.sleep(142);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + " spend " + (endTime - startTime) + "ms" );
	}
}

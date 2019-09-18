package com.hornsey.threadbasic;

import java.util.concurrent.TimeUnit;

/**
 * @Author hornsey
 * @create 2019/9/18 19:45
 */
public class ThreadPriority {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread( () -> {
			int i = 0;
			while (i < 10) {
				System.out.println("t1->i = " + i++ + " priority = " +
						                   Thread.currentThread().getPriority());
			}
		});
		t1.setPriority(10);

		Thread t2 = new Thread( () -> {
			int i = 0;
			while (i < 10) {
				System.out.println("t2->i = " + i++ + " pripority = " +
						                   Thread.currentThread().getPriority());
			}
		});
		t2.setPriority(1);
		System.out.println("t1 = " + t1.getId());
		System.out.println("t2 = " + t2.getId());

		t1.start();
		t2.start();


	}


}

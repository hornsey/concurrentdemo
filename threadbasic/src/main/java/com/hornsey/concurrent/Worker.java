package com.hornsey.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch usage sample
 *
 * @Author hornsey
 * @create 2019/10/10 11:30
 */
public class Worker implements Runnable {

	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;

	public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	@Override
	public void run() {
		try {
			startSignal.await();
			doWork();
			doneSignal.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void doWork() {
		System.out.println(Thread.currentThread().getName() + " working...");
	}
}

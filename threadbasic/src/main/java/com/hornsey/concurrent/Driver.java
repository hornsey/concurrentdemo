package com.hornsey.concurrent;

import com.hornsey.util.ThreadUtil;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch usage sample
 *
 * @Author hornsey
 * @create 2019/10/10 11:34
 */
public class Driver {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(10);

		for (int i = 0; i < 10; i++) {
			new Thread(new Worker(startSignal, doneSignal)).start();
		}

		ThreadUtil.log("Start work.");
		startSignal.countDown();
		ThreadUtil.log("Wait done.");
		doneSignal.await();
		ThreadUtil.log("Work done.");

	}
}

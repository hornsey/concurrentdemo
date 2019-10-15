package com.hornsey.concurrent;


import com.hornsey.common.util.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author hornsey
 * @create 2019/10/10 11:54
 */
public class Solver {
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;
	Random random = new Random();

	public Solver(float[][] matrix) throws InterruptedException {
		data = matrix;
		N = matrix.length;
		Runnable barrierAction = new Runnable() {
			@Override
			public void run() {
				ThreadUtil.log(" acting...");
			}
		};
		barrier = new CyclicBarrier(N, barrierAction);
		List<Thread> threads = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			Thread thread = new Thread(new Worker(i));
			threads.add(thread);
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}
	}


	class Worker implements Runnable {

		int myRow;
		boolean flag = false;

		public Worker(int row) {
			this.myRow = row;
		}

		@Override
		public void run() {
			while (!done()) {
				processRow(myRow);
				ThreadUtil.log(String.format("Row %d processed.", myRow));

				try {
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
					return;
				}
				flag = flag ? false : true;
			}
			ThreadUtil.log("Work done.");
		}

		private void processRow(int myRow) {
			int sum = 0;
			for (float v : data[myRow]) {
				sum += v;
			}
			ThreadUtil.shortSleep(random.nextInt(6));
			ThreadUtil.log(String.format("Row {%d} sum {%d}.", myRow, sum));
			return;
		}

		private boolean done() {

			return flag;
		}
	}

	public static void main(String[] args) {
		float[][] m =  {{1,2,3}, {4,5,6}, {7,8,9}};
		try {
			new Solver(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

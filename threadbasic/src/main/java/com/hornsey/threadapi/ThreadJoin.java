package com.hornsey.threadapi;

import com.hornsey.threadbasic.ThreadYield;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author hornsey
 * @create 2019/9/18 21:33
 */
public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		List<Thread> threads = IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(Collectors.toList());

		threads.forEach(Thread::start);

		for (Thread thread : threads) {
			thread.join();
		}

		for (int i = 0; i < 10; i++) {
			log("#" + i);
			shortSleep();
		}
	}

	private static void shortSleep() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static Thread create(int index) {
		return new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				log("#" + i);
				shortSleep();
			}
		}, String.valueOf(index));
	}

	public static void log(String args) {
		String threadName = Thread.currentThread().getName();
		System.out.println(String.format("[%10s][%s] - %s", threadName, System.currentTimeMillis(), args));
	}
}

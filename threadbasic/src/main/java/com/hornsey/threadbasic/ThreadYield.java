package com.hornsey.threadbasic;

import java.util.stream.IntStream;

/**
 * @Author hornsey
 * @create 2019/9/18 19:37
 */
public class ThreadYield {

	public static void main(String[] args) {
		IntStream.range(0,2).mapToObj(ThreadYield::create).forEach(Thread::start);
	}

	private static Thread create(int index) {
		return new Thread(() -> {
			if (index == 0) {
				Thread.yield();
			}
			System.out.println("index = " + index);
		});
	}
}

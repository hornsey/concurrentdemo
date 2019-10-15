package com.hornsey.common.util;

import java.util.concurrent.TimeUnit;

/**
 * @Author hornsey
 * @create 2019/10/10 11:36
 */
public class ThreadUtil {


	public static void shortSleep(int timeout) {
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void log(String args) {
		String threadName = Thread.currentThread().getName();
		System.out.println(String.format("[%10s][%s] - %s", threadName, System.currentTimeMillis(), args));
	}
}

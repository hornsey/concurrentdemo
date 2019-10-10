package com.hornsey.threadbasic;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author hornsey
 * @create 2019/9/16 9:29
 */
public class Naming {


	public static void main(String[] args) {
		AtomicStampedReference<Integer> asf = new AtomicStampedReference<>(40,15);
		int[] holder = new int[2];
		Integer integer = asf.get(holder);
		System.out.println("integer = " + integer);
		System.out.println("holder = " + Arrays.toString(holder));
	}

}

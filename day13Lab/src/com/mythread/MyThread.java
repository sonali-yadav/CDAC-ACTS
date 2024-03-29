package com.mythread;

import java.util.Scanner;

/*
 *  Create multi threaded application , to print even & odd numbers from a range, specified by user.
(3 threads 1. main --UI that will accept start n end numbers from user, 2. EvenPrinter 3. OddPrinter)
Ensure no orphans. First try it with "extends Thread" & later with "implements Runnable"
 */
public class MyThread extends Thread {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter Range for even odd numbers in format <start> <end>:");
			int start = sc.nextInt();
			int end = sc.nextInt();
			int i=0;
			System.out.println(Thread.currentThread().getName()+i);
			Thread t1 = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = (start%2==0?start:start+1); i <= end; i += 2) {
						System.out.println(Thread.currentThread().getName() + i);
					}
				}
			}, "EvenPrinter");
			Thread t2 = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = (start%2==0?start+1:start); i <= end; i += 2) {
						System.out.println(Thread.currentThread().getName() + i);
					}
				}
			}, "OddPrinter");
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("main over...");
		}
	}

}

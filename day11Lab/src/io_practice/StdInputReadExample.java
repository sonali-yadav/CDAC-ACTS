package io_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInputReadExample {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("Enter data:");
			String r = "";
			while (!(r = br.readLine()).equals("exit")) {
				System.out.println(r);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

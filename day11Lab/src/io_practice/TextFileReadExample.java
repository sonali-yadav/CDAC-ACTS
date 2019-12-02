package io_practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextFileReadExample {
	public static void main(String[] args) {
		System.out.println("Enter text file path/name to read:");
		try (Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}

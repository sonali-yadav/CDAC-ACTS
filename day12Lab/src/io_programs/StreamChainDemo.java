package io_programs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class StreamChainDemo {

	public static void main(String[] args) {
		
		//WRITING THE BINARY DATA INTO FILE
		System.out.println("******************BINARY WRITE******************");
		System.out.println("enter file name for WRITING binary data:");
		 Scanner sc=new Scanner(System.in);
		try(DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(sc.next())));) {
			for (int i = 1; i <= 10; i++) {
				dos.writeInt(i);	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//WRITING THE CHARACTER DATA INTO FILE
		System.out.println("******************CHARACTER WRITE******************");
		System.out.println("Enter file name for WRITING text data:");
		try(PrintWriter pw=new PrintWriter(new FileOutputStream(sc.next()))) {
			for (int i = 1; i <= 10; i++) {
				pw.println(i);	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//READING CHARACTER DATA FROM CHARACTER FILE
		System.out.println("******************CHARACTER READ******************");
		System.out.println("Enter file name for READING text data:");
		try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(sc.next())))) {
			for (int i = 1; i <= 10; i++) {
				System.out.println(br.readLine());	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		//READING BINARY DATA FROM BINARY FILE
		System.out.println("******************BINARY READ******************");
		System.out.println("enter file name for READING binary data:");
		try(DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(sc.next())));) {
			for (int i = 1; i <= 10; i++) {
				System.out.println(dis.readInt());	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}

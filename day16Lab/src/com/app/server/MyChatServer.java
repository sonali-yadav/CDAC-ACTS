package com.app.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyChatServer {
	public static final int PORT = 6066;

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(PORT);
				Socket s = server.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());) {
			System.out.println("Server started!");
			while (true) {
				
				String message = "";
				try {
					
					message = dis.readUTF();
					System.out.println("Received From: " + s.getPort());
					System.out.println(message);
					if (message.equals("logout")) {
						DataOutputStream dos = new DataOutputStream(s.getOutputStream());
						dos.writeUTF("logged out");
						dos.flush();
						s.close();
					}
				} catch (IOException e) {
					System.out.println("Exception in Server:");
					if (e instanceof ConnectException) {
						System.out.println("Client has logged out!!!");
					} else
						e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.app.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.app.server.MyChatServer;

public class MyChatClient {
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
//	Thread clientThread;

	JFrame frame;

	public void displayGUI() {
		do {
			String msg = (String) JOptionPane.showInputDialog(frame, "Enter Message: ", "Talk In Java",
					JOptionPane.PLAIN_MESSAGE);

			// If a string was returned, send it
			if ((msg != null) && (msg.length() > 0)) {
				try {
					s = new Socket(InetAddress.getLocalHost(), MyChatServer.PORT);
					dis = new DataInputStream(s.getInputStream());
					dos = new DataOutputStream(s.getOutputStream());
					try {
						dos.writeUTF(msg);
						if (msg.equalsIgnoreCase("logout"))
							System.exit(0);
					} catch (IOException e) {
						e.printStackTrace();
					}
					dos.writeUTF(msg);

				} catch (IOException e) {
					System.out.println("Exception in Client:");
					e.printStackTrace();
				}
			}
		} while (true);
	}

	public MyChatClient() {
		displayGUI();
	}

	public static void main(String[] args) {
		new MyChatClient();
	}
}

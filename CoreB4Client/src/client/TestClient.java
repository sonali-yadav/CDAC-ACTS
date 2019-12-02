package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {

	public static void main(String[] args) {
		System.out.println("Enter remote IP and remote port");
		try (Scanner sc = new Scanner(System.in); Socket s1 = new Socket(sc.next(), sc.nextInt())) {
			System.out.println("connected to server IP" + s1.getInetAddress().getHostName() + " server  port "
					+ s1.getPort() + " clnt port " + s1.getLocalPort());

			// attaching the data streams
			try (DataOutputStream out = new DataOutputStream(s1.getOutputStream());
					DataInputStream in = new DataInputStream(s1.getInputStream())) {

				// send request
				out.writeUTF("Hi server , wohoo ?");
				// await response
				System.out.println("server sent : " + in.readUTF());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

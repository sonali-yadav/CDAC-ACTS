package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	public static void main(String[] args) {
		System.out.println("Server Up. Waiting for client...");
		try (ServerSocket ss = new ServerSocket(5000, 1); Socket ds = ss.accept();) {
			
			System.out.println("conn accepted from Clnt IP " 
				+ ds.getInetAddress().getHostName() + " rem port "
					+ ds.getPort() + " server port  " 
				+ ds.getLocalPort());
			
			try(DataOutputStream out=new DataOutputStream(ds.getOutputStream());
				DataInputStream in=new DataInputStream(ds.getInputStream())
					)
			{
				//read request
				System.out.println("clnt's req "+in.readUTF());
				//send response
				out.writeUTF("I m good ! Bye!!!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

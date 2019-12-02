package server;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import cust_exception.CustomerHandlingException;
import pojos.Customer;
import static utils.CustomerUtils.*;
import static utils.ServerUtils.*;

public class CustomerHandlingServer {

	public static void main(String[] args) {
		System.out.println("Server Up. Waiting for client...");
		HashMap<String, Customer> org = populateData();
		try (ServerSocket ss = new ServerSocket(5003,2); Socket ds = ss.accept();) {

			System.out.println("connection accepted from Clnt IP " + ds.getInetAddress().getHostName() + " rem port "
					+ ds.getPort() + " server port  " + ds.getLocalPort());

			try (ObjectOutputStream out = new ObjectOutputStream(ds.getOutputStream());) {
				// send stream header to the client explicitly
				//out.flush();
				// attaching the streams
				DataInputStream in = new DataInputStream(ds.getInputStream());
				while (true) {
					switch (in.readInt()) {
					case 1: // 1. update customer address &mobile number
						//System.out.println("got the values");
						Customer cust = validateCustomerlogin(in.readUTF(), in.readUTF(), org);
						Customer c = updateCustomerDetails(cust, in.readUTF(), in.readUTF());
						org.put(c.getEmail(), c);
						String msg="Updated Successfully!";
						//System.out.println("data updated");
						out.writeObject(msg);
						//System.out.println(c);
						break;

					case 2: // 2. send back list of customer from specified city sorted as per dob
						ArrayList<Customer> al = getCustomersByCity(org, in.readUTF());
						writeData(out, al);

					case 0: // exit
						break;
					}
				}
			}
		} catch (Exception e) {
			if (e instanceof EOFException)
				System.out.println("client appln terminated... shutting down server");
			if (e instanceof CustomerHandlingException)
				System.out.println(e);
			else
				e.printStackTrace();
		}
	}
}

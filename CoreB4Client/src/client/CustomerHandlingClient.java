package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import pojos.Customer;

public class CustomerHandlingClient {

	public static void main(String[] args) {
		System.out.println("Enter remote IP and remote port");
		boolean exit = false;
		try (Scanner sc = new Scanner(System.in); Socket s1 = new Socket(sc.next(), sc.nextInt())) {
			System.out.println("connected to server IP" + s1.getInetAddress().getHostName() + " server  port "
					+ s1.getPort() + " clnt port " + s1.getLocalPort());

			// attaching the data streams
			try (DataOutputStream out = new DataOutputStream(s1.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(s1.getInputStream())) {

				while (!exit) {
					System.out.println("1. update customer address &mobile number" + "\n"
							+ "2. get list of customers from specified city sorted as per dob." + "\n" + "0:Exit");
					System.out.println("Enter Choice:");
					switch (sc.nextInt()) {
					case 1:
						out.writeInt(1);
						// send email to server
						System.out.println("Enter email ID, password, new city and new mobile no. ");
						out.writeUTF(sc.next());
						out.writeUTF(sc.next());
						out.writeUTF(sc.next());
						out.writeUTF(sc.next());
						sc.nextLine();
						System.out.println("Data sent to server...");
						// display response
						System.out.println(""+in.readObject());
						break;

					case 2:
						out.writeInt(2);
						// send the name of city to server
						System.out.println("Enter city:");
						out.writeUTF(sc.next());
						// display response
						ArrayList<Customer> cust = (ArrayList<Customer>) in.readObject();
						for (Customer customer : cust) {
							System.out.println(customer);
						}
						break;
					case 0:
						out.writeInt(0);
						System.out.println("Ending connection.");
						exit = true;
						break;
					}
					sc.nextLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
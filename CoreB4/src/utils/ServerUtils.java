package utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import pojos.Customer;

public class ServerUtils {

	// utility method to send Customer data to client
	public static void writeData(ObjectOutputStream out, ArrayList<Customer> cust) throws IOException {
		out.writeObject(cust);
	}
	//utility method to send a string message to client
	public static void writeMessage(ObjectOutputStream out, String msg) throws IOException {
		out.writeUTF(msg);
	}
}

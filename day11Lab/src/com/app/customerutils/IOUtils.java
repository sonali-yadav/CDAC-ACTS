package com.app.customerutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.HashMap;

import com.app.core.customer.Customer;
import static com.app.customerutils.CutomerUtils.*;

public class IOUtils {

	// actual example of de-serialization
	@SuppressWarnings("unchecked")
	public static HashMap<String, Customer> populateCustomerHashMapFromFile()
			throws ParseException, NotSerializableException, FileNotFoundException, ClassNotFoundException,
			InvalidClassException, IOException {
		// this throws ParseException, NotSerializableException, FileNotFoundException
		File f = new File("customerData.ser");
		if (!f.exists()) {
			createInitialTestFile();
		}
		try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(f));) {
			HashMap<String, Customer> hm = (HashMap<String, Customer>) obj.readObject();
			return hm;
		}
	}

	// utility method to serialize the data into a file
	public static void saveCustomerHashMapToFile(HashMap<String, Customer> hm)
			throws NotSerializableException, FileNotFoundException, IOException {
		try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("customerData.ser"));) {
			// trying to write hm object directly, let's see how this goes!
			 obj.writeObject(hm);
			System.out.println("saved your data! Now exiting...");
		}
	}

	// utility method to create initial .ser file
	public static void createInitialTestFile()
			throws ParseException, NotSerializableException, FileNotFoundException, IOException {
		HashMap<String, Customer> cmap = populateCustomerHashMap();
		try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("customerData.ser"));) {
			// trying to write hm object directly, let's see how this goes!
			obj.writeObject(cmap);
		}
	}
}

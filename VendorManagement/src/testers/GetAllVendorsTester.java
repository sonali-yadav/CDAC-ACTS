package testers;

import static utils.HibernateUtils.*;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IVendorDaoImpl;
import pojos.Vendor;

public class GetAllVendorsTester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getSf();) {
			System.out.println("details of all vendors------------>>>");
			IVendorDaoImpl vdao=new IVendorDaoImpl();
			List<Vendor> l=vdao.getAllVendors();
			for (Vendor vendor : l) {
				System.out.println(vendor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

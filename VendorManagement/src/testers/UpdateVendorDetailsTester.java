package testers;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IVendorDaoImpl;

public class UpdateVendorDetailsTester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getSf();) {
			System.out.println("enter the vendor ID, new city and new phone number:");
			IVendorDaoImpl vdao=new IVendorDaoImpl();
			System.out.println(vdao.updateVendorDetails(sc.nextInt(), sc.next(), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

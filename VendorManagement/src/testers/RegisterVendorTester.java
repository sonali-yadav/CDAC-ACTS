package testers;

import static utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IVendorDaoImpl;
import pojos.Vendor;

public class RegisterVendorTester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getSf();) {
			System.out.println("enter details in the format: name, email, password, city, phone, regAmount, regDate[yyyy-MM-dd]");
			Vendor v=new Vendor(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()));
			IVendorDaoImpl vdao=new IVendorDaoImpl();
			System.out.println(vdao.registerVendor(v));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

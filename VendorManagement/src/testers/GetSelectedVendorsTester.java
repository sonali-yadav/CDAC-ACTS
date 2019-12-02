package testers;

import static utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IVendorDaoImpl;
import pojos.Vendor;

public class GetSelectedVendorsTester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getSf();) {
			System.out.println("enter city and reg date[yyyy-MM-dd]");
			IVendorDaoImpl vdao=new IVendorDaoImpl();
			List<Vendor> l=vdao.getSelectedVendors(sc.next(), LocalDate.parse(sc.next()));
			for (Vendor vendor : l) {
				System.out.println(vendor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

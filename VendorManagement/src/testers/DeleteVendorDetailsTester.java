package testers;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.IVendorDaoImpl;

public class DeleteVendorDetailsTester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);SessionFactory sf=getSf();) {
			System.out.println("enter vendor id to delete:");
			IVendorDaoImpl vdao=new IVendorDaoImpl();
			System.out.println(vdao.deleteVendorDetails(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package testers;

import static utils.HibernateUtils.*;
import org.hibernate.*;

public class HibernateTester {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {
			System.out.println("hib started....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

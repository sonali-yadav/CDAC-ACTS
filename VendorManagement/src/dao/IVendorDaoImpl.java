package dao;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.*;
import pojos.Vendor;

public class IVendorDaoImpl implements IVendorDao {

	@Override
	public String registerVendor(Vendor v) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			hs.save(v);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return "Registered Successfully! Id is:"+v.getId();
	}

	@Override
	public Vendor getDetails(int id) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		Vendor v=null;
		try {
			v=hs.get(Vendor.class,id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException("error in:"+getClass().getName(),e);
		}
		return v;
	}

	@Override
	public List<Vendor> getAllVendors() {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		List<Vendor> vendors=null;
		String jpql="select v from Vendor v";
		try {
			vendors=hs.createQuery(jpql,Vendor.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return vendors;
	}

	@Override
	public List<Vendor> getSelectedVendors(String city1, LocalDate dt1) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		List<Vendor> vendors=null;
		String jpql="select v from Vendor v where city=:c and regDate >= :dt";
		try {
			vendors=hs.createQuery(jpql,Vendor.class)
					.setParameter("c", city1)
					.setParameter("dt", dt1).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return vendors;
	}

	@Override
	public String updateVendorDetails(int vid, String newCity, String newPhone) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		Vendor vendor=null;
		String jpql="select v from Vendor v where id=:vid1";
		try {
			vendor=hs.createQuery(jpql,Vendor.class).setParameter("vid1", vid).getSingleResult();
			vendor.setCity(newCity);
			vendor.setPhone(newPhone);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return "Successfully updated data!";
	}

	@Override
	public String deleteVendorDetails(int vid) {
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		Vendor v=null;
		try {
			v=hs.get(Vendor.class,vid);
			hs.delete(v);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException("error in:"+getClass().getName(),e);
		}
		return "Successfully deleted!";
	}

}

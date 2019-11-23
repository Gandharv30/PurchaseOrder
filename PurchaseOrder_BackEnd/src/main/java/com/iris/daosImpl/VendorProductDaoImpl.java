package com.iris.daosImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.VendorProductDao;
import com.iris.models.Products;
import com.iris.models.VendorProducts;
@Repository("vendorProductDao")
@Transactional
public class VendorProductDaoImpl implements VendorProductDao {


	@Autowired
	SessionFactory sessionFactory;
	public boolean add(VendorProducts vendorProductObj) {

		try {
			Session session=sessionFactory.getCurrentSession();
		    session.saveOrUpdate(vendorProductObj);
			return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public VendorProducts checkProductForVendor(int vendorId, int vendorProductId) {try {

		Session session=sessionFactory.getCurrentSession();

		Query query=session.createQuery("from com.project.model.VendorProduct where vendorId=:x and productId=:y");
		query.setParameter("x",vendorId);
		query.setParameter("y",vendorProductId);
		List list=query.list();
		if(list.size()!=0) {
			return (VendorProducts) list.get(0);
		}
		}

		catch(Exception e){

			e.printStackTrace();

		}

	return null;
}

	public List<VendorProducts> viewAllProducts(int id) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.iris.models.VendorProduct");
			List<VendorProducts> list=query.list();
			
			return list;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


}

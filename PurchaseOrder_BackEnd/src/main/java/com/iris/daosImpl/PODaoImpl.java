package com.iris.daosImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.PuchaseOrderDao;
import com.iris.models.PurchaseOrder;

@Repository("purchaseOrderDao")
@Transactional
public class PODaoImpl implements PuchaseOrderDao {
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addPO(PurchaseOrder POobj) {
		try {
			Session session=sessionFactory.getCurrentSession();
	
			session.saveOrUpdate(POobj);
			return true;

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public List<PurchaseOrder> viewAllPo() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.iris.models.PurchaseOrder where status='sent to seller'");
	        return q.list();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
		
}

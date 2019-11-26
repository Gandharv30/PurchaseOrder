package com.iris.daosImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.ProductDao;
import com.iris.models.Products;

@Repository("productDao")
@Transactional
public class ProductsDaoImpl implements ProductDao {
	
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Products productObj) {
			try {
				Session session = sessionFactory.getCurrentSession();
				
				session.saveOrUpdate(productObj);
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	
	public List<Products> viewAllProducts() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from com.iris.models.Products");
			System.out.println("Select all query running ");
			List<Products> productList = q.list();
			System.out.println("Select all query finished");
			return productList;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
	}
	

    public boolean deleteProduct(Products productObj) {
                    try {
                                    Session session = sessionFactory.getCurrentSession();
                                    session.delete(productObj);
                                    
                                    return true;
                    } catch (Exception e) {
                                    e.printStackTrace();

                    }

                    return false;
    }

    public boolean updateProduct(Products productObj) {
        try {
                        Session session = sessionFactory.getCurrentSession();
                        session.update(productObj);
                        return true;
        } catch (Exception e) {
                        e.printStackTrace();

        }

        return false;
    }


    public Products getProductByName(String productName) {
        try {
            Session session=sessionFactory.getCurrentSession();
            Products pro=session.get(Products.class,productName);
            return pro;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        return null;
    }


	@Override
	public Products getProductById(int productId) {

		try {
			Session session=sessionFactory.getCurrentSession();
			Products product=session.get(Products.class,productId);
			return product;
			}
			catch(Exception e){
				e.printStackTrace(); 
			}
		return null;
	}

}
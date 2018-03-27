package com.niit.shopingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopingcart.dao.ProductDAO;
import com.niit.shopingcart.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired 
	private SessionFactory sessionFactory;

	@Autowired
	private Product product;

	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Product get(String emailID) {
		return sessionFactory.getCurrentSession().get(Product.class, emailID);
	}

	public boolean delete(String emailID) {
		try {
			product = get(emailID);
			if (product == null) {
				return false;
			}
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Product> list() {
	return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
}










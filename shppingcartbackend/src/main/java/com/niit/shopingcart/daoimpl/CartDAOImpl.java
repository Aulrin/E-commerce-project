package com.niit.shopingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopingcart.dao.CartDAO;
import com.niit.shopingcart.domain.Cart;

@Transactional
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Cart cart;

	public boolean save(Cart cart) {
		// store in the database.
		try {
			cart.setId();
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Cart get(String id) {
		// it will fetch the record based on id and store in Cart class
		return sessionFactory.getCurrentSession().get(Cart.class, id);

	}

	public boolean delete(String id) {
		try {
			cart = get(id);
			if (cart == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(cart);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<Cart> list(String emailID) {
		//select * from cart where emialID = ?
	return	sessionFactory.getCurrentSession().createCriteria(Cart.class)
			.add(Restrictions.eq("emailID", emailID)).list();
		
	}

	public boolean update(String emailID) {
		String hql = "update Cart set status = 'O' where emailid='" +
				emailID +"'";
		

		try
		{
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		return true;
		}
		catch (Exception e) {
			return false;
		}
		
		
	}
}

package com.niit.shopingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopingcart.dao.UserDAO;
import com.niit.shopingcart.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {


	@Autowired 
	private SessionFactory sessionFactory;

	@Autowired
	private User user;

	public boolean save(User user) {
		try {
			user.setRole('C');
			user.setRegisteredDate(new Date(System.currentTimeMillis()) + "");
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public User get(String emailID) {
		return sessionFactory.getCurrentSession().get(User.class, emailID);
	}

	public boolean delete(String emailID) {
		try {
			user = get(emailID);
			if (user == null) {
				return false;
			}
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<User> list() {
	return	sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validate(String emailID, String password) {
	user = (User)sessionFactory.getCurrentSession().createCriteria(User.class)
		.add(Restrictions.eq("emailID", emailID))
		.add(Restrictions.eq("pwd", password)).uniqueResult();
	return user;
	}
}

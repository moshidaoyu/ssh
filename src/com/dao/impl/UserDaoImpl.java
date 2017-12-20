package com.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.dao.UserDao;
import com.pojo.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean register(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public User login(User user) {
		User u = null;
		u = (User) sessionFactory.getCurrentSession().createQuery("from User where username=:username and password=:password").setString("username", user.getUsername())
				.setString("password", user.getPassword()).uniqueResult();
		return u;
	}

}

package com.tw.phctw.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tw.phctw.dao.UserDao;
import com.tw.phctw.entities.User;

@Repository
@Transactional

public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<User> list() {
//		String hq1 = "from User where name ='wgrgreg'";
		String hq1 = "from User";
		return sessionFactory.getCurrentSession().createQuery(hq1).list();
	}

	@Override
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		return true;
	}

	@Override
	public boolean saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			Transaction transaction = (Transaction) session.beginTransaction();
//			session.saveOrUpdate(user);
//			transaction.commit();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		return true;
	}

	@Override
	public boolean searchName(User user) {
		String hql = "select count(*) from User where name = :name";
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", user.getName())
				.uniqueResult();
		boolean exists = (count > 0);
		return exists;
//		if (exists) {
//			return true;
//		} else {
//			return false;
//		}
	}

	@Override
	public boolean login(User user) {
		String hql = "select count(*) from User where name= :name and password= :password";
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", user.getName())
				.setParameter("password", user.getPassword()).uniqueResult();
		return count > 0;
	}

	@Override
	public boolean register(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

		return true;
	}

	@Override
	public User foragetPassword(User user) {
		String hql = "from User where name = :name";
		User us = (User) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", user.getName())
				.uniqueResult();

		return us;
	}

}

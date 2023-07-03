package com.tw.phctw.bean;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tw.phctw.entities.User;

@Repository // 內部封裝了數據查詢和儲存的邏輯。
@Transactional

public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean register(User user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);

		return true;
	}

	@Override
	public boolean searchName(User user) {
		String hql = "select count(*) from User where name = :name";
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", user.getName())
				.uniqueResult();
		boolean exists = (count > 0);
		return exists;
	}

	@Override
	public boolean loginUser(User user) {
		String hql = "select count(*) from User where name= :name and password= :password";
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", user.getName())
				.setParameter("password", user.getPassword()).uniqueResult();
		return count > 0; // count=1 >true ,count=0 >false
	}

	@Override
	public boolean checkName(String name) {
		String hql = "select count(*) from User where name = :name";
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql).setParameter("name", name)
				.uniqueResult();
		boolean exists = (count > 0);
		return exists;
	}

	@Override
	public User resetPassword(User user) {
		String hql = "select id, name, password,email from User where name = :name";
		Object[] result = (Object[]) sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("name", user.getName()).uniqueResult();
		if (result != null) {
			int id = (int) result[0];
			String name = (String) result[1];
			String password = (String) result[2];
			String email = (String) result[3];
			User us = new User(id, name, password, email);
			return us;
		}
		return null;
	}

	@Override
	public boolean saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

}

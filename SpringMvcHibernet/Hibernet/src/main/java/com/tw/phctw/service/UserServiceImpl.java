package com.tw.phctw.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Printer;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.tw.phctw.dao.UserDao;
import com.tw.phctw.entities.JavaMail;
import com.tw.phctw.entities.User;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return userDao.delete(user);
	}

	@Override
	public boolean saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		return userDao.saveOrUpdate(user);
	}

	@Override
	public boolean serchName(User user) {

		return userDao.searchName(user);
	}

	@Override
	public boolean login(User user) {
		String md5Psd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		System.out.println(md5Psd);
		User newUser = new User(user.getName(), md5Psd);
		return userDao.login(newUser);
	}

	@Override
	public boolean register(User user) {

		if (userDao.searchName(user)) {
			return false;
		} else {
			String md5Psd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
			User newUser = new User(user.getName(), md5Psd, user.getEmail());
			return userDao.register(newUser);
		}
	}

	@Override
	public boolean forgetPassword(User user) throws MessagingException {
		User us = new User();
		us = userDao.foragetPassword(user);
		System.out.println(us.getId());
		System.out.println(us.getName());
		System.out.println(us.getPassword());
		System.out.println(us.getEmail());

		int i = 0;
		i = (int) (Math.random() * 100000) + 1000;
		String numberString = Integer.toString(i);
		System.out.println(numberString);
		String newMd5Pwd = DigestUtils.md5DigestAsHex(numberString.getBytes());
		System.out.println(newMd5Pwd);

		User newUser = new User(us.getId(), us.getName(), newMd5Pwd, us.getEmail());
		JavaMail javaMail = new JavaMail();
		String txt = "給您的密碼:" + numberString;
		javaMail.SendMail(us.getEmail(), txt);

		return userDao.saveOrUpdate(newUser);
	}

}

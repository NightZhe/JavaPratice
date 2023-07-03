package com.tw.phctw.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.tw.phctw.bean.UserDao;
import com.tw.phctw.entities.JavaMail;
import com.tw.phctw.entities.User;

@Service
@Transactional

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public Boolean loginUser(User user) {
		String md5Psd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		System.out.println(md5Psd);
		User newUser = new User(user.getName(), md5Psd);
		return userDao.loginUser(newUser);
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
	public boolean checkName(String name) {
		return userDao.checkName(name);
	}

	@Override
	public boolean resetPassword(User user) throws MessagingException {
		User us = new User();
		us = userDao.resetPassword(user);
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

		if (userDao.saveOrUpdate(newUser)) {
			JavaMail javaMail = new JavaMail();
			String txt = "給您的密碼:" + numberString;
			javaMail.SendMail(us.getEmail(), txt);
			return true;
		}
		return false;
	}

}

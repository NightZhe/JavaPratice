package com.tw.phctw.service;

import java.util.List;

import javax.mail.MessagingException;

import com.tw.phctw.entities.User;

public interface UserService {
	public List<User> list();

	public boolean delete(User user);

	public boolean saveOrUpdate(User user);

	public boolean serchName(User user);

	public boolean login(User user);

	public boolean register(User user);

	public boolean forgetPassword(User user) throws MessagingException;

}

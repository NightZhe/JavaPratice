package com.tw.phctw.service;

import javax.mail.MessagingException;

import com.tw.phctw.entities.User;

public interface UserService {

	public Boolean loginUser(User user);

	public boolean register(User user);

	public boolean checkName(String name);

	public boolean resetPassword(User user) throws MessagingException;

}

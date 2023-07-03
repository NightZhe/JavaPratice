package com.tw.phctw.bean;

import com.tw.phctw.entities.User;

public interface UserDao {
	public boolean register(User user);

	public boolean searchName(User user);

	public boolean loginUser(User user);

	public boolean checkName(String name);

	public User resetPassword(User user);

	public boolean saveOrUpdate(User user);
}

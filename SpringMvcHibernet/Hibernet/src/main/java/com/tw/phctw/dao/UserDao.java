package com.tw.phctw.dao;

import java.util.List;

import com.tw.phctw.entities.User;

public interface UserDao {
	public List<User> list();

	public boolean delete(User user);

	public boolean saveOrUpdate(User user);

	public boolean searchName(User user);

	public boolean login(User user);

	public boolean register(User user);

	public User foragetPassword(User user);

}

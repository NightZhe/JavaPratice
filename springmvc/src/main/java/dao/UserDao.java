package dao;

import java.sql.SQLException;

import bean.User;

public interface UserDao {
	public void Register(User user) throws SQLException;

	public String SearchName(String name);

	public String SearchEmail(String name);

	public String SearchPassword(String name);
}
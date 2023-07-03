package dao;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import bean.User;

public class UserDaoImpl implements UserDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/JDBCDB?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT_USERS_SQL = "INSERT INTO user (name, password, email) VALUES(?, ?, ?);";
	private static final String SEARCH_NAME = "select * from user where name=?";

	public UserDaoImpl() {

	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void Register(User us) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
			ps.setString(1, us.getName());
			ps.setString(2, us.getPassword());
			ps.setString(3, us.getEmail());
			ps.executeUpdate();

		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public String SearchName(String name) {
		String name1;
		String email;
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SEARCH_NAME)) {
			User us = new User();
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // 移動 ResultSet 指標
				name1 = rs.getString("name");
				email = rs.getString("email");
				System.out.println("DB裡面的:" + name1 + " , " + "相對應的:" + email);
			} else {
				return null;
			}
		} catch (SQLException e) {
			printSQLException(e);
			return null;

		}

		return name1;
	}

	public String SearchEmail(String name) {
		String name1;
		String email;
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SEARCH_NAME)) {
			User us = new User();
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // 移動 ResultSet 指標
				name1 = rs.getString("name");
				email = rs.getString("email");
				System.out.println("DB裡面的: " + name1 + "相對應的: " + email);
			} else {
				return null;
			}
		} catch (SQLException e) {
			printSQLException(e);
			return null;

		}

		return email;
	}

	public String SearchPassword(String name) {
		String name1;
		String email;
		String password;
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(SEARCH_NAME)) {
			User us = new User();
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // 移動 ResultSet 指標
				name1 = rs.getString("name");
				email = rs.getString("email");
				password = rs.getString("password");
				System.out.println("DB裡面的:" + name1 + " , " + "相對應的:" + email + " , " + "密碼:" + password);
			} else {
				return null;
			}
		} catch (SQLException e) {
			printSQLException(e);
			return null;

		}

		return password;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}

	}

}

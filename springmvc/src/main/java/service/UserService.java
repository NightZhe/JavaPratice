package service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.User;
import dao.UserDaoImpl;

@Service
public class UserService {
	@Autowired
	UserDaoImpl userDaoImpl;

	public void Register(User us) {
		try {
			userDaoImpl.Register(us);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String SearchName(String name) {

		return userDaoImpl.SearchName(name);
	}

	public String SearchEmail(String name) {

		return userDaoImpl.SearchEmail(name);
	}

	public String SearchPassword(String name) {

		return userDaoImpl.SearchPassword(name);
	}

}

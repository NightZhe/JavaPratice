package controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;
import jakarta.servlet.http.HttpServletRequest;
import service.UserService;

@Controller
public class WebController {

	@RequestMapping(value = "/Register", method = RequestMethod.POST)

	public String login(HttpServletRequest request, Model model) {

		String username = request.getParameter("UserName");
		String password = request.getParameter("UserPassword");
		String email = request.getParameter("UserEmail");

		String md5password = DigestUtils.md5DigestAsHex(password.getBytes());
		System.out.println(md5password);

		User us = new User(username, md5password, email);
		UserDaoImpl usdl = new UserDaoImpl();
		try {
			usdl.Register(us);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("username", username);
		model.addAttribute("password", md5password);
		model.addAttribute("email", email);

		return "result";
	}
}

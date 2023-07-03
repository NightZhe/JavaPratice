package controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.UserDaoImpl;
import jakarta.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mail.JavaMail;

@Controller
public class MailController {

	@RequestMapping(value = "/RetrievePassword", method = RequestMethod.POST)

	public String Retrieve(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException, MessagingException {
		String username = request.getParameter("userName");
		System.out.print(username);
		UserDaoImpl usd = new UserDaoImpl();
		String email = usd.SearchEmail(username);
		String password = usd.SearchPassword(username);

		JavaMail javaMail = new JavaMail();
		javaMail.SendMail(email, password);
//
//		request.getRequestDispatcher("index.jsp").forward(request, response);

		return "hello";
	}
}

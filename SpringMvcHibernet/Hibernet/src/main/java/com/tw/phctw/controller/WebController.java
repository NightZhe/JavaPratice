package com.tw.phctw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tw.phctw.entities.User;
import com.tw.phctw.service.UserService;

@Controller
// @RequestMapping("users")
public class WebController {
	@Autowired
	UserService userService;

	@RequestMapping("/comfirm")
	@ResponseBody
	public Map<String, Object> comfirmName(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(user.getName());
		if (userService.serchName(user)) {

			map.put("status", "200");
			map.put("message", "repeat");
		} else {
			map.put("message", "no repeat");
		}
		return map;
	}

	@RequestMapping("/register")
	public String register(Model model, String name, String password, String email) {
		User user = new User(name, password, email);
		if (userService.register(user)) {
			model.addAttribute("message", "<script>alert('恭喜你註冊成功')</script>");
			return "forward:index.jsp";
		} else {
			model.addAttribute("message", "<script>alert('帳號重複，請重註冊')</script>");
			return "forward:register.jsp";
		}
	}

	@RequestMapping("/login")
	public String login(Model mode, String name, String password) {
		User user = new User(name, password);
		if (userService.login(user)) {
			mode.addAttribute("userName", user.getName());
			mode.addAttribute("userPassword", user.getPassword());
			return "show";
		} else {
			mode.addAttribute("message", "<script>alert('帳號密碼錯誤，請重新輸入')</script>");

			return "forward:index.jsp";
		}

	}

	@RequestMapping("/forgetpassword")
	public String forgetPassword(Model model, String name) throws MessagingException {
		User user = new User(name);
		if (!userService.serchName(user)) {
			model.addAttribute("message", "<script>alert('無此帳號，請重新輸入')</script>");
			return "forward:forgetpsd.jsp";
		} else {
			if (userService.forgetPassword(user)) {
				return "getpsd";
			} else {
				model.addAttribute("message", "<script>alert('無法寫入')</script>");
				return "forward:forgetpsd.jsp";
			}

		}
	}

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody Map<String, Object> getSaved(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		if (userService.saveOrUpdate(user)) {
			map.put("Status", "200");
			map.put("message", "you record have benn saved successfully");
		}
		return map;
	}
	// @RequestMapping("/saveOrUpdate")
	//
	// public String Save(String name, String password, Model model) {
	// User user = new User(name, password);
	// System.out.println(user.getName());
	//
	// if (userService.saveOrUpdate(user)) {
	// return "show";
	// }
	// return "show";
	// }

	@RequestMapping("/list")
	public @ResponseBody Map<String, Object> getlist(User user) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<User> list = userService.list();
		if (list != null) {
			map.put("Status", "200");
			map.put("message", "you record have benn saved successfully");
			map.put("data", list);
		} else {
			map.put("status", "400");
			map.put("massage", "Data not found");
		}
		return map;

	}

	@RequestMapping("/delete")
	public @ResponseBody Map<String, Object> delete(User user) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userService.delete(user)) {
			map.put("Status", "200");
			map.put("message", "you record have benn saved successfully");
		}
		return map;

	}
}

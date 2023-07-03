package com.tw.phctw.action;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.ResultPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.NativeWebRequest;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.tw.phctw.entities.User;
import com.tw.phctw.service.UserService;

import net.sf.json.JSONObject;

//import net.sf.json.JSONObject;
//@Namespace("/")
@ResultPath(value = "/") // 假設沒有ResultPath 59行的 location="index.jsp" 要改成 location="/index.jsp"
@ParentPackage("json-default")
public class AllAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;

	private String name;
	private String password;
	private String email;
	private String response;
	private String message;

	// 進首頁
	@Action(value = "/", results = { @Result(name = "success", location = "index.jsp") })
	public String execute5() {
		return SUCCESS;
	}

	// 跳註冊
	@Action(value = "register", results = { @Result(name = "success", location = "/WEB-INF/pages/register.jsp") })
	public String execute0() {
		return SUCCESS;
	}

	// 跳忘記密碼
	@Action(value = "forgetPassowrd", results = { @Result(name = "success", location = "/WEB-INF/pages/fpsd.jsp") })
	public String forwardfpsd() {
		return SUCCESS;
	}

	// 註冊
	@Action(value = "saveuser", results = { @Result(name = "success", location = "index.jsp"),
			@Result(name = "error", location = "/WEB-INF/pages/register.jsp") })
	public String execute9() {
		User user = new User(name, password, email);
		if (user.getName().equals("")) {
			addActionError("帳號不能為空值，請重新輸入");
			return ERROR;
		}
		System.out.println("user.name:" + user.getName());
		Boolean result = userService.register(user);
		if (!result) {

			addActionError("帳號重複了，請重新註冊");
			return ERROR;
		}

		addActionError("註冊成功，請重新登入！");
		return SUCCESS;
	}

	// 登入驗證
	@Action(value = "login", results = { @Result(name = "success", location = "/WEB-INF/pages/info.jsp"),
			@Result(name = "error", location = "index.jsp") })
	public String lgoin() {
		System.out.println("帳號:" + name);
		System.out.println("密碼:" + password);
		User user = new User(name, password);
		if (userService.loginUser(user)) {
			return SUCCESS;
		}
		addActionError("帳號密碼錯誤，請重新輸入");
		return ERROR;

	}

	// ajax 驗證帳號使否存在
	@Action(value = "comfirm", results = { @Result(name = "success", type = "json", params = { "roor", "response" }),
			@Result(name = "error", type = "json", params = { "root", "response" }) })
	public String checkName() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userService.checkName(name)) {
//			map.put("message", "repeat");
//			JSONObject json = JSONObject.fromObject(map);// 将map对象转换成json类型数据
//			response = json.toString();// 给result赋值，传递给页面，同时也是struts.xml中param参数root的值
			response = "repeat";
			return ERROR;
		}
		map.put("message", "noRepeat");
		JSONObject json = JSONObject.fromObject(map);// 将map对象转换成json类型数据
		response = json.toString();// 给result赋值，传递给页面，同时也是struts.xml中param参数root的值
		return SUCCESS;

	}

	// 忘記密碼找回
	@Action(value = "resetPassword", results = { @Result(name = "success", location = "/WEB-INF/pages/answer.jsp"),
			@Result(name = "error", location = "/WEB-INF/pages/fpsd.jsp") })
	public String resetPassword() throws MessagingException {
		if (!userService.checkName(name)) {
			addActionError("無此帳號，請重新數入");
			return ERROR;
		} else {
			User user = new User(name);
			if (userService.resetPassword(user)) {
				return SUCCESS;
			} else {
				addActionError("請聯繫管理員");
				return ERROR;
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

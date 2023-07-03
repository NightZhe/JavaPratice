package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDaoImpl;

@Controller
public class UserController {
	String message = "Welcome to Spring MVC!";

//	@Autowired
	UserDaoImpl udImpl;

	String result;

	@RequestMapping(value = "/comfirm", method = RequestMethod.GET)
	@ResponseBody
	public String showMessage(@RequestParam(value = "UserName", required = false, defaultValue = "World") String name) {

		System.out.println("in controller");
		System.out.println(name);
		UserDaoImpl userdoaImpl = new UserDaoImpl();

		String daoNameString = userdoaImpl.SearchName(name);
		System.out.print(daoNameString);

		if (daoNameString != null) {
			result = "repeat";
		} else {
			result = "no repeat";
		}

		return result;
	}

}
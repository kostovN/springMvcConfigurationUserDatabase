package rs.engineering.javacourse.springMvcConfigurationUser.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import rs.engineering.javacourse.springMvcConfigurationUser.dto.User;
import rs.engineering.javacourse.springMvcConfigurationUser.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute(name = "user")
	public User user() {
		return new User("-", "-", "-", "-");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView users(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/views/user/users");
		modelAndView.addObject("action", "Action: view all users");
		List<User> users = userService.getAll();
		request.getServletContext().setAttribute("users", users);
		return modelAndView;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "Action: add new company");
		return new ModelAndView("/WEB-INF/views/user/addUser");
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("user");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute(name = "user") User user, HttpServletRequest request,
			HttpServletResponse response) {
		String error = "";
		List<User> users = userService.getAll();
		userService.save(user);
		request.getServletContext().setAttribute("users", users);
		return "redirect:/users/addUser";
	}

}

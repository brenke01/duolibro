package com.main.controller;
 
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonObject;
import com.pojo.User;
import com.security.LoginUtility;
import com.security.PasswordAuthentication;
import com.user.service.UserService;
 
/*
 * author: Crunchify.com
 * 
 */
 
@Controller
public class MainController {

	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="UserService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	@RequestMapping("/welcome")
	public ModelAndView helloWorld(HttpServletRequest request) {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		ModelAndView model = new ModelAndView("welcome", "message", message);
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			model = new ModelAndView("redirect:/");
		}else {
			model.addObject("user", user);

		}
		return model;
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		String password =  request.getParameter("password");
		String hashedPass = LoginUtility.getHashedPassword(password);
		userService.registerUser(username, hashedPass, firstName, lastName, email);
		User user = userService.getUser(username);
		request.getSession().setMaxInactiveInterval(60);
		request.getSession().setAttribute("user", user);
		return new ModelAndView("redirect:/welcome");

		


	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redir) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");

		String password =  request.getParameter("password");
		boolean isValid = userService.login(username, password);
		JsonObject obj = new JsonObject();
		obj.addProperty("valid", isValid);
		if (!isValid) {
			ModelAndView model = new ModelAndView("redirect:/");
			model.addObject("loginError", true);
			return model;

		}else {
			User user = userService.getUser(username);
			request.getSession().setMaxInactiveInterval(60);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("redirect:/welcome");


		}


	}
}
package com.foodtogo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.foodtogo.model.Customer;
import com.foodtogo.service.CustomerServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	@Autowired
	private CustomerServiceImp customerService;
	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@GetMapping("/home")
	public String showHomePage() {
		return "home";
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "register";
	}
	@PostMapping("/login")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.registerCustomer(customer);
		System.out.println(customer);
		return "redirect:/login";
	}
	@GetMapping("/index")
	public String showIndexPage() {
		return "index";
	}
	@PostMapping("/home")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {
		Customer cust = customerService.findByEmail(username);
		if (cust != null && cust.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("custid", cust.getCustId());
			session.setAttribute("name", cust.getName());
			session.setAttribute("username", cust.getEmail());
			session.setAttribute("password", cust.getPassword());
			logger.info("User logged in:{}", username);
			return "redirect:/home";
		} else {
			model.addAttribute("message", "Invalid Credentials");
			logger.warn("Invalid login attempt for username:{}", username);
			return "login";
		}
	}
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		logger.info("user logged out");
		return "redirect:/home";
	}
	@GetMapping("/login")
	public String getLogin(Model model) {
		return "login";
	}
}

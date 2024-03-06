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
import com.foodtogo.model.Owner;
import com.foodtogo.service.OwnerServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OwnerController {
	@Autowired
	private OwnerServiceImp ownerService;
	private static final Logger logger = LogManager.getLogger(OwnerController.class);

	@GetMapping("/ohome")
	public String getHome() {
		return "ohome";
	}
	@GetMapping("/ologin")
	public String getLogin(Model model) {
		return "ologin";
	}
	@PostMapping("/ohome")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {
		Owner owner = ownerService.findByEmail(username);
		if (owner != null && owner.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("ownerId", owner.getOwnerId());
			session.setAttribute("name", owner.getOwnerName());
			session.setAttribute("username", owner.getEmail());
			session.setAttribute("password", owner.getPassword());
			logger.info("Owner logged in:{}", username);
			return "redirect:/ohome";
		} else {
			model.addAttribute("message", "Invalid Credentials");
			logger.warn("Invalid login attempt for username:{}", username);
			return "ologin";
		}
	}

	@GetMapping("/ologout")
	public String logOut(HttpSession session) {
		session.invalidate();
		logger.info("owner logged out");
		return "redirect:/ohome";
	}

	@GetMapping("/oregister")
	public String showRegistrationForm(Model model) {
		Owner owner = new Owner();
		model.addAttribute("owner", owner);
		return "oregister";
	}
	@PostMapping("/ologin")
	public String addOwner(@ModelAttribute("owner") Owner owner) {
		ownerService.saveOwner(owner);
		return "redirect:/ologin";
	}

}

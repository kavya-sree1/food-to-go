package com.foodtogo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.foodtogo.exceptions.NoOrdersPlacedException;
import com.foodtogo.model.Customer;
import com.foodtogo.model.FoodCart;
import com.foodtogo.model.Order;
import com.foodtogo.service.CartServiceImp;
import com.foodtogo.service.CustomerServiceImp;
import com.foodtogo.service.OrderServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	@Autowired
	private CartServiceImp cartService;
	@Autowired
	private OrderServiceImp orderService;
	@Autowired
	private CustomerServiceImp customerService;
	private static final Logger logger = LogManager.getLogger(OrderController.class);
	@GetMapping("/buyitem")
	private String buyItem(Model model, HttpSession session) {
		List<FoodCart> citems = cartService.findByCartId();
		int sum = cartService.getTotalPrice(citems);
		model.addAttribute("sum", sum);
		if (session.getAttribute("username") != null && session != null) {
			return "payment";
		} else {
			return "redirect:/register";
		}
	}

	@GetMapping("/onlinepay")
	private String onlinePay(Model model) {
		List<FoodCart> citems = cartService.findByCartId();
		int sum = cartService.getTotalPrice(citems);
		model.addAttribute("sum", sum);
		return "onlinepay";
	}

	@GetMapping("/odetails")
	private String getDetails(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Integer custId = (Integer) session.getAttribute("custid");
			Order ord = new Order();
			Customer customer = customerService.viewCustomerById(custId);
			ord.setCustomer(customer);
			Order order = orderService.addOrder(ord);
			session.setAttribute("id", order.getOrderId());
			model.addAttribute("order", order);
			List<FoodCart> citems = cartService.findByCartId();
			model.addAttribute("citems", citems);
			logger.info("Customer placed order:{}", customer.getName());
		}

		return "odetails";
	}

	@PostMapping("/status")
	private String changeStatus(Model model, @RequestParam("status") String status,
			@RequestParam("orderId") int orderId, HttpSession session) throws NoOrdersPlacedException {
		model.addAttribute("message", "updated Successfully");
		Order order = orderService.viewOrder(orderId);
		List<Order> orders = orderService.getAllOrders();
		if (!orders.contains(order)) {
			throw new NoOrdersPlacedException("<h2>" + "No Orders Received!" + "</h2>");
		}
		order.setStatus(status);
		orderService.updateOrder(orderId, order);
		logger.info("owner updated order status");
		return "status";
	}

	@GetMapping("/status")
	private String changeOStatus(Model model, HttpSession session) throws NoOrdersPlacedException {
		Integer id = (Integer) session.getAttribute("id");
		if (id == null) {
			throw new NoOrdersPlacedException("<h2>" + "No Orders Received!" + "</h2>");
		}
		Order order = orderService.viewOrder(id);
		model.addAttribute("order", order);
		List<FoodCart> citems = cartService.findByCartId();
		model.addAttribute("citems", citems);
		logger.info("owner updated order status");
		return "status";
	}

	@GetMapping("/custstatus")
	private String custStatus(Model model, HttpSession session) throws NoOrdersPlacedException {
		List<FoodCart> citems = cartService.findByCartId();
		model.addAttribute("citems", citems);
		// Integer id=(Integer)session.getAttribute("id");
		List<Order> orders = orderService.getAllOrders();
		if (orders.isEmpty()) {
			throw new NoOrdersPlacedException("<h2>" + "No Orders Placed!" + "</h2>");
		}
		model.addAttribute("orders", orders);
		logger.info("customer viewed his order status");
//          Order order=orderService.viewOrder(id);
//          String status=order.getStatus();
//          model.addAttribute("status",status);
		return "custstatus";
	}
}

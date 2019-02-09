package com.springBoot.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.entity.Customer;
import com.springBoot.entity.Order;
import com.springBoot.service.impl.CustomerImpl;
import com.springBoot.service.impl.OrderImpl;

@Controller
public class B4Action {

	@Resource
	CustomerImpl customerImpl;
	@Resource
	OrderImpl orderImpl;
	
	// postman
	// localhost:8006/b4.action
	@RequestMapping("/b4.action")
	public String test(Map<String, Object> map, Customer customer) {
		System.out.println("b4 ...");
		customerImpl.save(customer.getId(), customer);
		
		Order order = new Order(customer.getId(), "订单", customer.getId());
		orderImpl.saveOrUpdate(order.getCustomerId(), order);
		return "success";
	}
	
}

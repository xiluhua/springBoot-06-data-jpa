package com.springBoot.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.springBoot.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.springBoot.dao.CustomerDao;
import com.springBoot.dao.query.Customer2;
import com.springBoot.service.impl.CustomerImpl;

@Controller
public class B9Action {

	@Resource
	CustomerImpl customerImpl;
	@Resource
	CustomerDao customerDao;
	// postman
	// localhost:8006/b9.action
	@RequestMapping("/b9.action")
	public String test(Map<String, Object> map ) {
		System.out.println("b9 ...");
		
		List<Customer2> list = customerImpl.query12();
		for (Customer2 customer2 : list) {
			System.out.println(JSON.toJSONString(customer2));
		}
		
		System.out.println();
		System.out.println("----------------------------");
		System.out.println();
		
		list = customerDao.query12();
		for (Customer2 customer2 : list) {
			System.out.println(JSON.toJSONString(customer2));
		}
		
		return "success";
	}

	// localhost:8006/b11.action
	@RequestMapping("/b11.action")
	public String test11(Map<String, Object> map ) throws Exception {
		System.out.println("b11 ...");

		System.out.println();
		System.out.println("----------------------------");
		System.out.println();

        List<Map> list = customerDao.query11(1);
		for (Map map2 : list) {
			System.out.println(JSON.toJSONString(map2));
		}

		return "success";
	}
	
	// localhost:8006/b13.action
	@RequestMapping("/b13.action")
	public String test13(Map<String, Object> map ) throws Exception {
		System.out.println("b13 ...");
		
		System.out.println();
		System.out.println("----------------------------");
		System.out.println();
		
		List<Map> list = customerDao.query13(1);
		for (Map map2 : list) {
			System.out.println(JSON.toJSONString(map2));
		}
		
		return "success";
	}

}

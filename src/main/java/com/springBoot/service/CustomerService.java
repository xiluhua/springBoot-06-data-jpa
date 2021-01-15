package com.springBoot.service;

import java.util.List;

import com.springBoot.dao.query.Customer2;
import com.springBoot.entity.Customer;

public interface CustomerService {

	public int update13(String email, int id);
	
	public List query11(Integer age) throws Exception;
	
	public List query13(Integer age) throws Exception;

	public List<Customer2> query12();

	public Customer save(int id, Customer customer);
	
	public Customer save(Customer customer);
	
	public List<Customer> save15(List<Customer> customers);
	
	public Customer findById(int id);
	
	public Customer saveOrUpdate(int id, Customer customer);
}
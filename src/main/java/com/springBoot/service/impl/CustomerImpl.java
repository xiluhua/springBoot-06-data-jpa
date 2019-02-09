package com.springBoot.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.dao.CustomerDao;
import com.springBoot.dao.CustomerRepDao;
import com.springBoot.dao.query.Customer2;
import com.springBoot.entity.Customer;
import com.springBoot.service.CustomerService;

@Transactional
@Service
public class CustomerImpl implements CustomerService{

	@Resource
	CustomerDao customerDao;
	@Resource
	CustomerRepDao customerRepDao;
	
	@Override
	public int update13(String email, int id) {
		return customerRepDao.update13(email, id);
	}
	
	@Override
	public List<Customer2> query12() {
		return customerDao.query12();
	}
	
	@Override
	public Customer save(int id, Customer customer) {
		return customerRepDao.save(customer);
	}
	
	@Override
	public Customer save(Customer customer) {
		return customerRepDao.save(customer);
	}
	
	@Override
	public List<Customer> save15(List<Customer> customers) {
		return (List<Customer>) customerRepDao.saveAll(customers);
	}
	
	@Override
	public Customer findById(int id) {
		return customerRepDao.findById(id).get();
	}

	@Override
	public Customer saveOrUpdate(int id, Customer customer) {
		Customer exist 			= null;
		Optional<Customer> opt 	= customerRepDao.findById(id);
		if (!opt.isPresent()) {
			exist = customer;
		} else {
			exist = opt.get();
			BeanUtils.copyProperties(customer, exist, "createdTime");
		}
		
		return customerRepDao.save(exist);
	}

}
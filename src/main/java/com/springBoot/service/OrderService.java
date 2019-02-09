package com.springBoot.service;

import com.springBoot.entity.Order;

public interface OrderService {

	public Order saveOrUpdate(int id, Order entity);
	
}

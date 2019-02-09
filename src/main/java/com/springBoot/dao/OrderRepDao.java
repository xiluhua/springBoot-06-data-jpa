package com.springBoot.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springBoot.entity.Order;

public interface OrderRepDao extends PagingAndSortingRepository<Order, Integer>{

}
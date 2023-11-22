package com.softic.deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softic.deliver.dto.OrderDTO;
import com.softic.deliver.entities.Order;
import com.softic.deliver.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	public OrderRepository orderRepository;
	

	@Transactional(readOnly = true )
	public List<OrderDTO> findAll(){
		
		List<Order> listOrder=orderRepository.findOrderWithProducts();
		
		return listOrder.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	
	}
}

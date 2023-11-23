package com.softic.deliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softic.deliver.dto.OrderDTO;
import com.softic.deliver.dto.ProductDTO;
import com.softic.deliver.entities.Order;
import com.softic.deliver.entities.OrderStatus;
import com.softic.deliver.entities.Product;
import com.softic.deliver.repositories.OrderRepository;
import com.softic.deliver.repositories.ProductRepository;

@Service
public class OrderService {
	@Autowired
	public OrderRepository orderRepository;
	
	@Autowired
	public ProductRepository productRepository;

	@Transactional(readOnly = true )
	public List<OrderDTO> findAll(){
		
		List<Order> listOrder=orderRepository.findOrderWithProducts();
		
		return listOrder.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	
	}
	
	
	@Transactional
	public OrderDTO insert( OrderDTO dto){
		
		Order order=new Order(null, dto.getAddress(),dto.getLatitude(),dto.getLongitude(),Instant.now(),OrderStatus.PENDING);
		
		for(ProductDTO p : dto.getListProduct()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order= orderRepository.save(order);
		return new OrderDTO(order);
		
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id){
		
		Order order=orderRepository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order=orderRepository.save(order);
		
		return new OrderDTO(order);
		
	}
}

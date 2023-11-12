package com.softic.deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softic.deliver.dto.ProductDTO;
import com.softic.deliver.entities.Product;
import com.softic.deliver.repositories.ProductRepository;

@Service
public class ProductService { 
	@Autowired
	public ProductRepository productRepository;
	

	@Transactional(readOnly = true )
	public List<ProductDTO> findAll(){
		
		List<Product> listProduct=productRepository.findAllByOrderByNameAsc();
		
		return listProduct.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	
	}
}

package com.postgrecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgrecrud.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	
}

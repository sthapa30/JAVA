package com.uta.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uta.dto.ProductDTO;

@Repository
public interface ProductRepo extends JpaRepository<ProductDTO, String> {
	
	@Query("SELECT P FROM ProductDTO P WHERE USER_ID = ?1")	
	public List<ProductDTO> findAllUserPostedProduct(String userId);

}

package com.uta.service;

import java.util.List;

import com.uta.dto.ProductDTO;

public interface ProductServiceInterface {
	
	public List<ProductDTO> getAllProductService();
	public ProductDTO getProductByIdService(String Id);
	public List<ProductDTO> findAllUserPostedProduct(String userId);
	public String postProductService(ProductDTO productDto);
	public void deleteProductService(String productId) throws Exception;



}

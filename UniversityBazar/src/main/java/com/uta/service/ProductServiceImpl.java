package com.uta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uta.dto.ProductDTO;
import com.uta.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductServiceInterface {
	
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public List<ProductDTO> getAllProductService() {
		
		return productRepo.findAll();
	}

	@Override
	public ProductDTO getProductByIdService(String Id) {
		ProductDTO result = null;
		try {

			//logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - start: " + empId);

			Optional<ProductDTO> productDto = productRepo.findById(Id);
			result = productDto.get();

			//logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - end: " + empId);

		} catch (Exception e) {

			//logger.error(e.getStackTrace());
		}

		return result;
	}

	@Override
	public List<ProductDTO> findAllUserPostedProduct(String userId) {
		
		return productRepo.findAllUserPostedProduct(userId);
	}

	@Override
	public String postProductService(ProductDTO productDto) {
		String message = null;
		ProductDTO result = null;
		try {

			result = productRepo.save(productDto);
			if (result != null) {
				message = "Added Sucessfully!";
			}

		} catch (Exception e) {
			message = "Failed to Add";
			//logger.error(e.getStackTrace());
		}
		return message;
	}

	@Override
	public void deleteProductService(String productId) throws Exception {
		try {
			productRepo.deleteById(productId);

			
		}catch (Exception e) {
			throw new Exception("Product not found");
		}
		
	}

}

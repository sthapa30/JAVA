package com.uta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uta.dto.ProductDTO;
import com.uta.service.ProductServiceImpl;

@RestController
@RequestMapping(value = "ProductController")
public class ProductController {

	@Autowired
	ProductServiceImpl productService;

	@RequestMapping(value = "/getAllProductInfo", method = RequestMethod.GET, produces = { "application/json" })
	public List<ProductDTO> getAllProductInfo() {

		return productService.getAllProductService();

	}

	@RequestMapping(value = "/getProductById/{productId}", method = RequestMethod.GET, produces = {
			"application/json" })
	public ProductDTO getUserById(@PathVariable("productId") String productId) {

		return productService.getProductByIdService(productId);
	}

	@RequestMapping(value = "/findAllUserPostedProduct/{userId}", method = RequestMethod.GET, produces = {
			"application/json" })
	public List<ProductDTO> findAllUserPostedProduct(@PathVariable("userId") String userId) {

		return productService.findAllUserPostedProduct(userId);
	}

	@PostMapping(value = "/postProductService", consumes = { "application/json" }, produces = { "application/json" })
	public String postProductService(@RequestBody ProductDTO productDTO) {

		// logger.debug("EmployeeInfoMicroServiceController.addEmployee - start: ");
		// System.out.println(empDto.getEmpID());
		String result = productService.postProductService(productDTO);

		// logger.debug("EmployeeInfoMicroServiceController.addEmployee - end: ");

		return result;

	}

	@RequestMapping(value = "/deleteProductService/{productId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public String deleteProductService(@PathVariable("productId") String productId) throws Exception {

		try {
			productService.deleteProductService(productId);
		} catch (Exception e) {
			throw(e);
		}
		return "Delete Sucessful";
	}

}

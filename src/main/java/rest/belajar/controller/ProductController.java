package rest.belajar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.belajar.dto.ResponseData;
import rest.belajar.model.ProductModel;
import rest.belajar.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ResponseData<ProductModel>> create(@Valid @RequestBody 
			ProductModel product, Errors errors) {
		ResponseData<ProductModel> responseData = new ResponseData<>();
		if(errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		responseData.setStatus(true);
		responseData.setPayload(productService.save(product));
		return ResponseEntity.ok(responseData);
	}
	@GetMapping
	public Iterable<ProductModel> findAll(){
		return productService.findAll();
	}
	@GetMapping("/{id}")
	public ProductModel findOne(@PathVariable("id") Long id) {
		return productService.findOne(id);
	}
	@PutMapping
	public ResponseEntity<ResponseData<ProductModel>> update(@Valid @RequestBody 
			ProductModel product, Errors errors) {
		ResponseData<ProductModel> responseData = new ResponseData<>();
		if(errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		responseData.setStatus(true);
		responseData.setPayload(productService.save(product));
		return ResponseEntity.ok(responseData);
	}
	@DeleteMapping("/{id}")
	public void ProductModelremoveOne(@PathVariable("id") Long id) {
		productService.removeOne(id);
	}
}

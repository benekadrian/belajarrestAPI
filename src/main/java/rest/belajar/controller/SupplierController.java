package rest.belajar.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.belajar.dto.ResponseData;
import rest.belajar.dto.SupplierData;
import rest.belajar.model.SupplierModel;
import rest.belajar.service.SupplierService;

@RestController
@RequestMapping("api/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private ModelMapper modelMapper;
	@PostMapping
	public ResponseEntity<ResponseData<SupplierModel>> create(@Valid @RequestBody SupplierData supplierData, Errors errors){
		ResponseData<SupplierModel> responseData = new ResponseData<>();
		if(errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		/*
		 * SupplierModel supplier = new SupplierModel();
		 * supplier.setSuppliername(supplierData.getSuppliername());
		 * supplier.setAddress(supplierData.getAddress());
		 * supplier.setEmail(supplierData.getEmail());
		 */
		SupplierModel supplier = modelMapper.map(supplierData, SupplierModel.class);
		
		responseData.setStatus(true);
		responseData.setPayload(supplierService.save(supplier));
		return ResponseEntity.ok(responseData);
		
	}
	@GetMapping
	public Iterable<SupplierModel> findAll(){
		return supplierService.findAll(); 
	}
	@GetMapping("/{id}")
	public SupplierModel findOne(@PathVariable("id") Long id) {
		return supplierService.findOne(id);
	}
	@PutMapping
	public ResponseEntity<ResponseData<SupplierModel>> update(@Valid @RequestBody SupplierData supplierData, Errors errors){
		ResponseData<SupplierModel> responseData = new ResponseData<>();
		if(errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		/*
		 * SupplierModel supplier = new SupplierModel();
		 * supplier.setSuppliername(supplierData.getSuppliername());
		 * supplier.setAddress(supplierData.getAddress());
		 * supplier.setEmail(supplierData.getEmail());
		 */
		SupplierModel supplier = modelMapper.map(supplierData, SupplierModel.class);
		
		responseData.setStatus(true);
		responseData.setPayload(supplierService.save(supplier));
		return ResponseEntity.ok(responseData);
		
	}
}

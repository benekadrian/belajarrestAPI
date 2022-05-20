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

import rest.belajar.dto.CategoryData;
import rest.belajar.dto.ResponseData;
import rest.belajar.model.CategoryModel;
import rest.belajar.service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	@Autowired
	public CategoryService categoryService;
	@Autowired
	public ModelMapper modelMapper;
	@PostMapping
	public ResponseEntity<ResponseData<CategoryModel>> 
	create(@Valid @RequestBody CategoryData categoryData, Errors errors){
		ResponseData<CategoryModel> responseData = new ResponseData<>();
		
		if(errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		CategoryModel category = modelMapper.map(categoryData, CategoryModel.class);
		responseData.setStatus(true);
		responseData.setPayload(categoryService.save(category));
		return ResponseEntity.ok(responseData);
	}
	@GetMapping
	public Iterable<CategoryModel> findAll(){
	return categoryService.findAll();
	}
	@GetMapping("/{id}")
	public CategoryModel findOne(@PathVariable("id") Long id) {
		return categoryService.findOne(id);
	}
	@PutMapping
	public ResponseEntity<ResponseData<CategoryModel>> 
	update(@Valid @RequestBody CategoryData categoryData, Errors errors){
		ResponseData<CategoryModel> responseData = new ResponseData<>();
		
		if(errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		CategoryModel category = modelMapper.map(categoryData, CategoryModel.class);
		responseData.setStatus(true);
		responseData.setPayload(categoryService.save(category));
		return ResponseEntity.ok(responseData);
	}
}

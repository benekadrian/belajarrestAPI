package rest.belajar.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.belajar.model.ProductModel;
import rest.belajar.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public ProductModel save(ProductModel product) {
		return productRepo.save(product);
	}
	public ProductModel findOne(Long id) {
		Optional<ProductModel> product = productRepo.findById(id);
		if (!product.isPresent()) {
			return null;
		}
		return productRepo.findById(id).get();
	}
	public Iterable<ProductModel> findAll(){
		return productRepo.findAll();
	}
	public void removeOne(Long id) {
		productRepo.deleteById(id);
	}
	public List<ProductModel> findByName(String name){
		return productRepo.findByNameContains(name);
	}
}

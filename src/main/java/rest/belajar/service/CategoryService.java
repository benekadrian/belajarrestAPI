package rest.belajar.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.belajar.model.CategoryModel;
import rest.belajar.repository.CategoryRepository;

@Service
@TransactionScoped
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public CategoryModel save(CategoryModel category) {
		return categoryRepo.save(category);
	}
	public CategoryModel findOne(Long id) {
		Optional<CategoryRepository> category = Optional.empty();
		if(!category.isPresent()){
			return null;
		}
		return (CategoryModel) category.get();
	}
	public List<CategoryModel> findAll(){
		return categoryRepo.findAll();
	}
	public void removeOne(Long id) {
		categoryRepo.deleteById(id);
	}
}

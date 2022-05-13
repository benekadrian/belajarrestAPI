package rest.belajar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import rest.belajar.model.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Long>{

	List<ProductModel> findByNameContains(String name);
}

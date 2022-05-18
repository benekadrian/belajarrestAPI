package rest.belajar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import rest.belajar.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{

	List<ProductModel> findByNameContains(String name);
}

package rest.belajar.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import rest.belajar.model.SupplierModel;

public interface SupplierRepository extends JpaRepository<SupplierModel, Long>{
 
}

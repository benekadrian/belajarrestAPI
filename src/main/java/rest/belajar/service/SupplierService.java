package rest.belajar.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.belajar.model.SupplierModel;
import rest.belajar.repository.SupplierRepository;

@Service
@Transactional
public class SupplierService {
	@Autowired
	public SupplierRepository supplierRepo;
	
	public SupplierModel save(SupplierModel supplier) {
		return supplierRepo.save(supplier);
	}
	public SupplierModel findOne(Long id) {
		Optional<SupplierModel> supplier = supplierRepo.findById(id);
		if(!supplier.isPresent()) {
			return null;
		}
		return supplier.get();
	}
	public Iterable<SupplierModel> findAll(){
		return supplierRepo.findAll();
	}
	public void removeOne(long id) {
		supplierRepo.deleteById(id);
	}
	
	
}

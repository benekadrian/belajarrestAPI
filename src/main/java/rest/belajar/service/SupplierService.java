package rest.belajar.service;

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
		return supplier.save(supplier);
	}
	
}

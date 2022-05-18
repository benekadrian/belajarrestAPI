package rest.belajar.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="tbl_product")
public class ProductModel implements Serializable{
	

	private static final long serialVersionUID = -8098513079670418409L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "nama dibutuhkan")
	private String name;
	@NotEmpty(message = "deskripsi tidak boleh kosong")
	private String deskripsi;
	private Double harga;
	
	private CategoryModel category;
	@ManyToMany
	@JoinTable(name="tbl_product_supplier", 
	joinColumns = @JoinColumn(name = "product_id"),
	inverseJoinColumns = @JoinColumn(name="supplier_id"))
	private Set<SupplierModel> supplier;
	
	public ProductModel() {
		
	}
	public ProductModel(Long id, String name, String deskripsi, Double harga) {
		super();
		this.id = id;
		this.name = name;
		this.deskripsi = deskripsi;
		this.harga = harga;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public Double getHarga() {
		return harga;
	}
	public void setHarga(Double harga) {
		this.harga = harga;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	public Set<SupplierModel> getSupplier() {
		return supplier;
	}
	public void setSupplier(Set<SupplierModel> supplier) {
		this.supplier = supplier;
	}
	
	
}

package rest.belajar.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class SupplierData {
	@NotEmpty(message = "Name is required")
	private String suppliername;
	@NotEmpty(message = "Address is required")
	private String address;
	@NotEmpty(message = "Email is required")
	@Email(message = "Email is not valid")
	private String email;
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

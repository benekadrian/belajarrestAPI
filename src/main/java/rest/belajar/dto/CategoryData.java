package rest.belajar.dto;

import javax.validation.constraints.NotEmpty;

public class CategoryData {
	@NotEmpty(message="Name is required")
	private String categoryname;

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
}

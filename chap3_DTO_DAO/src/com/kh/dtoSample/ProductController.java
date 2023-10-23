package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

public class ProductController {
	private ProductModel productModel;
	private ProductView productView;
	
	public ProductController(Connection connection, ProductView view) {
		this.productModel = new ProductModel(connection);
		this.productView = view;
	}
	
	public void displayAllProducts() {
		List<ProductDTO> products = productModel.getAllProducts();
		productView.displayProducts(products);
	}
}
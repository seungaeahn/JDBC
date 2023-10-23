package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
	
	private Connection connection;
	
	public ProductModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<ProductDTO> getAllProducts(){
		List<ProductDTO> products = new ArrayList<>();
		String query = "SELECT * FROM products";
		
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				ProductDTO pro = new ProductDTO();
				pro.setProduct_id(result.getInt("product_id"));
				pro.setProductName(result.getString("product_name"));
				pro.setCategory(result.getString("category"));
				pro.setPrice(result.getDouble("price"));
				pro.setStock_quantity(result.getInt("stock_quantity"));
				products.add(pro);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return  products;
	}
	
	
}